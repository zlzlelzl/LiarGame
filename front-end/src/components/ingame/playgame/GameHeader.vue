<template>
  <div
    style="
      width: 100%;
      text-align: center;
      font-size: 40px;
      color: #e20000;
      margin-top: 20px;
    "
  >
    남은 시간
  </div>
  <div class="timer">{{ displaySeconds }} : {{ displayMilliSeconds }}</div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "GameHeader",
  components: {},
  data() {
    return {
      displaySeconds: 0,
      displayMilliSeconds: 0,
      testTime: 0,
    };
  },
  computed: {
    _seconds() {
      return 1000;
    },
    _milliseconds() {
      return 10;
    },
    ...mapState(["timer"]),
  },
  watch: {
    timer(newTime) {
      console.log("시간이변경됨");
      this.runTimer(newTime);
    },
  },
  created() {},
  methods: {
    runTimer(newTime) {
      if (newTime === 0) {
        this.displaySeconds = 0;
        this.displayMilliSeconds = 0;
        return;
      }
      var distance = newTime;
      console.log("타이머돌아가요: " + newTime);
      const timer = setInterval(() => {
        // 20기본 타이머 20초 설정
        if (distance < 0) {
          clearInterval(timer);
          return;
        }
        var seconds = Math.floor(distance / 1000);
        var milliseconds = Math.floor((distance - seconds * 1000) / 10);
        this.displaySeconds = seconds;
        this.displayMilliSeconds = milliseconds;
        distance -= 10;
      }, 10);
      this.$store.commit("RESET_TIMER");
    },
  },

  setup() {},
  mounted() {},
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Jura:wght@500&display=swap");
.timer {
  color: #e20000;
  text-align: center;
  font-size: 60px;
  margin-top: 10px;
  height: 90px;
  font-family: "Jura", sans-serif;
}
</style>
