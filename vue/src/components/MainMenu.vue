<template>
  <div id="menuDiv">
    <h2 id="menuHead">Menu</h2>
    <div></div>
    <Pizza-card id="card" />
    <Pizza-card id="card" />
  </div>
</template>

<script>
import PizzaCard from './PizzaCard.vue'
export default {
    components: { PizzaCard }
}
</script>

<style scoped>
#menuHead {
    font-size: 38px;
    text-align: center;
}
#menuDiv {
    margin: 20px;
    height: 100%;
    display: flex;
    flex-direction: column;
    border: solid 3px #75e8e7;
    border-radius: 30px;
    background-image: url('../assets/planets-moon-vaporwave-Favim.com-7224376.gif');
    background-size: cover;
}

</style>