<template>
  <div class="hello">
    <el-table :data="orderSearch" border style="width: 100%">
      <el-table-column prop="orderId" label="订单Id"></el-table-column>
      <el-table-column prop="customerName" label="客户姓名"></el-table-column>
      <el-table-column prop="status" label="状态"></el-table-column>
      <el-table-column prop="totalPrice" label="总价"></el-table-column>
      <el-table-column prop="createTimestamp" label="下单时间"></el-table-column>
      <el-table-column prop="updateTimestamp" label="修改时间"></el-table-column>
      <el-table-column fixed="right" label="操作" width="180">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      :page-size="pageSize"
      :pager-count="11"
      layout="prev, pager, next"
      :total="total"
      @current-change="currentChange"
    ></el-pagination>
  </div>
</template>

<script>
import axios from "../api/common";
export default {
  name: "HelloWorld",
  data() {
    return {
      orderSearch: [],
      pageSize: 0,
      total: 0
    };
  },
  methods: {
    getOrderSearch(pageNum) {
      var search = {
        params: {
          pageNum: pageNum
        }
      };
      axios.get("/order/search", search).then(res => {
        this.orderSearch = res.data.list;
        this.pageSize = res.data.pageSize;
        this.total = res.data.total;
      });
    },
    currentChange(pageNum) {
      this.getOrderSearch(pageNum);
    },
    handleClick(row){
      this.$router.push({path:"/orderShow",query:{orderId:row.orderId}})
    }
  },
  mounted() {
    this.getOrderSearch();
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
