<template>
  <div>이름 : {{ user.name }} 이메일 : {{ user.eamil }}</div>
</template>

<script setup>
const props = defineProps({
  user: Object,
});
</script>

<style scoped></style>
