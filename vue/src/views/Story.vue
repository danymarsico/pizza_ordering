<template>
  <div>
    <Header />
    <Cust-nav />
    <div id="story-main">
      <h1>Backstory</h1>

      <div  id="img-container"  @mouseleave="startCarousel">
        <img  id="img-slides" @mouseover="stopCarousel()" />

        <div >
          <p id="text-container"></p>
        </div>
      </div>
      <!-- <div id="slide-buttons">
        <button class="button" @click="prevSlide">&#10094;</button>
        <input type="radio" name="" id="" />
        <input type="radio" name="" id="" />
        <input type="radio" name="" id="" />
        <input type="radio" name="" id="" />
        <button class="button" @click="nextSlide">&#10095;</button>
      </div> -->
    </div>
  </div>
</template>

<script>
import Header from "../components/Header.vue";
import CustNav from "../components/CustNav.vue";

let arrayIndex = 0;
let intervalID;


export default {
  components: {
    Header,
    CustNav,
  },
  data() {
    return {
      hover: false,
    };
  },
  methods: {
    carousel() {
      let imgArray = [
        "/img/backstory1.b552cb31.jpg",
        "/img/backstory2.7e33b4d5.jpg",
        "/img/backstory3.4e786624.jpg",
        "/img/backstory4.ddedeaaa.jpg",
      ];
      let textArray = [
        `In the bustling metropolis of Tech Elevator City, where the fusion
            of technology and innovation propels the cityscape to new heights, a
            man named Frank Franklin found himself at a crossroads. Frank had
            always been captivated by the pulsating rhythms of vaporwave culture
            and the nostalgic allure of the 80s. Yet, he was trapped in a
            mundane corporate job that left him yearning for something more. One
            fateful day, as he sipped on a fluorescent-lit latte in a
            pastel-colored cafe, he met Luna Echo, a life coach with an aura as
            vibrant as the city itself.`,
        `Luna Echo was a beacon of hip wisdom in Tech Elevator City, known
            for her enigmatic advice and captivating vaporwave-inspired
            sessions. She sensed Frank's inner turmoil and encouraged him to
            embrace his passions, to let the retro beats of his heart guide him
            towards a more fulfilling path. "Live in the moment because
            everything is a coin flip", she urged, her voice a soothing blend of
            whispering synths. Inspired by her words, Frank embarked on a
            journey of self-discovery that would reshape his destiny.`,
        `Guided by Luna, Frank decided to disrupt the pizza ecosystem that
            had long grown stagnant. With a sprinkle of stardust and a dash of
            pixelated creativity, he founded N*A*M*E*L*E*S*S*Π, a pizza joint
            unlike any other. The restaurant's ambiance was a symphony of
            holographic posters, glitch art, and holograms playing retro arcade
            games. Each slice of pizza bore a neon resemblance to its former
            self, the flavors a fusion of classic recipes and futuristic
            culinary techniques.`,
        `As word spread through Tech Elevator City about the enigmatic
            pizzeria, Frank found himself at the forefront of a cultural
            revolution. N*A*M*E*L*E*S*S*Π became a haven for the city's
            avant-garde, a place where those seeking a slice of the past and a
            bite of the future could come together in harmonious satisfaction.
            Frank's journey from a stifled corporate drone to a pioneer of
            gastronomical artistry was a testament to the power of embracing
            one's true passions, and he owed it all to Luna Echo's transcendent
            wisdom.`,
      ];
      document.getElementById("img-slides").src = imgArray[arrayIndex];
      document.getElementById("text-container").innerHTML = textArray[arrayIndex];
      arrayIndex++;

      if(arrayIndex > imgArray.length -1){
        arrayIndex = 0;
      }

    },
    stopCarousel(){
      window.clearInterval(intervalID);
      console.log("stopped")
    },
    startCarousel(){
      intervalID = setInterval(this.carousel, 2000)
      console.log("started")
    },
    
  },
  mounted: function () {
    this.carousel();
    intervalID = setInterval(this.carousel, 2000)
    
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
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #27104e;
  margin: 25px;
  border: solid 3px #75e8e7;
  border-radius: 25px;
  padding: 20px;
  height: 90vh;

  overflow: hidden;
  flex-grow: 1;
  position: relative;
}
img {
  height: 100%;
  border-radius: 25px;
}

h1 {
  color: #75e8e7;
  font-size: 75px;
  font-family: monospace;
  text-decoration-line: underline;
  text-decoration-style: wavy;
  text-shadow: 1px 0px 10px whitesmoke;
  letter-spacing: 2pt;
  text-underline-offset: 25px;
}
#text-container {
  color: white;
  width: 60%;
  position: absolute;
  bottom: 30px;
  left: 8vw;
  background-color: #27104e;
  border: solid 3px #75e8e7;
  border-radius: 25px;
  padding: 5px 25px 5px 25px;
  font-family: monospace;
  color: #75e8e7;
  padding: 25px;
}

.button {
  height: 30px;
}
#slide-buttons {
  display: flex;
  justify-content: space-evenly;
  width: 50vw;
  margin: 20px;
}
</style>