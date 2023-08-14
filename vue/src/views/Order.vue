<template>
  <div>
    <Header />
    <Cust-nav />
    <div id="main-section">
      <form id="order-form">
        <div id="select-pizza">
          <label for="select-pizza">Select Pizza</label>
          <select name="select-pizza" id="select-pizza" v-model="selectedPizza">
            <option selected disabled>Choose a pizza</option>
            <option
              v-for="pizza in $store.state.specialtyPizzas"
              v-bind:key="pizza.pizzaName"
              v-bind:value="pizza.pizzaName"
            >
              {{ pizza.pizzaName }}
            </option>
          </select>
        </div>
        <div id="size">
          <label for="size">Size</label>
          <select required name="size" id="size" v-model="selectedSize">
            <option
              v-for="size in $store.state.size"
              v-bind:key="size.sizeName"
              v-bind:value="size.sizeName"
            >
              {{ size.sizeName }}
            </option>
          </select>
        </div>
        <div id="crust">
          <label for="crust">Crust</label>
          <select required name="crust" id="crust" v-model="selectedCrust">
            <option
              v-for="crust in $store.state.crust"
              v-bind:key="crust.crustName"
              v-bind:value="crust.crustName"
            >
              {{ crust.crustName }}
            </option>
          </select>
        </div>
        <div id="sauce-list">
          <h2>Select Sauce</h2>
          <div
            v-for="sauce in $store.state.sauce"
            v-bind:key="sauce.sauceName"
            v-bind:value="sauce.sauceName"
          >
            <label for="none">{{ sauce.sauceName }}</label>
            <input required type="radio" name="sauce" id="none" v-bind:value="sauce.sauceName" v-model="selectedSauce"/>
          </div>
        </div>
        
        <div id="toppings">
          <h2>Select Toppings</h2>
          
          <div id="topping-container">
            
            <div class="topping-list">
              <h2>Regular Toppings</h2>
              <div v-for="topping in regularToppings" v-bind:key="topping.toppingName">
                <label>{{topping.toppingName}}</label>
                <input type="checkbox" name="" id="" v-bind:value="topping.toppingName" v-model="selectedToppings" />
              </div>
            </div>


            <div class="topping-list">
              <h2>Premium Toppings</h2>
              <div v-for="topping in premiumToppings" v-bind:key="topping.toppingName">
                <label>{{topping.toppingName}}</label>
                <input type="checkbox" name="" id="" v-bind:value="topping.toppingName" v-model="selectedToppings"  />
              </div>
            </div>          
          </div>
        </div>
        <div id="instructions">
          <label for="instructions">Additional Instructions</label>
          <textarea
            name="instructions"
            id="instructions"
            cols="30"
            rows="10"
            v-model="additionalInfo"
          ></textarea>
        </div>
        <div id="myOrder">
          <h2>My Order</h2>
          <div>
            <h2>
              Selected size: {{selectedSize}} <br>
              Selected crust: {{selectedCrust}} <br>
              Selected sauce: {{selectedSauce}} <br>
              Selected Toppings: {{selectedToppings}} <br>
              <br>
              <br>
              Subtotal: {{subtotal.toFixed(2)}}
              </h2>
          </div>
          <input type="submit" value="Submit" @click.prevent="setCurrentPizzaInfo()" :disabled="!selectedSize || !selectedCrust || !selectedSauce"
      title="Please select at least a size, sauce, and crust type in order to submit" />
        </div>
      </form>
    </div>
  </div>
</template>



