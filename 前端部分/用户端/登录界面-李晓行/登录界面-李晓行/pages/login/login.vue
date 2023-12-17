
<template>
    <view>
    <!-- 标题栏 -->
    <view class="title-bar">
      <text class="title-text">欢迎登录</text>
    </view>

    <!-- 登录表单 -->
        <form @submit="login" class="login-form">
          <view class="input-group">
            <text class="input-label">校园网账号</text>
            <input type="text" v-model="username"  placeholder="请输入校园网账号" class="input-field" />
          </view>
		  <!-- 密码输入 -->
		  <view class="input-group password-group">
		      <text class="input-label password-label">密码</text>
		      <input
		        :type="showPassword ? 'text' : 'password'"
		        v-model="password"
		        placeholder="请输入密码"
		        class="input-field password-field"
				maxlength="16"
				@input="validatePassword"
		      />
		      <view class="password-toggle" @click="togglePassword">
		          <image :src="showPassword ? require('@/static/login/open.png') : require('@/static/login/close.png')" 
				  class="toggle-icon" />
		      </view>
		    </view>
		  <!-- 隐私协议 -->
		  <view class="privacy-agreement">
			  <checkbox-group name="checkbox">
					<label>
						<checkbox value="checkbox1" @click="toggleAgreement"/>
					</label>
			  </checkbox-group>
			  <text class="agreement-text">
				  <text class="agreement-link" @click="AgreementPage">点击阅读并同意《隐私协议》
				  </text>
			  </text>
		  </view>
          <button type="submit" class="login-button" @tap="login()">登录</button>
		  <button type="submit" class="Admin login-button" @tap="gotoAdmin()">管理员登录</button>
        </form>
    </view>
</template>

