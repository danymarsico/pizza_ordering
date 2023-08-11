<template>
  <div id="apHome">
      <Header/>
      <AP-nav />
      <AP-main />
      <button id="addBtn"><router-link :to="{name: 'PizzaDetails' }">Add New Pizza</router-link></button>
  </div>
</template>

<script>
import Header from '../components/Header.vue'
import APMain from '../components/APMain.vue'
import APNav from '../components/APNav.vue'

export default {
components: { Header, APNav, APMain },
name: 'AdminHome'
}
</script>

<style>
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

</style>