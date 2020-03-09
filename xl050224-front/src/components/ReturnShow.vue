<template>
  <div class="hello">
    <el-form ref="form" :model="returnShow" label-width="80px">
      <el-form-item label="退货Id">
        <el-input v-model="returnShow.returnId"></el-input>
      </el-form-item>
      <el-form-item label="订单Id">
        <el-input v-model="returnShow.orderId"></el-input>
      </el-form-item>
      <el-form-item label="订单时间">
        <el-input v-model="returnShow.orderTimestamp"></el-input>
      </el-form-item>
      <el-form-item label="客户姓名">
        <el-input v-model="returnShow.customerName"></el-input>
      </el-form-item>
      <el-form-item label="手机">
        <el-input v-model="returnShow.mobile"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="returnShow.email"></el-input>
      </el-form-item>
      <el-form-item label="状态">
        <el-input v-model="returnShow.status"></el-input>
      </el-form-item>
      <el-form-item label="处理方式">
        <el-input v-model="returnShow.action"></el-input>
      </el-form-item>
      <el-divider>退货商品信息</el-divider>
      <el-form-item label="商品代号">
        <el-input v-model="returnShow.productCode"></el-input>
      </el-form-item>
      <el-form-item label="商品名称">
        <el-input v-model="returnShow.productName"></el-input>
      </el-form-item>
      <el-form-item label="数量">
        <el-input v-model="returnShow.quantity"></el-input>
      </el-form-item>
      <el-form-item label="退货原因">
        <el-input v-model="returnShow.reason"></el-input>
      </el-form-item>
      <el-form-item label="是否开封">
        <el-input v-model="returnShow.opened"></el-input>
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="returnShow.comment"></el-input>
      </el-form-item>
      <el-form-item label="申请时间">
        <el-input v-model="returnShow.createTimestamp"></el-input>
      </el-form-item>
      <el-form-item label="更新时间">
        <el-input v-model="returnShow.updateTimestamp"></el-input>
      </el-form-item>
      <el-form-item label="处理方式">
        <el-select v-model="selectedAction" placeholder="请选择处理方式">
          <el-option
            v-for="item in actions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
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
      returnShow: {},
      actions: [
        { value: 0, label: "退货" },
        { value: 1, label: "换货" },
        { value: 2, label: "修理" }
      ],
      selectedAction: ""
    };
  },
  methods: {
    getReturnShow(returnId) {
      axios
        .get("/return/getById", { params: { returnId: returnId } })
        .then(res => {
          this.returnShow = res.data;
        });
    },
    onSubmit(){
      axios.post("/return/updateAction",{
                returnId: this.returnShow.returnId,
                action: this.selectedAction
            }).then(res=>{
         alert("处理方式更新成功") 
         this.getReturnShow(1);
      })
    }
  },
  mounted() {
    this.getReturnShow(1);
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
