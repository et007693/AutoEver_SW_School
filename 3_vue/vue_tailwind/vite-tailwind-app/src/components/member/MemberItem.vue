<template>
  <li
    class="p-6 rounded-xl shadow-md bg-white border border-gray-200 hover:shadow-lg transition duration-300"
  >
    <p class="text-lg font-semibold text-gray-900 mb-1">
      <span class="text-indigo-600">이름:</span> {{ user.name }}
    </p>
    <p class="text-sm text-gray-700 mb-1">
      <span class="font-medium text-gray-600">이메일:</span> {{ user.email }}
    </p>
    <p class="text-sm text-gray-700">
      <span class="font-medium text-gray-600">가입일:</span> {{ formattedDate }}
    </p>
  </li>
</template>

<script setup>
const props = defineProps({
  user: Object,
});

const formattedDate = new Date(props.user.regDate).toLocaleString("ko-KR", {
  year: "numeric",
  month: "2-digit",
  day: "2-digit",
  hour: "2-digit",
  minute: "2-digit",
});
</script>
