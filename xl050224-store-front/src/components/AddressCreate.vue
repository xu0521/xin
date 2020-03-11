<template>
  <div class="hello">
    <el-form ref="form" :model="addressCreate" label-width="180px">
      <el-form-item label="标签">
        <el-input v-model="addressCreate.tag"></el-input>
      </el-form-item>
      <el-form-item label="收货人姓名">
        <el-input v-model="addressCreate.receiverName"></el-input>
      </el-form-item>
      <el-form-item label="收货人手机">
        <el-input v-model="addressCreate.receiverMobile"></el-input>
      </el-form-item>
      <el-form-item label="地址内容">
        <el-input v-model="addressCreate.content"></el-input>
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
      addressCreate: {}
    };
  },
  methods:{
    onSubmit(){
      axios.post("/address/create",this.addressCreate).then(res=>{
        alert("创建成功")
        this.addressCreate ={};
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
