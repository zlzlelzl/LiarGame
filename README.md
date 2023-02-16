# ![favicon](https://user-images.githubusercontent.com/96412633/219274760-d3499ab9-1142-451d-a6e9-ebf0420479df.jpg)Liar Game

화상채팅을 이용한 라이어 게임

## 목차

- [팀 소개](#팀소개)
- [프로젝트개요](#프로젝트-개요)
- [기능](#기능)
- [컨벤션](#컨벤션)
- [git정책](#git정책)

## 팀소개

|    이름    |       역할       |
| :--------: | :--------------: |
| 🌟최원준🌟 | 팀장, 프론트엔드 |
| 🎇이상현🎇 |      백엔드      |
| ✨김동현✨ |    프론트엔드    |
| 🎉심호연🎉 |      백엔드      |
| 🎊장지웅🎊 |      백엔드      |
| 🎈전주영🎈 |      백엔드      |

---

## 프로젝트 개요

- 프로젝트 명 : Liar Game
- 진행 기간 : 2023.01.03 ~ 2023.02.17
- 서비스 특징 : WebRTC를 사용하여 화상 Liar Game 구현
- 기존의 Liar Game과의 차별점
  - 화상채팅을 사용하여 기존의 온라인 Liar Game보다 비언어적인 추리 요소를 더함
  - 축적된 유저 데이터를 수집하여 통계 제공
  - 랭킹 시스템 도입으로 이용자의 경쟁요소 추가
  - 스파이 모드 추가

---

### Rule(모드별)

- 일반모드(게임인원 : 6명)

1. 단 한명의 유저에게 라이어 역할을 부여하고 나머지 유저에게 제시어를 보여준다.
2. 한명 씩 제시어를 설명한다.
3. 라이어는 제시어를 예측해서 설명한다.
4. 유저들이 모두 설명을 했으면 예상 라이어를 투표로 결정한다.
5. 투표로 결정된 유저가 일반 유저라면 라이어 승리, 투표로 라이어를 특정하는데 성공하더라도 라이어가 제시어를 맞출경우 라이어가 승리한다. 이외의 경우는 일반 유저가 승리한다.

- 스파이모드(기본적으로 일반 모드의 룰을 따릅니다.)

6. 스파이라는 신규 직업이 등장합니다.
7. 스파이 모드의 경우 일반 유저 측에 스파이가 존재, 스파이는 일반 유저들에게 발각당하지 않으면서 라이어를 돕는 사람입니다.
8. 기본 승리 규칙에 더하여 스파이는 라이어가 승리하면 승리, 만약 투표로 지목된 사람이 스파이라면 일반 유저들의 승리입니다.

---

## 기능

- 주요 기능
  - 회원 관리
  - 화상 미팅룸
  - 그룹 채팅
  - 게임 데이터 관리
  - 게시물 관리
- 주요 기술
  - openVidu
    - 화상 채팅 구현 API
  - SSE
    - 다른 브라우저 통신
  - JWT Authentication
    - JWT를 이용한 로그인 구현
    - 유저별 권한 구현
      - 관리자
      - 일반
  - Vue.js
    - SPA 구현
  - REST API
    - json 데이터 통신
- 아키텍처
  - SPA 배포 : EC2
  - REST API 배포 : AWS ES2
  - database 배포 : AWS RDS
  - webserver : nginx
- 협업
  - 버전관리 : Git
  - gitLab
  - jira
  - Obsidian
  - Discord
  - Mattermost
  - Webex
  - oneDrive
- 배포 환경
  - URL: https://i8a706.p.ssafy.io/
  - 테스트 계정: 미정

---

## 컨벤션

### Prettier

- 자바스크립트, html, css는 prettier, ESlint 사용
- 자바는 Google Java Convention 사용

---

## git정책

### github flow

1. `master` 브런치는 어떤 때든 배포가 가능하다.
2. 새로운 일을 시작하기 위해 브런치를 `master`에서 딴다면 이름은 어떤 일을 하는지 명확하게 작성한다.
3. 원격지 브런치로 수시로 push를 한다.
4. 피드백이나 도움이 필요할 때, 그리고 머징 준비가 완료되었을 때는 `pull request`를 생성한다.
5. 기능에 대한 리뷰와 사인이 끝난 후 `master`로 머지한다.
6. `master`로 머지되고 푸시되었을 때는 즉시 배포되어야 한다.
