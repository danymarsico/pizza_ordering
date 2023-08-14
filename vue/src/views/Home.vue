<template>
  <div class="home">
    <Header />
    <Cust-nav />
    
    <div id="home-container">
      <div id="group1" class="group-container">
        <div id="first-img" >
          <img src="../assets/pizza-chef.jpg">
        </div>
        <h3>Step into the neon-drenched realm of N*A*M*E*L*E*S*S*Π Pizza, where culinary innovation merges with retro-futuristic aesthetics! Our menu invites you on an exhilarating journey through time, presenting a symphony of flavors that pay homage to the neon-soaked nostalgia of yesteryears. Savor "The Butcher," a carnivore's delight featuring a tantalizing blend of cheeses, pepperoni, sausage, ham, and prosciutto, all dancing harmoniously atop a perfectly baked crust. Embark on a voyage of taste as you explore the "Create Your Own" option, where you wield the power to curate your very own pixel-perfect pizza masterpiece. Immerse yourself in this gastronomic pixel paradise and uncover the full menu by visiting our Menu page – an extraordinary vaporwave-inspired pizza experience awaits with just a click!</h3>
      </div>
      <div id="group2" class="group-container">
        <h3>Welcome back, fellow traveler of the digital cosmos! If you've graced our pixelated realm before, then consider yourself part of the elite vanguard. Skip the introductory stardust and journey straight to the pulsating heart of flavor – our Order Now page. Synthwave through the formalities and dive headfirst into the neon-tinted symphony of taste.</h3>
        <div id="second-img" >
          <img src="../assets/pizza-turntables.gif">
        </div>
        
      </div>
      <div id="group3" class="group-container">
        <div id="third-img" >
          <img src="../assets/Frank-Franklin.jpg">
        </div>
        <h3>Venture beyond the neon horizon and explore the genesis of our cosmic pizzeria on the Our Story page. Unearth the legend of our visionary founder, Frank Franklin, as he forged a path through the digital cosmos to create an epochal pixelated pizzeria experience. Embark on this vaporwave odyssey and let the pixels of our past illuminate your present.</h3>
      </div>
      <div id="group4" class="group-container">
        <h3>Dare to ride the neon wave of culinary innovation and reshape the pizza universe with us? Seek the path to pixelated enlightenment and unravel the mysteries of flavor on our Contact Us page. Whether you're a renegade taste explorer or simply want to drop a virtual hi-fi, this is your portal to the vaporwave frontier. Embrace the glitch, ride the vibe, and let's reshape the gastronomic cosmos together.</h3>
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
