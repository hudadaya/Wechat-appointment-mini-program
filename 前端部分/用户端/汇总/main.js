import Vue from 'vue'
import App from './App'
//import router from './router'; // 引入路由器文件

Vue.config.productionTip = false

App.mpType = 'app'

const app = new Vue({
    ...App,
	username: '',
})
Vue.prototype.$app = app
app.$mount()
