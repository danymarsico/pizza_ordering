<template>
  <div id="apHome">
      <Header />
      <AP-nav />
      <AP-toppings />
      <button id="addBtn"><router-link :to="{name: 'IngredientDetails' }">Add New Ingredient</router-link></button>
  </div>
</template>

<script>
import Header from '../components/Header.vue'
import APNav from '../components/APNav.vue'
import APToppings from '../components/APToppings.vue'
export default {
  components: { Header, APNav, APToppings },

}
</script>

<style>

</style>