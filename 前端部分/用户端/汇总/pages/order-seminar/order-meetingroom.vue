<template>
	<view class="page">
		<scroll-view class="scroll" scroll-x>
		<view class="box">
			<view class="title">{{arr[0]}}</view>
			
			<view class="room" >
				
				<view class="room1">
					<navigator url="/pages/order-menu/order-menu?wd=101" open-type="navigate" class="color-change iconfont icon-xiangfa-L" style="font-size: 26px;">101</navigator>
				</view>
				
				<view class="room1">
					<navigator url="/pages/order-menu/order-menu?wd=102" open-type="navigate" class="color-change iconfont icon-xiangfa-L" style="font-size: 26px;">102</navigator>
				</view>
				
				<view class="room1">
					<navigator url="/pages/order-menu/order-menu?wd=103" open-type="navigate" class="color-change iconfont icon-xiangfa-L" style="font-size: 26px;">103</navigator>
				</view>
				
				<view class="room1">
					<navigator url="/pages/order-menu/order-menu?wd=104" open-type="navigate" class="color-change iconfont icon-xiangfa-L" style="font-size: 26px;">104</navigator>
				</view>
				
			</view>
			
		</view>
		</scroll-view>
		
		<scroll-view class="scroll" scroll-x>
		<view class="box">
			<view class="title">{{arr[1]}}</view>
			<view class="room">
				
				<view class="room1">
					<navigator url="/pages/order-menu/order-menu?wd=201" open-type="navigate" class="color-change iconfont icon-zaixiangoutong" style="font-size: 26px; ">201</navigator>
				</view>
				
				<view class="room1">
					<navigator url="/pages/order-menu/order-menu?wd=202" open-type="navigate" class="color-change iconfont icon-zaixiangoutong" style="font-size: 26px;">202</navigator>
				</view>
				
				<view class="room1">
					<navigator url="/pages/order-menu/order-menu?wd=203" open-type="navigate" class="color-change iconfont icon-zaixiangoutong" style="font-size: 26px;">203</navigator>
				</view>
				
				<view class="room1">
					<navigator url="/pages/order-menu/order-menu?wd=204" open-type="navigate" class="color-change iconfont icon-zaixiangoutong" style="font-size: 26px;">204</navigator>
				</view>
				
				<view class="room1">
					<navigator url="/pages/order-menu/order-menu?wd=204" open-type="navigate" class="color-change iconfont icon-zaixiangoutong" style="font-size: 26px;">205</navigator>
				</view>
				
			</view>
		</view>
		</scroll-view>
		
		<scroll-view class="scroll" scroll-x>
		<view class="box">
			<view class="title">{{arr[2]}}</view>
			<view class="room">
				
				<view class="room1">
					<navigator url="/pages/order-menu/order-menu?wd=301" open-type="navigate" class="color-change iconfont icon-hezuo" style="font-size: 26px; ">301</navigator>
				</view>
				
				<view class="room1">
					<navigator url="/pages/order-menu/order-menu?wd=302" open-type="navigate" class="color-change iconfont icon-hezuo" style="font-size: 26px;">302</navigator>
				</view>
				
				<view class="room1">
					<navigator url="/pages/order-menu/order-menu?wd=303" open-type="navigate" class="color-change iconfont icon-hezuo" style="font-size: 26px; ">302</navigator>
				</view>
				
				<view class="room1">
					<navigator url="/pages/order-menu/order-menu?wd=304" open-type="navigate" class="color-change iconfont icon-hezuo" style="font-size: 26px; ">303</navigator>
				</view>
			</view>
		</view>
		</scroll-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				arr:["4人研讨室","6人研讨室","10人研讨室"],
			}
		},
		methods: {

		},
	}
</script>

<style>
	.page{
		
	}
	.box{
		font-size:20px;
		width:750rpx;
		height:170px;
		
		margin-top: 20px;
		
	}
	.title{
		margin-left:15px;
		margin-top: -15px;
		position: fixed;
	}
	.scroll{
		box-sizing: border-box;
	}
	.room{
		white-space: nowrap;
	}
	.room1{
		color: #000;
		width: 40%;
		height:170rpx;
		border: 1px solid whitesmoke;	
		box-shadow:0.3em 0.3em 1em rgba(0, 0, 0, 0.3); 
		margin:15px;
		/* float: left; */
		text-align: center;
		line-height: 170rpx;
		display: inline-block;
	}
	
	.color-change {
		color: #000;
	}
	.color-change:active{
		color: #83c6c2;
	}
	
</style>
