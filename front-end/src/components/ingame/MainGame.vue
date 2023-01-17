<template>
  <div class="game">
    <div class="row" style="height:20%">a_title</div>
    <div class="row" style="height:5%">a_blank</div>
    <div class="row" style="height:50%">
        <game-users></game-users>
    </div>
    <div class="row" style="height:5%">a_blank</div>
    <div class="row" style="height:20%">a_confirm</div>
  </div>
</template>

<script>
import GameUsers from "@/components/ingame/GameUsers.vue"

export default {
  components: { GameUsers },
  name: "MainGame",
  created() {
    
  },
}
</script>

<style></style>