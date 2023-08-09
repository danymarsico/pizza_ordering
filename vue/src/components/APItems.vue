<template>
  <div>
      <table id="itemList">
        <tbody>
          <tr>
            <td id="item"> <button>Item</button> </td>
            <td id="checkbox1"> <button>Unavailable</button> </td>
            <td id="checkbox2"> <button>Delete</button> </td>
          </tr>
        </tbody>
      </table>
  </div>
</template>

<script>
export default {

}
</script>

<style>
#itemList {
  display: flex;
  border-bottom: solid 1px #75E8E7;
}

tr {
  width: 80vw;
  display: flex;
  justify-content: flex-start;
  
}

#item {
  margin-left: 32vw;
}

#checkbox1 {
  margin-left: 25vw;
}

#checkbox2 {
  margin-left: 5vw;
}

</style>