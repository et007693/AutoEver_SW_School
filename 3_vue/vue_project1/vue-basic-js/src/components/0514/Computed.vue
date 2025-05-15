<template>
  <div style="padding: 2rem">
    <h2>computed 예제</h2>
    <input v-model.number="num0" placeholder="숫자 1 입력" />
    <input v-model.number="num1" placeholder="숫자 1 입력" />
    <input v-model.number="num2" placeholder="숫자 2 입력" />
    <p>합계 : {{ sum() }}</p>
    <p>Computed 합계 : {{ computedSum }}</p>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";
const num0 = ref(0);
const num1 = ref(0);
const num2 = ref(0);

const sum = () => {
  console.log("sum 값을 재계산");
  return num0.value + num1.value + num2.value;
};

const computedSum = computed(() => num0.value + num1.value + num2.value);
</script>

<style scoped>
input {
  padding: 8px;
  margin-left: 8px;
  width: 120px;
}
</style>
