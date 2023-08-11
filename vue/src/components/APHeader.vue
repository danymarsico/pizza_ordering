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
#header {
    background-image: url('../assets/banner.jpg');
    background-size: 100%;
    background-repeat: no-repeat;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    border: solid 3px #75E8E7;
    border-radius: 30px;
    color: #75E8E7;
    margin: 20px;
    height: 400px;
}


</style>