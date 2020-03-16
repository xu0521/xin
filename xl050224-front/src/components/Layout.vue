<template>
  <div class="hello">
    <el-container>
      <el-aside>
        <el-menu
          unique-opened
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#303133"
          text-color="#fff"
          active-text-color="#ffd04b"
          :default-active="onRoutes"
          :collapse="collapse"
          router
          collapse-transition
        >
          <!-- <el-header>电商系统</el-header> -->
          <el-header>电商系统</el-header>

          <el-submenu v-for="subMenu in subMenus" :key="subMenu.index" :index="subMenu.index">
            <template slot="title">
              <i :class="subMenu.icon"></i>
              <span>{{subMenu.name}}</span>
            </template>

            <el-menu-item
              v-for="menuItem in subMenu.menuItems"
              :key="menuItem.index"
              :index="menuItem.index"
              :route="menuItem.route"
            >{{menuItem.name}}</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown @command="handleMyItemClick">
            <i class="el-icon-s-tools" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item
                v-for="item in my"
                :key="item.route"
                :divided="item.divided"
                :command="item.route"
              >{{item.name}}</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>王小虎</span>
        </el-header>

        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script>
export default {
  name: "HelloWorld",
  data() {
    const item = {
      date: "2016-05-02",
      name: "王小虎",
      address: "上海市普陀区金沙江路 1518 弄"
    };
    return {
      tableData: Array(20).fill(item),
      collapse: false,
      subMenus: [
        {
          name: "商品管理",
          index: "1",
          icon: "el-icon-s-goods",
          menuItems: [
            { name: "商品列表", index: "/layout/productSearch"  }
          ]
        },
        {
          name: "客户管理",
          index: "2",
          icon: "el-icon-user-solid",
          menuItems: [
            { name: "客户列表", index: "/layout/customerSearch" }
          ]
        },
        {
          name: "订单管理",
          index: "3",
          icon: "el-icon-shopping-cart-2",
          menuItems: [
            { name: "订单列表", index: "/layout/orderSearch"}
          ]
        },
        {
          name: "退货管理",
          index: "4",
          icon: "el-icon-delete-solid",
          menuItems: [
            { name: "退货列表", index: "/layout/returnSearch"}
          ]
        },
        {
          name: "用户管理",
          index: "5",
          icon: "el-icon-s-custom",
          menuItems: [
            { name: "用户列表", index: "/layout/administratorIndex" }
          ]
        }
      ],
      my: [
        {
          name: "个人信息",
          route: "/layout/administratorUpdateProfile",
          divided: false
        },
        { name: "关于", route: "/layout", divided: false },
        { name: "退出", route: "/layout/administratorLogin", divided: true }
      ]
    };
  },
  computed: {
    onRoutes(path) {
      //当前激活菜单的 index
      return this.$route.path.replace("/", "");
    }
  },
  methods: {
    handleOpen() {
      console.log("open click");
    },
    handleClose() {
      console.log("close click");
    },
    handleMyItemClick(val) {
      return this.$router.replace(val);
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



.el-header {
  background-color: #303133;
  color: #ffffff;
  line-height: 60px;
}

.el-aside {
  background-color: #303133;
  color: #333;
}
ul[data-v-005bfc5a] {
  list-style-type: none;
  padding: 0;
}
.el-submenu__title {
  font-size: 14px;
  color: #303133;
  padding: 0 20px;
  cursor: pointer;
  -webkit-transition: border-color 0.3s, background-color 0.3s, color 0.3s;
  transition: border-color 0.3s, background-color 0.3s, color 0.3s;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  width: 255px;
}
li[data-v-005bfc5a] {
  display: inline-block;
  margin: 0 10px;
  width: 240px;
}
</style>
