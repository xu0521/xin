<template>
  <div class="hello">
    <el-table :data="addressList" border style="width: 100%">
      <el-table-column prop="tag" label="标签"></el-table-column>
      <el-table-column prop="content" label="内容"></el-table-column>
      <el-table-column prop="receiverName" label="姓名"></el-table-column>
      <el-table-column prop="receiverMobile" label="手机"></el-table-column>
      <el-table-column fixed="right" label="操作" width="180">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
import axios from "../api/common";
export default {
  name: "HelloWorld",
  data() {
    return {
      addressList: []
    };
  },
  methods: {
    getAddressList(customerId) {
      axios
        .get("/address/getListByCustomerId", {
          params: { customerId: customerId }
        })
        .then(res => {
          this.addressList = res.data;
        });
    },
    handleClick(row){
      this.$router.push({path:"/addressShow",query:{addressId:row.addressId}})
    }
  },
  mounted() {
    this.getAddressList(1);
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
