<template>
  <div>
    <Header />
    <Cust-nav />
    <div id="main">
      <div id="text">
      <h2>Want to talk about distrupting the pizza ecosystem?</h2>
      <h3>Call Us at 123-456-7890</h3>
      <form @submit.prevent="sendEmail">
        <label>Your Name</label><br />
        <input type="text" v-model="name" /><br />
        <label>E-mail:</label><br />
        <input type="text" v-model="mail" /><br />
        <label>Tell us your thoughts:</label><br />
        <textarea v-model="comment" rows="4" cols="50"></textarea><br /><br />
        <button type="submit">Send</button>
        <button type="reset" @click="resetForm">Reset</button>
      </form>
      </div>
      <div id="phone">
        <img src="../assets/contactus.gif">
      </div>
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
  name: "Contact",
  data() {
    return {
      name: "",
      mail: "",
      comment: "",
    };
  },
  methods: {},
};
</script>

<style scoped>
#text {
  display: flex;
  flex-direction: column;
  margin: 50px 0px 0px 250px;
  justify-content: flex-start;
  padding-right: -200px;
}
#phone img {
  border-radius: 25px;
  background-image: url("../assets/contactus.gif");
  background-repeat: no-repeat;
  background-size: cover;
  border: solid 3px #75E8E7;
  margin: 0px 250px 0px 0px;
  justify-content: flex-start;
}
#main {
  display: flex;
  align-items: center;
  background-image: url("../assets/planets-moon-vaporwave-Favim.com-7224376.gif");
  background-size: cover;
  background-repeat: no-repeat;
  color: #27104e;
  border: 3px solid #75e8e7;
  border-radius: 25px;
  background-color: #64379f;
  margin: 20px;
  margin-top: 20px;
}

h2 {
  font-size: 45pt;
  font-family: fantasy;
  color: #27104e;
  margin: 0px;
  width: 50%;
  text-shadow: 6px 4px #75e8e7;
  letter-spacing: 6pt;
  text-decoration: none;
  margin-bottom: 25px;
  margin-left: 50px;
}
h3 {
  font-size: 24pt;
  color: #27104e;
  letter-spacing: 6px;
  font-family: fantasy;
  margin: 50px;
  margin-bottom: 25px;
  margin-top: 25px;
  text-shadow: 3px 3px #75e8e7;
}
form {
  font-family: fantasy;
  margin: 50px;
  margin-top: 0px;
}
label {
  color: #27104e;
  text-shadow: 2px 2px #75e8e7;
  letter-spacing: 1px;
}

button {
  background-image: linear-gradient(231deg, #75e8e7, #2099ff);
  font-family: fantasy;
  color: #27104e;
  letter-spacing: 1px;
  font-size: 24pt;
  padding: 10px;
  margin-right: 8px;
}
button {
  text-decoration: none;
  color: #492586;
  font-family: fantasy;
  font-weight: lighter;
  text-shadow: 4px 3px #75e8e7;
  letter-spacing: 2pt;
  font-size: 24pt;
}
button:hover,
button:active {
  color: #75e8e7;
  text-shadow: 4px 3px #492586;
  -webkit-text-stroke-width: 1px;
  -webkit-text-stroke-color: #0089fa;
}
</style>

  
  