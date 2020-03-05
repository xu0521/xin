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
    </el-form>
  </div>
</template>

<script>
import axios from "../api/common";
export default {
  name: "HelloWorld",
  data() {
    return {
      orderCheckout:{},
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
      selectedPayMethod: ""
    };
  },
  methods: {
    getMyAddress() {
      axios.get("/address/getListByCustomerId").then(res => {
        this.myAddresses = res.data;
      });
    }
  },
  mounted() {
    this.getMyAddress();
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
