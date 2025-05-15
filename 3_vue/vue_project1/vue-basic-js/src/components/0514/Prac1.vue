<template>
  <div>
    <input v-model="member.name" placeholder="이름 입력" />
    <br />
    <input v-model.number="age" placeholder="나이 입력" />
    <p>이름 : {{ member.name }}</p>
    <p>나이 : {{ age }}</p>
    <p>{{ isAdult ? "성인입니다" : "미성년자입니다." }}</p>
  </div>
</template>

<script setup>
import { computed, onMounted, reactive, watch } from "vue";
const member = reactive({
  name: "",
  age: 0,
});

// 상태 변경이 일어나면 리렌더링이 일어나고, 이후 동작을 정의
watch(
  () => member.age,
  (newAge, oldAge) => {
    console.log(`나이 변경 : ${oldAge} -> ${newAge}`);
  }
);

onMounted(() => {
  console.log("성함과 나이를 입력해주세요.");
});

// 내 코드
// const name = ref("");
// const age = ref();
// const isAdult = computed(() => {
//   return age.value > 19;
// });

// watch(age, (newAge, oldAge) => {
//   console.log(`나이 변경 : ${oldAge} -> ${newAge}`);
// });

// onMounted(() => {
//   alert("성함과 나이를 입력해주세요.");
// });
</script>

<style scoped></style>
