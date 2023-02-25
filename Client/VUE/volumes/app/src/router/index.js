import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import IconView from '../views/IconView.vue'
import UsuariList from '../views/usuaris/UserListView.vue'
import UsuariForm from '../views/usuaris/UserFormView.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/icon',
      name: 'icon',
      component: IconView
    },
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },

    {
      path: '/usuaris',
      children:[
        {
          path: 'llistat',
          component: UsuariList
        },
        {
          path: 'form',
          component: UsuariForm
        },
        {
          path: 'form/:idusuari',
          component: UsuariForm
        }
      ]
    }
  ]
})

export default router
