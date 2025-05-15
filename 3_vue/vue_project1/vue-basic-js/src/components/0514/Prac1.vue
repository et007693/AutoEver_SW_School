<template>
  <div>
    <input v-model="name" placeholder="이름 입력" />
    <br />
    <input v-model.number="age" placeholder="나이 입력" />
    <p>이름 : {{ name }}</p>
    <p>나이 : {{ age }}</p>
    <p>{{ isAdult ? "성인입니다" : "미성년자입니다." }}</p>
  </div>
</template>

<script setup>
import { computed, onMounted, ref, watch } from "vue";
const name = ref("");
const age = ref();
const isAdult = computed(() => {
  return age.value > 19;
});

watch(age, (newAge, oldAge) => {
  console.log(`나이 변경 : ${oldAge} -> ${newAge}`);
});

onMounted(() => {
  alert("성함과 나이를 입력해주세요.");
});
</script>

<style scoped></style>
