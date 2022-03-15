import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import '@/assets/css/globai.css'
/*引入  element-plus  样式框架  网址  https://element-plus.gitee.io/zh-CN/guide/quickstart.html */
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
/* 引入 element-plus  使用中文  */
import zhCn from 'element-plus/es/locale/lang/zh-cn'
/*引入  element-plus  样式框架     .app.use(ElementPlus)  */
createApp(App).use(store).use(router).use(ElementPlus,{locale: zhCn,size:'small'}).mount('#app')
