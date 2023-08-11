import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import AdminHome from '../views/AdminHome.vue'
import PizzaDetails from '../views/PizzaDetails'
import IngredientsHome from '../views/IngredientsHome'
import IngredientDetails from '../views/IngredientDetails'
import CustomerInfo from '../views/CustomerInfo'
import Menu from '../views/Menu'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/admin-pizza',
      name: 'AdminHome',
      component: AdminHome,
      meta: {
        //TODO: switch to true later. Auth is required and must have and admin ROLE.
        requiresAuth: false
      }
    },
    {
      path: '/pizza-details',
      name: 'PizzaDetails',
      component: PizzaDetails,
      meta: {
        //TODO: switch to true later. Auth is required and must have and admin ROLE.
        requiresAuth: false
      }
    },
    {
      path: '/admin-ingredients',
      name: 'Ingredients',
      component: IngredientsHome,
      meta: {
        //TODO: switch to true later. Auth is required and must have and admin ROLE.
        requiresAuth: false
      }
    },
    {
      path: '/ingredient-details',
      name: 'IngredientDetails',
      component: IngredientDetails,
      meta: {
        //TODO: switch to true later. Auth is required and must have and admin ROLE.
        requiresAuth: false
      }
    },
    {
      path: '/customer-info',
      name: 'CustomerInfo',
      component: CustomerInfo,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/menu',
      name: 'Menu',
      component: Menu,
      meta: {
        requiresAuth: false
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
