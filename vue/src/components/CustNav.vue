<template>
  <nav id="custNav">
    <ul id="nav-list">
      <li class="nav">
        <router-link :to="{ name: 'Home' }">Home</router-link>
      </li>
      <li class="nav">
        <router-link :to="{ name: 'Menu' }">Menu</router-link>
      </li>
      <li class="nav">
        <router-link :to="{ name: 'Order' }">Order Now</router-link>
      </li>
      <li class="nav">
        <router-link :to="{ name: 'Story' }">Backstory</router-link>
      </li>
      <li class="nav">
        <router-link :to="{ name: 'Contact' }">Contact Info</router-link>
      </li>
      <li>
        <router-link :to="{ name: 'Cart' }"
          ><img src="../assets/neon-cart.png"
        /></router-link>
      </li>
      <li class="nav">
        <router-link :to="{ name: 'Logout' }">Logout</router-link>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {};
</script>

<style scoped>
img {
  width: 50px;
}

.nav {
  margin-top: 16px;
}

#custNav {
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
#nav-list {
  width: 90vw;
  list-style: none;
  display: flex;
  justify-content: space-around;
}
</style>