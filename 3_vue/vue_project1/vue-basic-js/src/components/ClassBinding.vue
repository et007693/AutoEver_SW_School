<template>
  <div>
    <h2>고정 클래스</h2>
    <div class="box">항상 적용되는 클래스</div>

    <h2>조건부 클래스</h2>
    <div :class="{ active: isActive, error: hasError }" class="box">
      {{ isActive ? "Active" : "" }} {{ hasError ? "Error" : "" }}
    </div>

    <h2>배열 클래스 (동적 조합)</h2>
    <div :class="['box', isActive ? 'active' : '', hasError ? 'error' : '']">
      배열 클래스 박스
    </div>

    <div style="margin-top: 20px">
      <button @click="isActive = !isActive">Active Toggle</button>
      <button @click="hasError = !hasError">Error Toggle</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
const isActive = ref(true);
const hasError = ref(false);
</script>

<style scoped>
.box {
  padding: 1rem;
  border: 1px solid #ccc;
  margin-bottom: 1rem;
}

.active {
  background-color: #d1fae5;
  border-color: #10b981;
}

.error {
  background: #f87171;
  color: white;
  border: none;
}
</style>
