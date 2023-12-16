<template>
	<view>
		<!-- 预约时间段的写法 -->
		<!-- <times @change="getTime" :isMultiple="true" :timeInterval="1" :isQuantum="true" :disableTimeSlot="disableTimeSlot"></times> -->
		
		<!-- 多选时间的配置 -->
		<p class="room">{{room}}</p>
		<times @change="getTime" :timeInterval="1" :appointTime="appointTime"
		:isMultiple="true" :disableTimeSlot = "disableTimeSlot"></times>
	     
<!-- 		<times :timeActiveArray="timeActiveArray" @onEmitIndex="onEmitIndex"></times>
		<p>{{timeActiveArray}}</p> -->
		<!-- 单选的配置 -->
<!-- 		<times @change="getTime" :timeInterval="1" :appointTime="appointTime"
		:isMultiple="false" :disableTimeSlot = "disableTimeSlot"></times> -->
		
		<!-- 预约时间段 -->
		<!-- <times @change="getTime" :timeInterval="1" :appointTime="appointTime"
		:isSection="true" :disableTimeSlot = "disableTimeSlot"></times> -->
	</view>
</template>

<script>
	import times from '@/components/pretty-times/pretty-times.vue'
	import axios from 'axios';
	export default {
		components: {
			times
		},
		data() {
			return {
				appointTime: ["2022-02-10 15:30:00"],
				disableTimeSlot: [
					["2022-10-17 09:00:00", "2022-10-17 10:00:00"],
					["2022-05-05 16:30:00", "2022-05-05 18:30:00"]
				],
				timeActiveArray:[],
				selectDate:"",
				userName:"",
				room:"",
				time:"",
				startTimeId:0,
				endTimeId:0
			}
		},
		onLoad(e) {
			console.log(e);
			//this.room=e;
			//console.log(this.room);\
			var room=e.wd;
			//console.log(room);
			this.room=room;
			console.log(this.room)
		},
		methods: {
			getTime(e) {
				//console.log(e)
				//this.timeActiveArray=e.timeActiveArray1;
				this.selectDate=e.selectDate1;
				//this.time=e.time1;
				this.startTimeId=e.timeActiveArray1[0];
				this.endTimeId=e.timeActiveArray1[e.timeActiveArray1.length-1];
				console.log(this.userName)
				console.log(this.selectDate);
				console.log(this.startTimeId);
				console.log(this.endTimeId);
				console.log(this.room)
				//console.log(this.time)
				this.submit();
			},
             submit(){
				 uni.request({
				 		url: 'http://8.134.201.230:8082/seminar/appointments',
				 		method: 'POST',
				 		data: {
				 		  seminarUserId: this.userName,
				 		  seminarRoomNumber:this.room,
						  seminarDate:this.selectDate,
						  startTimeId:this.startTimeId,
						  endTimeId:this.endTimeId
				 		},
				 		header: {
				 		  'content-type': 'application/json'
				 		},
				 		success: (res) => {
				 		  console.log(res.data);
							if (res.data.code == 240) {	//预约成功
				 			uni.showToast({
				 			  title: res.data.msg,
				 			  icon: 'none'
				 			})
				 		  } else if (res.data.code == 440) {
				 			uni.showToast({
				 			  title: '开始时间不可大于结束时间',
				 			  icon: 'none'
				 			});
				 		  } else if (res.data.code == 441) {
				 			uni.showToast({
				 			  title: '时间与已有预约冲突，请重新预约',
				 			  icon: 'none'
				 			});
				 		  } else if (res.data.code == 442) {
				 			uni.showToast({
				 			  title: '今日已预约过研讨室，不可再次预约',
				 			  icon: 'none'
				 			});
				 		  } else if (res.data.code == 443) {
				 			uni.showToast({
				 			  title: '单次预约时间不可超过2小时',
				 			  icon: 'none'
				 			});
				 		  } else {
				 			uni.showToast({
				 			  title: '预约失败,存在未知错误，请联系管理员',
				 			  icon: 'none'
				 			});
				 		  }
				 		},
				 		fail: (err) => {
				 		  console.error(err);
				 		  uni.showToast({
				 			title: '存在网络问题，请重试！',
				 			icon: 'none'
				 		  });
				 		}
				 });
			 }
		},
		mounted(){
			console.log(this.$router);
			this.userName=getApp().globalData.username;
			//console.log(this.userName)
		}
	}
</script>

<style>
	.room{
		  text-align: center; /* 将文本内容居中对齐 */
		  color: white; /* 设置文本颜色为白色 */
		  background-color: #57C3C2E0;
		  display: flex;
		  justify-content: center;
		  align-items: center;
		  padding: 10px; 
		  /* 如果需要设置宽度，也可以添加 width 属性 */
	}
</style>
