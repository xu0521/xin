<template>
  <div class="hello">
    <el-form ref="form" :model="addressUpdate" label-width="180px">
      <el-form-item label="标签">
        <el-input v-model="addressUpdate.tag"></el-input>
      </el-form-item>
      <el-form-item label="收货人姓名">
        <el-input v-model="addressUpdate.receiverName"></el-input>
      </el-form-item>
      <el-form-item label="收货人手机">
        <el-input v-model="addressUpdate.receiverMobile"></el-input>
      </el-form-item>
      <el-form-item label="地址内容">
        <el-input v-model="addressUpdate.content"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">更新</el-button>
        <el-button>取消</el-button>
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
      addressUpdate:{}
    }
  },
  methods:{
    getAddressById(addressId){
      axios.get("/address/getById",{params:{addressId:addressId}}).then(res=>{
        this.addressUpdate = res.data;
      })
    },
    onSubmit(){
      axios.post("/address/update",this.addressUpdate).then(res=>{
        alert("更新成功")
      })
    }
  },
  mounted(){
    this.getAddressById(5)
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
