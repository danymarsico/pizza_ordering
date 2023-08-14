<template>
  <div>
    <Header />
    <Cust-nav />
    <div id="story-main" >
      <h1>Our Story</h1>
      <div id="img-container">
        <img src="../assets/pizza-shop.jpg" class="pizza-slides" />
        <img src="../assets/pizza-shop2.jpg" class="pizza-slides" />
        <img src="../assets/making-pizza.jpg" class="pizza-slides" />
        <img src="../assets/pizza-champion.jpg" class="pizza-slides" />
        <button>&#10094;</button>
        <button>&#10095;</button>
        <div class="text">
            <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio
            recusandae corrupti ducimus dicta delectus nemo, maiores a nisi
            aliquid necessitatibus omnis itaque dolore nostrum debitis incidunt
            error temporibus. Possimus, quaerat?
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
      for(let i = 0; i < slides.length; i++){
        slides[i].style.display = "none";
      }

      slideIndex++;
      if(slideIndex > slides.length) {
         slideIndex = 1
         }
      slides[slideIndex -1].style.display = "block";
      setTimeout(this.carousel, 4000);

    }
  },
  created: function(){
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
}
#img-container {
  margin: 25px;
  width: 80vw;
  flex-grow: 1;
  position: relative;
}
img {
  width: 80vw;
  border: solid 3px #75e8e7;
  border-radius: 25px;
}
h1 {
  color: #75e8e7;
  font-size: 50px;
}
.text {
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