<template>
  <div class="hello">
    <el-form ref="form" :model="productCreate" label-width="180px">
      <el-form-item label="商品名称">
        <el-input v-model="productCreate.productName"></el-input>
      </el-form-item>
      <el-form-item label="商品价钱">
        <el-input v-model="productCreate.price"></el-input>
      </el-form-item>
      <el-form-item label="商品积分">
        <el-input v-model="productCreate.rewordPoints"></el-input>
      </el-form-item>
      <el-form-item label="商品代码">
        <el-input v-model="productCreate.productCode"></el-input>
      </el-form-item>
      <el-form-item label="折扣">
        <el-input v-model="productCreate.discount"></el-input>
      </el-form-item>
      <el-form-item label="排序">
        <el-input v-model="productCreate.sortOrder"></el-input>
      </el-form-item>
      <el-form-item label="商品库存">
        <el-input v-model="productCreate.stockQuantity"></el-input>
      </el-form-item>
      <el-form-item label="描述">
        <!-- <el-input type="textarea" v-model="productCreate.description"></el-input> -->
        <tinymce-editor v-model="productCreate.description" @onClick="onClick" ref="editor"></tinymce-editor>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="productCreate.status" clearable placeholder="请选择">
          <el-option
            v-for="item in status"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="商品主图">
        <el-upload
          ref="upload"
          action
          :http-request="uploadMainImage"
          :limit="1"
          accept="image/*"
          :on-change="handleOnMainChange"
          :file-list="mainFileList"
          :auto-upload="false"
        >
          <el-button slot="trigger" size="small" type="primary">选取主图</el-button>
          <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传</el-button>
          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>
      </el-form-item>
      <el-form-item label="其他图片">
        <el-upload
          ref="upload"
          action
          :http-request="uploadOtherImage"
          multiple
          :limit="9"
          accept="image/*"
          :on-change="handleOnOtherChange"
          :on-remove="handleOnOtherRemove"
          :file-list="otherFileList"
          :auto-upload="false"
        >
          <el-button slot="trigger" size="small" type="primary">选取其他图片</el-button>
          <el-button
            style="margin-left: 10px;"
            size="small"
            type="success"
            @click="submitOtherUpload"
          >上传</el-button>
          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
        <el-button @click="onReturn">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "../api/common";
import TinymceEditor from '../components/tinymce-edito'
export default {
  components: { TinymceEditor },
  name: "HelloWorld",
  data() {
    return {
      productCreate: {},
      status: [
        {
          value: 1,
          label: "待审核"
        },
        {
          value: 2,
          label: "上架"
        },
        {
          value: 3,
          label: "下架"
        }
      ],
      minaPicUrl: "",
      otherPicUrls: [],
      selectedMainPic: "",
      selectedOtherPic: [],
      mainFileList: [],
      otherFileList: []
    };
  },
  methods: {
    handleOnMainChange(val) {
      this.selectedMainPic = val.raw;
    },
    submitUpload() {
      this.uploadMainImage();
    },
    uploadMainImage() {
      var forData = new FormData();
      forData.append("file", this.selectedMainPic);

      axios
        .post("/image/upload", forData, {
          headers: { "Content-Type": "mutipart/form-data" }
        })
        .then(res => {
          this.minaPicUrl = res.data;
        });
    },
    handleOnOtherChange(file, fileList) {
      this.selectedOtherPic = fileList;
    },
    handleOnOtherRemove(file, fileLists) {
      this.selectedOtherPic = fileList;
    },
    submitOtherUpload() {
      this.uploadOtherImage();
    },
    uploadOtherImage() {
      this.selectedOtherPic.forEach(pic => {
        var forData = new FormData();
        forData.append("file", pic.raw);

        axios
          .post("/image/upload", forData, {
            headers: { "Content-Type": "mutipart/form-data" }
          })
          .then(res => {
            var url = res.data;
            this.otherPicUrls.push(url);
          });
      });
    },
    onSubmit() {
      this.productCreate.mainPicUrl = this.minaPicUrl;
      this.productCreate.otherPicUrls = this.otherPicUrls;
      axios.post("/product/create", this.productCreate).then(res => {
        this.$router.push("/productSearch");
      });
    },
    onReturn() {
      this.$router.push("/productSearch");
    },
    onClick(e) {
      //this.$emit("onClick", e, tinymce);
    }
  },
  mounted() {}
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
