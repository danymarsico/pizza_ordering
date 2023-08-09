<template>
  <div id="header">
      <h1>Dope Pizza Admin Panel</h1>
      <nav>
          <ul id="nav-list">
              <li><router-link :to="{name: 'AdminHome' }">Menu Items</router-link></li>
              <li><router-link :to="{name: 'Ingredients' }">Ingredients</router-link></li>
              <!-- TODO Implement Reports page and add link -->
              <li>Reports</li>
              <li><button>Logout</button></li>
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
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    border: solid 3px black;
    border-radius: 30px;
    background-color: aquamarine;
    margin: 20px;
}

#nav-list {
    width: 90vw ;
    list-style: none;
    display: flex;
    justify-content: space-around;
}


</style>