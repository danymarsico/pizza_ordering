<template>
  <div class="home">
    <Header />
    <h1>Home</h1>
    <p>If you are seeing this, you are authenticated.</p>
  </div>
</template>

<script>
import Header from '../components/Header.vue'
export default {
  components:{
        Header,
    },
  name: "home"
};
</script>
