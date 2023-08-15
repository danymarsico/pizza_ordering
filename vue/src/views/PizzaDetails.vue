<template>
  <div id="pizzaDtls">
      <Header />
       <AP-nav />
      <div id="main">
          <label for="name">Pizza Name: </label>
          <input id="name" type="text">
          <label for="desc">Description: </label>
          <textarea name="" id="" cols="10" rows="5"></textarea>
          <label for="price">Price: </label>
          <input id="price" type="number" min="10.00" step=".01">
          <label for="img">Image Upload: </label>
          <input id="img" type="text">
      </div>

      <button id="addBtn">Submit Pizza</button>
      
  </div>
</template>

<script>
import Header from '../components/Header.vue'
import APNav from '../components/APNav.vue'

export default {
    components: { Header, APNav },
}
</script>

<style scoped>
label {
    font-size: 25px;
    font-weight: bold;
    color: #75E8E7;
}
input {
    width: 20vw;
}

#pizzaDtls {
    display: flex;
    flex-direction: column;
    justify-content: center;
}

#main {
    display: flex;
    flex-direction: column;
    margin: 40px;
    margin-top: 20px;
    height: 900px;
    border: 1px solid #75E8E7;
    border-radius: 30px;
    padding: 40px;
}
#addBtn {
    width: 15vw;
    height: 40px;
    align-self: flex-end;
    margin-right: 10vw;
    background-image: linear-gradient(231deg,#e982df,#2099ff);
    text-decoration: none;
}
</style>