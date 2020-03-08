<template>
  <div class="hello">
    <el-table :data="returnList" border style="width: 100%">
      <el-table-column prop="returnId" label="退货Id"></el-table-column>
      <el-table-column prop="status" label="退货状态"></el-table-column>
      <el-table-column prop="createTimestamp" label="退货申请时间"></el-table-column>
      <el-table-column prop="orderId" label="订单Id"></el-table-column>
      <el-table-column prop="customerName" label="客户姓名"></el-table-column>
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
      returnList: [],
      pageSize: 0,
      total: 0
    };
  },
  methods: {
    getReturnList(pageNum) {
      axios
        .get("/return/getList", { params: { pageNum: pageNum } })
        .then(res => {
          this.returnList = res.data.list;
          this.pageSize = res.data.pageSize;
          this.total = res.data.total;
        });
    },
    currentChange(pageNum) {
      this.getReturnList(pageNum);
    }
  },
  mounted() {
    this.getReturnList();
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
