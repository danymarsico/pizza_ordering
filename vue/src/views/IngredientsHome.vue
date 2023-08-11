<template>
  <div id="apHome">
      <Header />
      <AP-main />
      <button id="addBtn"><router-link :to="{name: 'IngredientDetails' }">Add New Ingredient</router-link></button>
  </div>
</template>

<script>
import Header from '../components/Header.vue'
import APMain from '../components/APMain.vue'
export default {
  components: { Header, APMain },

}
</script>

<style>

</style>