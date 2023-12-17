<template>
	<view class>
		
		
			<view class="box">
				<navigator url="/pages/order-menu/order-menu" open-type="navigate">教室预约</navigator>
			</view>
			<view class="box">
				<navigator url="/pages/order-menu/order-menu" open-type="navigate">实验室预约</navigator>
			</view>
			<view class="box">
				<navigator url="/pages/order-seminar/order-meetingroom" open-type="navigate">研讨室预约</navigator>
			</view>
			
		
	</view>
	
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style>
	
	.box{
		color: white;
		width: 80%;
		height: 200rpx;
		background-color: #83c6c2;
		margin: auto;
		margin-top:20px;
		text-align: center;
		line-height: 200rpx;
		font-size:20px;
		
	}
</style>
