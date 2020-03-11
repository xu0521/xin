<template>
  <div class="hello">
     <el-form ref="form" :model="customerResetPwd" label-width="180px">
      <el-form-item label="邮箱">
        <el-input v-model="customerResetPwd.email"></el-input>
      </el-form-item>
      <el-form-item label="请输入验证码">
        <el-input v-model="customerResetPwd.resetCode" ></el-input>
      </el-form-item>
      <el-form-item label="请输入新密码">
        <el-input v-model="customerResetPwd.newPed" type="password"></el-input>
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
import axios from '../api/common'
export default {
  name: 'HelloWorld',
  data () {
    return {
      customerResetPwd:{},
      reNewPwd:''
    }
  },
  methods:{
    onSubmit(){
      if(this.customerResetPwd.newPed !== this.reNewPwd){
        alert("密码不一致")
      }else{
        this.handleResetPwd();
      }
    },
    handleResetPwd(){
      axios.post("/customer/resetPwd",this.customerResetPwd).then(res=>{
        alert("秘密修改成功")
        this.customerResetPwd={};
        this.reNewPwd = '';
      })
    },
    resetForm(){
      this.customerResetPwd={};
      this.reNewPwd = '';
    }
  },
  mounted(){

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
