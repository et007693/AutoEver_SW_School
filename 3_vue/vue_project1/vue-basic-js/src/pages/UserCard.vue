<template>
  <div class="container">
    <h2>회원 정보</h2>
    <UserItem v-for="user in users" :key="user.name" :user="user" />
  </div>
</template>

<script setup>
import { reactive, onMounted } from "vue";
import UserItem from "../components/0515/UserItem.vue";

const users = reactive([]);

const fetchedData = [
  { name: "김민지", age: 25, addr: "서울특별시 강남구", isAdult: true },
  { name: "이준호", age: 17, addr: "부산광역시 해운대구", isAdult: false },
  { name: "박서연", age: 32, addr: "인천광역시 연수구", isAdult: true },
  { name: "최지훈", age: 14, addr: "대구광역시 수성구", isAdult: false },
  { name: "정하늘", age: 19, addr: "대전광역시 유성구", isAdult: true },
  { name: "한예린", age: 21, addr: "광주광역시 북구", isAdult: true },
  { name: "오민석", age: 16, addr: "울산광역시 남구", isAdult: false },
  { name: "서지우", age: 28, addr: "경기도 성남시 분당구", isAdult: true },
  { name: "장도윤", age: 13, addr: "강원도 춘천시", isAdult: false },
  { name: "윤다인", age: 22, addr: "전라북도 전주시", isAdult: true },
];

// 화면이 처음 나타나는 시점
onMounted(() => {
  // 서버로 데이터를 요청하고, 데이터가 전달되면 아래의 동작 수행
  users.push(...fetchedData);
});
</script>

<style scoped>
.container {
  width: 500px;
  margin: 40px auto;
  text-align: center;
  background-color: antiquewhite;
}
</style>
