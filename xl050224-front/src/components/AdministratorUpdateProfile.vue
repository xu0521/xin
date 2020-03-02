<template>
  <div class="hello">
    <el-form ref="form" :model="administratorUpdateProfile" label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="administratorUpdateProfile.username" readonly></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="administratorUpdateProfile.realName" ></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="administratorUpdateProfile.email" ></el-input>
      </el-form-item>
      <el-form-item label="头像">
        <el-input v-model="administratorUpdateProfile.avatarUrl" ></el-input>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-input v-model="administratorUpdateProfile.createTime" readonly></el-input>
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
      administratorUpdateProfile:{},
      administratorId:""
    };
  },
  methods:{
    GetAdministratorUpdateProfile(){
      axios.get("/administrator/getProfile").then(res=>{
        this.administratorId = res.data.administratorId;
        this.administratorUpdateProfile = res.data;
      })
    },
    onSubmit(){
      axios.post("/administrator/updateProfile",this.administratorUpdateProfile).then(res=>{
        
      })
    }
  },
  mounted(){
    this.GetAdministratorUpdateProfile();
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
