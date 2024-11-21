import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeVuew.vue'
import MenuView from "@/views/MenuView.vue"

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/menu',
      name: 'Menu',
      component: MenuView,
    },
  ],
})

export default router
