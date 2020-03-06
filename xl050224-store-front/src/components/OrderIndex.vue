<template>
  <div class="hello">
    <el-table :data="orderList" border style="width: 100%">
      <el-table-column prop="orderId" label="订单Id"></el-table-column>
      <el-table-column prop="status" label="订单状态"></el-table-column>
      <el-table-column prop="totalPrice" label="总价"></el-table-column>
      <el-table-column prop="createTime" label="下单时间"></el-table-column>
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
      orderList: [],
      pageSize:5,
      total:0
    };
  },
  methods: {
    getOrderList(pageNum) {
      axios.get("/order/getList",{params:{pageNum:pageNum}}).then(res => {
        this.orderList = res.data.list;
        this.total = res.data.total;
        this.pageSize = res.data.pageSize;
      });
    },
    currentChange(pageNum){
      this.getOrderList(pageNum);
    }
  },
  mounted() {
    this.getOrderList();
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
