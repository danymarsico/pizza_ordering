<template>
  <div class="home">
    <Header />
    <Cust-nav />
    
    <div id="home-container">
      <div id="group1" class="group-container">
        <div id="first-img" >
          <img src="../assets/neonsign-home.jpg">
        </div>
        <div>
          <h3 class="text-blurb">Experience N*A*M*E*L*E*S*S*Π Pizza's neon world, where culinary innovation meets retro-futuristic style! Our menu takes you on a flavorful journey through time, with a symphony of tastes that evoke nostalgic neon vibes. Try "The Butcher," a carnivore's dream with cheeses, pepperoni, sausage, ham, and prosciutto on a perfect crust. Customize your own pixel-perfect pizza with "Create Your Own." Explore the full menu on our vaporwave-inspired Menu page. Click to immerse yourself in this unique pizza experience!</h3>
          <router-link :to="{name: 'Menu'}"><button>Teleport Me To The Menu</button></router-link>
        </div>
      </div>
      <div id="group2" class="group-container">
        <div>
          <h3 class="text-blurb">If you've graced our pixelated realm before, welcome back, fellow traveler of the digital cosmos! Consider yourself part of the elite vanguard. Skip the introductory stardust and journey straight to the pulsating heart of flavor – our Order Now page. Synthwave through the formalities and dive headfirst into the neon-tinted symphony of taste.</h3>
          <router-link :to="{name: 'Order'}"><button>I Want Pizza NOW</button></router-link>
        </div>
        <div id="second-img" >
          <img src="../assets/pizzanbeer.png">
        </div>
        
      </div>
      <div id="group3" class="group-container">
        <div id="third-img" >
          <img src="../assets/therealfrankfranklin.png">
        </div>
        <div>
          <h3 class="text-blurb">Venture beyond the neon horizon and explore the genesis of our cosmic pizzeria on the Backstory page. Unearth the legend of our visionary founder, Frank Franklin, as he forged a path through the digital cosmos to create an epochal pixelated pizzeria experience. Embark on this vaporwave odyssey and let the pixels of our past illuminate your present.</h3>
          <router-link :to="{name: 'Story'}"><button>Travel Back In Time</button></router-link>
        </div>
      </div>
      <div id="group4" class="group-container">
        <div>
          <h3 class="text-blurb">Dare to ride the neon wave of culinary innovation and reshape the pizza universe with us? Seek the path to pixelated enlightenment and unravel the mysteries of flavor on our Contact Info page. Whether you're a renegade taste explorer or simply want to drop a virtual hi-fi, this is your portal to the vaporwave frontier. Embrace the glitch, ride the vibe, and let's reshape the gastronomic cosmos together.</h3>
          <router-link :to="{name: 'Contact'}"><button>Let's Disrupt The Pizza Ecosystem</button></router-link>
        </div>
        <div id="fourth-img" >
          <img src="../assets/callus-home.gif">
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

<style scoped>
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
  padding: 50px;
}
.group-container{
  display: flex;
  justify-content: center;
  align-items: center;
}

.text-blurb{
  color: #75e8e7;
  background-color: #27104e;
  border: ridge 3px #75e8e7;
  border-radius: 25px;
  padding: 15px;
  width: 40vw;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  font-weight: lighter;
}

.group-container img{
  width: 400px;
  margin: 20px;
  border: solid 3px #75e8e7;
  border-radius: 25px;
}

button{
  background-image: linear-gradient(231deg,#e982df,#2099ff);
  margin: -5px 0px 0px 0px;
  font-family: fantasy;
  font-size: 18pt;
  letter-spacing: 2pt;
  color: #492586;
  font-weight: lighter;
  text-shadow: 3px 2px #75e8e7;
  padding: 12px;
}
button:hover, button:active {
    color: #75e8e7;
    text-shadow: 6px 4px #492586;
        -webkit-text-stroke-width: 1px;
  -webkit-text-stroke-color: #0089fa;
}
</style>
