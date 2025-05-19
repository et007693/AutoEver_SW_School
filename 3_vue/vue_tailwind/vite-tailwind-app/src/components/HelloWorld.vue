<template>
  <div class="mt-6 p-4 bg-white rounded shadow">
    <p class="text-gray-700 text-lg">{{ msg }}</p>
  </div>
</template>

<script setup>
defineProps({
  msg: String,
});
</script>
