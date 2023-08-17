<template>
  <div>
    <h1 id="title">Manage Specialty Pizzas</h1>
    <table id="itemList">
      <tbody>
        <tr v-for="(item, index) in items" :key="index">
          <td id="item">
            <h2>{{ item.name }}</h2>
          </td>
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
        { name: "The Butcher", buttonText: "Make Unavailble" },
        { name: "The G.O.A.T.", buttonText: "Make Unavailble" },
        { name: "O.G. NAMELESS", buttonText: "Make Unavailble" },
        { name: "Playlist Deluxe", buttonText: "Make Unavailble" },
      ],
    };
  },
  methods: {
    toggleAvailability(index) {
      for (let i = 0; i < this.items.length; i++) {
        if (index === i) {
          let item = this.items[i];
          if (item.buttonText != "Make Available") {
            item.buttonText = "Make Available";
          } else {
            item.buttonText = "Make Unavailable";
          }
        }
      }
    },
  },
};
</script>

<style scoped>
#title {
  margin-left: 20px;
  color: #75e8e7;
  text-align: center;
  font-family: monospace;
  font-size: 35pt;
  text-shadow: 2px 1px #0089fa;
}
tbody {
  background-color: #64379f;
  border-radius: 30px;
}
button {
  background-image: linear-gradient(231deg, #e982df, #2099ff);
  font-family: fantasy;
  padding: 10px;
  margin-left: 60px;
  opacity: 1;
  text-decoration: none;
  color: #492586;
  font-weight: lighter;
  text-shadow: 4px 3px #75e8e7;
  letter-spacing: 2pt;
  font-size: 14pt;
  opacity: 1;
  width: 250px;
}
button:hover,
button:active {
  color: #75e8e7;
  text-shadow: 4px 3px #64379f;
  -webkit-text-stroke-width: 1px;
  -webkit-text-stroke-color: #0089fa;
}
#itemList {
  display: flex;
  border: solid 3px #75e8e7;
  border-radius: 25px;
  vertical-align: middle;;
    display: flex;
  flex-direction: column;
  margin: 20px;
  justify-content: center;
}
tbody {
  display: grid;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  flex-grow: 1;
}
tr {
  display: flex;
  margin-bottom: 5px;
  align-items: center;
  justify-content: center;
  justify-items: center;
  width: 80vw;
}
#item {
  align-items: center;
  display: flex;
  width: 300px;
  justify-content: left;
  text-shadow: 1px 1px #0089fa;
}
td {
  font-family: monospace;
  color: #75e8e7;
  font-size: 14pt;
}
</style>