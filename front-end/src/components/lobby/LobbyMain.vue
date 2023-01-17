
<template>
  <div class="main">
    <div class="row" style="height:40%;">
        <div class="col-4">
            <user-comp></user-comp>
        </div>
        <div class="col-4">
            <user-comp></user-comp>
        </div>
        <div class="col-4">
            <user-comp></user-comp>
        </div>
    </div>
    <div class="row" style="height:10%;"></div>
    <div class="row" style="height:40%;">
        <div class="col-4">
            <user-comp></user-comp>
        </div>
        <div class="col-4">
            <user-comp></user-comp>
        </div>
        <div class="col-4">
            <user-comp></user-comp>
        </div>
    </div>
  </div>
</template>

<script>
import RoomComp from "@/components/lobby/RoomComp.vue"

export default {
  components: { RoomComp },
  name: "LobbyMain",
  created() {
    
  },
}
</script>

<style></style>