<!-- 增加头像 -->	
<template>
	<!-- 不能写两个盒子 -->
	<view class="chat-container">
		<!-- 公告 -->
	    <view class="chat-header">
		
		</view>
		<view class="chat-box">
			<label for="announcement" class="textarea-label">
				<textarea name="公告内容" id="announcement" cols="30" rows="10"></textarea>
				<span class="placeholder">公告</span>
			</label>
		</view>
		<!-- 留言 -->	
	    <view class="chat-input">
	    	<view class="message-box">
	    		<textarea class="message-input" placeholder="在此输入留言"></textarea>
	    		<button class="send-button">发送</button>
				<!-- 组件<icon :type="success" size="26"></icon> -->
	    	</view>
			<view class="uni-padding-wrap" style="height: calc(100% - 180rpx); ">
				<!-- 应在这里渲染 -->
			            <view class="uni-comment" style="overflow-y: auto;">
			                <view class="uni-comment-list">
			                    <view class="uni-comment-face">
									<image src="../../static/logo.png" mode="widthFix"></image>
			                    </view>
			                    <view class="uni-comment-body">
			                        <view class="uni-comment-top">
			                            <text>网友</text>
			                        </view>
			                        <view class="uni-comment-content">很酷的HBuilderX和uni-app，开发一次既能生成小程序，又能生成App</view>
			                    </view>
			                </view>
			                <view class="uni-comment-list">
			                    <view class="uni-comment-face">
			                       <image src="../../static/logo.png" mode="widthFix"></image>
			                    </view>
			                    <view class="uni-comment-body">
			                        <view class="uni-comment-top">
			                            <text>马克一天</text>
			                        </view>
			                        <view class="uni-comment-content">很强大，厉害了我的uni-app!</view>
			                    </view>
			                </view>
			                <view class="uni-comment-list">
			                    <view class="uni-comment-face">
			                      <image src="../../static/logo.png" mode="widthFix"></image>
			                    </view>
			                    <view class="uni-comment-body">
			                        <view class="uni-comment-top">
			                            <text>今生缘</text>
			                        </view>
			                        <view class="uni-comment-content">好牛逼的感觉，是不是小程序、App、移动端都互通了？</view>
			                        </view>
			                    </view>
			                </view>
			                <view class="uni-comment-list">
			                    <view class="uni-comment-face">
			                      <image src="../../static/logo.png" mode="widthFix"></image>
			                    </view>
								<view class="uni-comment-body">
								    <view class="uni-comment-top">
								        <text>小猫咪</text>
								    </view>
								    <view class="uni-comment-content">支持国产，支持DCloud!</view>
								</view>
							</view>
							<view class="uni-comment-list">
							    <view class="uni-comment-face">
							      <image src="../../static/logo.png" mode="widthFix"></image>
							    </view>
								<view class="uni-comment-body">
								    <view class="uni-comment-top">
								        <text>小猫咪</text>
								    </view>
								    <view class="uni-comment-content">支持国产，支持DCloud!</view>
								</view>
							</view>
							<view class="uni-comment-list">
							    <view class="uni-comment-face">
							       <image src="../../static/logo.png" mode="widthFix"></image>
							    </view>
								<view class="uni-comment-body">
								    <view class="uni-comment-top">
								        <text>小猫咪</text>
								    </view>
								    <view class="uni-comment-content">支持国产，支持DCloud!</view>
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
		
	}
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
	width: 425px;
	height: 280px;
	left: 25px;
	right: 24px;
	top: 27px;
	bottom: 618px;
	background-color: #f5f8f8;
	text-align: left;
}
.chat-container .chat-box{
	position:absolute;
	padding-top: 10px;
	top:42px;
	width: 400px;
	height: 200px;
	background-color: #fcfcfc;
	border: 1px solid #ccc;
	left: 38px;
	text-align: center;
}

.chat-container .chat-box .textarea-label {
    position: relative;
    width: 100%;
}

.chat-container .chat-box textarea {
    width: 100%;
    height: 100%;
    resize: none; 
    border: none; 
    font-size: 16px; 
}

.chat-container .chat-box .placeholder {
    position: absolute;
	padding-top: 20px;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: #999; 
    writing-mode: horizontal-tb; 
    white-space: nowrap; 
    pointer-events: none; 
}

.chat-container .chat-box textarea:focus + .placeholder {
    display: none; /* Hide the placeholder when the textarea is focused */
}


// 留言部分
.chat-container .chat-input{
	position: absolute;
	width: 425px;
	height: 575px; /* Adjust the height as needed */
	left: 5.27%;
	right: 5.06%;
	top: 334px;
	bottom: 25.37%;
	background-color: #f5f8f8;
	overflow: hidden;
    
}

.chat-container .chat-input .message-box {
	margin-top: 16px; 
	margin-left: 10px;
	width: 410px;
	// overflow-y: auto; /* Enable scrolling if messages overflow */
	
}

.chat-container .chat-input .message-input {
	width:390px; 
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
	margin-right: 36px ;
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
