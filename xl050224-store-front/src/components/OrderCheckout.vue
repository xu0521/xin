<template>
  <div class="hello">
    <el-form ref="form" :model="orderCheckout" label-width="80px">
      <el-form-item label="寄送地址">
        <el-select v-model="selectedShipAddressId" clearable placeholder="请选择寄送地址">
          <el-option
            v-for="item in myAddresses"
            :key="item.addressId"
            :label="item.content"
            :value="item.addressId"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="寄送方式">
        <el-select v-model="selectedShipMethod" clearable placeholder="请选择寄送方式">
          <el-option
            v-for="item in shipMethods"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="发票地址">
        <el-select v-model="selectedInvoiceAddredssId" clearable placeholder="请选择发票地址">
          <el-option
            v-for="item in myAddresses"
            :key="item.addressId"
            :label="item.content"
            :value="item.addressId"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="支付方式">
        <el-select v-model="selectedPayMethod" clearable placeholder="请选择支付方式">
          <el-option
            v-for="item in payMethods"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="商品">
        <el-table :data="myShoppingCart" border style="width: 100%">
          <el-table-column prop="productCode" label="商品代码"></el-table-column>
          <el-table-column prop="productName" label="商品名称"></el-table-column>
          <el-table-column label="价格">
            <template slot-scope="scope">
              单价：{{scope.row.unitPrice}}
              <br />
              打折：{{scope.row.discount}}
              <br />
              折后价：
              {{(scope.row.unitPrice * scope.row.discount).toFixed(2)}}
            </template>
          </el-table-column>
          <el-table-column prop="quantity" label="数量"></el-table-column>
          <el-table-column label="总计">
            <template
              slot-scope="scope"
            >{{(scope.row.unitPrice * scope.row.quantity * scope.row.discount).toFixed(2)}}</template>
          </el-table-column>
        </el-table>
        总价：{{totablePrice}}
        <br />
        邮费：{{shipPrice}}
        <br />
        支付价：{{payPrice}}
      </el-form-item>
      <el-form-item label="备注">
        <el-input type="textarea" :rows="5" placeholder="请输入备注内容" v-model="orderCheckout.comment"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="checkoutOrder">立即创建</el-button>
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
      orderCheckout: {},
      myAddresses: [],
      shipMethods: [
        {
          value: 0,
          label: "EMS"
        },
        {
          value: 1,
          label: "顺丰"
        },
        {
          value: 2,
          label: "圆通"
        },
        {
          value: 3,
          label: "中通"
        },
        {
          value: 4,
          label: "申通"
        }
      ],
      payMethods: [
        {
          value: 0,
          label: "货到付款"
        },
        {
          value: 1,
          label: "借记卡"
        },
        {
          value: 2,
          label: "信用卡"
        },
        {
          value: 3,
          label: "微信支付"
        },
        {
          value: 4,
          label: "支付宝"
        }
      ],
      selectedShipAddressId: "",
      selectedShipMethod: "",
      selectedInvoiceAddredssId: "",
      selectedPayMethod: "",
      myShoppingCart: [],
      shipPrice: 5.0
    };
  },
  computed: {
    totablePrice() {
      var suTotalPrices = this.myShoppingCart.map(p => {
        return p.unitPrice * p.discount * p.quantity;
      });
      var totablePrice = suTotalPrices.reduce((a, b) => a + b, 0);
      var totablePriceStr = totablePrice.toFixed(2);
      totablePrice = parseFloat(totablePriceStr);
      return totablePrice;
    },
    payPrice() {
      return this.totablePrice + this.shipPrice;
    },
    orderProducts() {
      var orderProducts = this.myShoppingCart.map(p => {
        var orderPrduct = new Object();
        orderPrduct.productId = p.productId;
        orderPrduct.quantity = p.quantity;
        return orderPrduct;
      });
      return orderProducts;
    }
  },
  methods: {
    getMyAddress() {
      axios.get("/address/getListByCustomerId").then(res => {
        this.myAddresses = res.data;
      });
    },
    checkoutOrder() {
      this.orderCheckout.shipAddressId = this.selectedShipAddressId;
      this.orderCheckout.shipMethod = this.selectedShipMethod;
      this.orderCheckout.payMethod = this.selectedPayMethod;
      this.orderCheckout.invoiceAddressId = this.selectedInvoiceAddredssId;
      this.orderCheckout.orderProducts = this.orderProducts;
      console.log(this.orderCheckout);
      axios.post("/order/checkout", this.orderCheckout).then(res => {});
    }
  },
  mounted() {
    this.getMyAddress();
    var myShoppingCartJson = localStorage["myShoppingCartJson"];
    this.myShoppingCart = myShoppingCartJson
      ? JSON.parse(myShoppingCartJson)
      : [];
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
