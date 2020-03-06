<template>
  <div class="hello">
    <el-form ref="form" :model="productShow" label-width="180px">
      <el-form-item label="主图">
        <el-input v-model="productShow.minaPicUrl" readonly></el-input>
      </el-form-item>
      <el-form-item label="其他图片">
        <el-input v-model="productShow.otherPicUrls" readonly></el-input>
      </el-form-item>
      <el-form-item label="商品名称">
        <el-input v-model="productShow.productName" readonly></el-input>
      </el-form-item>
      <el-form-item label="商品价钱">
        <el-input v-model="productShow.price" readonly></el-input>
      </el-form-item>
      <el-form-item label="折扣">
        <el-input v-model="productShow.discount" readonly></el-input>
      </el-form-item>
      <el-form-item label="商品库存">
        <el-input v-model="productShow.stockQuantity" readonly></el-input>
      </el-form-item>
      <el-form-item label="描述">
        <!-- <el-input type="textarea" v-model="productUpdate.description"></el-input> -->
        <div v-html="productShow.description"></div>
      </el-form-item>
      <el-form-item label="数量">
        <el-input v-model="quantity" type="number"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">添加到购物车</el-button>
        <el-button @click="onReturn">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "../api/common"
export default {
  name: 'HelloWorld',
  data () {
    return {
      productShow:{},
      quantity:1,
      myShoppingCart:[]
    }
  },
  methods:{
    getProductShow(productId){
      axios.get("/product/getById",{params:{productId:productId}}).then(res=>{
        this.productShow = res.data;
      })
    },
    onSubmit(){
      var newProduct = {
        productId: this.productShow.productId,
        productCode: this.productShow.productCode,
        productName: this.productShow.productName,
        mainPicUrl: this.productShow.minaPicUrl,
        unitPrice: this.productShow.price,
        discount:this.productShow.discount,
        quantity: this.quantity
        
      }    
      var myShoppingCartJson = localStorage['myShoppingCartJson'];
      this.myShoppingCart = myShoppingCartJson ? JSON.parse(myShoppingCartJson) : [];

      var carProduct = this.myShoppingCart.find(p => p.productId === this.productShow.productId);
      if(carProduct){
        var originQuantity = parseInt(carProduct.quantity);
        carProduct.quantity =  originQuantity + parseInt(this.quantity);
      }else{
        carProduct = {
          productId: this.productShow.productId,
          productCode: this.productShow.productCode,
          productName: this.productShow.productName,
          mainPicUrl: this.productShow.minaPicUrl,
          unitPrice: this.productShow.price,      
          discount:this.productShow.discount,
          quantity: this.quantity
        } 
        this.myShoppingCart.push(carProduct)
      }
      localStorage['myShoppingCartJson'] = JSON.stringify(this.myShoppingCart);
      this.$message.success("添加购物车成功")
    },
    onReturn(){
      this.$router.push("/productSearch")
    }
  },
  mounted(){
    if(this.$route.params){
      this.getProductShow(this.$route.params.productId)
    }  
    var myShoppingCartJson = localStorage['myShoppingCartJson'];
    this.myShoppingCart = myShoppingCartJson ? JSON.parse(myShoppingCartJson) : [];
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
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
