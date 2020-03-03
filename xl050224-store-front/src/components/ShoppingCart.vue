<template>
  <div class="hello">
    <el-table :data="myShoppingCart" border style="width: 100%">
      <el-table-column prop="mainPicUrl"  label="主图">
        <!-- <el-image style="width: 100px; height: 100px" :src="'http://localhost:80/'+mainPicUrl"></el-image> -->
      </el-table-column>
      <el-table-column prop="productCode" label="商品代号"></el-table-column>
      <el-table-column prop="productName" label="商品名称"></el-table-column>
      <el-table-column prop="unitPrice" label="单价"></el-table-column>
      <el-table-column prop="quantity" label="数量"></el-table-column>
      <el-table-column prop="totalPrice" label="总价"></el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
  data() {
    return {
      myShoppingCart:[]
    };
  },
  methods:{

  },
  mounted(){
    var myShoppingCart = localStorage['myShoppingCart'];
    this.myShoppingCart = JSON.parse(myShoppingCart);
    console.log(myShoppingCart)
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
