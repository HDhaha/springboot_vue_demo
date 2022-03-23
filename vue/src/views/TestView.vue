<template>
  <div style="width: 100%;height:80vh; background-color: darkslateblue; overflow:hidden">
    <div style="width:400px;margin: 150px auto">
      <div style="color: #cccccc;font-size: 30px;text-align: center;padding: 30px 0px">欢迎登陆</div>

      <el-form :inline="true" :model="formInline" >
        <el-form-item label="用户名:">
          <el-input :prefix-icon="Avatar"  v-model="formInline.name" placeholder="请输入你的用户名" />
        </el-form-item>
      </el-form>



    </div>
  </div>
  <el-button type="primary" icon="Edit" circle></el-button>
  <el-icon><arrow-down /></el-icon>
  <div style="font-size: 20px">
    <Avatar style="width: 1em; height: 1em; margin-right: 8px" />
  </div>
</template>

<script>
// import {Avatar} from '@element-plus/icons-vue';
import {Lock} from '@element-plus/icons-vue';
// import {Search} from '@element-plus/icons-vue';
const {Avatar} = require('@element-plus/icons-vue/dist');
// 一个用户图像+密码锁图标
// import { Avatar, Lock } from "@element-plus/icons-vue";
export default {
  name: "TestView",
  setup(){
    return {
      formInline:{
        Avatar
      },

    }
  },

}
</script>

<style scoped>

</style>