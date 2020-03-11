<template>
  <div class="hello">
    <el-form ref="form" :model="customerPorgetPwd" label-width="80px">
      <el-form-item label="邮箱">
        <el-input v-model="customerPorgetPwd.email"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
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
      customerPorgetPwd: {}
    };
  },
  methods:{
    onSubmit(){
      axios.get("/customer/getPwdResetCode",{params:{email:this.customerPorgetPwd.email}}).then(res=>{
        alert("邮件发送成功")
        this.customerPorgetPwd = {}
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
