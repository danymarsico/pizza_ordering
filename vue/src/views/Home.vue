<template>
  <div class="home">
    <AP-header />
    <h1>Home</h1>
    <p>If you are seeing this, you are authenticated.</p>
  </div>
</template>

<script>
import APHeader from '../components/APHeader.vue'
export default {
  components:{
        APHeader,
    },
  name: "home"
};
</script>
