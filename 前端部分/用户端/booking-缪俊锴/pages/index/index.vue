<template>
    <view class="background">

		<view class="box" v-for="item in listArr" :key="item.seminarBookId">
			<view class="stu">预约人：{{item.seminarUserId}} </view>
			<view class="room">预约教室：{{item.seminarRoomNumber}} </view>
			<view class="time">预约时间起：{{item.startTime}} </view>
            <view class="time2">预约时间止：{{item.endTime}} </view>
			<button  @click="detele" class="button">取消预约</button>
		</view>
	</view>
</template>


<script>
	export default {
	    data(){
	        return{
	            listArr:[]
	        };
	    },
		methods: {
	        getData(){
	            uni.request({
	                url:"http://localhost:8088/seminar/appointments/21wlliu",
	                success:res=>{
	                    console.log(res)
	                    this.listArr=res.data.data
	                }
	            })
             },   
		    detele() {
		        uni.showModal({
		        	title: '提示',
		        	content: '你确定要删除吗',
		        	success: function (res) {
		        		if (res.confirm) {
		        			console.log('确定');
                            uni.request({
                                url:"http://localhost:8088/delete/8", 
                            });                              
                            uni.navigateTo({
                            	url: '/pages/index/index'
                            });
		        		} else if (res.cancel) {
		        			console.log('取消');
		        		}
		        	}
		        });
		    }
		},
        onLoad() {
            this.getData();
        }
	}
</script>

<style>
	.background {
		background-color: #ffffff;
	}
	.box{
		color: white;
		width: 260px;
		height: 150px;
		background-color: #83c6c2;
		margin: auto;
		margin-top:20px;
		margin-bottom: 20px;
		text-align: center;
		line-height: 70rpx;
		font-size:10px;
	}
	.button{
		height:50rpx;
		width: 150rpx;
		color: black;
		font-size: 20rpx;
	}
</style>