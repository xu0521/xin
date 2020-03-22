<template>
  <div class="hello">
    <el-table :data="customerSearch" border style="width: 100%">
      <el-table-column prop="username" label="客户用户名"></el-table-column>
      <el-table-column prop="realName" label="客户姓名"></el-table-column>
      <el-table-column prop="mobile" label="手机"></el-table-column>
      <el-table-column prop="email" label="邮箱"></el-table-column>
      <el-table-column prop="status" label="状态">
        <template slot-scope="scope">
          <el-select v-model="scope.row.status" placeholder="请选择状态">
            <el-option
              v-for="item in stautses"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </template>
      </el-table-column>
      <el-table-column prop="createTimestamp" label="注册日期"></el-table-column>
      <el-table-column fixed="right" label="操作" width="180">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button @click="handleUpdateStatus(scope.row)" type="text" size="small">更新状态</el-button>
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
      customerSearch: [],
      pageSize: 5,
      total: 0,
      stautses: [
        {
          value: 0,
          label: "禁用"
        },
        {
          value: 1,
          label: "启用"
        },
        {
          value: 2,
          label: "不安全"
        }
      ]
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
    currentChange(pageNum) {
      this.getCustomerList(pageNum);
    },
    handleClick(row) {
      this.$router.push({ path: "/layout/customerShow", query: {customerId:row.customerId} });
    },
    handleUpdateStatus(row){
      this.getUpdateStatus(row.customerId,row.status);
    },
    getUpdateStatus(customerId,status){
      axios.post("/customer/setStatus",{customerId:customerId,status:status}).then(res=>{
        this.$message.success('状态更新成功');
      })
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
