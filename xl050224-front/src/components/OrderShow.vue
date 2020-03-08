<template>
  <div class="hello">
    <el-form ref="form" :model="orderShow" label-width="180px">
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
          <el-table-column prop="productCode" label="商品代码"></el-table-column>
          <el-table-column prop="productName" label="商品名称"></el-table-column>
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
      <el-form-item label="应付">{{orderShow.totalPrice + orderShow.shipPrice}}</el-form-item>
      <el-form-item label="订单历史">
        <el-table :data="orderHistory" border style="width: 100%">
          <el-table-column prop="timestamp" label="时间"></el-table-column>
          <el-table-column prop="orderStatus" label="订单状态"></el-table-column>
          <el-table-column prop="comment" label="备注"></el-table-column>
          <el-table-column label="通知客户">
            <template slot-scope="scope">{{scope.row.customerNotified}}</template>
          </el-table-column>
        </el-table>
      </el-form-item>
      <el-form-item label="添加订单历史">
        <br />
        <el-form ref="form" :model="orderHistoryCreate" label-width="80px">
          <el-form-item label="订单状态">
            <el-select v-model="orderHistoryCreate.orderStatus" placeholder="请选择订单状态">
              <el-option
                v-for="item in orderStatuses"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="通知客户">
            <el-checkbox v-model="orderHistoryCreate.customerNotified">通知客户</el-checkbox>
          </el-form-item>
          <el-form-item label="备注">
            <el-input type="textarea" v-model="orderHistoryCreate.comment"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="orderHistorySubmit">立即创建</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
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
      orderHistory: [],
      orderHistoryCreate: {},
      orderStatuses: [
        { value: 0, label: "待处理" },
        { value: 1, label: "处理中" },
        { value: 2, label: "待发货" },
        { value: 3, label: "已发货" },
        { value: 4, label: "待签收" },
        { value: 5, label: "已签收" },
        { value: 6, label: "待支付" },
        { value: 7, label: "已支付" },
        { value: 8, label: "取消" },
        { value: 9, label: "拒绝" },
        { value: 10, label: "完成" },
        { value: 11, label: "待评价" },
        { value: 12, label: "已评价" }
      ],
      orderShowId:0
    };
  },
  methods: {
    getOrderShow(orderId) {
      axios
        .get("/order/getById", { params: { orderId: orderId } })
        .then(res => {
          this.orderShow = res.data;
          this.getOrderHistoryById();
        });
    },
    getOrderHistoryById() {
      axios
        .get("/orderhistory/getListByOrderId", {
          params: { orderId: this.orderShow.orderId }
        })
        .then(res => {
          this.orderHistory = res.data;
        });
    },
    orderHistorySubmit(){
      this.orderHistoryCreate.orderId = this.orderShow.orderId;
      axios.post("/orderhistory/create",this.orderHistoryCreate).then(res=>{
        this.orderHistoryCreate = {}
        this.orderHistoryCreate.customerNotified = false
        this.getOrderHistoryById();
      })
    }
  },
  mounted() {
    if(this.$route.query){
      this.orderShowId = this.$route.query.orderId;
    }
    this.getOrderShow(this.orderShowId);
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
