<template>
  <div>
    <el-col :span="12">
      <h5 class="mb-2">京东后台管理</h5>
      <el-menu default-active="user" class="el-menu-vertical-demo" default-openeds="1" style="width: 200px;min-height: 20vh">
          <!--@open="handleOpen"
          @close="handleClose"-->
        <el-sub-menu index="1">
          <template #title>系统管理</template>
            <el-menu-item index="user">用户管理</el-menu-item>
        </el-sub-menu>
      </el-menu>
    </el-col>
  </div>
</template>

<script>
export default {
  name: "Aside"
}
</script>

<style scoped>

</style>