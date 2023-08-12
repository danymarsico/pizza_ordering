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
      </div>
    </div>

  </div>
</template>

<script>
export default {
  props: {
    pizza: Object,
  }
};
</script>

<style scoped>
#pizzaCard {
  display: flex;
  margin: 10px;
  border: 2px solid red;
  justify-content: space-evenly;
  border: solid 3px #75e8e7;
  border-radius: 30px;
  background-image: linear-gradient(231deg,#2099ff,#e982df);
}

.group {
    margin: 25px;
    text-shadow: #75e8e7 3px 0 5px;
}

p, h2 {
  color: #27104e;
}
</style>