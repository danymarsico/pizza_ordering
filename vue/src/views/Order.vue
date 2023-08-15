<template>
  <div>
    <Header />
    <Cust-nav />
    <div id="main-section">
      <form id="order-form">
        <div id="top-selections">
          <div id="select-pizza">
            <label for="select-pizza">Select Pizza: </label>
            <select
              name="select-pizza"
              class="selection"
              v-model="selectedPizza"
            >
              <option selected disabled>Choose a pizza</option>
              <option
                v-for="pizza in $store.state.specialtyPizzas"
                v-bind:key="pizza.pizzaName"
                v-bind:value="pizza.pizzaName"
                v-bind="selectToppings()"
              >
                {{ pizza.pizzaName }}
              </option>
            </select>
          </div>
          <div id="size">
            <label for="size">Size: </label>
            <select
              required
              name="size"
              class="selection"
              v-model="selectedSize"
            >
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
            <label for="crust">Crust: </label>
            <select
              required
              name="crust"
              class="selection"
              v-model="selectedCrust"
            >
              <option
                v-for="crust in $store.state.crust"
                v-bind:key="crust.crustName"
                v-bind:value="crust.crustName"
              >
                {{ crust.crustName }}
              </option>
            </select>
          </div>
        </div>
        <div id="choice-container">
          <div id="sauce-list">
            <div>
              <h2>Select Sauce</h2>
            </div>
            <div id="sauce-flex">
              <div
                id="sauce"
                v-for="sauce in $store.state.sauce"
                v-bind:key="sauce.sauceName"
                v-bind:value="sauce.sauceName"
              >
                <input
                  required
                  type="radio"
                  name="sauce"
                  id="sauce-radial"
                  v-bind:value="sauce.sauceName"
                  v-model="selectedSauce"
                />
                <label for="none">{{ sauce.sauceName }}</label>
              </div>
            </div>
          </div>
          <div id="toppings">
            <h2>Select Toppings</h2>
            <div id="topping-container">
              <div>
                <h2>Regular Toppings</h2>
                <div
                  v-for="topping in regularToppings"
                  v-bind:key="topping.toppingName"
                  class="topping-list"
                >
                  <input
                    type="checkbox"
                    class="checkbox"
                    v-bind:value="topping.toppingName"
                    v-model="selectedToppings"
                  />
                  <label>{{ topping.toppingName }}</label>
                </div>
              </div>
              <div>
                <h2>Premium Toppings</h2>
                <div
                  v-for="topping in premiumToppings"
                  v-bind:key="topping.toppingName"
                  class="topping-list"
                >
                  <input
                    type="checkbox"
                    class="checkbox"
                    v-bind:value="topping.toppingName"
                    v-model="selectedToppings"
                  />
                  <label>{{ topping.toppingName }}</label>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div id="instructions">
          <label for="instructions">Additional Instructions</label>
          <textarea
            name="instructions"
            cols="30"
            rows="10"
            class="instructions"
            v-model="additionalInfo"
          ></textarea>
        </div>
        <div id="my-order">
          <h2>My Order</h2>
          <div>
            <h2>
              Selected size: {{ selectedSize }} <br />
              Selected crust: {{ selectedCrust }} <br />
              Selected sauce: {{ selectedSauce }} <br />
              Selected Toppings: {{ selectedToppings }} <br />
              <br />
              <br />
              Subtotal: {{ subtotal.toFixed(2) }}
            </h2>
          </div>
          <input
            type="submit"
            value="Submit"
            @click.prevent="setCurrentPizzaInfo()"
            :disabled="!selectedPizza || !selectedSize || !selectedCrust || !selectedSauce"
            title="Please select at least a size, sauce, and crust type in order to submit"
          />
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
      selectedPizza: "",
      selectedToppings: [],
      selectedSize: "",
      selectedCrust: "",
      selectedSauce: "",
      additionalInfo: "",
    };
  },
  components: {
    Header,
    CustNav,
  },
  methods: {
    setCurrentPizzaInfo() {
      this.$store.commit("ADD_TO_CART", {
        selectedSize: this.selectedSize,
        selectedCrust: this.selectedCrust,
        selectedSauce: this.selectedSauce,
        selectedToppings: this.selectedToppings,
        selectedPizza: this.selectedPizza,
        additionalInfo: this.additionalInfo,
        price: this.subtotal
      });
      this.$router.push('/cart')
    },
    selectToppings() {
      if (this.selectedPizza === "The Butcher") {
      this.selectedToppings =
        this.$store.state.specialtyPizzas[0].specialtyToppings;
    }
    if (this.selectedPizza === "The G.O.A.T.") {
      this.selectedToppings =
        this.$store.state.specialtyPizzas[1].specialtyToppings;
    }
    if (this.selectedPizza === "O.G. NAMELESS") {
      this.selectedToppings =
        this.$store.state.specialtyPizzas[2].specialtyToppings;
    }
    if (this.selectedPizza === "Playlist Deluxe") {
      this.selectedToppings =
        this.$store.state.specialtyPizzas[3].specialtyToppings;
    }
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
      const size = this.$store.state.size.find(
        (item) => item.sizeName === this.selectedSize
      );
      return size ? size.sizePrice : 0;
    },
    crustPrice() {
      const crust = this.$store.state.crust.find(
        (item) => item.crustName === this.selectedCrust
      );
      return crust ? crust.crustPrice : 0;
    },
    saucePrice() {
      const sauce = this.$store.state.sauce.find(
        (item) => item.sauceName === this.selectedSauce
      );
      return sauce ? sauce.saucePrice : 0;
    },
    toppingPrices() {
      let totalToppingPrice = 0;
      this.selectedToppings.forEach((toppingName) => {
        const topping = this.$store.state.toppings.find(
          (item) => item.toppingName === toppingName
        );
        totalToppingPrice += topping ? topping.toppingPrice : 0;
      });
      return totalToppingPrice;
    },
    subtotal() {
      return (
        this.sizePrice + this.crustPrice + this.saucePrice + this.toppingPrices
      );
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
    if(this.selectedPizza === ''){
      this.selectedPizza = 'Custom Pizza'
    }
    this.selectedPizza = this.$route.params.selectedPizza;
    //TODO These are hardcoded statements but ideally would be a dynamic function that pull the
    //toppings of the selectedPizza based either on its name or ID
    if (this.selectedPizza === "The Butcher") {
      this.selectedToppings =
        this.$store.state.specialtyPizzas[0].specialtyToppings;
    }
    if (this.selectedPizza === "The G.O.A.T.") {
      this.selectedToppings =
        this.$store.state.specialtyPizzas[1].specialtyToppings;
    }
    if (this.selectedPizza === "O.G. NAMELESS") {
      this.selectedToppings =
        this.$store.state.specialtyPizzas[2].specialtyToppings;
    }
    if (this.selectedPizza === "Playlist Deluxe") {
      this.selectedToppings =
        this.$store.state.specialtyPizzas[3].specialtyToppings;
    }
  },
};
</script>
<style scoped>
#main-section {
  display: flex;
  flex-direction: column;
  justify-content: center;
  background-color: #9854CB;
  border-radius: 25px;
  margin: 20px;
  border: solid 3px #75E8E7;
  height: 100%;
  background-image: url("../assets/planets-moon-vaporwave-Favim.com-7224376.gif");
  background-size: cover;
  padding: 50px;
}
#top-selections {
  display: flex;
  padding: 15px;
  height: auto;
  width: 100;
  justify-content: space-evenly;
  background-color: #64379F;
  border-radius: 15px;
  border: solid 3px #75E8E7;
}
.selection {
  width: 200px;
  margin: 10px;
}
#choice-container {
  display: flex;
  flex-direction: column;
}
#sauce-list {
  display: flex;
  flex-direction: column;
  justify-content: center;
  background-color: #64379F;
  border-radius: 15px;
  border: solid 3px #75E8E7;
}
h2 {
  font-size: 30px;
  text-align: center;
  text-decoration: underline;
}
#sauce-flex{
  display: flex;
  justify-content: center;
}
#sauce {
  padding: 10px;
  margin: 10px;
  background-color: #DDACF5;
  border-radius: 15px;
  border: solid 3px #75E8E7;
}
#sauce label {
  text-decoration: none;
  color: #64379F;
  font-family: fantasy;
  font-weight: lighter;
  text-shadow: 6px 4px #75E8E7;
  letter-spacing: 2pt;
  font-size: 18pt;
  margin: 10px;
}
#sauce-radial {
  width: 10px;
  transform: scale(3);
}
#toppings {
  display: flex;
  align-items: center;
  flex-direction: column;
  background-color: #64379F;
  border-radius: 15px;
  border: solid 3px #75E8E7;
  flex-grow: 1;
}
#topping-container {
  display: flex;
  width: 100%;
  justify-content: space-evenly;
  margin: 25px;
}
.topping-list {
  display: flex;
  margin: 10px;
  padding: 10px;
  background-color: #DDACF5;
  border-radius: 15px;
  border: solid 3px #75E8E7;
}
.topping-list label {
  text-decoration: none;
  color: #64379F;
  font-family: fantasy;
  font-weight: lighter;
  text-shadow: 6px 4px #75E8E7;
  letter-spacing: 2pt;
  font-size: 18pt;
}
.checkbox {
  width: 30px;
}
#instructions {
  display: flex;
  align-items: center;
  flex-direction: column;
  background-color: #64379F;
  border-radius: 15px;
  border: solid 3px #75E8E7;
  flex-grow: 1;
}
.instructions {
  border: solid black 3px;
  margin: 10px;
}
#my-order {
  display: flex;
  align-items: center;
  flex-direction: column;
  background-color: #64379F;
  border-radius: 15px;
  border: solid 3px #75E8E7;
  flex-grow: 1;
  padding: 10px;
}
</style>