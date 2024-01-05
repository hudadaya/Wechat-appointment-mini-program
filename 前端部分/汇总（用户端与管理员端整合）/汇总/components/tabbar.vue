<template>
<view class="tab-bar">
   		<view class="tab-bar-border"></view>
   		<view v-for="(item,index) in tabBarList" :key="index" class="tab-bar-item" :data-id="index"
   			@click="jump(item,index)">
   			<image :src="current == item.index ? item.selectedIconPath : item.iconPath"></image>
   			<view :style="{'color':current == item.index ? '#409eff' : '#909399'}" style="margin-top: 10rpx;">
   				{{item.text}}</view>
   		</view>
   	</view>

</template>

<script>
	export default {
		props: {
			tabBarList: {
				type: Array,
				default: uni.getStorageSync('tabBarList')
			},
			current: Number
		},
		data() {
			return {
				value1: 0, // 默认页面
				inactiveColor: '#909399' // 高亮颜色
			}
		},
		methods: {
			// 点击跳转对应tabbar页面
			jump(e,index) {
				 console.log('Clicked:', e)
				 if(index==1){
					 uni.navigateTo({
					 	url: "/pages/adamin-liuyan/adamin-liuyan"
					 })
				 }else if(index==2){
					 uni.navigateTo({
					 	url: "/pages/adamin-heimingdan/adamin-heimingdan"
					 })
				 }else if(index==0){
					 uni.navigateTo({
					 	url: "/pages/admin-gonggao/admin-gonggao"
					 })
				 }
			}
		}
	}

</script>

<style lang="less" scoped>
		.tab-bar {
			position: fixed;
			bottom: 0;
			left: 0;
			right: 0;
			height: 48px;
			border-top: 1px solid #ccc;
			background: white;
			display: flex;
		}
		.tab-bar-border {
			// background-color: rgba(0, 0, 0, 0.33);
			background-color: white;
			position: absolute;
			left: 0;
			top: 0;
			width: 100%;
			height: 1px;
			border-top: 2rpx solid rgba(187, 187, 187, 0.3);
			transform: scaleY(0.5);
		}
	
		.tab-bar-item {
			flex: 1;
			text-align: center;
			display: flex;
			justify-content: center;
			align-items: center;
			flex-direction: column;
		}
	
		.tab-bar-item image {
			width: 24px;
			height: 24px;
		}
	
		.tab-bar-item view {
			font-size: 10px;
		}

</style>
