<template>
  <div id="pizzaDtls">
    <Header />
    <AP-nav />
    <h1 id="title">Add A New Pizza</h1>
    <div id="mainContainer">
      <div id="main">
        <label for="name">Pizza Name: </label>
        <input id="name" type="text" />
        <label for="desc">Description: </label>
        <textarea name="" id="" cols="10" rows="5"></textarea>
        <label for="price">Price: </label>
        <input id="price" type="number" min="10.00" step=".01" />
        <label for="img">Image Upload: </label>
        <input id="img" type="text" />
      </div>
    </div>

    <button id="addBtn">Submit Pizza</button>
  </div>
</template>

<script>
import Header from "../components/Header.vue";
import APNav from "../components/APNav.vue";

export default {
  components: { Header, APNav },
};
</script>

<style scoped>
label {
  font-size: 25px;
  font-weight: bold;
  color: #75e8e7;
  font-family: monospace;
  text-shadow: 1px 1px #0089fa;
  margin-bottom: 8px;
}
input {
  width: 20vw;
  margin: 5px 0px 10px;
}
#pizzaDtls {
  display: flex;
  flex-direction: column;
  justify-content: center;
}
#main {
  display: flex;
  flex-direction: column;
  margin: 20px;
  margin-top: 0px;
  height: 300px;
  border: 1px solid #75e8e7;
  border-radius: 25px;
  padding: 40px;
  background-color: #64379f;
}
button {
  width: 15vw;
  height: 40px;
  align-self: flex-end;
  margin-right: 10vw;
  background-image: linear-gradient(231deg, #e982df, #2099ff);
  text-decoration: none;
  font-family: fantasy;
  color: #492586;
  font-weight: lighter;
  text-shadow: 4px 3px #75e8e7;
  letter-spacing: 2pt;
  font-size: 14pt;
}
button:hover,
button:active {
  color: #75e8e7;
  text-shadow: 4px 3px #64379f;
  -webkit-text-stroke-width: 1px;
  -webkit-text-stroke-color: #0089fa;
}
#title {
  margin-left: 20px;
  color: #75e8e7;
  text-align: center;
  font-family: monospace;
  font-size: 35pt;
  text-shadow: 2px 1px #0089fa;
}
</style>