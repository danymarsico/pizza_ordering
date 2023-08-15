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
#itemList {
  display: flex;
  border: solid 3px #75e8e7;
  border-radius: 30px;
  vertical-align: middle;
}

tbody {
  display: grid;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  flex-grow: 1;
}

tr {
  display: flex;
  flex-grow: 1;
  justify-content: space-between;
  margin-bottom: 5px;
  justify-content: center;
  align-items: center;
}

#item {
  align-items: center;
  display: flex;
  width: 100px;
  justify-content: right;
}
</style>