<template>
  <div class="hello">
    <el-form ref="form" :model="administratorLogin" label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="username"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input type="password" v-model="password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "../api/common"
export default {
  name: "HelloWorld",
  data() {
    return {
      administratorLogin: {},
      username:"",
      password:""
    };
  },
  methods:{
    onSubmit(){
      var administrator = {
        params:{
          username : this.username,
          password : this.password
        }
      }
      axios.get("/administrator/login",administrator).then(res=>{
        var dto = res.data;
        localStorage['jcartToken'] = dto.token;
        localStorage['expireTimestamp'] = dto.expireTimestamp;
        alert("登录成功")
      })
    }
  },
  mounted(){

  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
