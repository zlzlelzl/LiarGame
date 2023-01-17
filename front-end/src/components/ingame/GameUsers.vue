<template>
  <div class="users">
    <div class="row" style="height:40%;">
        <div class="col-4">
            <user-comp></user-comp>
        </div>
        <div class="col-4">
            user2
        </div>
        <div class="col-4">
            user3
        </div>
    </div>
    <div class="row" style="height:10%;"></div>
    <div class="row" style="height:40%;">
        <div class="col-4">
            user4
        </div>
        <div class="col-4">
            user5
        </div>
        <div class="col-4">
            user6
        </div>
    </div>
  </div>
</template>

<script>
import UserComp from "@/components/ingame/UserComp.vue"

export default {
  components: { UserComp },
  name: "GameUser",
  created() {
    
  },
}
</script>

<style></style>