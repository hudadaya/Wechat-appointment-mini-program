<template>
	<!-- 不能写两个盒子 -->
	<view class="chat-container">
		<!-- 公告 -->
	    <view class="chat-header">
		
		</view>
		<!-- 公告内容 -->
		 <view class="chat-box">
		      <view class="ann" v-for="(announcement, index) in announcements" :key="index">
				<view class="title">{{ announcement.title }}</view>
		        <view class="createtime">{{ announcement.createTime }}</view> 
		        <view class="content">{{ announcement.content }}</view>
		      </view>
		    </view>
		
		<!-- 留言 -->	
	    <view class="chat-input">
	    	<view class="message-box">
	    		<textarea class="message-input" placeholder="在此输入留言"></textarea>
	    		<button class="send-button">发送</button>
				<!-- 组件<icon :type="success" size="26"></icon> -->
	    	</view>
			<view class="uni-padding-wrap" style="height: calc(100% - 180rpx);">
			        <view class="uni-comment" style="overflow-y: auto;">
			          <view class="uni-comment-list" v-for="(comment, index) in comments" :key="index">
			            <view class="uni-comment-face">
			              <image :src="comment.img" mode="widthFix"></image>
			            </view>
			            <view class="uni-comment-body">
			              <view class="uni-comment-top">
			                <text>{{ comment.name }}</text>
			              </view>
			              <view class="uni-comment-content">{{ comment.comment }}</view>
			            </view>
			          </view>
			        </view>
			      </view>
			            </view>
			 </view>
	    </view>
		

	</view>
</template>

<script>
	import axios from 'axios';
export default {
  data() {
    return {
		// 用户留言部分
      comments: [
        {
          img: "../../static/logo.png",
          name: "网友",
          comment: "很酷的HBuilderX和uni-app，开发一次既能生成小程序，又能生成App",
        },
        {
          img: "../../static/logo.png",
          name: "Cat",
          comment: "101的空调遥控器在哪里",
        },
		{
		  img: "../../static/logo.png",
		  name: "dog",
		  comment: "我的学生卡不见了！！",
		},
		{
		  img: "../../static/logo.png",
		  name: "mikey",
		  comment: "301实验室的仪器怎么少了！",
		},
		{
		  img: "../../static/logo.png",
		  name: "Goofy",
		  comment: "谢谢关空调的女生，坐标e103！",
		},
		{
		  img: "../../static/logo.png",
		  name: "Potato",
		  comment: "能不能把垃圾拿走!"
		},
		{
		  img: "../../static/logo.png",
		  name: "totoro",
		  comment: "哈哈哈哈哈哈",
		},
		{
		  img: "../../static/logo.png",
		  name: "马克一天",
		  comment: "很强大，厉害了我的uni-app!",
		},
       
      ],
	  announcements: [], // 用来存储公告数据的数组
    };
	
	//公告接口
  },
  onLoad() {
     this.fetchAnnouncements(); // 在页面加载时获取公告数据
   },
   methods: {
     fetchAnnouncements() {
       uni.request({
        //url: 'http://localhost:8082/notice', 
		url: 'http://8.134.201.230:8082/notice',
		
         method: 'GET',
         success: (res) => {
			 console.log(res)
           if (res.data && res.data.code === 202) { 
             this.announcements = res.data.data; // 将返回的公告数据存储到 announcements 中
           } else if (res.data && res.data.code === 402) {
             // 处理无公告的情况
             // 可以设置默认公告数据或在界面上显示“暂时没有公告”的提示
             console.log('暂时没有公告');
           } else {
             console.error('未知错误');
           }
         },
         fail: (err) => {
           console.error('请求失败', err);
         },
       });
     },
   },
 };
</script>

<style lang="scss">
.chat-container{
	position: relative;
	height: 925px;
	background-color: #dfeae9;
	overflow: hidden;
}
.chat-container .chat-header{
	position: relative;
	width: 90%;
	height: 280px;
	left: 25px;
	right: 15px;
	top: 27px;
	bottom: 618px;
	background-color: #f5f8f8;
	text-align: left;
	background-image: url("../../static/1.png");
	background-size: contain;
}
.chat-container .chat-box{
	position:absolute;
	margin-top: 5px;
	top:70px;
	width: 80%;
	height: 200px;
	background-color: #fcfcfc;
	// border: 1px solid #ccc;
	left: 38px;
	padding-left: 15rpx;
	overflow-y: auto;
	// text-align: center;
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
  width: 100%;
  padding-left: 5px;
  text-align: left;
  font-family: 'Times New Roman', Times, serif;
}

.chat-container .ann .title {
  color: steelblue;
  font-size: 14px; /* 将字体大小调整为你想要的大小 */
  padding-top: 15px;
  padding-bottom: 5px;
}
.chat-container .ann .createtime{
	 font-size: 10px;
	 padding-bottom: 8px;
}
.chat-container .ann .content{
	padding-bottom: 10px;
	font-size: 14px;
	color: black;
}

.chat-container .chat-input .message-box {
	margin-top: 16px; 
	margin-left: 10px;
	width: 90%;
	// overflow-y: auto; /* Enable scrolling if messages overflow */
	
}

.chat-container .chat-input .message-input {
	width:100%; 
	height: 150px; 
	margin-left: 1px;
	margin-top: 10px;
	padding: 5px; 
	border: 1px solid #ccc; 
	border-radius: 5px;
	background-color: #fcfcfc;
	text-align: center;
}

.chat-container .chat-input .send-button {
	display: block;
	margin-right: -10px ;
	margin-top: 10px;
	background-color: #1b9aee;
	width: 100px;
	height: 40px;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	line-height: 40px;
	font-size: 20px;
	text-align: center;
}
// 留言显示
.uni-padding-wrap {
    /* Update as needed */
    padding: 10rpx;
    width: 100%;
    box-sizing: border-box;
    overflow-y: auto; /* Enable vertical scrolling */
}
    .uni-comment {
        padding: 5rpx 0;
        display: flex;
        flex-grow: 1;
        flex-direction: column;
    }

    .uni-comment-list {
        flex-wrap: nowrap;
        padding: 10rpx 0;
        margin: 10rpx 0;
        width: 100%;
        display: flex;
    }

    .uni-comment-face {
        width: 70upx;
        height: 70upx;
        border-radius: 100%;
        margin-right: 20upx;
        flex-shrink: 0;
        overflow: hidden;
    }

    .uni-comment-face image {
        width: 100%;
        border-radius: 100%;
    }

    .uni-comment-body {
        width: 100%;
    }

    .uni-comment-top {
        line-height: 1.5em;
        justify-content: space-between;
    }

    .uni-comment-top text {
        color: #0A98D5;
        font-size: 24upx;
    }


    .uni-comment-content {
        line-height: 1.6em;
        font-size: 28upx;
        padding: 8rpx 0;
    }

</style>