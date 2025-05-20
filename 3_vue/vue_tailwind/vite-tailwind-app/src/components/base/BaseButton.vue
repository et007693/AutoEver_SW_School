<template>
  <button
    :disabled="disabled"
    @click="emit('click')"
    class="w-full px-4 py-3 border border-gray-400 rounded-full"
    :class="
      disabled
        ? 'bg-gray-400 cursor-not-allowed'
        : 'bg-gray-700 hover:bg-gray-800 text-white'
    "
  >
    <slot>버튼</slot>
  </button>
</template>

<script setup>
defineProps({
  disabled: { type: Boolean, default: false },
});

const emit = defineEmits(["click"]);
</script>
