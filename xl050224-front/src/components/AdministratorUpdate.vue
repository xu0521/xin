<template>
  <div class="hello">
    <el-form ref="form" :model="administratorUpdate" label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="administratorUpdate.username" readonly></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="administratorUpdate.password"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="administratorUpdate.realName"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="administratorUpdate.email"></el-input>
      </el-form-item>
      <el-form-item label="头像">
        <el-input v-model="administratorUpdate.avatarUrl"></el-input>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="status" clearable placeholder="请选择">
          <el-option
            v-for="item in statuses"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
        <el-button @click="onRetuen">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "../api/common"
export default {
  name: "HelloWorld",
  data() {
    return {
      administratorUpdate: {},
      statuses: [
        {
          value: 0,
          label: "禁用"
        },
        {
          value: 1,
          label: "启用"
        }
      ],
      status: ""
    };
  },
  methods: {
    getAdministratorUpdate(administratorId) {
      axios
        .get("/administrator/getById", {
          params: { administratorId: administratorId }
        })
        .then(res => {
          this.status = res.data.status;
          this.administratorUpdate = res.data;
        });
    },
    onSubmit() {
      axios
        .post("/administrator/update", this.administratorUpdate)
        .then(res => {
          this.$router.push("/adminitratorIndex")
        });
    },
    onRetuen(){
       this.$router.push("/administratorIndex")
    }
  },
  mounted() {
    if(this.$route.params){
      this.getAdministratorUpdate(this.$route.params.administratorId);
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
