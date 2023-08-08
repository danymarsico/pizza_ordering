<template>
  <div id="pizzaDtls">
      <AP-header />
      <div id="main">
          <label for="">Pizza Name: </label>
          <input type="text">
          <label for="">Description: </label>
          <input type="text">
          <label for="">Price: </label>
          <input type="text">
          <label for="">Ingredients: </label>
          <input type="text">
          <label for="">Image Upload: </label>
          <input type="text">
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
}
#addBtn {
    width: 15vw;
    height: 40px;
    align-self: flex-end;
    margin-right: 10vw;
}
</style>