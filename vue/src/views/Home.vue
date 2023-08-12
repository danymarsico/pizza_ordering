<template>
  <div class="home">
    <Header />
    <Cust-nav />
    
    <div id="home-container">
      <div id="group1" class="group-container">
        <div id="first-img" >
          <img src="../assets/pizza-chef.jpg">
        </div>
        <h3>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam laudantium dolores eveniet tempora blanditiis perferendis perspiciatis voluptatibus sint eius? Vero necessitatibus, obcaecati voluptates temporibus non et corrupti est qui sapiente!</h3>
      </div>
      <div id="group2" class="group-container">
        <h3>Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque error voluptates aut facere, aliquid nulla quibusdam sint odio quo excepturi totam quaerat accusamus odit id qui nihil culpa? Ipsum, tenetur!</h3>
        <div id="second-img" >
          <img src="../assets/pizza-turntables.gif">
        </div>
        
      </div>
      <div id="group3" class="group-container">
        <div id="third-img" >
          <img src="../assets/Frank-Franklin.jpg">
        </div>
        <h3>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Harum minus sit, perspiciatis neque eius dolorem! Magni, natus. Totam alias rerum ut odio consequuntur quod eveniet quam impedit, tenetur perferendis ex!</h3>
      </div>
      <div id="group4" class="group-container">
        <h3>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Maxime eveniet veritatis voluptate enim, possimus molestiae natus nulla, fugiat id est sunt asperiores. Perspiciatis quos exercitationem at consequatur. Optio, at illum.</h3>
        <div id="fourth-img" >
          <img src="../assets/holding-pizza.jpg">
        </div>
      </div>
    </div>
  </div>
</template>

<script scoped>
import Header from "../components/Header.vue";
import CustNav from "../components/CustNav.vue";
export default {
  components: {
    Header,
    CustNav,
  },
  name: "home",
};
</script>

<style>

.home{
  text-align: center;
}
#home-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  background-color: #9854cb;
  border-radius: 25px;
  margin: 20px;
  border: solid 3px #75e8e7;
  height: 100%;
  background-image: url('../assets/planets-moon-vaporwave-Favim.com-7224376.gif');
  background-size: cover;
}
.group-container{
  display: flex;
  justify-content: center;
  align-items: center;
}
.group-container h3{
  color:white;
}

.group-container img{
  width: 400px;
  margin: 20px;
  border: solid 3px #75e8e7;
  border-radius: 25px;
}

</style>
