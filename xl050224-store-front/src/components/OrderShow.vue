<template>
  <div class="hello">
    <el-form ref="form" :model="orderShow" label-width="80px">
      <el-form-item label="订单Id">
        <el-input v-model="orderShow.orderId" readonly></el-input>
      </el-form-item>
      <el-form-item label="订单状态">
        <el-input v-model="orderShow.status" readonly></el-input>
      </el-form-item>
      <el-form-item label="总价">
        <el-input v-model="orderShow.totalPrice" readonly></el-input>
      </el-form-item>
      <el-form-item label="积分">
        <el-input v-model="orderShow.rewordPoints" readonly></el-input>
      </el-form-item>
      <el-form-item label="下单时间">
        <el-input v-model="orderShow.createTimestamp" readonly></el-input>
      </el-form-item>
      <el-form-item label="更新时间">
        <el-input v-model="orderShow.updateTimestamp" readonly></el-input>
      </el-form-item>
      <el-form-item label="寄送方式">
        <el-input v-model="orderShow.shipMethod" readonly></el-input>
      </el-form-item>
      <el-form-item label="寄送地址">
        <el-input v-model="orderShow.shipAddress" readonly></el-input>
      </el-form-item>
      <el-form-item label="寄送费用">
        <el-input v-model="orderShow.shipPrice" readonly></el-input>
      </el-form-item>
      <el-form-item label="支付方式">
        <el-input v-model="orderShow.payMethod" readonly></el-input>
      </el-form-item>
      <el-form-item label="发票地址">
        <el-input v-model="orderShow.invoiceAddress" readonly></el-input>
      </el-form-item>
      <el-form-item label="发票金额">
        <el-input v-model="orderShow.invoicePrice" readonly></el-input>
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="orderShow.comment" readonly></el-input>
      </el-form-item>
      <el-form-item label="订单商品">
        <el-table :data="orderShow.orderProduct" border style="width: 100%">
          <el-table-column prop="productCode" label="商品代码" ></el-table-column>
          <el-table-column prop="productName" label="商品名称" ></el-table-column>
          <el-table-column prop="quantity" label="数量"></el-table-column>
          <el-table-column prop="unitPrice" label="单价"></el-table-column>
          <el-table-column prop="totalPrice" label="总计"></el-table-column>
        </el-table>
      </el-form-item>
      <el-form-item label="总价">
        <el-input v-model="orderShow.totalPrice" readonly></el-input>
      </el-form-item>
      <el-form-item label="寄送费">
        <el-input v-model="orderShow.shipPrice" readonly></el-input>
      </el-form-item>
      <el-form-item label="应付">
        {{orderShow.totalPrice + orderShow.shipPrice}}
      </el-form-item>
      <el-form-item label="订单历史">
        <el-table :data="orderShow.orderHistory" border style="width: 100%">
          <el-table-column prop="timestamp" label="时间" ></el-table-column>
          <el-table-column prop="orderStatus" label="订单状态" ></el-table-column>
          <el-table-column prop="comment" label="备注"></el-table-column>
        </el-table>
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
      orderShow: {}
    };
  },
  methods: {
    getOrderShow(orderId) {
      axios
        .get("/order/getById", { params: { orderId: orderId } })
        .then(res => {
          this.orderShow = res.data;
        });
    }
  },
  mounted() {
    this.getOrderShow(6);
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
