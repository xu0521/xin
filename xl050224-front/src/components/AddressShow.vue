<template>
  <div class="hello">
    <el-form ref="form" :model="addressShow" label-width="180px">
      <el-form-item label="标签">
        <el-input v-model="addressShow.tag" readonly></el-input>
      </el-form-item>
      <el-form-item label="内容">
        <el-input v-model="addressShow.content" readonly></el-input>
      </el-form-item>
      <el-form-item label="收货人姓名">
        <el-input v-model="addressShow.receiverName" readonly></el-input>
      </el-form-item>
      <el-form-item label="收货人手机">
        <el-input v-model="addressShow.receiverMobile" readonly></el-input>
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
      addressShow: {}
    };
  },
  methods: {
    getAddressShow(addressId) {
      axios.get("/address/getById", {params:{addressId:addressId}}).then(res => {
        this.addressShow = res.data;
      });
    }
  },
  mounted() {
    if(this.$route.query){
      var addressId = this.$route.query.addressId;
      this.getAddressShow(addressId);
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
