<template>
  <div style="padding: 2rem">
    <h2>watch 예제</h2>
    <input v-model="search" key="" />
    <p>입력값 : {{ search }}</p>
    <p>최근 검색어 : {{ recent }}</p>
  </div>
</template>

<script setup>
import { watch, ref, onMounted } from "vue";
const search = ref("");
const recent = ref("");

onMounted(() => {
  console.log("컴포넌트가 마운트 됨");
});

// watch는 상태 변화 감지 후 특정 로직 수행
watch(search, (newVal, oldVal) => {
  console.log(`검색어 변경 : ${oldVal} -> ${newVal}`);
  recent.value = "검색중입니다.";
  // 서버와의 비동기 통신에 주로 사용됨
  // await를 통해서 결과가 수신되면 객체에 값 저장
});
</script>

<style scoped>
input {
  padding: 8px;
  width: 200px;
  margin-bottom: 1rem;
}

p {
  font-size: 20px;
  margin: 4px 0;
}
</style>
