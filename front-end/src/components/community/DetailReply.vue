<template>
  <div>
    <reply-header></reply-header>
    <reply-write></reply-write>
    <reply-list></reply-list>
  </div>
</template>

<script>
import ReplyHeader from './ReplyHeader.vue';
import ReplyWrite from './ReplyWrite.vue';
import ReplyList from './ReplyList.vue';

export default {

  components: { ReplyHeader, ReplyList, ReplyWrite },
  name: "MainDetail",
  data() {
    return {
      
    };
  },
  created() {
    // 받아올 메서드 이름 한번은(ex)this.userinfo )
  },
  methods: {
    
    
  },
}
</script>

<style>

</style>