import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import IconView from '../views/IconView.vue'
import UserListView from '../views/usuaris/UserListView.vue'
import UserFormView from '../views/usuaris/UserFormView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/icon',
      name: 'icon',
      component: UserListView
    },
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/sergi',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/usuaris',
      children: [
        {
          path: 'llistat',
          component : UserListView
        },
        {
          path: 'form',
          component : UserFormView
        },
        {
          path: 'form/:idusuari',
          component : UserFormView
        }]


    }
  ]
})

export default router
