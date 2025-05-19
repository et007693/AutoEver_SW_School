<template>
  <div class="box">
    <h2>ref() 방식 (반응형)</h2>
    <p>countRef: {{ countRef }}</p>
    <button @click="incrementCount">+1</button>
    <button @click="decrementCount">-1</button>

    <hr />

    <h2>일반 변수 방식 (비반응형)</h2>
    <p>countVar: {{ countVar }}</p>
    <button @click="incrementValue">+1</button>
    <button @click="decrementValue">-1</button>
  </div>
</template>

<script setup>
import { ref } from "vue";

const countRef = ref(0);
var countVar = 0;

const incrementCount = () => {
  countRef.value++;
};

const decrementCount = () => {
  countRef.value--;
};

const incrementValue = () => {
  countVar++;
  console.log(`값 증가 : ${countVar}`);
};

const decrementValue = () => {
  countVar--;
  console.log(`값 감소 : ${countVar}`);
};
</script>

<style scoped>
.box {
  font-family: sans-serif;
  max-width: 400px;
  margin: 40px auto;
  padding: 1rem;
  border: 1px solid #ccc;
  border-radius: 8px;
}
button {
  margin-right: 8px;
  padding: 6px 12px;
}
hr {
  margin: 1.5rem 0;
}
</style>
