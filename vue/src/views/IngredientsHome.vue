<template>
  <div id="apHome">
      <Header />
      <AP-nav />
      <AP-items />
      <button id="addBtn"><router-link :to="{name: 'IngredientDetails' }">Add New Ingredient</router-link></button>
  </div>
</template>

<script>
import Header from '../components/Header.vue'
import APNav from '../components/APNav.vue'
import APItems from '../components/APItems.vue'
export default {
  components: { Header, APNav, APItems },

}
</script>

<style>

</style>