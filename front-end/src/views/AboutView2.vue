<template>
  <div class="about" style="width:100%;height:100vh;">
    
    <div class="row">
        <div class="col-2">
        </div>
        <div class="col-8">
            <main-lobby style="width:100%;height:100vh;"></main-lobby>
        </div>
        <div class="col-2">
        </div>
    </div>
    
  </div>
</template>

<script>
// import { mapState } from "vuex";
import MainLobby from "@/components/lobby/MainLobby.vue";

export default {
    "name":"AboutView2",
    components: {
    MainLobby
  }
}

</script>
