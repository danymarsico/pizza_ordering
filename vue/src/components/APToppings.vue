<template>
  <div>
      <h1 id="title">Current Toppings</h1>
    <table id="itemList">
      <tbody>
        <tr v-for="topping in $store.state.toppings" :key="topping.toppingName">
          <td id="item"><h2>{{topping.toppingName}}</h2></td>
          <td id="checkbox1">
            <button v-on:click.prevent="toggleAvailability(index)">
              {{ item.buttonText }}
            </button>
          </td>
          <td id="checkbox2"><button>Delete</button></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
 data() {
   return {
     items: [
       { name: 'Pepperoni', buttonText: 'Make Unavailble' },
       { name: 'Sausage', buttonText: 'Make Unavailble' },
       { name: 'Ham', buttonText: 'Make Unavailble' },
       { name: 'Olive', buttonText: 'Make Unavailble' },
       { name: 'Green Pepper', buttonText: 'Make Unavailble' },
       { name: 'Onion', buttonText: 'Make Unavailble' },
     ]
    };
   },
    methods: {
   toggleAvailability(index){
     for(let i =0; i < this.items.length; i++) {
       if(index === i) {
         let item = this.items[i];
         if(item.buttonText != 'Make Available') {
           item.buttonText = 'Make Available';
         } else {
           item.buttonText= 'Make Unavailable';
         }
       }
     }



   }
 }
}
</script>

<style>
tbody {
  background-color:#64379f
}
button {
  margin-top: 8px;
}
</style>