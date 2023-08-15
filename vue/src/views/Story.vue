<template>
  <div>
    <Header />
    <Cust-nav />
    <div id="story-main" >
      <h1>Backstory</h1>
      <div id="img-container">
        <img src="../assets/pizza-shop.jpg" class="pizza-slides" />
        <img src="../assets/pizza-shop2.jpg" class="pizza-slides" />
        <img src="../assets/making-pizza.jpg" class="pizza-slides" />
        <img src="../assets/pizza-champion.jpg" class="pizza-slides" />
        <!-- <button>&#10094;</button>
        <button>&#10095;</button> -->
        <div id="text-container">
            <p class="text">
            text 1
            </p>
            <p class="text">
            text 2
            </p>
            <p class="text">
            text 3
            </p>
            <p class="text">
            text 4
            </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Header from "../components/Header.vue";
import CustNav from "../components/CustNav.vue";
let slideIndex = 0;



export default {
  components: {
    Header,
    CustNav,
  },
  methods: {
    carousel(){

      let slides = document.getElementsByClassName("pizza-slides");
      let text = document.getElementsByClassName("text");
      for(let i = 0; i < slides.length; i++){
        slides[i].style.display = "none";
        text[i].style.display = "none";
      }

      slideIndex++;
      if(slideIndex > slides.length) {
         slideIndex = 1
         }
      slides[slideIndex -1].style.display = "block";
      text[slideIndex -1].style.display = "block";
      setTimeout(this.carousel, 8000);

    }
  },
  mounted: function(){
    this.carousel();
  },
};
</script>

<style scoped>
#story-main {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: #9854cb;
  border-radius: 25px;
  margin: 20px;
  border: solid 3px #75e8e7;
  height: 100%;
  background-image: url("../assets/planets-moon-vaporwave-Favim.com-7224376.gif");
  background-size: cover;
  text-underline-offset: 17px;
}
#img-container {
  margin: 25px;
  border: solid 3px #75e8e7;
  border-radius: 25px;
  width: 80vw;
  height: 800px;
  overflow: hidden;
  flex-grow: 1;
  position: relative;
}
img{
  width:100%;
}

h1 {
  color: #75e8e7;
  font-size: 75px;
  font-family: monospace;
  text-decoration-line: underline;
  text-decoration-style: wavy;
  text-shadow: 1px 0px 10px whitesmoke;
  letter-spacing: 2pt;
}
#text-container {
  color: white;
  width:50%;
  position: absolute;
  bottom: 25px;
  left: 20vw;
  background-color: blueviolet;
  border: solid 3px #75e8e7;
  border-radius: 25px;
  padding:5px 5px 5px 25px;

}
</style>