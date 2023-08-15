<template>
  <div>
    <h1>Placeholder for Version 2</h1>

    <button id="checkout" @click="showModal">Check Out</button>

    <div id="modal-container" class="modal hide">
      <span id="close" @click="hideModal">x</span>
      <form>
        <div>
          <input
            type="radio"
            name="is-delivery"
            class="delivery"
            checked="checked"
          />
          <label for="delivery">Delivery</label>
          <input type="radio" name="is-delivery" class="delivery" />
          <label for="delivery">Carry Out</label>
        </div>
        <div>
          <input
            type="radio"
            name="payment"
            class="delivery"
            checked="checked"
          />
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
          <div>
            <input
              type="tel"
              name="exp-month"
              id=""
              placeholder="Expiration Month"
            />
            <input
              type="tel"
              name="exp-year"
              id=""
              placeholder="Expiration Year"
            />
          </div>
          <input type="tel" name="exp-cvv" id="" placeholder="CVV" />
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
    showModal() {
      let modal = document.getElementById("modal-container");
      modal.classList.remove("hide");
      modal.classList.add("display");
    },
    hideModal() {
      let modal = document.getElementById("modal-container");
      modal.classList.remove("display");
      modal.classList.add("hide");
    },
  },
};
</script>

<style scoped>
.modal {
  background: rgb(2, 0, 36);
  background: linear-gradient(
    180deg,
    rgba(2, 0, 36, 1) 0%,
    rgba(9, 9, 121, 1) 57%,
    rgba(243, 27, 131, 1) 100%
  );
  position: fixed;
  z-index: 1;
  left: 25vw;
  top: 25vh;
  height: 30vh;
  width: 50vw;
  padding: 25px;
  overflow: auto;
  border: solid 3px #75e8e7;
  border-radius: 25px;
}
.display {
  display: block;
}
.hide {
  display: none;
}
#modal-container div {
  text-align: center;
  margin: 15px;
}
#close {
  float: right;
  margin: 10px;
  font-size: 25px;
  color: #75e8e7;
}
.delivery {
  margin: 10px;
  width: 10px;
}
#cc-info {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>>
