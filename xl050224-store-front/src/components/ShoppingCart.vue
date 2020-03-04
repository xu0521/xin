<template>
  <div class="hello">
    <el-table :data="myShoppingCart" border style="width: 100%">
      <el-table-column prop="mainPicUrl" label="主图">
        <!-- <el-image style="width: 100px; height: 100px" :src="'http://localhost:80/'+mainPicUrl"></el-image> -->
      </el-table-column>
      <el-table-column prop="productCode" label="商品代号"></el-table-column>
      <el-table-column prop="productName" label="商品名称"></el-table-column>
      <el-table-column prop="unitPrice" label="单价"></el-table-column>
      <el-table-column  label="数量">
        <template slot-scope="scope">
          <el-input placeholder="请输入数量" v-model="scope.row.quantity" type="number" clearable style="width:180px"></el-input>
          <el-button @click="handleUpdateQuantity(scope.row)" type="text" size="small">修改</el-button>
        </template>
      </el-table-column>
      <el-table-column prop="totalPrice" label="总价">
        <template slot-scope="scope">
          {{(scope.row.unitPrice * scope.row.quantity).toFixed(2)}}
        </template>
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="180">
        <template slot-scope="scope">
          <el-button @click="handleDelete(scope.$index,scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
  data() {
    return {
      myShoppingCart: []
    };
  },
  methods: {
    handleDelete(index, row) {
      this.myShoppingCart.splice(index, 1);
      localStorage["myShoppingCartJson"] = JSON.stringify(this.myShoppingCart);
    },
    handleUpdateQuantity(row){
      localStorage["myShoppingCartJson"] = JSON.stringify(this.myShoppingCart);
      this.$message.success("修改成功");
    }
  },
  mounted() {
    var myShoppingCartJson = localStorage["myShoppingCartJson"];
    this.myShoppingCart = myShoppingCartJson ? JSON.parse(myShoppingCartJson):[];
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
