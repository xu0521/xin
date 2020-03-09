<template>
  <div class="hello">
    <el-table :data="returnSearch" border style="width: 100%">
      <el-table-column prop="returnId" label="退货Id"></el-table-column>
      <el-table-column prop="orderId" label="订单Id"></el-table-column>
      <el-table-column prop="customerName" label="客户姓名"></el-table-column>
      <el-table-column prop="productCode" label="商品代号"></el-table-column>
      <el-table-column prop="productName" label="商品名称"></el-table-column>
      <el-table-column prop="status" label="状态"></el-table-column>
      <el-table-column prop="createTimestamp" label="申请时间"></el-table-column>
      <el-table-column prop="updateTimestamp" label="修改日期"></el-table-column>
    </el-table>
    <el-pagination :page-size="pageSize" :pager-count="11" layout="prev, pager, next" :total="total" @current-change="currentChange"></el-pagination>
  </div>
</template>

<script>
import axios from '../api/common';
export default {
  name: "HelloWorld",
  data() {
    return {
      returnSearch: [],
      pageSize:0,
      total:0
    };
  },
  methods:{
    getReturnSearch(pageNum){
      var search = {
        params:{
          pageNum :pageNum
        }
      }
      axios.get("/return/search",search).then(res=>{
        this.returnSearch = res.data.list;
        this.total = res.data.total;
        this.pageSize = res.data.pageSize;
      })
    },
    currentChange(pageNum){
      this.getReturnSearch(pageNum);
    }
  },
  mounted(){
    this.getReturnSearch()
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
