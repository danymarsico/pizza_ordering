<template>
  <div>
    <Header />
    <div id="container">
      <div id="info">
        <form v-on:submit.prevent="createCustomer()">
          <h1 id="header">Transcend Your Infomatrix</h1>
          <div class="textInp">
            <input
              type="text"
              id="first-name"
              name="first-name"
              v-model="customer.firstName"
              placeholder="First Name"
              required
              autofocus
            />
          </div>
          <div class="textInp">
            <input
              type="text"
              id="last-name"
              name="last-name"
              v-model="customer.lastName"
              placeholder="Last Name"
              required
              autofocus
            />
          </div>
          <div class="textInp">
            <input
              type="text"
              id="street-address"
              name="street-address"
              v-model="customer.streetAddress"
              placeholder="Street Address"
              required
              autofocus
            />
          </div>
          <div class="textInp">
            <input
              type="text"
              id="city"
              name="city"
              v-model="customer.city"
              placeholder="City"
              required
              autofocus
            />
          </div>
          <div class="textInp">
            <input
              type="text"
              id="phone-number"
              name="phone-number"
              v-model="customer.phoneNumber"
              placeholder="Phone Number"
              required
              autofocus
            />
          </div>
          <input id="submit" type="submit" value="Vibe Dataflow" />
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import Header from "../components/Header.vue";
import AuthService from "../services/AuthService";

export default {
  components: {
    Header,
  },
  name: "CustomerInfo",
  data() {
    return {
      customer: {
        firstName: "",
        lastName: "",
        streetAddress: "",
        city: "",
        phoneNumber: "",
      },
    };
  },
  methods: {
    createCustomer() {
      AuthService.setUserInfo(this.customer).then((response) => {
        console.log(response.data);
        const route = {
          name: "Home",
        };
        this.$router.push(route);
      });
    },
  },
};
</script>

<style scoped>
#container{
  background-image: url("../assets/neonpizza.png");
  background-size: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  background-color: #9854cb;
  border-radius: 25px;
  margin: 20px;
  border: solid 3px #75e8e7;
  height: 500px;
}
#info {
  text-align: center;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  padding: 15px;
  height: auto;
  width: 20vw;
  background-color: #27104E;
  border-radius: 15px;
  border: solid 3px #75e8e7;
}
#submit {
  background-image: linear-gradient(231deg, #e982df, #2099ff);
  margin-top: 20px;
  font-family: fantasy;
  font-size: 18pt;
  letter-spacing: 2pt;
  color: #492586;
  font-weight: lighter;
  text-shadow: 3px 2px #75e8e7;
  padding: 8px;
  margin-bottom: 20px;
}
#submit:hover,
#submit:active {
  color: #75e8e7;
  text-shadow: 4px 3px #492586;
  -webkit-text-stroke-width: 1px;
  -webkit-text-stroke-color: #0089fa;
}
#header {
  color: #75e8e7;
  font-family: monospace;
  text-shadow: 1px 1px #f31b83;
  text-align: center;
}
.textInp {
  margin-bottom: 5px;
}
</style>