<template>
<nav id="apNav">
          <ul id="nav-list">
              <li><router-link :to="{name: 'AdminHome' }">Menu Items</router-link></li>
              <li><router-link :to="{name: 'Ingredients' }">Ingredients</router-link></li>
              <!-- TODO Implement Reports page and add link -->
              <li><router-link :to="{name: 'Reports'}">Reports</router-link></li>
              <!-- <li><button id="logoutBtn">Logout</button></li> -->
              <li><router-link id="logoutBtn" :to="{name: 'Logout'}">Log Out</router-link></li>
          </ul>
      </nav>
</template>

<script>
export default {

}
</script>

<style scoped>
#apNav {
    margin:5px 20px 5px 20px;
    border: solid 3px #75E8E7;
    border-radius: 30px;
    background-color: #DDACF5;
}
a:link, a:visited {
    text-decoration: none;
    color: #27104e;
    font-weight: bold;
}
a:hover, a:active {
    color: #75e8e7;
}

</style>