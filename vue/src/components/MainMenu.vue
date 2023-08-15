<template>
  <div id="menuDiv">
    <h2 id="menuHead">Menu</h2>
    <div></div>
    <Pizza-card id="card" v-bind:pizza="pizza" v-for="pizza in $store.state.specialtyPizzas" v-bind:key="pizza.pizzaName" />
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
    font-size: 75px;
    text-align: center;
    font-family: monospace;
    text-decoration-line: underline;
    text-decoration-style: wavy;
    text-shadow: 1px 0px 10px whitesmoke;
    letter-spacing: 2pt;
    text-underline-offset: 12px;
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
    padding: 0px 0px 77px 0px;
}

</style>