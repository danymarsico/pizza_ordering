<template>
  <div id="apHome">
      <AP-header />
      <AP-main />
      <button id="addBtn">Add New Ingredient</button>
  </div>
</template>

<script>
import APHeader from '../components/APHeader.vue'
import APMain from '../components/APMain.vue'
export default {
  components: { APHeader, APMain },

}
</script>

<style>

</style>