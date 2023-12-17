<template>
  <view>
    <!-- 标题栏 -->
    <view class="title-bar">
      <text class="title-text">黑名单管理</text>
    </view>
    
	<!-- 滚动视图容器 -->
	<view class="container">
		<scroll-view class="scroll-view" scrollY style="height: 40vh;">
		  <view class="button-container">
			<view class="button-title">
				<view>黑名单列表</view>
			</view>
		    <view class="button-grid">
		      <view v-for="(row, rowIndex) in grid" :key="rowIndex" class="button-row">
		        <view v-for="(user, colIndex) in row" :key="colIndex" class="user-button" @click="showDeleteDialog(user.name)">
		          <text v-if="user">{{ user.name }}</text>
				  <text v-if="user">{{ user.reason }}</text>
		        </view>
				<view v-if="showDeleteModal" class="modal">
				  <view class="modal-content">
				    <view class="top-content">
				      <text>是否将{{ modalUser }}移出黑名单？</text>
				    </view>
				    <view class="bottom-content">
				      <button @click="deleteblacklist(modalUser)" class="confirm-bottom">确认</button>
				      <button @click="hideDeleteDialog()" class="cancel-bottom">取消</button>
				    </view>
				  </view>
				</view>
		      </view>
		    </view>
			<view v-if="IsBlacklistNull">黑名单为空</view>
		  </view>
		</scroll-view>
	</view>
	
	<!-- 遮罩层 -->
	<view v-if="showModal" class="modal-overlay"></view>
	
	<!-- 输入框 -->
	<form>
	  <view >
	    <input type="text" v-model="username"  placeholder="请输入用户账号" class="input-field" />
	    <input type="text" v-model="reason" placeholder="请输入原因" class="input-field" />
		<!-- 按钮 -->
		<button type="submit" class="bl-button" @click="AddModal()">添加用户到黑名单</button>
		<view v-if="showAddModal" class="modal">
		  <view class="modal-content">
		    <view class="top-content">
		      <text>是否将{{ username }}加入黑名单？</text>
		    </view>
		    <view class="middle-content">
		    </view>
		    <view class="bottom-content">
		      <button @click="addBlacklist(username, reason)" class="confirm-bottom">确认</button>
		      <button @click="hideAddDialog()" class="cancel-bottom">取消</button>
		    </view>
		  </view>
		</view>

	  </view>
	</form>
  </view>
</template>

