<template>
  <div id="header">
      <img id="logo" src="../assets/namelesspi.png" alt="">
    
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
#header {
    background-image: url('../assets/banner.jpg');
    background-size: 100%;
    background-repeat: no-repeat;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    border: solid 3px #75E8E7;
    border-radius: 30px;
    color: #75E8E7;
    margin: 20px;
    height: 400px;
}
#logo {
    width: 90vw;
    margin: 0 20px 0 20px;
    
}


</style>