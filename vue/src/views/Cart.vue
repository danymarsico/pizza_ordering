<template>
  <div>
      <Header />
      <Cust-nav />
      <div id="main-section">
          <h1>Your Cart</h1>
          <div v-show="$store.state.cart.length === 0">
              <h2>
                  Your Cart Is Currently Empty
              </h2>
          </div>
          <div id="pizza" v-for="pizza in $store.state.cart" v-bind:key="pizza">
              <h2>
             Pizza Name: {{pizza.pizzaName}} | Size: {{pizza.pizzaSize}} | Crust: {{pizza.pizzaCrust}} | Sauce: {{pizza.pizzaSauce}} | Toppings: {{pizza.selectedToppings}}              <br>
              Price: {{pizza.price}}
              </h2>
          </div>
          <router-link :to="{name: 'Order'}"><button>Order More</button></router-link>
          <router-link :to="{name: 'Order'}"><button>Pay Now</button></router-link>
      </div>
  </div>
</template>

<script>
import Header from '../components/Header.vue'
import CustNav from '../components/CustNav.vue'
export default {
    components: { Header, CustNav },
    data() {
        return {
            isEmpty: true
        }
    },
}
</script>

<style scoped>
h1 {
    text-align: center;
    color: #75e8e7;
    font-size: 50px;
}
#main-section {
  display: flex;
  flex-direction: column;
  justify-content: center;
  background-color: #9854cb;
  background-image: url('../assets/planets-moon-vaporwave-Favim.com-7224376.gif');
  background-repeat: no-repeat;
  background-size: cover;
  border-radius: 25px;
  margin: 20px;
  border: solid 3px #75e8e7;
  padding: 20px;
}
#pizza {
    display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  background-color: #64379f;
  border-radius: 25px;
  border: solid 3px #75e8e7;
  padding: 10px;
}
button {
    background-image: linear-gradient(231deg,#e982df,#2099ff);
    width: 150px;
    text-decoration: none;
    color: #64379f;
    font-family: fantasy;
    font-weight: lighter;
    text-shadow: 6px 4px #75e8e7;
    letter-spacing: 2pt;
    font-size: 16pt;
}
button:hover, button:active {
    color: #75e8e7;
    text-shadow: 6px 4px #64379f;
        -webkit-text-stroke-width: 1px;
  -webkit-text-stroke-color: #0089fa;
}
</style>