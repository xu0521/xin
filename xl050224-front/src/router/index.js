import Vue from 'vue'
import Router from 'vue-router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import HelloWorld from '@/components/HelloWorld'
import ProductSearch from '@/components/ProductSearch'

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
    }
  ]
})
