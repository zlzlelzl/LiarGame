<template>
  <div id="myModal" class="modal">
    <div class="modal-content">
      <div class="login-modal-header">
        <div class="hidden-icon">&times;</div>
        <div class="login-text">로그인</div>
        <div class="close" v-on:click="offModal">&times;</div>
      </div>
      <div class="modal-padding">
        <ul>
          <li class="modal-email-pwd">이메일</li>
          <li>
            <input
              class="modal-input"
              type="text"
              placeholder="이메일을 입력해주세요"
              v-model="useremail"
            />
          </li>
          <li class="modal-email-pwd">비밀번호</li>
          <li>
            <input
              class="modal-input"
              type="password"
              placeholder="비밀번호를 입력해주세요"
              id="userpwd"
              v-model="userpwd"
            />
          </li>
          <li style="margin-bottom: 10px; margin-top: 10px">
            <span style="font-size: 14px; color: #684107"
              >비밀번호를 잊어버리셨나요?
            </span>
            <a href="#" style="font-size: 14px; color: #b80000"
              >비밀번호 찾기</a
            >
          </li>
          <li class="login-container">
            <button class="btn-login modal-email-pwd" v-on:click="logIn()">
              로그인
            </button>
          </li>
          <li class="text-center" style="margin-bottom: 10px">
            <span style="font-size: 14px; color: #684107"
              >아직 회원이 아니신가요?
            </span>
            <a href="#" style="font-size: 14px; color: #b80000"> 회원가입</a>
          </li>
          <hr />
          <li class="text-center" style="margin-bottom: 17px; margin-top: 10px">
            <span style="font-size: 15px">다른 방법으로 로그인 </span>
          </li>
          <li class="btngrp">
            <a
              href="https://accounts.google.com/o/oauth2/v2/auth?client_id=***REMOVED***&redirect_uri=https://i8a706.p.ssafy.io/google&response_type=code&scope=https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile"
              ><div class="google btn-logo">
                <span class="google-logo"></span
                ><span class="social-text">Google</span>
              </div>
            </a>
            <a
              href="https://kauth.kakao.com/oauth/authorize?client_id=***REMOVED***&redirect_uri=https://i8a706.p.ssafy.io/kakao&response_type=code"
              ><div class="kakao btn-logo">
                <span class="kakao-logo"></span
                ><span class="social-text">Kakao</span>
              </div></a
            >
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "LoginModal",
  components: {},
  data() {
    return {
      useremail: null,
      userpwd: null,
      modalDisplay: "none",
    };
  },
  created() {},
  mounted() {},
  methods: {
    offModal() {
      (this.useremail = null), (this.userpwd = null);
      this.$emit("close", "login"); // 창 닫아주세요.
    },
    logIn() {
      const payload = {
        email: this.useremail,
        password: this.userpwd,
      };
      this.$store.dispatch("logIn", payload);
      this.offModal();
    },
  },
};
</script>

<style scoped>
.btngrp {
  display: flex;
  justify-content: space-evenly;
}
.btn-logo {
  border-radius: 20px;
  width: 140px;
  height: 60px;
  display: flex;
  align-items: center;
}
.social-text {
  margin-left: 10px;
  font-size: 20px;
}
.google-logo {
  margin-left: 15px;
  width: 35px;
  height: 35px;
  background-image: url(../../assets/icon/btngoogle.png);
  background-repeat: no-repeat;
  display: flex;
  justify-content: center;
  background-size: cover;
}
.kakao-logo {
  margin-left: 15px;
  width: 35px;
  height: 35px;
  background-image: url(../../assets/icon/btnkakao.png);
  background-repeat: no-repeat;
  display: flex;
  justify-content: center;
  background-size: cover;
}
.kakao {
  background-color: #fee500;
}
.google {
  background-color: white;
}
.login-container {
  display: flex;
  justify-content: center;
}
.btn-login {
  background-color: rgba(253, 253, 253, 70%);
  border-radius: 20px;
  width: 150px;
  height: 42px;
  border: 0px;
}
.btn-login:hover {
  background-color: rgb(253, 253, 253);
}
.modal-email-pwd {
  font-weight: 500;
  font-size: 20px;
  margin-top: 10px;
  margin-bottom: 10px;
}
.modal-input {
  background-color: rgb(217, 217, 217);
  border-radius: 20px;
  border: 0px;
  width: 100%;
  height: 48px;
  padding: 20px;
}
.login-modal-header {
  display: flex;
  margin-top: 12px;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 30px;
}
.modal-padding {
  padding-left: 20px;
  padding-right: 20px;
}
.modal {
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0, 0, 0); /* Fallback color */
  background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  margin-top: 20vh;
  margin-left: calc(50vw - 200px);
  background-color: rgba(255, 255, 255, 85%);
  padding: 20px;
  border: 1px solid #888;
  width: 400px;
  height: 600px;
  border-radius: 30px;
}

/* The Close Button */
.hidden-icon {
  visibility: hidden;
  font-size: 50px;
}
.close {
  color: #aaaaaa;
  font-size: 50px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}
.login-text {
  font-size: 35px;
  font-weight: 500;
  text-align: center;
}
</style>

<!-- 
  -기능
  1. 로그인 버튼
    - 로그인 버튼 클릭시, 로그인 진행
      - 로그인 완료시 토큰을 vuex에 저장. 메인페이지로 이동
      - 로그인 실패시 현재상태유지, alert창 로그인실패 안내
  
  2. 회원가입 링크
    - 회원가입 링크 클릭시, 로그인 모달창 닫힘
    - 회원가입 모달창 켜짐
  
  3. 비밀번호 찾기 링크
    - 비밀번호 찾기 링크 클릭시, 로그인 모달창 닫힘
    - 비밀번호 찾기 모달창 켜짐
 -->