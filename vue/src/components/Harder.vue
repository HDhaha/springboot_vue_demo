<template>
  <div style="height: 50px;line-height: 50px;border-bottom: 1px solid #cccccc;display: flex">
    <div style="width: 200px;padding-left: 30px;font-weight: bold;color: blue">后台管理</div>
    <div style="flex: 1"></div>
    <div style="width: 100px;">
      <el-dropdown>
        <el-button type="primary" style="padding-left: 10px">
          root<el-icon class="el-icon--right"><arrow-down /></el-icon>
        </el-button>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>个人信息</el-dropdown-item>
            <el-dropdown-item>修改密码</el-dropdown-item>
            <el-dropdown-item>退出登陆</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
/*  设置  返回的 方法 名字 */
export default {
  name: "Harder"
}
</script>

<style scoped>

</style>