<template>
  <div>
    <Header />
    <div id="container">
      <div id="info">
        <form v-on:submit.prevent="createCustomer()">
          <div>
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
          <div>
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
          <div>
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
          <div>
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
          <div>
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
          <input type="submit" value="Submit" />
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

<style>
#container{
  background-image: url("../assets/cat-dj.gif");
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
  background-color: #64379f;
  border-radius: 15px;
  border: solid 3px #75e8e7;
}
</style>