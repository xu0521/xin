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
    }
  ]
})
