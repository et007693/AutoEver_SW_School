<template>
  <button
    :class="[
      baseClass,
      type === 'primary'
        ? 'bg-blue-500 hover:bg-blue-600'
        : type === 'danger'
        ? 'bg-red-500 hover:bg-red-600'
        : 'bg-gray-300 hover:bg-gray-400',
    ]"
    @click="emit('click')"
    :disabled="disabled"
  >
    <slot>기본 버튼</slot>
  </button>
</template>

<script setup>
const props = defineProps({
  type: { type: String, default: "default" },
  disabled: { type: Boolean, default: false },
});

const emit = defineEmits(["click"]);
</script>
