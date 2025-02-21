import { createApp } from 'vue'
import App from './App.vue'
import './assets/css/global.css'
import router from './router/router.ts'

createApp(App).use(router).mount('#app')
