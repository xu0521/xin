import Vue from 'vue'
import Router from 'vue-router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import HelloWorld from '@/components/HelloWorld'
import ShoppingCart from '@/components/ShoppingCart'
import ProductShow from '@/components/ProductShow'
import ProductSearch from '@/components/ProductSearch'
import OrderCheckout from '@/components/OrderCheckout'
import CustomerLogin from '@/components/CustomerLogin'
import OrderIndex from '@/components/OrderIndex'
import OrderShow from '@/components/OrderShow'
import ReturnApply from '@/components/ReturnApply'
import ReturnIndex from '@/components/ReturnIndex'
import ReturnShow from '@/components/ReturnShow'
import AddressCreate from '@/components/AddressCreate'
import AddressIndex from '@/components/AddressIndex'
import AddressUpdate from '@/components/AddressUpdate'
import CustomerChangePwd from '@/components/CustomerChangePwd'
import CustomerForgetPwd from '@/components/CustomerForgetPwd'
import CustomerResetPwd from '@/components/CustomerResetPwd'
import CustomerRegister from '@/components/CustomerRegister'
import customerUpdateProfile from '@/components/customerUpdateProfile'


Vue.use(Router)
Vue.use(ElementUI);

export default new Router({
  mode:"history",
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
      path: '/productShow',
      name: 'ProductShow',
      component: ProductShow
    },
    {
      path: '/shoppingCart',
      name: 'ShoppingCart',
      component: ShoppingCart
    },
    {
      path: '/orderCheckout',
      name: 'OrderCheckout',
      component: OrderCheckout
    },
    {
      path: '/customerLogin',
      name: 'CustomerLogin',
      component: CustomerLogin
    },
    {
      path: '/orderIndex',
      name: 'OrderIndex',
      component: OrderIndex
    },
    {
      path: '/orderShow',
      name: 'OrderShow',
      component: OrderShow
    },
    {
      path: '/returnApply',
      name: 'ReturnApply',
      component: ReturnApply
    },
    {
      path: '/returnIndex',
      name: 'ReturnIndex',
      component: ReturnIndex
    },
    {
      path: '/returnShow',
      name: 'ReturnShow',
      component: ReturnShow
    },
    {
      path: '/addressCreate',
      name: 'AddressCreate',
      component: AddressCreate
    },
    {
      path: '/addressIndex',
      name: 'AddressIndex',
      component: AddressIndex
    },
    {
      path: '/addressUpdate',
      name: 'AddressUpdate',
      component: AddressUpdate
    },
    {
      path: '/customerChangePwd',
      name: 'CustomerChangePwd',
      component: CustomerChangePwd
    },
    {
      path: '/customerForgetPwd',
      name: 'CustomerForgetPwd',
      component: CustomerForgetPwd
    },
    {
      path: '/customerResetPwd',
      name: 'CustomerResetPwd',
      component: CustomerResetPwd
    },
    {
      path: '/customerRegister',
      name: 'CustomerRegister',
      component: CustomerRegister
    },
    {
      path: '/customerUpdateProfile',
      name: 'customerUpdateProfile',
      component: customerUpdateProfile
    }
  ]
})
