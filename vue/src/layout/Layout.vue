<template>
  <div>
    <!--头部-->
    <harder ></harder>
    <!--主体-->
    <div style="display:flex ">
      <!--侧边栏-->
      <Aside></Aside>
      <!--内容区域-->
      <router-view style="flex:1"></router-view>
    </div>
  </div>
</template>

<script>
/*  引入  写的头部  */
import Harder from "@/components/Harder";
import Aside from "@/components/Aside";

export default {
  name: "Layout",
  components:{
    Harder,
    Aside
  }
}
</script>

<style scoped>

</style>