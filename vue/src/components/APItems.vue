<template>
  <div>
      <table id="itemList">
        <tbody>
          <tr>
            <td id="item"> Button</td>
            <td class="checkbox"> Unavailable</td>
            <td class="checkbox"> Delete</td>
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
  border-bottom: solid 1px black;
}
tr {
  display: flex;
  justify-content: space-evenly;
  
}


</style>