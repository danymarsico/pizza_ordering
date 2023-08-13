<template>
  <div id="ingredientDtls">
      <Header />
      <AP-nav />
      <div id="main">
          <label for="name">Ingredient Name: </label>
          <input id="name" type="text">
          <label for="price">Ingredient Price: </label>
          <input id="price" type="number" min=".01" step=".01">
          <label for="premium">Premium Ingredient: </label>
          <select id="premium">
              <option value="">---Yes/No---</option>
              <option value="">Yes</option>
              <option value="">No</option>
          </select>
      </div>

      <button id="addBtn">Submit Ingredient</button>
      
  </div>
</template>

<script>
import Header from '../components/Header.vue'
import APNav from '../components/APNav.vue'

export default {
  components: { Header, APNav },

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

#premium {
    width: 20.5vw;
}

#ingredientDtls {
    display: flex;
    flex-direction: column;
    justify-content: center;
}

#main {
    display: flex;
    flex-direction: column;
    margin: 40px;
    margin-top: 20px;
    margin-bottom: 0px;
    height: 900px;
    border: 3px solid #75E8E7;
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