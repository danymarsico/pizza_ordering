<template>
  <div id="apHome">
    <Header />
    <AP-nav />
    <AP-specialty-pizzas />
    <button id="addBtn">
      <router-link :to="{ name: 'PizzaDetails' }">Add New Pizza</router-link>
    </button>
  </div>
</template>

<script>
import Header from "../components/Header.vue";
import APNav from "../components/APNav.vue";
import APSpecialtyPizzas from "../components/APSpecialtyPizzas.vue";

export default {
  components: { Header, APNav, APSpecialtyPizzas },
  name: "AdminHome",
};
</script>

<style scoped>
#apHome {
  display: flex;
  flex-direction: column;
  justify-content: center;
}

#addBtn {
  width: 15vw;
  height: 40px;
  align-self: flex-end;
  margin-right: 10vw;
}
#checkbox1 {
  padding-left: 22px;
}

#checkbox2 {
  margin-left: 5vw;
}

</style>