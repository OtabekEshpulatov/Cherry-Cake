
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import cors from "cors"
import store from './store';
import vuetify from './plugins/vuetify';
import '@mdi/font/css/materialdesignicons.css'
import './assets/style/main.scss'



const app = createApp(App)
app.use(router)
app.use(vuetify)
app.use(cors)
app.use(store);
app.mount('#app')