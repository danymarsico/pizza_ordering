<template>
  <div>
    <Header />
    <Cust-nav />
    <div id="main">
      <!-- <h1>Contact</h1> -->
      <div id="container">
        <div id="text">
          <h2>Want to talk about distrupting the pizza ecosystem?</h2>
          <h3>Call Us at 123-456-7890</h3>
          <form @submit.prevent="sendEmail">
            <label>Your Name</label><br />
            <input type="text" v-model="name" /><br />
            <label>E-mail:</label><br />
            <input type="text" v-model="mail" /><br />
            <label>Tell us your thoughts:</label><br />
            <textarea v-model="comment" rows="4" cols="50"></textarea
            ><br /><br />
            <button type="submit">Send</button>
            <button type="reset" @click="resetForm">Reset</button>
          </form>
        </div>
        <div id="phone">
          <img src="../assets/contactus.gif" />
        </div>
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
  justify-content: center;
  padding: 25px;
  margin-right: -300px;
  margin-left: 40px;
  margin-top: 25px;
  margin-bottom: 0px;
  z-index: 1;
}
#phone img {
  border-radius: 25px;
  background-image: url("../assets/contactus.gif");
  background-repeat: no-repeat;
  background-size: cover;
  border: solid 3px #75e8e7;
  height: auto;
  margin-left: -200px;
  margin-right: 100px;
  margin-top: 50px;
  margin-bottom: 50px;
  z-index: 0;
}
#main {
  display: flex;
  align-items: center;
  justify-content: center;
  background-image: url("../assets/planets-moon-vaporwave-Favim.com-7224376.gif");
  background-size: cover;
  background-repeat: no-repeat;
  color: #27104e;
  border: 3px solid #75e8e7;
  border-radius: 25px;
  background-color: #64379f;
  margin: 20px;
  margin-top: 20px;
  padding: 50px;
}
#container {
  display: flex;
  background-color: #ddacf5;
  border: solid 3px #75e8e7;
  border: ridge 3px #75e8e7;
  border-radius: 25px;
  width: 80%;
  align-items: center;
  justify-content: center;
}
h2 {
  font-size: 40pt;
  font-family: fantasy;
  color: #64379f;
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
  color: #64379f;
  letter-spacing: 6px;
  font-family: fantasy;
  margin: 50px;
  margin-bottom: 25px;
  margin-top: 25px;
  text-shadow: 6px 4px #75e8e7;
  width: 50%;
}
/* h1 {
  color: #75e8e7;
  font-size: 75px;
  font-family: monospace;
  text-decoration-line: underline;
  text-decoration-style: wavy;
  text-shadow: 1px 0px 10px whitesmoke;
  letter-spacing: 2pt;
} */
form {
  font-family: fantasy;
  margin: 50px;
  margin-top: 0px;
  width: 50%;
}
label {
  color: #64379f;
  text-shadow: 6px 4px #75e8e7;
  letter-spacing: 1px;
}

button {
  background-image: linear-gradient(231deg, #e982df, #2099ff);
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

  
  