<template>
  <div>
    <Header />
    <Cust-nav />
    <div id="story-main">
      <h1>Our Story</h1>
      <div id="img-container">
        <img src="../assets/pizza-shop.jpg" alt="" />
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
export default {
  components: {
    Header,
    CustNav,
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
  bottom: -390px;
  left: 320px;
  background-color: blueviolet;
  border: solid 3px #75e8e7;
  border-radius: 25px;
  padding:5px 5px 5px 25px;

}
</style>