<template>
  <div class="hello">
    <el-form ref="form" :model="administratorResettPwd" label-width="180px">
      <el-form-item label="邮箱">
        <el-input v-model="administratorResettPwd.email"></el-input>
      </el-form-item>
      <el-form-item label="请输入验证码">
        <el-input v-model="administratorResettPwd.resetCode" ></el-input>
      </el-form-item>
      <el-form-item label="请输入新密码">
        <el-input v-model="administratorResettPwd.newPed" type="password"></el-input>
      </el-form-item>
      <el-form-item label="请确认新密码">
        <el-input v-model="reNewPwd" type="password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">找回密码</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from '../api/common';
export default {
  name: 'HelloWorld',
  data () {
    return {
      administratorResettPwd:{},
      reNewPwd:""
    }
  },
  methods:{
    onSubmit(){
      if(this.administratorResettPwd.newPed === ''){
        alert("密码不能为空")
      }else if(this.reNewPwd === ''){
        alert("密码不能为空")
      }else if(this.administratorResettPwd.newPed !== this.reNewPwd){
        alert("密码不一致")
      }else{
        this.handleResetPwdClick();
      }
        
    
      
    },
    handleResetPwdClick(){
      axios.post("/administrator/resetPwd",this.administratorResettPwd).then(res=>{
        alert("密码修改成功")
        this.administratorResettPwd = {};
      }).catch(error=>{
        console.log(error);
      })
    },
    resetForm(){
      this.administratorResettPwd = {}
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
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
