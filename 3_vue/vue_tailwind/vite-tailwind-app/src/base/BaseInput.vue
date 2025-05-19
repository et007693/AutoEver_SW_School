<template>
  <div>
    <input
      :type="type"
      :placeholder="placeholder"
      :value="modelValue"
      @input="emit('update', $event.target.value)"
      class="border border-gray-300 px-4 py-2 rounded w-full focus:ring-2 focus:ring-blue-400 focus:outline-none"
    />
  </div>
</template>

<script setup>
defineProps({
  type: { type: String, default: "text" },
  placeholer: { type: String, default: "" },
  modelValue: String,
});

const emit = defineEmits(["update:modelValue"]);
</script>

<style scoped></style>
