<template>
  <div class="card" v-for="user in users" :key="user.name">
    <p>이름 : {{ user.name }}</p>
    <p>나이 : {{ user.age }}</p>
    <p>주소 : {{ user.addr }}</p>
    <p>성인여부 : {{ user.isAdult }}</p>
  </div>
</template>

<script setup>
const props = defineProps({
  users: Object,
});
</script>
<style scoped>
.card {
  border: 1px solid #ccc;
  padding: 1rem;
  border-radius: 8px;
}
</style>
