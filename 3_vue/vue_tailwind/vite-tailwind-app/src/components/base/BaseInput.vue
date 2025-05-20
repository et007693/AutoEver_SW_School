<template>
  <input
    :type="type"
    :placeholder="placeholder"
    :value="modelValue"
    @input="emit('update:modelValue', $event.target.value)"
    class="w-full px-4 py-3 border border-gray-400 rounded-full"
  />
</template>

<script setup>
defineProps({
  modelValue: String,
  type: { type: String, default: "text" },
  placeholder: { type: String, default: "" },
});
const emit = defineEmits(["update:modelValue"]);
</script>
