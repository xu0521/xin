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
    }
  ]
})
