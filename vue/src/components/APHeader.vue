<template>
  <div id="header">
      <img id="logo" src="../assets/namelesspi.png" alt="">
      <nav>
          <ul id="nav-list">
              <li><router-link :to="{name: 'AdminHome' }">Menu Items</router-link></li>
              <li><router-link :to="{name: 'Ingredients' }">Ingredients</router-link></li>
              <!-- TODO Implement Reports page and add link -->
              <li>Reports</li>
              <li><button id="logoutBtn">Logout</button></li>
          </ul>
      </nav>
  </div>
</template>

<script>
export default {

}
</script>

<style>



</style>