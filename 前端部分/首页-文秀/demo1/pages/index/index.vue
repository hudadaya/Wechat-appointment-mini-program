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
			<view class="fetched-messages">
			          <!-- Messages fetched from backend will be displayed here -->
			          <!-- Example message structure -->
			       <view class="message">
			           <ul>
						   <li>
							   <span class="user-id">用户id</span>
							   <p>留言内容</p>
						   </li>
						   <li>
							   <span class="user-id">用户id</span>
							   <p>留言内容</p>
						   </li>
						   <li>
						   		<span class="user-id">用户id</span>
						   		<p>留言内容</p>
						   </li>
						   <li>
						   		<span class="user-id">用户id</span>
						   		<p>留言内容</p>
						   </li>
						   <li>
						   		<span class="user-id">用户id</span>
						   		<p>留言内容</p>
						   </li>
						   <li>
						   		<span class="user-id">用户id</span>
						   		<p>留言内容</p>
						   </li>
					   </ul>
			       </view>

          <!-- Repeat this structure for each fetched message -->
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
	height: 1025px;
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
	height: 550px;
	left: 5.27%;
	right: 5.06%;
	top: 334px;
	bottom: 25.37%;
	background-color: #f5f8f8;
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
.chat-container .chat-input .fetched-messages {
	margin: 10px 0;
	// height: 100px;
	width: 425px;
	 overflow-y: auto; /* Enable vertical scrolling */
	// border: 1px solid #ccc; //测试范围
	
}
.chat-container .chat-input .fetched-messages .message {
  display: flex;
	align-items: left;
	justify-content: center;
  height: 300px;

  // background-color: skyblue;
	flex-direction: column; /* 将内容垂直排列 */
	text-align: left; /* 文本居中 */
}
.chat-container .chat-input .fetched-messages .message ul li{
	padding-bottom: 30px;
	padding-left: 60px;


}

.chat-container .chat-input .fetched-messages .message .user-id {
  padding-bottom: 5px;
  border-radius: 5px;
}
.chat-container .chat-input .fetched-messages .message p {
  margin: 0; /* 移除段落标签的默认间距 */
}


</style>
