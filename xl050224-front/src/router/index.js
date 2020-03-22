import Vue from 'vue'
import Router from 'vue-router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';


import HelloWorld from '@/components/HelloWorld'
import ProductSearch from '@/components/ProductSearch'
import ProductCreate from '@/components/ProductCreate'
import ProductUpdate from '@/components/productUpdate'
import AdministratorLogin from '@/components/AdministratorLogin'
import AdministratorUpdateProfile from '@/components/AdministratorUpdateProfile'
import AdministratorCreate from '@/components/AdministratorCreate'
import AdministratorUpdate from '@/components/AdministratorUpdate'
import AdministratorIndex from '@/components/AdministratorIndex'
import CustomerSearch from '@/components/CustomerSearch'
import CustomerShow from '@/components/CustomerShow'
import AddressIndex from '@/components/AddressIndex'
import AddressShow from '@/components/AddressShow'
import OrderSearch from '@/components/OrderSearch'
import OrderShow from '@/components/OrderShow'
import ReturnSearch from '@/components/ReturnSearch'
import ReturnShow from '@/components/ReturnShow'
import ReturnHistoryIndex from '@/components/ReturnHistoryIndex'
import AdministratorForgetPwd from '@/components/AdministratorForgetPwd'
import AdministratorResetPwd from '@/components/AdministratorResetPwd'
import Layout from '@/components/Layout'
import Login from '@/components/Login'


Vue.use(Router)
Vue.use(ElementUI);

Vue.component("productSearch",ProductSearch)

export default new Router({
  mode: "history",
  scrollBehavior: () => ({
     y: 0
     }),
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/productSearch',
      name: 'ProductSearch',
      component: ProductSearch
    },
    {
      path: '/productCreate',
      name: 'ProductCreate',
      component: ProductCreate
    },
    {
      path: '/productUpdate',
      name: 'ProductUpdate',
      component: ProductUpdate
    },
    {
      path: '/administratorLogin',
      name: 'AdministratorLogin',
      component: AdministratorLogin
    },
    {
      path: '/administratorUpdateProfile',
      name: 'AdministratorUpdateProfile',
      component: AdministratorUpdateProfile
    },
    {
      path: '/administratorCreate',
      name: 'AdministratorCreate',
      component: AdministratorCreate
    },
    {
      path: '/administratorUpdate',
      name: 'AdministratorUpdate',
      component: AdministratorUpdate
    },
    {
      path: '/administratorIndex',
      name: 'AdministratorIndex',
      component: AdministratorIndex
    },
    {
      path: '/customerSearch',
      name: 'CustomerSearch',
      component: CustomerSearch
    },
    {
      path: '/customerShow',
      name: 'CustomerShow',
      component: CustomerShow
    },
    {
      path: '/addressIndex',
      name: 'AddressIndex',
      component: AddressIndex
    },
    {
      path: '/addressShow',
      name: 'AddressShow',
      component: AddressShow
    },
    {
      path: '/orderSearch',
      name: 'OrderSearch',
      component: OrderSearch
    },
    {
      path: '/orderShow',
      name: 'OrderShow',
      component: OrderShow
    },
    {
      path: '/returnSearch',
      name: 'ReturnSearch',
      component: ReturnSearch
    },
    {
      path: '/returnShow',
      name: 'ReturnShow',
      component: ReturnShow
    },
    {
      path: '/returnHistoryIndex',
      name: 'ReturnHistoryIndex',
      component: ReturnHistoryIndex
    },
    {
      path: '/administratorForgetPwd',
      name: 'AdministratorForgetPwd',
      component: AdministratorForgetPwd
    },
    {
      path: '/administratorResetPwd',
      name: 'AdministratorResetPwd',
      component: AdministratorResetPwd
    },
    {
      path: '/layout',
      name: 'Layout',
      component: Layout,
      hidden: true,
      children: [ 
        { path: '/layout/productSearch', name: '产品页面列表', component: ProductSearch, hidden: false },

        { path: '/layout/productCreate', name: '产品页面添加', component: ProductCreate, hidden: true },
        { path: '/layout/productUpdate', name: '产品页面修改', component: ProductUpdate, hidden: true },

        { path: '/layout/customerSearch', name: '客户页面列表', component: CustomerSearch, hidden: false },

        { path: '/layout/customerShow', name: '客户页面查询', component: CustomerShow, hidden: true },

        { path: '/layout/orderSearch', name: '订单页面列表', component: OrderSearch, hidden: true },
        { path: '/layout/returnSearch', name: '退货页面列表', component: ReturnSearch, hidden: true },
        { path: '/layout/administratorIndex', name: '用户页面列表', component: AdministratorIndex, hidden: true },

        { path: '/layout/administratorUpdateProfile', name: '个人信息', component: AdministratorUpdateProfile, hidden: true },
        
        

        
        
      ]
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
  ]

}
)
