<template>
  <div>
    {{ detail }}
  </div>
</template>

<script setup>
const props = defineProps({
  detail: Object,
});

console.log(props.detail);
</script>

<style scoped></style>
