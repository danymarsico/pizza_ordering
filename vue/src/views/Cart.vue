<template>
  <div>
    <Header />
    <Cust-nav />
    <div id="main-section">
      <h1>Your Cart</h1>
      <div class="pizza" v-show="$store.state.cart.length === 0">
        <h2>Empty Flavor Space</h2>
      </div>
      <div class="pizza" v-for="pizza in $store.state.cart" v-bind:key="pizza">
        <h2>
          Pizza Name: {{ pizza.pizzaName }} | Size: {{ pizza.pizzaSize }} |
          Crust: {{ pizza.pizzaCrust }} | Sauce: {{ pizza.pizzaSauce }} |
          Toppings: {{ toppingsToString(pizza.selectedToppings) }} <br />
          Price: {{ pizza.price }}
        </h2>
        <h2 v-show="pizza.additionalInfo">
          Additional Instructions: {{ pizza.additionalInfo }}
        </h2>
      </div>
      <router-link :to="{ name: 'Order' }"
        ><button>Order More</button></router-link
      >
      <button @click="showModal">Pay Now</button>
      <div id="total">
        <h2>Your Total is : $ {{ calculateTotal }}</h2>
      </div>
      <div id="modal-container" class="modal hide">
        <span id="close" @click="hideModal">x</span>
        <form>
          <div>
            <h2>First Name: {{ customer.firstName }}</h2>
            <h2>Last Name: {{ customer.lastName }}</h2>
            <h2>Street Address: {{ customer.streetAddress }}</h2>
            <h2>City: {{ customer.city }}</h2>
            <h2>Phone Number: {{ customer.phoneNumber }}</h2>
          </div>
          <div>
            <input
              type="radio"
              name="is-delivery"
              class="delivery"
              checked="checked"
            />
            <label for="delivery">Delivery</label>
            <input type="radio" name="is-delivery" class="delivery" />
            <label for="delivery">Carry Out</label>
          </div>
          <div>
            <input
              type="radio"
              name="payment"
              class="delivery"
              checked="checked"
            />
            <label for="delivery">Pay Online</label>
            <input type="radio" name="payment" class="delivery" />
            <label for="delivery">Pay at Store</label>
          </div>
          <div id="cc-info">
            <label for="credit-card">Credit Card Information</label>
            <input
              type="tel"
              inputmode="numeric"
              name="credit-card"
              id="credit-card"
              autocomplete="cc-number"
              pattern="[0-9\s]{13,19}"
              maxlength="19"
              placeholder="xxxx xxxx xxxx xxxx"
            />
            <div>
              <input
                type="tel"
                name="exp-month"
                id=""
                placeholder="Expiration Month"
              />
              <input
                type="tel"
                name="exp-year"
                id=""
                placeholder="Expiration Year"
              />
            </div>
            <input type="tel" name="exp-cvv" id="" placeholder="CVV" />
          </div>
          <div>
            <input type="submit" value="Submit" />
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import Header from "../components/Header.vue";
import CustNav from "../components/CustNav.vue";
import CustomerInfoService from "../services/CustomerInfoService";
export default {
  components: { Header, CustNav },
  data() {
    return {
      isEmpty: true,
      customer: {},
      userId: this.$store.state.user.id,
    };
  },
  computed: {
    calculateTotal() {
      let total = 0.0;
      this.$store.state.cart.forEach((item) => {
        total += item.price;
      });
      return total;
    },
  },
  methods: {
    showModal() {
      let modal = document.getElementById("modal-container");
      modal.classList.remove("hide");
      modal.classList.add("display");
    },
    hideModal() {
      let modal = document.getElementById("modal-container");
      modal.classList.remove("display");
      modal.classList.add("hide");
    },
    toppingsToString(toppings) {
        let toppingString = '';
        toppings.forEach((topping) => {
          toppingString += topping + ", ";
        });
      toppingString = toppingString.substring(0, toppingString.length - 2);
      return toppingString;
    },
  },
  created() {
    const userId = this.$store.state.user.id;
    CustomerInfoService.getCustomerInfo(userId).then((response) => {
      this.customer = response.data;
    });
  },
};
</script>

<style scoped>
h1 {
  text-align: center;
  color: #75e8e7;
  font-size: 75px;
  font-family: monospace;
  text-decoration-line: underline;
  text-decoration-style: wavy;
  text-shadow: 1px 0px 10px whitesmoke;
  letter-spacing: 2pt;
  margin-top: 0;
  text-underline-offset: 12pt;
}
h2 {
  font-family: monospace;
  color: #75e8e7;
}
#main-section {
  display: flex;
  flex-direction: column;
  justify-content: center;
  background-color: #9854cb;
  background-image: url("../assets/planets-moon-vaporwave-Favim.com-7224376.gif");
  background-repeat: no-repeat;
  background-size: cover;
  border-radius: 25px;
  margin: 20px;
  border: solid 3px #75e8e7;
  padding: 20px;
}
.pizza {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  background-color: #27104e;
  border-radius: 25px;
  border: solid 3px #75e8e7;
  padding: 10px;
  margin: 0px 35px 25px 35px
}
button {
  background-image: linear-gradient(231deg, #e982df, #2099ff);
  width: 150px;
  text-decoration: none;
  color: #64379f;
  font-family: fantasy;
  font-weight: lighter;
  text-shadow: 4px 3px #75e8e7;
  letter-spacing: 2pt;
  font-size: 16pt;
  padding: 10px;
  margin-top: 5px;
}
button:hover,
button:active {
  color: #75e8e7;
  text-shadow: 5px 3px #64379f;
  -webkit-text-stroke-width: 1px;
  -webkit-text-stroke-color: #0089fa;
  padding: 10px;
}
.modal {
  background: rgb(2, 0, 36);
  background: linear-gradient(
    180deg,
    rgba(2, 0, 36, 1) 0%,
    rgba(9, 9, 121, 1) 57%,
    rgba(243, 27, 131, 1) 100%
  );
  position: fixed;
  z-index: 1;
  left: 25vw;
  top: 25vh;
  height: 30vh;
  width: 50vw;
  padding: 25px;
  overflow: auto;
  border: solid 3px #75e8e7;
  border-radius: 25px;
}
.display {
  display: block;
}
.hide {
  display: none;
}
#modal-container div {
  text-align: center;
  margin: 15px;
}
#close {
  float: right;
  margin: 10px;
  font-size: 25px;
  color: #75e8e7;
}
.delivery {
  margin: 10px;
  width: 10px;
}
#cc-info {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>