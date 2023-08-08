<template>
  <div id="apHome">
      <AP-header/>
      <AP-main />
      <button id="addBtn">Add New Pizza</button>
  </div>
</template>

<script>
import APHeader from '../components/APHeader.vue'
import APMain from '../components/APMain.vue'

export default {
components: { APHeader, APMain },
name: 'AdminHome'
}
</script>

<style>
#apHome {
    display: flex;
    flex-direction: column;
    justify-content: center;

}

#addBtn {
    width: 15vw;
    height: 40px;
    align-self: flex-end;
    margin-right: 10vw;
}
</style>