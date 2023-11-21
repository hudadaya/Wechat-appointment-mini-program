<template>
	<view class="content">
		<view class="container">
			<!-- 日期列表 -->
			<scroll-view class="scroll-view_H b-t b-b" scroll-x>
				<block v-for="(item,index) in dateArr" :key="index">
					<div class="flex-box" @click="selectDateEvent(index,item)" :class="{ borderb: index==dateActive}">
						<view class="date-box" :style="{color:index==dateActive?selectedTabColor:'#333'}">
							<text class="fontw">{{item.week}}</text>
							<text>{{item.date}}</text>
						</view>
					</div>
				</block>
			</scroll-view>

			<!-- 时间选项 -->
			<view class="time-box" v-if="!isSection || isQuantum">
				<template v-for="(item,_index) in timeArr">
					<view class="item" :key="_index">
						<view class="item-box" :class="{'disable':item.disable,
						'active':isMultiple?item.isActive:_index==timeActive}" :style="{color:isMultiple?item.isActive? selectedItemColor:'#333'
						 :_index==timeActive?selectedItemColor:'#333'}" @click="selectTimeEvent(_index,item)">
							<text v-if="isQuantum">{{item.begin}}~{{item.end}}</text>
							<text v-else>{{item.time}}</text>
							<text class="all">{{item.disable?disableText:undisableText}}</text>
						</view>
					</view>
				</template>
			</view>
			<!-- 预约时间段 -->
			<view class="time-box" v-else>
				<template v-for="(item,_index) in timeArr">
					<view class="item" :key="_index">
						<view class="item-box" :class="{'disable':item.disable || item.isInclude,
						'active':item.time == timeQuanBegin || item.time == timeQuanEnd }"
							:style="{color:item.time == timeQuanBegin || item.time == timeQuanEnd? selectedItemColor:'#333'}"
							@click="handleSection(_index,item)">
							<text>{{item.time}}</text>
							<text class="all">{{item.disable?disableText:undisableText}}</text>
						</view>
					</view>
				</template>
			</view>
		</view>
		<view class="bottom">
			<view class="show-time" v-if="!isMultiple && !isSection && !isQuantum">
				预约时间：{{orderDateTime}}
			</view>
			<button form-type="submit" type="default" size="mini" class="submit-btn" @click="handleSubmit">
				确认预约
			</button>

		</view>
	</view>
</template>

