<template>
  <div class="hello">
    <el-divider>订单信息</el-divider>
    <el-form ref="form" :model="orderShow" label-width="180px">
      <el-form-item label="订单Id">
        <el-input v-model="orderShow.orderId"></el-input>
      </el-form-item>
      <el-form-item label="订单时间">
        <el-date-picker v-model="orderShow.orderTime" type="datetime" placeholder="选择日期时间"></el-date-picker>
      </el-form-item>
    </el-form>
    <el-form ref="form" :model="returnApply" label-width="180px">
      <el-form-item label="客户姓名">
        <el-input v-model="returnApply.customerName"></el-input>
      </el-form-item>
      <el-form-item label="手机">
        <el-input v-model="returnApply.mobile"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="returnApply.email"></el-input>
      </el-form-item>
      <el-divider>退货商品信息</el-divider>
      <el-form-item label="商品代码">
        <el-input v-model="returnApply.productCode"></el-input>
      </el-form-item>
      <el-form-item label="商品名称">
        <el-input v-model="returnApply.productName"></el-input>
      </el-form-item>
      <el-form-item label="商品数量">
        <el-input type="number" v-model="returnApply.quantity"></el-input>
      </el-form-item>
      <el-form-item label="退货理由">
        <el-radio-group v-model="returnApply.reason">
          <el-radio label="0">发货过期</el-radio>
          <el-radio label="1">订单错误</el-radio>
          <el-radio label="2">收到错误商品</el-radio>
          <el-radio label="3">质量问题</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="备注">
        <el-input type="textarea" v-model="returnApply.comment"></el-input>
      </el-form-item>
      <el-form-item label="是否开封">
        <el-checkbox v-model="returnApply.opened">是否开封</el-checkbox>
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
      orderShow: {},
      returnApply: {},
      opened: [],
      productId: 0
    };
  },
  methods: {
    getOrderShow(orderId) {
      axios.get("order/getById", { params: { orderId: orderId } }).then(res => {
        this.orderShow = res.data;
        this.orderShow.orderTime = new Date(res.data.createTimestamp);
        var orderProducts = res.data.orderProduct;
        var returnProduct = orderProducts.find(
          p => p.productId === this.productId
        );
        this.returnApply = returnProduct;
      });
    },
    getReturnApply() {
      axios.get("/return/getList").then(res => {
        this.returnApply = res.data;
      });
    },
    onSubmit(){
      this.returnApply.orderId = this.orderShow.orderId;
      this.returnApply.orderTimestamp = this.orderShow.createTimestamp;
      axios.post("/return/apply",this.returnApply).then(res=>{
        alert("申请成功")
      })
    }
  },
  mounted() {
    this.getOrderShow(1);
    this.productId = 10;
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
