<template>
  <div>
    <Header />
    <div id="main">
    <h2>Want to talk about distrupting the pizza ecosystem?</h2>
    <h3>Call Us at 123-456-7890</h3>
    <form @submit.prevent="sendEmail">
      <label>Your Name</label><br>
      <input type="text" v-model="name"><br>
      <label>E-mail:</label><br>
      <input type="text" v-model="mail"><br>
      <label>Tell us your thoughts:</label><br>
      <textarea v-model="comment" rows="4" cols="50"></textarea><br><br>
      <button type="submit">Send</button>
      <button type="reset" @click="resetForm">Reset</button>
    </form>
    </div>
  </div>
</template>
<script>
import Header from '../components/Header.vue';

export default {
   components: {
    Header,
  },
  name: "Contact",
  data() {
    return {
      name: '',
      mail: '',
      comment: ''
    };
  },
    methods: {
    }
        
  };
  </script>

  <style>
  #main {
      display: grid;
      background-image: url('../assets/contactus.gif');
      background-size: cover;
      background-repeat: no-repeat;
      color: #27104e
  }
  h2 {
    font-size: 22pt;
    color: #27104e

  }
  h3 {
    font-size: 22pt;
    color: #75e8e7

  }
  
  </style>

  