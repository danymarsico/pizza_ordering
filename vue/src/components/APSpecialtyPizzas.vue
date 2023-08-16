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

<style scoped>
#title {
    margin-left: 20px;
    color: #75E8E7;
    text-align: center;
}
tbody {
  background-color:#64379f;
  border-radius: 30px;
}
button {
  margin-top: 8px;
}
#itemList {
  display: flex;
  border: solid 3px #75e8e7;
  border-radius: 30px;
  vertical-align: middle;
}

tbody {
  display: grid;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  flex-grow: 1;
}

tr {
  display: flex;
  flex-grow: 1;
  justify-content: space-between;
  margin-bottom: 5px;
  justify-content: center;
  align-items: center;
}

#item {
  align-items: center;
  display: flex;
  width: 100px;
  justify-content: right;
}
#checkbox1 {
    padding-left: 22px;
  }
  
  #checkbox2 {
    margin-left: 5vw;
  }
</style>