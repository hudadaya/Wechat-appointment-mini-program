<template>
    <view class="background">

		<view class="box" v-for="item in listArr" :key="item.seminarBookId">
			<!-- Item {{ index + 1 }}: {{ item }} -->
			<view class="stu">预约人：{{item.seminarUserId}} </view>
			<view class="room">预约教室：{{item.seminarRoomNumber}} </view>
			<view class="stu">预约日期：{{item.seminarDate}} </view>
			<view class="time">预约时间起：{{item.startTime}} </view>
            <view class="time2">预约时间止：{{item.endTime}} </view>
			<button  @click="detele(item.seminarUserId , item.seminarRoomNumber , item.seminarDate)" class="button">取消预约</button>
		</view>
	</view>
</template>


<script>
	export default {
	    data(){
	        return{
	            listArr:[],
				userName:"",
				//index:0,
				SeminarDate:"",
				seminarRoomNumber:""
	        };
	    },
		methods: {
	        getData(){
	            uni.request({
	                url:"http://8.134.201.230:8082/seminar/appointments/"+this.userName,
					 //url:"http://8.134.201.230:8082/seminar/appointments/20yjma",
					method: 'GET',
	                success:res=>{
	                    console.log(res)
	                    this.listArr=res.data.data
	                }
	            })
             },   
		    detele(item1 , item2 , item3) {
				console.log(item1)
				console.log(item2)
				console.log(item3)
		        uni.showModal({
		        	title: '提示',
		        	content: '你确定要删除吗',
		        	success: function (res) {
		        		if (res.confirm) {
		        			console.log('确定');
                            uni.request({
                               // url:"http://8.134.201.230:8082/seminar/appointments/delete/"+"username="this.userName+"&room="+this.seminarRoomNumber+"&date="+this.SeminarDate,
							   url: "http://8.134.201.230:8082/seminar/appointments/" + item1 + "/" + item2 + "/" + item3,
								 method: 'GET',
                            });                              
                            uni.navigateTo({
                            	url: '/pages/mybook/mybook1'
                            });
		        		} else if (res.cancel) {
		        			console.log('取消');
		        		}
		        	}
		        });
		    }
		},
        onLoad() {
			this.userName=getApp().globalData.username;
			console.log(this.userName)
            this.getData();
        },
		mounted(){
			console.log(this.$router);
			//this.userName=getApp().globalData.username;
			//console.log(this.userName)
		}
	}
</script>

<style>
	.background {
		background-color: #ffffff;
	}
	.box{
/* 		color: white;
		width: 260px;
		height: 170px;
		background-color: #83c6c2;
		margin: auto;
		margin-top:20px;
		margin-bottom: 20px;
		text-align: center;
		line-height: 70rpx;
		font-size:10px; */
		    color: white;
		    width: 90vw; /* 使用视窗宽度作为相对单位 */
		    max-width: 260px; /* 设置最大宽度 */
		    height: 30vh; /* 使用视窗高度作为相对单位 */
		    background-color: #83c6c2;
		    margin: auto;
		    margin-top: 5vw; /* 使用vw单位调整间距 */
		    margin-bottom: 5vw; /* 使用vw单位调整间距 */
		    text-align: center;
		    line-height: 7vw; /* 使用vw单位调整行高 */
		    font-size: 3vw; /* 使用vw单位调整字体大小 */
	}
	.button{
/* 		height:50rpx;
		width: 150rpx;
		color: black;
		font-size: 20rpx; */
		    height: 10vw; /* 使用vw单位调整按钮高度 */
		    width: 40%; /* 使用vw单位调整按钮宽度 */
		    color: black;
		    font-size: 4vw; /* 使用vw单位调整字体大小 */
			margin-top: 10px; /* 设置按钮与上方文字的上外边距 */
	}
</style>