<script>
export default {
  data() {
    return {
	  IsBlacklistNull: false,
	  showAddModal: false,
	  modalUser: null,
	  blacklist:[
	  ],
	  itemsPerRow: 4, // 每行显示的按钮数量
	  grid: [] ,// 用于存储按钮组的二维数组
	  
	  inBlackList:true,
	  username:'',//用户名
	  reason:"",
	  showDeleteModal: false,
      showCheckModal: false // 控制模态框显示与隐藏的变量
    };
  },
  mounted() {
	this.fetchBlacklist().then(() => {
	this.generateButtonGrid(); // 在fetchBlacklist()成功后生成按钮组
    }).catch(error => {
	  console.error('Error fetching blacklist:', error);
    });
  },
  methods: {
	fetchBlacklist() {
	  //使用 uni.request 发送 GET 请求获取黑名单数据
	  return new Promise((resolve, reject) => {
	  uni.request({
		url: 'http://8.134.201.230:8081/blacklist/select',
		method: 'GET',
		data: {
		  username: this.username,
		  reason:this.reason
		},
		header: {
		  'content-type': 'application/json'
		},
		success: (res) => {
		  if(res.data.code == 241){
			  // 将获取到的数据赋值给 blacklist
			  if (res.data.data && res.data.data.length > 0) {
					this.blacklist = res.data.data.map(username => ({
					  name: username,
					  //reason: 'Default Reason' // 理由那一行，数据库里面还没有
				    }));
				}
			  resolve(); // 执行成功回调
		  }
		  else if(res.data.code == 445){
			  console.log(1);
			  this.IsBlacklistNull = true;
			  resolve(); // 执行成功回调
		  }
		  else
			reject('Failed to fetch blacklist'); // 执行失败回调
 		},
		fail: (err) => {
		  console.error('Error fetching blacklist:', err);
		  reject('Failed to fetch blacklist'); // 执行失败回调
		}
	  });
	  });
	},
	showDeleteDialog(user){
	  this.showDeleteModal = true;
	  this.modalUser = user;
	},
	hideDeleteDialog(){
	  this.showDeleteModal = false;
	  console.log('hideDeleteDialog() 方法被调用了');
	  this.modalUser = null;
	},
    showCheckDialog() {
      this.showCheckModal = true; // 点击按钮显示模态框
    },
    hideCheckDialog() {
      this.showCheckModal = false; // 关闭模态框
    },
	addBlacklist(username,reason){
		uni.request({
			url: 'http://8.134.201.230:8081/blacklist/insert',
			method: 'POST',
			data: {
			  username: this.username,
			  reason:this.reason
			},
			header: {
			  'content-type': 'application/json'
			},
			success:(res)=> {
				console.log(res.data);
				//以下是跳转的逻辑
				if(res.data.code == 451){
					uni.showToast({
					  title: res.data.msg,
					  icon: 'none'
					});
				}
				else if(res.data.code == 450){
					uni.showToast({
					  title: res.data.msg,
					  icon: 'none'
					});
					
				}
				else if(res.data.code == 210){
					uni.showToast({
					  title: res.data.msg,
					  icon: 'none'
					});
					uni.navigateTo({
						url: '/pages/index/index'
					});
				}
			},
			fail: (err) => {
			  console.error(err);
			  uni.showToast({
				title: '存在网络问题，请重试！',
				icon: 'none'
			  });
			}
		})
	},
	hideAddDialog(){
		this.showAddModal = false;
	},
	generateButtonGrid() {
	  const rows = [];
	  let tempRow = [];
	  this.blacklist.forEach((user, index) => {
	    if (index > 0 && index % this.itemsPerRow === 0) {
	      rows.push(tempRow);
	      tempRow = [];
	    }
	    tempRow.push(user);
	  });
	  if (tempRow.length > 0) {
	    rows.push(tempRow);
	  }
	  this.grid = rows;
	},
	deleteblacklist(username) {
	// 使用 uni.request 发送 DELETE 请求删除黑名单用户
	uni.request({
	  url: `http://8.134.201.230:8081/blacklist/delete?username=${username}`,
	  method: 'DELETE',
	  data: {
	    username: username,
	  },
	  header: {
	    'content-type': 'application/json'
	  },
	  success: (res) => {
		if (res.data.code == 206) {
		  // 删除成功
		  uni.showToast({
		    title: `成功从黑名单中删除用户 ${username}`,
		    icon: 'none'
		  });
		  this.hideDeleteDialog(); // 关闭模态框
		  uni.navigateTo({
		  	url: '/pages/index/index'
		  });
		  // 可以根据需要执行其他操作
		} else if (res.data.code == 406) {
		  // 删除失败
		  uni.showToast({
		    title: res.data.msg,
		    icon: 'none'
		  });
		  this.hideDeleteDialog(); // 关闭模态框
		  
		} else {
		  // 其他情况，处理错误
		  console.log('出现未知错误');
		}
	  },
	  fail: (err) => {
		console.error('Error deleting from blacklist:', err);
	  }
	});
	  },
	AddModal(){
		this.showAddModal = true;
	}
  },
  onload(){
	  this.fetchBlacklist();
  }
};
</script>

<style lang="scss">
/* 样式文件中添加样式 */
.title-bar {
  height: 60px;
  line-height: 60px;
  background-color:000000 ;
  color: white;
  text-align: center;
}

.container{
  margin-left: 20rpx; /* 左侧间距 */
  margin-right: 20rpx; /* 右侧间距 */
  margin-top: 20px; /* 设置容器顶部的间距为20像素 */
  padding: 10px;
  border: 1px solid #ccc; /* 大框的边框 */
}

.title-text {
  font-size: 24px;
  color: black;
}

.scroll-view {
  padding: 10px;
}

.button-container {
  display: flex;
  flex-direction: column; /* 设置按钮垂直排列 */
  padding: 10px;
}
.button-title{
  text-align: center; /* 水平居中 */
  font-size: 20px;
  display: flex;
  justify-content: center; /* 垂直居中 */
  align-items: center;
  margin-bottom: 20rpx; /* 设置文本下方的间距为20像素 */
}

