<template>
  <div>
      <h1 id="title">Current Specialty Pizzas</h1>
    <table id="itemList">
      <tbody>
        <tr v-for="(item, index) in items" :key="index">
          <td id="item"><h2>{{item.name}}</h2></td>
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
       { name: 'The Butcher', buttonText: 'Make Unavailble' },
       { name: 'The G.O.A.T.', buttonText: 'Make Unavailble' },
       { name: 'O.G. NAMELESS', buttonText: 'Make Unavailble' },
       { name: 'Playlist Deluxe', buttonText: 'Make Unavailble' },
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
  background-color:#64379f;
  border-radius: 30px;
}
button {
  margin-top: 8px;
}
</style>