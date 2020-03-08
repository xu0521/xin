<template>
  <div class="hello">
    <el-form ref="form" :model="customerShow" label-width="180px">
      <el-form-item label="客户用户名">
        <el-input v-model="customerShow.username" readonly></el-input>
      </el-form-item>
      <el-form-item label="客户姓名">
        <el-input v-model="customerShow.realName" readonly></el-input>
      </el-form-item>
      <el-form-item label="客户头像">
        <el-input v-model="customerShow.avatarUrl" readonly></el-input>
      </el-form-item>
      <el-form-item label="手机">
        <el-input v-model="customerShow.mobile" readonly></el-input>
      </el-form-item>
      <el-form-item label="邮件">
        <el-input v-model="customerShow.email" readonly></el-input>
      </el-form-item>
      <el-form-item label="状态">
        <el-input v-model="customerShow.status" readonly></el-input>
      </el-form-item>
      <el-form-item label="注册时间">
        <el-input v-model="customerShow.createTimestamp" readonly></el-input>
      </el-form-item>
      <el-form-item label="订阅新闻">
        <!-- <el-input v-model="customerShow.newsSubscribed" readonly></el-input> -->
        <el-switch v-model="customerShow.newsSubscribed" disabled></el-switch>
      </el-form-item>
      <el-form-item label="积分">
        <el-input v-model="customerShow.rewordPoints" readonly></el-input>
      </el-form-item>
      <el-form-item label="默认地址">
        <el-input v-model="customerShow.defaultAddress" readonly></el-input>
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
      customerShow: {}
    };
  },
  methods: {
    getCustomerShowById(customerId) {
      axios
        .get("/customer/getCustomer", { params: { customerId: customerId } })
        .then(res => {
          this.customerShow = res.data;
          console.log(this.customerShow);
        });
    }
  },
  mounted() {
    if (this.$route.query) {
      var customerId = this.$route.query.customerId;
      this.getCustomerShowById(customerId);
    }
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
