// router.js 文件内容示例
import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
  // 定义你的路由规则
  {
    path: './pages/user',
    component: () => import('./user.vue') // 替换为你的实际组件路径
  },
  {
    path: './login',
    component: () => import('./login.vue') // 替换为你的登录页组件路径
  },
  // 其他路由规则
];

const router = new VueRouter({
  routes,
  mode: 'history' // 路由模式，可选值为 'hash' 或 'history'
});

export default router;
