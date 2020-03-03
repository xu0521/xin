<template>
  <div class="hello">
    <el-button type="primary" plain @click="administratorCreate">添加</el-button>
    <el-button type="danger" plain @click="headleBatchDelete">批量删除</el-button>
    <el-table
      ref="multipleTable"
      :data="administratorList"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="username" label="用户名"></el-table-column>
      <el-table-column prop="realName" label="姓名"></el-table-column>
      <el-table-column prop="status" label="状态"></el-table-column>
      <el-table-column prop="createTime" label="创建时间"></el-table-column>
      <el-table-column fixed="right" label="操作" width="180">
        <template slot-scope="scope">
          <el-button @click="handleDelete(scope.row)" type="text" size="small">删除</el-button>
          <el-button @click="handleClick(scope.row)" type="text" size="small">编辑</el-button>
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
      administratorList: [],
      pageSize: 5,
      total: 0,
      selectedAdministrators:[]
    };
  },
  computed:{
    selectedAdministratorIds(){
      return this.selectedAdministrators.map(a => a.administratorId);
    }
  },
  methods: {
    //列表显示
    getAdministratorList(pageNum) {
      axios
        .get("/administrator/getList", { params: { pageNum: pageNum } })
        .then(res => {
          this.administratorList = res.data.list;
          this.total = res.data.total;
          this.pageSize = res.data.pageSize;
        });
    },
    //页码
    currentChange(pageNum) {
      this.getAdministratorList(pageNum);
    },
    //修改
    handleClick(row) {
      this.$router.push({ name: "AdministratorUpdate", params: row });
    },
    //单删
    handleDelete(row) {
      var administratorId = row.administratorId;
      if (confirm("确认删除？")) {
        axios
          .post("/administrator/delete", administratorId, {
            headers: {
              "Content-Type": "application/json"
            }
          })
          .then(res => {
            this.getAdministratorList();
          });
      }
    },
    //添加
    administratorCreate() {
      this.$router.push("/administratorCreate");
    },
    //全选
    handleSelectionChange(val){
      this.selectedAdministrators = val;
    },
    //批量删除
    headleBatchDelete(){
      if (confirm("确认删除？")) {
        axios.post("/administrator/batchDelete",this.selectedAdministratorIds).then(res=>{
          this.getAdministratorList();
        })
      }
    }
  },
  mounted() {
    this.getAdministratorList();
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
