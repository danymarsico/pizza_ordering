<template>
  <div>
    <Header />
    <h2>Want to talk about distrupting the pizza ecosystem? Send us a message:</h2>
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
  h2 {
    font-size: 18pt;
  }
  
  </style>