<script>
	import {
		initData,
		initTime,
		timeStamp,
		currentTime
	} from '../utils/date.js'
	export default {
		name: 'times',
		model: {
			prop: "showPop",
			event: "change"
		},
		props: {
			isQuantum: {
				type: Boolean,
				default: false
			},
			isMultiple: { //是否多选
				type: Boolean,
				default: false
			},
			isSection: { //预约时间段
				type: Boolean,
				default: false
			},
			disableText: { //禁用显示的文本
				type: String,
				default: "已约满"
			},
			undisableText: { //未禁用显示的文本
				type: String,
				default: "可预约"
			},
			timeInterval: { // 时间间隔，小时为单位
				type: Number,
				default: 1
			},
			selectedTabColor: { // 日期栏选中的颜色
				type: String,
				default: "#FB4B5C"
			},
			selectedItemColor: { // 时间选中的颜色
				type: String,
				default: "#FB4B5C"
			},
			beginTime: {
				type: String,
				default: "09:00:00"
			},
			endTime: {
				type: String,
				default: "19:00:00"
			},
			appointTime: { // 预约的时间
				type: Array,
				default () {
					return []
				}
			},
			disableTimeSlot: { // 预约开始和结束时间，来禁用时间段
				type: Array,
				default () {
					return []
				}
			}
		},
		watch: {
			appointTime: {
				handler(val) {
					if (val && val.length) {
						this.initOnload()
					}
				}
			},
			disableTimeSlot: {
				handler(val) {
					if (val && val.length) {
						this.initOnload()
					}
				}
			}
		},
		data() {
			return {
				orderDateTime: '暂无选择', // 选中时间
				orderTimeArr: {}, //多选的时间
				dateArr: [], //日期数据
				timeArr: [], //时间数据
				nowDate: "", // 当前日期
				dateActive: 0, //选中的日期索引
				timeActive: 0, //选中的时间索引
				timeQuanBeginIndex: 0, //时间段开始的下标
				selectDate: "", //选择的日期
				timeQuanBegin: "", //时间段开始时间
				timeQuanEnd: "", //时间段结束时间
			}
		},
		created(props) {
			this.selectDate = this.nowDate = currentTime().date
			this.initOnload()
		},
		methods: {
			initOnload() {
				this.dateArr = initData() // 日期栏初始化
				this.timeArr = initTime(this.beginTime, this.endTime, this.timeInterval, this.isQuantum) //时间选项初始化
				this.timeQuanBegin = this.timeQuanEnd = ""
				console.log(this.orderTimeArr)
				let isFullTime = true
				this.timeArr.forEach((item, index) => {
					// 时间段
					if (this.isQuantum) {
						const cur_be_time = `${this.selectDate} ${item.begin}:00`
						const cur_end_time = `${this.selectDate} ${item.end}:00`
						for (let time of this.disableTimeSlot) {
							const [begin_time = "", end_time = ""] = time
							if (begin_time && end_time && (begin_time <= cur_be_time && cur_end_time <=
									end_time)) {
								item.disable = true
							}
						}
						if (this.selectDate == this.nowDate && currentTime().time > `${item.begin}:00`) {
							item.disable = true
						}
						// 多选时间段的切换日期不清除
						if (this.orderTimeArr[this.selectDate]) {
							for (let items of this.orderTimeArr[this.selectDate]) {
								if (items[0].split(' ')[1] === `${item.begin}:00` && items[1].split(' ')[1] ===
									`${item.end}:00`) {
									item.isActive = true
								}
							}
						}

					} else {
						//判断是当前这一天，选中时间小于当前时间则禁用
						if (this.selectDate == this.nowDate && currentTime().time > item.time) {
							item.disable = true
						}

						// 将预约的时间禁用
						this.appointTime.forEach(t => {
							let [date, time] = t.split(' ')
							if (date == this.selectDate && item.time == time) {
								item.disable = true
							}
						})

						// 禁用时间段 
						const cur_time = `${this.selectDate} ${item.time}`

						for (let time of this.disableTimeSlot) {
							const [begin_time = "", end_time = ""] = time
							if (begin_time && end_time && (begin_time <= cur_time && cur_time <= end_time)) {
								item.disable = true
							}
						}

						// 判断是否当前日期时间都被预约
						if (!item.disable) {
							isFullTime = false
						}
						this.isSection && (item.isInclude = false)

						// 对多选操作的已选时间的回显
						if (this.isMultiple && (this.orderTimeArr[this.selectDate] || []).includes(item.time)) {
							item.isActive = true
						}

					}

				})

				this.orderDateTime = isFullTime ? "暂无选择" : this.selectDate
				this.timeActive = -1
				for (let i = 0, len = this.timeArr.length; i < len; i++) {
					if (!this.timeArr[i].disable) {
						this.orderDateTime = `${this.selectDate} ${this.timeArr[i].time}`
						this.timeActive = i
						return
					}
				}
			},

			// 日期选择事件
			selectDateEvent(index, item) {
				this.dateActive = index
				this.selectDate = item.date
				this.initOnload()
			},

			// 时间选择事件
			selectTimeEvent(index, item) {
				if (this.isQuantum) {
					return this.handleSelectQuantum(index, item)

				}
				if (item.disable) return
				if (this.isMultiple) {
					item.isActive = !item.isActive
					this.timeArr = this.timeArr.slice()
					this.orderTimeArr[this.selectDate] = this.timeArr.reduce((prev, cur) => {
						cur.isActive && prev.push(cur.time)
						return prev
					}, [])
				} else {
					this.timeActive = index
					this.orderDateTime = `${this.selectDate} ${item.time}`
				}
			},

			// 选择时间段
			handleSection(index, item) {
				if (item.disable) return

				function clearTime() {
					this.timeQuanBeginIndex = index
					this.timeQuanBegin = item.time
					this.timeQuanEnd = ""
				}

				if (!this.timeQuanBegin) {
					clearTime.call(this)
					return
				}
				if (!this.timeQuanEnd && this.timeQuanBegin) {
					let isDisble = false
					let start = this.timeQuanBeginIndex
					let end = index
					start > end && ([start, end] = [end, start])
					for (let i = start + 1; i < end; i++) {
						if (this.timeArr[i].disable) {
							isDisble = true
							clearTime.call(this)
							return
						}
					}
					if (!isDisble) {
						for (let i = start + 1; i < end; i++) {
							this.timeArr[i].isInclude = true
						}
					}
					this.timeQuanEnd = item.time
					return
				}

				if (this.timeQuanBegin && this.timeQuanEnd) {
					this.timeArr.forEach(t => {
						t.isInclude = false
					})
					clearTime.call(this)
				}

			},
			handleSelectQuantum(index, item) {
				if (item.disable) return
				if (this.isMultiple) {
					item.isActive = !item.isActive
					this.timeArr = this.timeArr.slice()
					this.orderTimeArr[this.selectDate] = this.timeArr.reduce((prev, cur) => {
						const cur_be_time = `${this.selectDate} ${cur.begin}:00`
						const cur_end_time = `${this.selectDate} ${cur.end}:00`
						cur.isActive && prev.push([cur_be_time, cur_end_time])
						return prev
					}, [])
				} else {
					this.timeActive = index
					this.orderDateTime = {
						begin: `${this.selectDate} ${item.begin}:00`,
						end: `${this.selectDate} ${item.end}:00`,
					}
				}
				console.log(this.orderTimeArr)
			},
			handleChange() {
				this.timeQuanBegin > this.timeQuanEnd && ([this.timeQuanBegin, this.timeQuanEnd] = [this.timeQuanEnd, this
					.timeQuanBegin
				])
			},
			handleSubmit() {
				if (this.isSection) {
					this.handleChange()
					this.$emit('change', {
						beginTime: `${this.selectDate} ${this.timeQuanBegin}`,
						endTime: `${this.selectDate} ${this.timeQuanEnd}`
					})
					return
				}
				console.log(this.orderTimeArr)
				if (this.isMultiple) {
					if (this.isQuantum) {
						this.$emit('change', this.orderTimeArr)
						return
					}
					let time = []
					for (let date in this.orderTimeArr) {
						this.orderTimeArr[date].forEach(item => {
							time.push(`${date} ${item}`)
						})
					}
					this.$emit('change', time)
				} else {
					this.$emit('change', this.orderDateTime)
				}

			}
		}
	}
</script>
<style lang="scss" scoped>
	@import './pretty-times.scss';

	page {
		height: 100%;
	}

	.content {
		text-align: center;
		height: 100%;
	}

	/* 两个按钮 */
	.bottom {
		display: flex;
		flex-direction: row;
		position: fixed;
		bottom: 8px;
		top: auto;
		left: 0px;
		width: 100%;
		background-color: #fff;
	}

	.show-time {
		width: 70%;
		height: 47px;
		color: #505050;
		background-color: rgba(255, 255, 255, 1);
		font-size: 15px;
		line-height: 47px;
		text-align: center;
	}

	.submit-btn {
		width: 25%;
		height: 40px;
		color: white;
		background-color: #CA89FF;
		font-size: 15px;
		line-height: 40px;
		text-align: center;
		margin: auto;
		padding: 0;
	}

	.fontw {
		font-weight: bold;
	}

	.borderb {
		border-bottom: 2px solid #FB4B5C;
	}
</style>