<template>
	<!-- 不能写两个盒子 -->
	<view class="chat-container">
		<!-- 公告 -->
	    <view class="chat-header">
		
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
          name: "马克一天",
          comment: "很强大，厉害了我的uni-app!",
        },
		{
		  img: "../../static/logo.png",
		  name: "马克一天",
		  comment: "很强大，厉害了我的uni-app!",
		},
		{
		  img: "../../static/logo.png",
		  name: "马克一天",
		  comment: "很强大，厉害了我的uni-app!",
		},
		{
		  img: "../../static/logo.png",
		  name: "马克一天",
		  comment: "很强大，厉害了我的uni-app!",
		},
		{
		  img: "../../static/logo.png",
		  name: "马克一天",
		  comment: "很强大，厉害了我的uni-app!",
		},
		{
		  img: "../../static/logo.png",
		  name: "马克一天",
		  comment: "很强大，厉害了我的uni-app!",
		},
		{
		  img: "../../static/logo.png",
		  name: "马克一天",
		  comment: "很强大，厉害了我的uni-app!",
		},
        // 其他评论按照相同的格式添加
      ],
    };
	
	//公告接口
	
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
	left: 19px;
	right: 15px;
	top: 27px;
	bottom: 618px;
	background-color: #f5f8f8;
	text-align: left;
}
.chat-container .chat-box{
	position:absolute;
	padding-top: 10px;
	top:42px;
	width: 80%;
	height: 200px;
	background-color: #fcfcfc;
	border: 1px solid #ccc;
	left: 38px;
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
