import Vue from 'vue'
import App from './App'
import store from './pages/store/index.js'

//import uView from "uni_modules/uview-ui"
// 引用uView
//Vue.use(uView)

Vue.prototype.$store = store


Vue.config.productionTip = false

App.mpType = 'app'

const app = new Vue({
	store,
    ...App
})
app.$mount()

