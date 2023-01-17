<template>
  <div class="user">
    <user-comp-speak>
        <div class="row" style="height:40%;">
            <div class="col-4">
                user1
            </div>
        </div>
    </user-comp-speak>
    
  </div>
</template>

<script>
import UserCompSpeak from "@/components/ingame/UserCompSpeak.vue";

export default {
  name: "UserComp",
  components: { UserCompSpeak },
  created() {
    
  },
}
</script>

<style></style>