<script>
import Header from "../components/Header.vue";
import CustNav from "../components/CustNav.vue";
export default {
  data() {
    return {
      selectedPizza: '',
      selectedToppings: [],
      selectedSize: '',
      selectedCrust: '',
      selectedSauce: '',
      additionalInfo: '',
    };
  },
  components: {
    Header,
    CustNav,
  },
  methods: {
    setCurrentPizzaInfo(){
      this.$store.commit('SET_PIZZA_INFO', 
      { selectedSize: this.selectedSize, 
        selectedCrust: this.selectedCrust,
        selectedSauce: this.selectedSauce,
        selectedToppings: this.selectedToppings,
        selectedPizza: this.selectedPizza
      })
    }
  },
  computed: {
    regularToppings() {
      return this.$store.state.toppings.filter((topping) => !topping.isPremium);
    },
    premiumToppings() {
      return this.$store.state.toppings.filter((topping) => topping.isPremium);
    },
    sizePrice() {
    const size = this.$store.state.size.find(item => item.sizeName === this.selectedSize);
    return size ? size.sizePrice : 0;
  },
  crustPrice() {
    const crust = this.$store.state.crust.find(item => item.crustName === this.selectedCrust);
    return crust ? crust.crustPrice : 0;
  },
  saucePrice() {
    const sauce = this.$store.state.sauce.find(item => item.sauceName === this.selectedSauce);
    return sauce ? sauce.saucePrice : 0;
  },
  toppingPrices() {
    let totalToppingPrice = 0;
    this.selectedToppings.forEach(toppingName => {
      const topping = this.$store.state.toppings.find(item => item.toppingName === toppingName);
      totalToppingPrice += topping ? topping.toppingPrice : 0;
    });
    return totalToppingPrice;
  },
  subtotal() {
    return this.sizePrice + this.crustPrice + this.saucePrice + this.toppingPrices;
  },
  //Deprecated function
    // calculateSubtotal(){
    //   let subtotal = 0;

    //   // Calculate pizza price based on size
    //   const size = this.$store.state.size.find(item => item.sizeName === this.selectedSize);
    //   subtotal += size.sizePrice;

    //   // Calculate topping prices
    //   this.selectedToppings.forEach(toppingName => {
    //     const topping = this.$store.state.toppings.find(item => item.toppingName === toppingName);
    //     subtotal += topping.toppingPrice;
    //   });

    //   // Calculate sauce price
    //   const sauce = this.$store.state.sauce.find(item => item.sauceName === this.selectedSauce);
    //   subtotal += sauce.saucePrice;

    //   // Calculate crust price
    //   const crust = this.$store.state.crust.find(item => item.crustName === this.selectedCrust);
    //   subtotal += crust.crustPrice;

    //   return subtotal;
    // },
    // subtotal() {
    //   return this.calculateSubtotal();
    // }
    //Function that first checks what specialtyPizza has been selected,
    //then based on that has a forEach loop that adds all the toppings
    //associated to the specific specialtyPizza into the selectedToppings array
    // preselectToppings() {
    //   if(this.selectedPizza === "The Butcher") +{
    //    this.selectedToppings = this.$store.state.specialtyPizzas.specialtyToppings;
    //   }
    // }
  },
  created() {
    this.selectedPizza = this.$route.params.selectedPizza;

    //TODO These are hardcoded statements but ideally would be a dynamic function that pull the
    //toppings of the selectedPizza based either on its name or ID
    if(this.selectedPizza === "The Butcher") {
       this.selectedToppings = this.$store.state.specialtyPizzas[0].specialtyToppings;
  }
  if(this.selectedPizza === "The G.O.A.T.") {
       this.selectedToppings = this.$store.state.specialtyPizzas[1].specialtyToppings;
  }
  if(this.selectedPizza === "O.G. NAMELESS") {
       this.selectedToppings = this.$store.state.specialtyPizzas[2].specialtyToppings;
  }
  if(this.selectedPizza === "Playlist Deluxe") {
       this.selectedToppings = this.$store.state.specialtyPizzas[3].specialtyToppings;
  }
  }
};
</script>
<style scoped>
#order-form {
  display: grid;
  grid-template-areas:
    "select-pizza sauce-list myOrder"
    "size toppings myOrder"
    "crust toppings instructions";
  grid-gap: 20px;
  justify-content: center;
  align-items: center;
  margin: 10px;
}

#select-pizza,
#size,
#crust,
#sauce-list,
#instructions,
#myOrder {
  margin-bottom: 20px;
}

#select-pizza,
#size,
#crust,
#sauce-list h2 {
  font-size: 18px;
}

select,
label,
input[type="checkbox"],
input[type="radio"],
textarea {
  font-size: 16px;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 5px;
  width: 100%;
}

#sauce-list h2 {
  text-decoration: underline;
  margin-right: 8px;
}

#sauce-list label {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

#sauce-list input[type="radio"] {
  margin-right: 5px;
  align-self: center;
}

#toppings {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  background-color: #64379f;
  border-radius: 25px;
  border: solid 3px #75e8e7;
  padding: 10px;
}

.topping-list {
  margin: 15px;
  padding: 10px;
  border-radius: 25px;
  border: solid 5px #75e8e7;
  border-style: ridge;
}

.topping-list label {
  margin-bottom: 10px;
}

input[type="checkbox"],
input[type="radio"] {
  vertical-align: middle;
}

#instructions {
  grid-area: instructions;
}

#myOrder {
  text-align: center;
  margin-top: 20px; /* Add margin to create space between Additional Instructions and My Order */
}

.order-summary {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f7f7f7;
  margin-top: 10px;
}

.styled-button {
  padding: 10px 20px;
  background-color: #9854cb;
  color: white;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
}

#main-section {
  display: flex;
  flex-direction: column;
  justify-content: center;
  background-color: #9854cb;
  border-radius: 25px;
  margin: 20px;
  border: solid 3px #75e8e7;
  padding: 20px;
}
/*#order-form {
  display: grid;
  grid-template-areas:
    "select-pizza  sauce-list myOrder"
    "size  toppings myOrder"
    "crust  toppings instructions";
  justify-content: center;
  justify-items: left;
  align-items: center;
  margin: 10px;
}
#select-pizza {
  grid-area: select-pizza;
}
#size {
  grid-area: size;
}
#crust {
  grid-area: crust;
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
  grid-area: sauce-list;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #64379f;
  border-radius: 25px;
  border: solid 3px #75e8e7;
  margin: 5px;
}
#instructions {
  grid-area: instructions;
}
#sauce-list h2 {
  font-size: 30px;
  text-decoration: underline;
  margin-right: 8px;
}
#myOrder {
  grid-area: myOrder;
}
#toppings {
  grid-area: toppings;
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
  margin: 15px;
  padding: 10px;
  border-radius: 25px;
  border: solid 5px #75e8e7;
  border-style: ridge;
}
input {
  width: 50px;
}*/
</style>




<!--<template>
  <div>
    <Header />
    <Cust-nav />
    <div id="main-section">
      <form id="order-form">
        <div>
          <label for="select-pizza">Select Pizza</label>
          <select name="select-pizza" id="select-pizza" v-model="selectedPizza">
            <option v-for="pizza in $store.state.specialtyPizzas" v-bind:key="pizza.pizzaName" v-bind:value="pizza.pizzaName">{{pizza.pizzaName}}</option>
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
  data() {
    return {
      selectedPizza: ''
    };
  },
  components: {
    Header,
    CustNav,
  },
  created() {
    this.selectedPizza = this.$route.params.selectedPizza;
  }
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
-->