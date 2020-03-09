import Vue from 'vue'
import Router from 'vue-router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import HelloWorld from '@/components/HelloWorld'
import ProductSearch from '@/components/ProductSearch'
import ProductCreate from '@/components/ProductCreate'
import productUpdate from '@/components/productUpdate'
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
      path: '/productCreate',
      name: 'ProductCreate',
      component: ProductCreate
    },
    {
      path: '/productUpdate',
      name: 'ProductUpdate',
      component: productUpdate
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
    }
  ]
})
