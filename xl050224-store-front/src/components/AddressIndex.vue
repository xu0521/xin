<template>
  <div class="hello">
    <el-table :data="addressIndex" border style="width: 100%">
      <el-table-column prop="tag" label="标签" ></el-table-column>
      <el-table-column prop="receiverName" label="收货人姓名"></el-table-column>
      <el-table-column prop="receiverMobile" label="收货人手机"></el-table-column>
      <el-table-column prop="content" label="地址"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from '../api/common';
export default {
  name: "HelloWorld",
  data() {
    return {
      addressIndex:[]
    };
  },
  methods:{
    getAddressIndex(){
      axios.get("/address/getListByCustomerId").then(res=>{
        this.addressIndex = res.data;
      })
    }
  },
  mounted(){
    this.getAddressIndex();
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
