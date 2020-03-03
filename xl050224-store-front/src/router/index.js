import Vue from 'vue'
import Router from 'vue-router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import HelloWorld from '@/components/HelloWorld'
import ShoppingCart from '@/components/ShoppingCart'
import ProductShow from '@/components/ProductShow'


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
      path: '/productShow',
      name: 'ProductShow',
      component: ProductShow
    },
    {
      path: '/shoppingCart',
      name: 'ShoppingCart',
      component: ShoppingCart
    }
  ]
})
