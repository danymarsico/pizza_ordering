<template>
  <div>
      <Header />
      <Cust-nav />
      <Main-menu />
  </div>
</template>

<script>
import Header from '../components/Header.vue'
import CustNav from '../components/CustNav.vue'
import MainMenu from '../components/MainMenu.vue'
export default {
components: { Header, CustNav, MainMenu}


}
</script>

<style>

</style>