<template>
  <div class="hello">
    <el-form ref="form" :model="customerChangePwd" label-width="180px">
      <el-form-item label="原密码">
        <el-input v-model="originPwd" type="password"></el-input>
      </el-form-item>
      <el-form-item label="新密码">
        <el-input v-model="newPwd" type="password"></el-input>
      </el-form-item>
      <el-form-item label="确认新密码">
        <el-input v-model="reNewPwd" type="password"></el-input>
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
      customerChangePwd: {},
      originPwd:'',
      newPwd:'',
      reNewPwd:''
    };
  },
  methods:{
    onSubmit(){
      if(this.newPwd === ''){
        alert("新密码不能为空")
      }else if(this.originPwd === ''){
        alert("原密码不能为空")
      }else if(this.reNewPwd === ''){
        alert("确认密码不能为空")
      }else if(this.newPwd !== this.reNewPwd){
        alert("密码不一致")
      }else{
        this.handleChangePwdClick();
      }
    },
    handleChangePwdClick(){
      this.customerChangePwd.originPwd = this.originPwd;
      this.customerChangePwd.newPwd = this.newPwd;
      axios.post("/customer/changePwd",this.customerChangePwd).then(res=>{
        alert("密码修改成功")
        this.originPwd = '';
        this.newPwd = '';
        this.reNewPwd = '';
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