<script>
export default {
  data() {
	return{
		username:'',
		password:'',
		agreed: false, // 初始化复选框状态为未选中
		password: '', // 初始化密码为空
		showPassword: false // 控制密码显示状态，默认不显示密码
	};
  },
  methods: {
	  usernameInput(e){
		this.username=e.target.value;
	  },
	  
	  passwordInput(e){
		this.password=e.target.value;
	  },
    toggleAgreement() {
		
      this.agreed = !this.agreed; // 点击切换复选框状态
    },
	togglePassword() {
		
	  this.showPassword = !this.showPassword; // 切换密码显示状态
	},
	AgreementPage(){
		
		uni.navigateTo({
			url: '/pages/agreement/agreement',
		});
	},
	validatePassword() {
	      // 在这里进行密码长度的自定义验证
	      if (this.password.length > 16) {
	        // 如果密码超过长度限制，可以给出提示或做其他处理
	        this.password = this.password.slice(0, 16); // 截取到指定长度
			}
    },
    login(){
		//登录逻辑
		if (!this.agreed) {
		      // 如果用户未同意条款，可以给出提示或做其他处理
		      uni.showToast({
		        title: '请同意服务条款后再登录',
		        icon: 'none'
		      })
		      return; // 不执行登录逻辑
		    }
	  uni.request({
		url: 'http://8.134.201.230:8082/login',
		method: 'POST',
		data: {
		  username: this.username,
		  password: this.password
		},
		header: {
		  'content-type': 'application/json'
		},
		success: (res) => {
		  console.log(res.data);
		  if (res.data.code == 413) {
			uni.showToast({
			  title: '账号已禁用，请联系管理员',
			  icon: 'none'
			});
		  } else if (res.data.code == 200) {	//密码正确
			uni.navigateTo({
			  url: '/pages/index/index',
			  //if(res.data.data==2)	//管理员
			  //url： '/pages/index/AdministratorIndex'，
			  //else if(res.data.data==2)	//普通用户
			  //url： '/pages/index/UserIndex'，
			});
			uni.showToast({
			  title: res.data.msg,
			  icon: 'none'
			})
		  } else if (res.data.code == 411) {
			uni.showToast({
			  title: '登陆失败,用户名或密码输入错误',
			  icon: 'none'
			});
		  } else if (res.data.code == 412) {
			uni.showToast({
			  title: '登陆失败,该用户不存在',
			  icon: 'none'
			});
		  } else {
			uni.showToast({
			  title: '登陆失败,存在未知错误，请联系管理员',
			  icon: 'none'
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
	  });
	
	},
	gotoAdmin(){
		uni.navigateTo({
			url: '/pages/admin/admin',
		});
	}
  }
};
</script>

<style lang="scss">
/* 样式文件中添加样式 */
.title-bar {
  margin-top: 80rpx;
  height: calc(20rpx * 5); /* 设置为屏幕高度的1/5 */
  line-height: calc(20rpx * 5); /* 文字垂直居中 */
  padding-left: 90rpx; /* 左边距 */
  background-color: #ffffff; /* 根据自己的设计选择颜色 */
  margin-bottom: 80rpx;
  .title-text {
    font-size: 72rpx; /* 文字大小 */
    font-weight: bold;
    color: #333;
  }
}

.login-form {
  .input-group {
    margin-bottom: 50rpx; /* 增大密码提示文字和输入框之间的间隔为30rpx */
	.password-toggle {
	  position: absolute;
	  z-index: 2;
	  top: 80%;
	  right: 80rpx; /* 右侧间距 */
	  transform: translateY(-50%);
	  cursor: pointer;
	}
  }
  
  .input-label {
    font-size: 42rpx; /* 提示文字大小 */
    padding-left: 80rpx; /* 左边距 */
    color: #333;
    margin-bottom: 100rpx; /* 提示文字和输入框之间的间距 */
    font-weight: bold; /* 设置为粗体 */
	
  }
  
  .input-field {
    margin-top: 20rpx;
    padding: 10rpx; /* 输入框内边距 */
    border-radius: 6rpx; /* 输入框圆角 */
    border: 1rpx solid #ccc; /* 输入框边框 */
    border: none; /* 去掉边框 */
    border-bottom: 1rpx solid #ccc; /* 只显示底部边框 */
    width: 100%; /* 输入框宽度 */
    width: 80%; /* 设置宽度为页面宽度的80%，留出左右各10%的空白 */
    margin-left: 10%; /* 左边距10% */
    margin-right: 10%; /* 右边距10% */
	position: relative;
	z-index: 1;
  }
  .privacy-agreement {
    display: flex;
    align-items: center;
	margin-top: 40rpx;
    margin-bottom: 20rpx;
	padding-left: 80rpx; /* 左边距 */
  	.checkbox {
  	  width: 20rpx;
  	  height: 20rpx;
  	  border-radius: 50%;
  	  border: 1rpx solid #333;
  	  display: flex;
  	  align-items: center;
  	  justify-content: center;
  	  margin-right: 10rpx;
  	  cursor: pointer;
  	}
  	
  	.checked {
  	  width: 20rpx;
  	  height: 20rpx;
  	  border-radius: 50%;
  	  background-color: #333;
  	  
  	}
  
  	.agreement-text {
  	  font-size: 28rpx;
  	  color: #333;
	  white-space: nowrap;
  	}
	.agreement-link {
	  color: blue; /* 超链接文字颜色 */
	  text-decoration: underline; /* 给超链接添加下划线 */
	}
  }
}
.login-button {
  margin-top: 60rpx;
  margin-bottom: 100rpx; /* 提示文字和输入框之间的间距 */
  width: 84%; /* 设置宽度为页面宽度的84%，留出左右各8%的空白 */
  margin-left: 8%; /* 左边距8% */
  margin-right: 8%; /* 右边距8% */
  height: 60rpx;
  border-radius: 40rpx; /* 圆角半径增加到20rpx */
  background-color: rgb(124, 201, 199); /* 蓝绿色 */
  color: white;
  font-size: 16rpx;
  text-align: center;
  line-height: 60rpx;
  font-size: 28rpx;
  border: none;
}
.Admin{
	background-color: rgb(151,150,200);
}

.password-group {
	position: relative;
}

.toggle-icon {
  width: 60rpx;/*图标大小*/
  height: 60rpx;
  z-index: 2; /* 更高的 z-index 值 */
}

</style>
