import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../layout/Layout.vue'
/*设置登陆的地址  当访问路径 */
const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    /*重定向,当访问路径为:https://127.0.0.1:9876/  会自动跳转  https://127.0.0.1:9876/home  */
    redirect:"/home",
    /*  二次嵌套路由数组,可编辑多个页面*/
    children:[
      {
        path: '/home',
        name: 'Home',
        component: ()=>import("@/views/HomeView")
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: ()=>import("@/views/LoginView")
  },
  {
    path: '/test',
    name: 'test',
    component: ()=>import("@/views/TestView")
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
