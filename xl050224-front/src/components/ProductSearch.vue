<template>
  <div class="hello">
    <el-button type="primary" @click="create">添加</el-button>
    <el-table :data="productList" border style="width: 100%">
      <el-table-column prop="productId" label="商品编号"></el-table-column>
      <el-table-column prop="productName" label="商品名称"></el-table-column>
      <el-table-column prop="price" label="价钱"></el-table-column>
      <el-table-column prop="productCode" label="商品代码"></el-table-column>
      <el-table-column prop="discount" label="折扣"></el-table-column>
      <el-table-column prop="stockQuantity" label="库存数量"></el-table-column>
      <el-table-column prop="status" label="状态"></el-table-column>
      <el-table-column label="图片">
        <template slot-scope="scope">
          <el-image style="width: 100px; height: 100px" :src="'http://localhost/' + scope.row.mainPicUrl" :preview-src-list="srcList"></el-image>
        </template>
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="180">
        <template slot-scope="scope">
          <el-button  type="text" size="small">查看</el-button>
          <el-button type="text" size="small" @click="handleClick(scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      :page-size="pageSize"
      :pager-count="11"
      layout="prev, pager, next"
      :total="total"
      @current-change="currentChange"
    ></el-pagination>
  </div>
</template>

<script>
import axios from "../api/common";
export default {
  name: "HelloWorld",
  data() {
    return {
      productList: [],
      pageSize: 5,
      total: 0,
      url: "",
      srcList: []
    };
  },
  methods: {
    getProduct(pageNum) {
      var productSearchInDTO = {
        params: {
          pageNum: pageNum
        }
      };
      axios.get("/product/search", productSearchInDTO).then(res => {
        this.productList = res.data.list;
        this.total = res.data.total;
        this.pageSize = res.data.pageSize;
      });
    },
    currentChange(pageNum) {
      this.getProduct(pageNum);
    },
    create() {
      this.$router.push("/productCreate");
    },
    handleClick(row){
      this.$router.push({name:"ProductUpdate" , query:row})
    }
  },
  mounted() {
    this.getProduct();
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
