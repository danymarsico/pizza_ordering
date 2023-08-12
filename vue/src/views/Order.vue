<template>
  <div>
    <Header />
    <Cust-nav />
    <div id="main-section">
      <form id="order-form">
        <div>
          <label for="select-pizza">Select Pizza</label>
          <select name="select-pizza" id="select-pizza">
            <option value="butcher">The Butcher</option>
            <option value="goat">The G.O.A.T.</option>
            <option value="og-nameless">O.G. NAMELESS</option>
            <option value="playlist">Playlist Deluxe</option>
            <option value="custom">Create Your Own</option>
          </select>
        </div>
        <div>
          <label for="size">Size</label>
          <select name="size" id="size">
            <option value="Small">Small</option>
            <option value="Medium">Medium</option>
            <option value="Large">Large</option>
          </select>
        </div>
        <div>
          <label for="crust">Crust</label>
          <select name="crust" id="crust">
            <option value="hand-tossed">Hand Tossed</option>
            <option value="pan">Pan Crust</option>
            <option value="Stuffed">Stuffed Crust</option>
            <option value="Thin">Thin Crust</option>
          </select>
        </div>
        <div id="sauce-list">
          <h2>Select Sauce</h2>
          <label for="none">No Sauce</label>
          <input type="radio" name="sauce" id="none" />
          <label for="totato">Tomato</label>
          <input type="radio" name="sauce" id="tomato" />
          <label for="pesto">Pesto</label>
          <input type="radio" name="sauce" id="pesto" />
          <label for="buffalo">Buffalo</label>
          <input type="radio" name="sauce" id="buffalo" />
          <label for="white-garlic">White Garlic</label>
          <input type="radio" name="sauce" id="white-garlic" />
        </div>
        <div id="toppings">
          <h2>Select Toppings</h2>
          <div id="topping-container">
            <div class="topping-list">
              <label for="cheese">Cheese</label>
              <input type="checkbox" name="cheese" id="cheese" />
              <label for="pepperoni">Pepperoni</label>
              <input type="checkbox" name="pepperoni" id="pepperoni" />
              <label for="sausage">Sausage</label>
              <input type="checkbox" name="sausage" id="sausage" />
              <label for="ham">Ham</label>
              <input type="checkbox" name="ham" id="ham" />
              <label for="olives">Olive</label>
              <input type="checkbox" name="olives" id="olives" />
              <label for="green-peppers">Green Peppers</label>
              <input type="checkbox" name="green-peppers" id="green-peppers" />
            </div>
            <div class="topping-list">
              <label for="onions">Onions</label>
              <input type="checkbox" name="onions" id="onions" /><br />

              <label for="eggs">Eggs</label>
              <input type="checkbox" name="eggs" id="eggs" />
              <label for="gold-leaf">Gold Leaf</label>
              <input type="checkbox" name="gold-leaf" id="gold-leaf" />
              <label for="chanterelle-mushrooms">Chanterelle Mushrooms</label>
              <input
                type="checkbox"
                name="chanterelle-mushrooms"
                id="chanterelle-mushrooms"
              />
              <label for="black-truffle">Black Truffle</label>
              <input type="checkbox" name="black-truffle" id="black-truffle" />
              <label for="prosciutto">Prosciutto</label>
              <input type="checkbox" name="prosciutto" id="prosciutto" />
            </div>
          </div>
        </div>
        <div>
          <label for="instructions">Additional Instructions</label>
          <textarea
            name="instructions"
            id="instructions"
            cols="30"
            rows="10"
          ></textarea>
        </div>
        <div>
            <h2>My Order</h2>
            <div>
                <h2>my order goes here</h2>
            </div>
            <input type="submit" value="submit">
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import Header from "../components/Header.vue";
import CustNav from "../components/CustNav.vue";
export default {
  components: {
    Header,
    CustNav,
  },
};
</script>

<style scoped>
#order-form {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
#main-section {
  display: flex;
  flex-direction: column;
  justify-content: center;
  background-color: #9854cb;
  border-radius: 25px;
  margin: 20px;
  border: solid 3px #75e8e7;
  height: 100%;
  background-image: url("../assets/planets-moon-vaporwave-Favim.com-7224376.gif");
  background-size: cover;
}
#sauce-list {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  background-color: #64379f;
  border-radius: 25px;
  border: solid 3px #75e8e7;
}
#sauce-list h2 {
  font-size: 30px;
  text-decoration: underline;
}
#toppings {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  background-color: #64379f;
  border-radius: 25px;
  border: solid 3px #75e8e7;
}
#topping-container {
  display: flex;
}

.topping-list {
  margin: 25px;
  border: red 1px solid;
}
input {
  width: 50px;
}
</style>