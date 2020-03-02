<template>
  <div class="hello">
    <el-table :data="administratorList" border style="width: 100%">
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
      total: 0
    };
  },
  methods: {
    getAdministratorList(pageNum) {
      axios
        .get("/administrator/getList", { params: { pageNum: pageNum } })
        .then(res => {
          this.administratorList = res.data.list;
          this.total = res.data.total;
          this.pageSize = res.data.pageSize;
        });
    },
    currentChange(pageNum) {
      this.getAdministratorList(pageNum);
    },
    handleClick(row){
      this.$router.push({name:"AdministratorUpdate" , params:row})
    },
    handleDelete(row){
      var administratorId = row.administratorId;
      if(confirm("确认删除？")){
        axios.post("/administrator/delete",administratorId,
        {
          headers:{
            'Content-Type':'application/json'
          }
        }).then(res=>{
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
