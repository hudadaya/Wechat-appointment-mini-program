<template>
	<view class="chat-container">
	    <view class="chat-input">
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
	              <!-- Added buttons below each comment -->
	              <view class="uni-comment-buttons">
	                <button class="uni-comment-button1" @click="editComment(index)">删除</button>
	                <button class="uni-comment-button2" @click="deleteComment(index)">回复</button>
	              </view>
	            </view>
	          </view>
	        </view>
	      </view>
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
		tabBerLists: [],
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
       
      ],
    };
   },
 methods: {
    // Add methods for edit and delete actions
    editComment(index) {
      // Logic for editing comment
      console.log('Edit comment:', index);
    },
    deleteComment(index) {
      // Logic for deleting comment
      console.log('Delete comment:', index);
    },
  },
  onLoad() {
  	//影藏原生的tabbar,有自定义tabbar的页面都要写一遍
  	uni.hideTabBar()
  },
  onShow() {
  	this.tabBerLists = uni.getStorageSync('tabBarList') // 自定义的tabbar赋值
  	console.log(this.tabBerLists)
  }
};
</script>

<style>
// 留言显示
.chat-container{
	background-color: rgb(225, 224, 246);
}
.chat-input{
	width: 80%;
	margin-left: 22px;
}
.uni-padding-wrap {
    /* Update as needed */
    padding: 10rpx;
    width: 110%;
    box-sizing: border-box;
    overflow-y: auto; /* Enable vertical scrolling */
	/* background-color: white; */
}
    .uni-comment {
        padding: 5rpx 0;
        display: flex;
        flex-grow: 1;
        flex-direction: column;
		background-color: rgb(225, 224, 246);
		margin-bottom: 30px;
    }

    .uni-comment-list {
        flex-wrap: nowrap;
        padding: 10rpx 0;
        margin: 10rpx 0;
        width: 100%;
		height: 120px;
        display: flex;
		background-color: white;
    }

    .uni-comment-face {
        width: 70upx;
        height: 70upx;
        border-radius: 100%;
        margin-right: 20upx;
        flex-shrink: 0;
        overflow: hidden;
		padding-left: 5px;
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
	
	.uni-comment-buttons {
	  display: flex;
	  justify-content: space-between;
	  margin-top: 10px;
	}
	
	.uni-comment-button1 {
	  /* padding: 8px 16px; */
	  border: none;
	  border-radius: 4px;
	  background-color: rgb(245, 108, 108);
	  color: white;
	  font-size: 14px;
	  height: 40rpx;
	  width: 100px;
	  line-height: 20px;
	  cursor: pointer;
	  transition: background-color 0.3s ease;
	}
	
	.uni-comment-button2 {

	  border: none;
	  border-radius: 4px;
	  background-color: rgb(101, 217, 105);
	  color: white;
	  font-size: 14px;
	  height: 40rpx;
	  width: 100px;
	  line-height: 20px;
	  cursor: pointer;
	  transition: background-color 0.3s ease;
	}	
	.uni-comment-button:hover {
	  background-color: #077DAE;
	}
	

</style>
