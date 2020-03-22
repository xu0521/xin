<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
.el-submenu__title {
    width: 270px;
}
.el-header {
  background-color: #303133;
  color: #ffffff;
  line-height: 60px;
}
.el-aside {
  color: #333;
}
</style>
