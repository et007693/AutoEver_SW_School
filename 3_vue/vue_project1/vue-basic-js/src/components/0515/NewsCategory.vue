<template>
  <div class="container">
    <button @click="selectCategory('정치')">정치</button>
    <button @click="selectCategory('경제')">경제</button>
    <button @click="selectCategory('사회')">사회</button>
    <button @click="selectCategory('문화')">문화</button>
  </div>
</template>

<script setup>
const emit = defineEmits(["send-category"]);

function selectCategory(category) {
  emit("send-category", category);
}
</script>

<style scoped>
.container {
  display: flex;
  gap: 30px;
}

button {
  background-color: darkcyan;
  width: 200px;
}
</style>
