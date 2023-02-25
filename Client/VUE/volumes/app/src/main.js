import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'

import './assets/main.css'


// Add a request interceptor
axios.interceptors.request.use(function (config) {
    console.log("Request", config);
    //Afegir un header authorization amb el token amb nom Authorization

    config.headers.Authorization = 'token1234';

    return config;
}, function (error) {
    // Do something with request error
    return Promise.reject(error);
});

const app = createApp(App)
app.config.globalProperties.$axios = axios



app.use(router)

app.mount('#app')
