<template>
  <div class="hello">
    <el-form ref="form" :model="administratorForgetPwd" label-width="80px" v-loading="loading">
      <el-form-item label="邮箱">
        <el-input v-model="administratorForgetPwd.email" placeholder="请输入邮箱号"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit()" :disabled="!buttonEnabled">找回密码</el-button>
        <span v-show="!buttonEnabled">{{counter}}秒</span>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "../api/common";
export default {
  name: "HelloWorld",
  data() {
    return {
      administratorForgetPwd: {},
      loading:false,
      buttonEnabled:true,
      counter:60
    };
  },
  methods: {
    onSubmit() {
      this.loading = true;
      this.buttonEnabled = false;
      this.counter = 60;
      setInterval(res=>{
        this.counter--;
        if(this.counter < 0 ){
          this.buttonEnabled = true;
        }
      },1000)
      axios
        .get("/administrator/getPwdResetCode", {
          params: { email: this.administratorForgetPwd.email }
        })
        .then(res => {
          this.loading = false;
          this.administratorForgetPwd = {};
          alert("验证码发送成功");
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  mounted() {}
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
