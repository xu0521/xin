<template>
  <div class="hello">
    <el-form ref="form" :model="customerRegister" label-width="180px">
      <el-form-item label="用户名">
        <el-input v-model="customerRegister.username" ></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="customerRegister.realName" ></el-input>
      </el-form-item>
      <el-form-item label="手机">
        <el-input v-model="customerRegister.mobile" ></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="customerRegister.email"></el-input>
      </el-form-item>
      <el-form-item label="请输入新密码">
        <el-input v-model="customerRegister.password" type="password"></el-input>
      </el-form-item>
      <el-form-item label="请确认新密码">
        <el-input v-model="rePassword" type="password"></el-input>
      </el-form-item>
      <el-form-item label="订阅新闻">
        <el-switch v-model="newsSubscribed"></el-switch>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">注册</el-button>
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
      customerRegister:{},
      rePassword:'',
      newsSubscribed:false
    }
  },
  methods:{
    onSubmit(){
      if(this.customerRegister.password !== this.rePassword){
        alert("密码不一致")
      }else{
        this.handleCustomerRegister();
      }
    },
    handleCustomerRegister(){
      this.customerRegister.newsSubscribed = this.newsSubscribed;
      axios.post("/customer/register",this.customerRegister).then(res=>{
        alert("注册成功")
        this.customerRegister = {};
        this.rePassword = '';
        this.newsSubscribed=false;
      })
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
