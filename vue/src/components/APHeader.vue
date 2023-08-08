<template>
  <div id="header">
      <h1>Homepage</h1>
      <nav>
          <ul id="nav-list">
              <li>Menu Items</li>
              <li>Ingredients</li>
              <li>Reports</li>
              <li>Logout</li>
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