.button-grid {
  display: flex;
  flex-wrap: wrap;
}

.button-row {
  width: 100%; /* 让每行占满父容器 */
  display: flex;
  justify-content: flex-start;
}

.user-button {
  width: 23%; /* 每个按钮所占宽度 */
  padding: 10px;
  border: 1px solid #ccc;
  margin-bottom: 10px; /* 按钮之间的底部间距 */
  display: flex;
  flex-direction: column;
  align-items: center;
}
.input-label {
    font-size: 42rpx; /* 提示文字大小 */
    padding-left: 80rpx; /* 左边距 */
    color: #333;
    margin-bottom: 100rpx; /* 提示文字和输入框之间的间距 */
    font-weight: bold; /* 设置为粗体 */
}

.input-field {
    margin-top: 50rpx;
    padding: 10rpx; /* 输入框内边距 */
    border-radius: 6rpx; /* 输入框圆角 */
    border: 1rpx solid #ccc; /* 输入框边框 */
    border-bottom: 1rpx solid #ccc; /* 只显示底部边框 */
    width: 100%; /* 输入框宽度 */
    width: 80%; /* 设置宽度为页面宽度的80%，留出左右各10%的空白 */
    margin-left: 10%; /* 左边距10% */
    margin-right: 10%; /* 右边距10% */
	position: relative;
	z-index: 1;
}

.bl-button {
  margin-top: 40rpx;
  margin-bottom: 100rpx; /* 提示文字和输入框之间的间距 */
  width: 40%; /* 设置宽度为页面宽度的30%，留出左右各8%的空白 */
  margin-left: 30%; /* 左边距35% */
  margin-right: 8%; /* 右边距8% */
  height: 60rpx;
  border-radius: 40rpx; /* 圆角半径增加到20rpx */
  background-color: #A6A0F8; /* 紫色 */
  color: white;
  font-size: 16rpx;
  text-align: center;
  line-height: 60rpx;
  font-size: 28rpx;
  border: none;
}

.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5); /* 半透明遮罩层 */
  z-index: 999; /* 设置遮罩层的层级 */
  pointer-events: auto; /* 阻止用户点击遮罩层下的元素 */
}

.modal {
  position: fixed;
  z-index: 1000;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  .modal-content {
    width: 80%;
    max-width: 400px;
    padding: 20px;
    background-color: white;
    border-radius: 8px;
    text-align: center;
    display: flex;
    justify-content: space-between;
	flex-direction: column;
	.top-content {
	  margin-bottom: 20px; /* 上部内容和中部内容之间的间距 */
	}
	.middle-content {
	  margin-bottom: 20px; /* 中部内容和下部内容之间的间距 */
	}
	.bottom-content {
	  display: flex;
	  justify-content: space-between;
	}
    .confirm-bottom{
  	  margin-top: 20rpx;
  	  width: 84%; /* 设置宽度为页面宽度的84%，留出左右各8%的空白 */
  	  margin-left: 8%; /* 左边距8% */
  	  margin-right: 8%; /* 右边距8% */
  	  height: 60rpx;
  	  border-radius: 40rpx; /* 圆角半径增加到20rpx */
  	  background-color: #3498db;
  	  color: white;
  	  font-size: 16rpx;
  	  text-align: center;
  	  line-height: 60rpx;
  	  font-size: 28rpx;
  	  border: none;
  	  z-index: 1001;
    }
    .cancel-bottom{
  	  margin-top: 20rpx;
  	  width: 84%; /* 设置宽度为页面宽度的84%，留出左右各8%的空白 */
  	  margin-left: 8%; /* 左边距8% */
  	  margin-right: 8%; /* 右边距8% */
  	  height: 60rpx;
  	  border-radius: 40rpx; /* 圆角半径增加到20rpx */
  	  background-color: #e74c3c;
  	  color: white;
  	  font-size: 16rpx;
  	  text-align: center;
  	  line-height: 60rpx;
  	  font-size: 28rpx;
  	  border: none;
  	  z-index: 1001;
    }
  }
}

</style>
