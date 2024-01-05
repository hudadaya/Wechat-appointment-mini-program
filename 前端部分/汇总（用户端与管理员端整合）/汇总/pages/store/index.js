import Vue from 'vue'

import Vuex from 'vuex'

Vue.use(Vuex)
import tabBar from '@/components/utils/tabBar.js' // 引入刚刚创建的tabBar.js
const store = new Vuex.Store({
    state: {
		//公共的变量，这里的变量不能随便修改，只能通过触发mutations的方法才能改变
		tabBarList: [],
	},
    mutations: {
		//相当于同步的操作
				setRoleId(state,data){
					//console.log(data)
					state.tabBarList = tabBar[data]
					//console.log(state.tabBarList)
					uni.setStorageSync('tabBarList', tabBar[data]) // 根据登录时传过来的值,存储对应的tabbarlist
				}
	},
    actions: {
		//相当于异步的操作,不能直接改变state的值，只能通过触发mutations的方法才能改变
	}
})
export default store
