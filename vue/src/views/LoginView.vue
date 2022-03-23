<template>
  <div style="width: 100%;height:100vh; background-color: darkslateblue; overflow:hidden">
    <div style="width:400px;margin: 150px auto">
      <div style="color: #cccccc;font-size: 30px;text-align: center;padding: 30px 0px">欢迎登陆</div>
        <!--size  尺寸变大-->
      <el-form :inline="true" :model="formInline" >
        <el-form-item label="用户名:">
          <el-input :prefix-icon="Avatar"  v-model="formInline.name" placeholder="请输入你的用户名" />
        </el-form-item>
        <el-form-item label="密&#12288;码:">
          <el-input :prefix-icon="Lock" v-model="formInline.password" placeholder="请输入你的密码" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width: 100%">登 陆</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>

</template>
<script>
//组件script
// 一个用户图像+密码锁图标
// import { Avatar, Lock } from "@element-plus/icons-vue";
import {Avatar} from '@element-plus/icons-vue';
import {Lock} from '@element-plus/icons-vue';
const {Search} = require('@element-plus/icons-vue/dist');
// const {Avatar} = require('@element-plus/icons-vue/dist');
// const {Lock} = require('@element-plus/icons-vue/dist');
export default {
  name: "LoginView",
  components: {
    Avatar,
    Lock,
    Search,
  },
  data(){
    return{
      formInline:{
        Avatar,
        Lock,
        Search,
      },
    }
  },

}
</script>
<style scoped>

</style>