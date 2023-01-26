<template>
    <div class="m-0 p-0 users">
      <div class="m-0 p-0 row" style="height:40%;">
          <div class="m-0 p-0" style="width:20%">
              <user-comp curIdx=0></user-comp>
          </div>
          <div class="m-0 p-0" style="width:20%">
              <user-comp curIdx=1></user-comp>
          </div>
          <div class="m-0 p-0" style="width:20%">
            <user-comp curIdx=2></user-comp>
          </div>
          <div class="m-0 p-0" style="width:20%">
              <user-comp curIdx=3></user-comp>
          </div>
          <div class="m-0 p-0" style="width:20%">
              <user-comp curIdx=4></user-comp>
          </div>
      </div>
      <div class="m-0 p-0 row" style="height:10%;"></div>
      <div class="m-0 p-0 row" style="height:40%;">
          
          
          <div class="m-0 p-0" style="width:20%">
              <user-comp curIdx=5></user-comp>
          </div>
          <div class="m-0 p-0" style="width:20%">
              <user-comp curIdx=6></user-comp>
          </div>
          <div class="m-0 p-0" style="width:20%">
              <user-comp curIdx=7></user-comp>
          </div>
          <div class="m-0 p-0" style="width:20%">
              <user-comp curIdx=8></user-comp>
          </div>
          <div class="m-0 p-0" style="width:20%">
              <user-comp curIdx=9></user-comp>
          </div>
      </div>
    </div>
  </template>
  
  <script>
  import UserComp from "@/components/ingame/UserComp.vue"
  
  export default {
    components: { UserComp },
    name: "GameUser",
  //   data: {
  //     show: true
  //   },
  el:'#liar',
  data(){
      return {
          show: false,
          myIdx: -1, 
        //   isShowList = $store.state.isShow
      }
  },
    created() {
        console.log("before",this.$store.state.isShowList)
      this.setSessionByMyIdx()
      console.log("after",this.$store.state.isShowList)
    },
    methods:{
      toggleShow(){
          this.show = !this.show;
          
      },
        getMyIdxFromSession(){
        let tempIdx = -1
        for(let i = 0; i < 10; i++){
            
            if( this.$store.state.isShowList[i] == 0){
                tempIdx = i;
                break;
            }
        }
        return tempIdx;
      },
      setSessionByMyIdx(){
        let tempIdx = this.getMyIdxFromSession()
        if(tempIdx != -1)
            this.$store.state.isShowList[tempIdx] = 1;
            this.$store.state.myIdx = tempIdx;
      },
      joinUser(){
        
      }
    }
  }
  </script>
  
  <style></style>