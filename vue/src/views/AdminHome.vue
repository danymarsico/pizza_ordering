<template>
  <div id="apHome">
      <AP-header/>
      <AP-main />
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
</style>