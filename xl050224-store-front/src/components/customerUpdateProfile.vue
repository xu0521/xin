<template>
  <div class="hello">
    <el-form ref="form" :model="customerUpdateForfile" label-width="180px">
      <el-form-item label="用户名">
        <el-input v-model="customerUpdateForfile.username" ></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="customerUpdateForfile.realName" ></el-input>
      </el-form-item>
      <el-form-item label="手机">
        <el-input v-model="customerUpdateForfile.mobile" ></el-input>
      </el-form-item>
      <el-form-item label="手机验证">
        <el-input v-model="customerUpdateForfile.mobileVerified" ></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="customerUpdateForfile.email"></el-input>
      </el-form-item>
      <el-form-item label="邮箱验证">
        <el-input v-model="customerUpdateForfile.emailVerified"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">更新</el-button>
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
      customerUpdateForfile:{}
    }
  },
  methods:{
    handleCustomerUpdate(){
      axios.get("/customer/getProfile").then(res=>{
        this.customerUpdateForfile = res.data;
      })
    },
    onSubmit(){
      axios.post("/customer/updateProfile",this.customerUpdateForfile).then(res=>{
        alert("更新成功")
      })
    }
  },
  mounted(){
    this.handleCustomerUpdate();
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
