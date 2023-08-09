<template>
  <div id="main">
      <h1 id="title">Current Items</h1>
      <AP-items />
  </div>
</template>

<script>
import APItems from './APItems.vue'
export default {
    components: { APItems },
}
</script>

<style>
#main {
    margin: 40px;
    margin-top: 20px;
    height: 900px;
    border: 1px solid #75E8E7;
    border-radius: 30px;
}

#title {
    margin-left: 20px;
    color: #75E8E7;
}

</style>