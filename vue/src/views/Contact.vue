<template>
  <div>
    <Header />
    <Cust-nav />
    <div id="main">
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
#main {
  display: grid;
  background-image: url("../assets/contactus.gif");
  background-size: cover;
  background-repeat: no-repeat;
  color: #27104e;
  max-height: 1000px;
  border: 3px solid #75e8e7;
  border-radius: 25px;
  background-color: #64379f;
  margin: 20px;
  margin-top: 20px;
  height: 900px;
}

h2 {
  font-size: 65pt;
  font-family: fantasy;
  color: #27104e;
  margin: 0px;
  width: 75%;
  text-shadow: 6px 4px #75e8e7;
  letter-spacing: 6pt;
}
h3 {
  font-size: 28pt;
  color: #27104e;
  letter-spacing: 6px;
  font-family: fantasy;
  margin-top: 50px;
  margin-bottom: 0px;
  text-shadow: 3px 3px #75e8e7;
}
form {
  font-family: fantasy;
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

  
  