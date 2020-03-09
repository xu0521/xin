<template>
  <div class="hello">
    <el-divider>退货历史信息</el-divider>
    <el-table :data="returnHistoryList" border style="width: 100%">
      <el-table-column prop="timestamp" label="时间"></el-table-column>
      <el-table-column prop="returnStatus" label="退货状态"></el-table-column>
      <el-table-column prop="comment" label="备注"></el-table-column>
      <el-table-column label="是否通知客户">
        <template slot-scope="scope">{{scope.row.customerNotified}}</template>
      </el-table-column>
    </el-table>

    <br />
    <el-divider>添加历史信息</el-divider>
    <br />
    <el-form ref="form" :model="returnHistoryCreate" label-width="180px">
      <el-form-item label="退货状态">
        <el-select v-model="selectedReturnStatus" placeholder="请选择退货状态">
          <el-option
            v-for="item in returnStatuses"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="是否通知客户">
        <el-checkbox v-model="returnHistoryCreate.customerNotified">是否通知客户</el-checkbox>
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="returnHistoryCreate.comment" type="textarea" placeholder="请输入备注"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
        <el-button>取消</el-button>
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
      returnHistoryList: [],
      returnHistoryCreate: {},
      selectedReturnStatus: "",
      returnStatuses: [
        { value: 1, label: "待取货" },
        { value: 2, label: "正在处理" },
        { value: 3, label: "完成" },
        { value: 4, label: "拒绝" }
      ],
      returnId:''
    };
  },
  methods: {
    getReturnHistory() {
      axios
        .get("/returnhistory/getListByReturnId", {
          params: { returnId: this.returnId }
        })
        .then(res => {
          this.returnHistoryList = res.data;
        });
    },
    onSubmit(){
      this.returnHistoryCreate.returnId = this.returnId;
      this.returnHistoryCreate.returnStatus = this.selectedReturnStatus;
      console.log(this.returnHistoryCreate)
      axios.post("/returnhistory/create", this.returnHistoryCreate).then(res=>{
        alert("创建成功")
        this.returnHistoryCreate={};
        this.selectedReturnStatus='';
        this.returnHistoryCreate.customerNotified = false;
        this.getReturnHistory(1);
      })
    }
  },
  mounted() {
    this.returnId = 1;
    this.getReturnHistory();
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
