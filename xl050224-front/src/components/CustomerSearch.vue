<template>
  <div class="hello">
    <el-table :data="customerSearch" border style="width: 100%">
      <el-table-column prop="username" label="客户用户名"></el-table-column>
      <el-table-column prop="realName" label="客户姓名"></el-table-column>
      <el-table-column prop="mobile" label="手机"></el-table-column>
      <el-table-column prop="email" label="邮箱"></el-table-column>
      <el-table-column prop="status" label="状态"></el-table-column>
      <el-table-column prop="createTimestamp" label="注册日期"></el-table-column>
      <el-table-column fixed="right" label="操作" width="180">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination :page-size="pageSize" :pager-count="11" layout="prev, pager, next" :total="total" @current-change="currentChange"></el-pagination>
  </div>
</template>

<script>
import axios from "../api/common";
export default {
  name: "HelloWorld",
  data() {
    return {
      customerSearch: [],
      pageSize:5,
      total:0
    };
  },
  methods: {
    getCustomerList(pageNum) {
      var search = {
        params: {
          pageNum: pageNum
        }
      };
      axios.get("/customer/search", search).then(res => {
        this.customerSearch = res.data.list;
        this.total = res.data.total;
        this.pageSize = res.data.pageSize;
      });
    },
    currentChange(pageNum){
      this.getCustomerList(pageNum)
    }
  },
  mounted() {
    this.getCustomerList();
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
