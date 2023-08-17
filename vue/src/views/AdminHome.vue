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
a:link,
a:visited {
  text-decoration: none;
  color: #492586;
  font-family: fantasy;
  font-weight: lighter;
  text-shadow: 6px 4px #75e8e7;
  letter-spacing: 2pt;
  font-size: 14pt;
}
a:hover,
a:active {
  color: #75e8e7;
  text-shadow: 6px 4px #64379f;
  -webkit-text-stroke-width: 1px;
  -webkit-text-stroke-color: #0089fa;
}
button {
    width: 15vw;
    height: 40px;
    align-self: flex-end;
    margin-right: 10vw;
    background-image: linear-gradient(231deg,#e982df,#2099ff);
    text-decoration: none;
    font-family: fantasy;
    color: #492586;
    font-weight: lighter;
    text-shadow: 4px 3px #75e8e7;
  letter-spacing: 2pt;
  font-size: 14pt;
}
button:hover,
button:active {
  color: #75e8e7;
  text-shadow: 4px 3px #64379f;
  -webkit-text-stroke-width: 1px;
  -webkit-text-stroke-color: #0089fa;
}

</style>