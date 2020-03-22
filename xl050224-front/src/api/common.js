import axios from 'axios'
axios.defaults.baseURL = 'http://localhost:8090'
axios.defaults.headers.common['jcartToken'] = localStorage['jcartToken'];
axios.interceptors.request.use(
    config => {
        if (window.sessionStorage.getItem('token')) { // 判断是否存在token，如果存在的话，则每个http header都加上token
            config.headers.authorization = window.sessionStorage.getItem('token');  //请求头加上token
        }
        return config;
    },
    err => {
        return Promise.reject(err)
    })
export default axios;