<template>
  <div>
    <div id="pizzaCard">
      <div class="group">
        <img src="../assets/butcher.png" width="200" alt="" />
      </div>

      <div class="group">
        <h2>Pizza Name</h2>
        <p>Description of the current Pizza</p>
        <p>Starting from:</p>
      </div>
    </div>

    <div id="pizzaCard">
      <div class="group">
        <h2>Pizza Name</h2>
        <p>Description of the current Pizza</p>
        <p>Starting from:</p>
      </div>

      <div class="group">
        <img src="../assets/butcher.png" width="200" alt="" />
      </div>
    </div>
  </div>
</template>

<script>
export default {};
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