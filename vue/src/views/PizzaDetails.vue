<template>
  <div id="pizzaDtls">
      <AP-header />
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
import APHeader from '../components/APHeader.vue'
export default {
    components: { APHeader },
}
</script>

<style>
label {
    font-size: 25px;
    font-weight: bold;
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
    border: 1px solid black;
    border-radius: 30px;
    padding: 40px;
}
#addBtn {
    width: 15vw;
    height: 40px;
    align-self: flex-end;
    margin-right: 10vw;
}
</style>