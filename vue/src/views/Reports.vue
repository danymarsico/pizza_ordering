<template>
  <div>
    <h1>Placeholder for Version 2</h1>

    <button id="checkout" @click="displayChange">Check Out</button>


    <div id="modal-container" class="modal hide">
      <span class="close">x</span>
      <form>
        <div>
          <input type="radio" name="is-delivery" class="delivery" />
          <label for="delivery">Delivery</label>
          <input type="radio" name="is-delivery" class="delivery" />
          <label for="delivery">Carry Out</label>
        </div>
        <div>
          <input type="radio" name="payment" class="delivery" />
          <label for="delivery">Pay Online</label>
          <input type="radio" name="payment" class="delivery" />
          <label for="delivery">Pay at Store</label>
        </div>
        <div>
          <h2>Your Info</h2>
        </div>
        <div id="cc-info">
          <label for="credit-card">Credit Card Information</label>
          <input
            type="tel"
            inputmode="numeric"
            name="credit-card"
            id="credit-card"
            autocomplete="cc-number"
            pattern="[0-9\s]{13,19}"
            maxlength="19" 
            placeholder="xxxx xxxx xxxx xxxx"
          />
        </div>
        <div>
          <input type="submit" value="Submit" />
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    displayChange(event){
      event.currentTarget.classList.remove('hide');
      event.currentTarget.classList.add('display');
    }
  }
};
</script>

<style scoped>
.modal{
  
  background-color: rgb(133, 133, 133);
  position: fixed;
  z-index: 1;
  left:25vw;
  top:25vh;
  height: 30vh;
  width:50vw;
  padding: 25px;
  overflow: auto;
  border: solid 3px #75e8e7;
  border-radius: 25px;
}
.display{
  display: block;
}
.hide{
  display: none;
}
#modal-container div{
  text-align: center;
  margin:15px;
}
.close{
  float: right;
  margin:10px;
  font-size: 25px;
}
.delivery{
  margin: 10px;
  width: 10px
}
#cc-info{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

</style>>
