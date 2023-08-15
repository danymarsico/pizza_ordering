<template>
  <div>
    <div id="pizzaCard">
      <div class="group">
        <img :src="pizza.imgsrc" width="200" alt="" />
      </div>

      <div class="group">
        <h2>{{pizza.pizzaName}}</h2>
        <p>{{pizza.desc}}</p>
        <p>Comes with: {{pizza.specialtyToppings}}</p>
        <p>Starting from: ${{pizza.price}}</p>
        <button @click="selectPizza(pizza)">Order Now</button>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  props: {
    pizza: Object,
  },
  methods: {
    selectPizza(pizza) {
      this.$router.push({name: 'Order', params: { selectedPizza: pizza.pizzaName}});
    }
  }
};
</script>

<style scoped>
#pizzaCard {
  display: flex;
  margin: 15px 92px 15px 92px;
  border: 2px solid red;
  justify-content: space-evenly;
  border: solid 3px #75e8e7;
  border-radius: 30px;
  background-image: linear-gradient(231deg,#e982df, #2099ff);
}

.group {
    margin: 25px;
    text-shadow: #75e8e7 3px 0 5px;
}

h2 {
  color: #27104e;
  font-size: 30px;
}

p {
  color: #27104e;
  font-size: 25px;
}
button {
    background-image: linear-gradient(231deg,#75e8e7,#2099ff);
    font-family: fantasy;
    color: #27104e;
    letter-spacing: 1px;
    font-size: 15pt;
    padding: 10px;
    margin-left: 83%;
  }
  img {
    margin-top: 50%;
  }
  button {
    text-decoration: none;
    color: #64379f;
    font-family: fantasy;
    font-weight: lighter;
    text-shadow: 6px 4px #75e8e7;
    letter-spacing: 2pt;
    font-size: 18pt;
}
button:hover, button:active {
    color: #75e8e7;
    text-shadow: 6px 4px #64379f;
        -webkit-text-stroke-width: 1px;
  -webkit-text-stroke-color: #0089fa;
}
</style>