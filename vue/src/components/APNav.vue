<template>
  <nav id="apNav">
    <ul id="nav-list">
      <li><router-link :to="{ name: 'AdminHome' }">Menu Items</router-link></li>
      <li>
        <router-link :to="{ name: 'Ingredients' }">Ingredients</router-link>
      </li>
      <!-- TODO Implement Reports page and add link -->
      <li><router-link :to="{ name: 'Reports' }">Reports</router-link></li>
      <!-- <li><button id="logoutBtn">Logout</button></li> -->
      <li>
        <router-link id="logoutBtn" :to="{ name: 'Logout' }"
          >Log Out</router-link
        >
      </li>
    </ul>
  </nav>
</template>

<script>
export default {};
</script>

<style scoped>
#nav-list {
  width: 90vw;
  list-style: none;
  display: flex;
  justify-content: space-around;
}
#apNav {
  margin: 5px 20px 5px 20px;
  border: solid 3px #75e8e7;
  border-radius: 30px;
  background-color: #ddacf5;
}
a:link,
a:visited {
  text-decoration: none;
  color: #64379f;
  font-family: fantasy;
  font-weight: lighter;
  text-shadow: 6px 4px #75e8e7;
  letter-spacing: 2pt;
  font-size: 18pt;
}
a:hover,
a:active {
  color: #75e8e7;
  text-shadow: 6px 4px #64379f;
  -webkit-text-stroke-width: 1px;
  -webkit-text-stroke-color: #0089fa;
}
</style>