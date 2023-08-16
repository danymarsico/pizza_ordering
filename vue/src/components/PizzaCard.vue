<template>
  <div>
    <div id="pizzaCard">
      <div class="group1">
        <img :src="pizza.imgsrc" width="200" alt="" />
      </div>

      <div class="group2">
        <h2>{{pizza.pizzaName}}</h2>
        <p>{{pizza.desc}}</p>
        <p>Comes with: {{toppingsToString}}</p>
        <p>Starting from: ${{pizza.price}}</p>
        <button @click="selectPizza(pizza)">Order Now</button>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  data() {
    return {
      toppings: ''
    }
  },
  props: {
    pizza: Object,
  },
  methods: {
    selectPizza(pizza) {
      this.$router.push({name: 'Order', params: { selectedPizza: pizza.pizzaName}});
    }
  },
  computed : {
    toppingsToString () {
      let toppings = '';
      this.pizza.specialtyToppings.forEach(topping => {
        toppings += topping + ', ';
      });
      toppings = toppings.substring(0, toppings.length-2);
      return toppings
    }
  }
};
</script>

<style scoped>
#pizzaCard {
  display: flex;
  margin: 15px 92px 15px 92px;
  justify-content: space-evenly;
  background-image: linear-gradient(231deg,#e982df,#2099ff);
  color: #75e8e7;
  background-color: #27104e;
  border: ridge 3px #75e8e7;
  border-radius: 25px;
  padding: 15px;
  /* width: 40vw; */
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  font-weight: lighter;
}
.group2 {
    margin: 25px;
    text-shadow: #9854cb 3px 0 5px;
    border: solid 3px #75e8e7;
    padding: 20px;
    border-radius: 25px;
    /* background-color: #27104e; */
    background-color: rgba(39, 16, 78, 0.7);
}
h2 {
  color: #75e8e7;
  font-size: 30px;
  font-family: Verdana;
  text-shadow: #2099ff 3px 0 5px;
}

p {
  color: #75e8e7;
  font-size: 25px;
  font-family: Verdana;
  
}
button {
    background-image: linear-gradient(231deg,#e982df,#2099ff);
    font-family: fantasy;
    padding: 10px;
    margin-left: 83%;
    opacity: 1.0;
    text-decoration: none;
    color: #492586;
    font-weight: lighter;
    text-shadow: 4px 3px #75e8e7;
    letter-spacing: 2pt;
    font-size: 18pt;
    opacity: 1.0;
  }
  img {
    margin-top: 70%;
  }
button:hover, button:active {
    color: #75e8e7;
    text-shadow: 4px 3px #64379f;
        -webkit-text-stroke-width: 1px;
  -webkit-text-stroke-color: #0089fa;
}
</style>