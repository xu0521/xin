<template>
  <div class="hello">
    <el-form ref="form" :model="administratorForgetPwd" label-width="80px">
      <el-form-item label="邮箱">
        <el-input v-model="administratorForgetPwd.email"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">找回密码</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from '../api/common';
export default {
  name: "HelloWorld",
  data() {
    return {
      administratorForgetPwd: {}
    };
  },
  methods:{
    onSubmit(){
      axios.get("/administrator/getPwdResetCode",{params:{email:this.administratorForgetPwd.email}}).then(res=>{
        alert("验证码发送成功")
      }).catch(error=>{
        console.log(error)
      })
    }
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
