<template>
	<!-- 不能写两个盒子 -->
	<view class="chat-container">
		<!-- 公告 -->
	    <view class="chat-header">
			<!-- 添加叉的元素 -->
			<view class="close-icon">✖</view>
			<!-- 添加笔的元素 -->
			<view class="pen-icon">✎</view>
		</view>
		<view class="chat-box">
			<view class="ann">
				<view class="createtime">2023-10-25 16:24:59</view>
				<view class="title">公告标题</view>
				<view class="content"> 1. 在规定时间内签到 2. xxx</view>	
			</view>
			<view class="ann">
				<view class="createtime">2023-10-25 16:24:59</view>
				<view class="title">公告标题</view>
				<view class="content"> 1. 在规定时间内签到 2. xxx</view>	
			</view>
		</view>
		<!-- 新添加的按钮 -->
		<view class="button-container">
		    <button class="custom-button">添加公告</button>
		</view>
		<tabbar :current="0" :tabBarList="tabBerLists" />
	</view>
</template>

<script>
	import tabBar from '@/components/tabbar.vue'
export default {
	components: {
		'tabbar':tabBar
	},
	data() {
		return {
			tabBerLists: []
		}
	},
	onLoad() {
		//影藏原生的tabbar,有自定义tabbar的页面都要写一遍
		uni.hideTabBar()
	},
	onShow() {
		this.tabBerLists = uni.getStorageSync('tabBarList') // 自定义的tabbar赋值
		console.log(this.tabBerLists)
	},
}
</script>

<style lang="scss">
.chat-container{
	position: relative;
	height: 925px;
	background-color: rgba(204, 201, 255, 0.41);
	overflow: hidden;
}
.chat-container .chat-header{
	position: relative;
	width: 90%;
	height: 250px;
	left: 20px;
	right: 15px;
	top: 27px;
	bottom: 618px;
	background-color: rgba(255, 255, 255, 0.70);
	text-align: left;
	border-radius: 3px; /* 设置圆角 */
	box-shadow: 2px 2px 10px 0 rgba(89, 89, 89, 0.2); /* 添加外阴影 */
	display: flex;
	justify-content: flex-end; /* 将元素推到右侧 */
	align-items: flex-start; /* 将元素推到顶部 */
	position: relative;
}
.close-icon {
	font-size: 20px;
	cursor: pointer;
	color: #333; /* 设置图标颜色 */
	position: absolute;
	top: 20px;
	left: 295px; /* 调整左边距 */
	z-index: 2; /* 设置更高的z-index值 */
}
.pen-icon {
    font-size: 20px;
    cursor: pointer;
    color: #333; /* 设置图标颜色 */
    position: absolute;
    top: 20px;
    left: 270px; /* 调整左边距 */
    z-index: 2; /* 设置更高的z-index值 */
}
.chat-container .chat-box{
	position:absolute;
	padding-top: 10px;
	top:42px;
	width: 80%;
	height: 170px;
	background-color: rgba(255, 254, 254, 1.00); /* 设置背景颜色 */
	border: 1px solid #ccc;
	left: 33px;
	padding-left: 15rpx;
	// text-align: center;
}

.chat-container .chat-box textarea:focus + .placeholder {
    display: none; /* Hide the placeholder when the textarea is focused */
}

// 留言部分
.chat-container .chat-input{
	position: absolute;
	width: 90%;
	height: 575px; /* Adjust the height as needed */
	left: 5.27%;
	right: 5.06%;
	top: 334px;
	bottom: 25.37%;
	background-color: #f5f8f8;
	overflow: hidden;
}

.chat-container .ann .createtime,
.chat-container .ann .title,
.chat-container .ann .content {
  font-size: 14px; /* 将字体大小调整为你想要的大小 */
  width: 100%;
  padding-left: 5px;
  text-align: left;
}

.chat-container .ann .title {
  color: blue; /* 设置标题颜色为蓝色 */
}
.chat-container .ann .content{
	padding-bottom: 10px;
}

.button-container {
    position: absolute;
    width: 90%; /* 调整按钮宽度为80%，根据需要调整 */
    left: 20px;
    top: 300px; /* 调整按钮距离顶部的位置，根据需要调整 */
}

.custom-button {
    width: 100%;
    height: 40px; /* 根据需要调整按钮高度 */
    background-color: rgba(255, 254, 254, 0.77); /* 设置按钮背景颜色 */
    color: #595959; /* 设置按钮文字颜色 */
    border: none; /* 去除按钮边框 */
    border-radius: 3px; /* 设置按钮圆角 */
    cursor: pointer; /* 设置鼠标悬停样式 */
	box-shadow: 2px 2px 10px 0 rgba(89, 89, 89, 0.2); /* 添加外阴影 */
}

.custom-button:hover {
    background-color: #A6A0F8; /* 设置鼠标悬停时的背景颜色 */
}

</style>
