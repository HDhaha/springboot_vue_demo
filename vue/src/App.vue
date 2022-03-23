<template>
  <div>
    <router-view style="flex:1"></router-view>
  </div>

</template>
<script>
import { ElConfigProvider } from 'element-plus'

export default {
  name:"App",
  components: {
    [ElConfigProvider.name]: ElConfigProvider,
  },
}
</script>
