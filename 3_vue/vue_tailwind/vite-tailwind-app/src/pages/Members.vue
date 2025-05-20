<template>
  <div class="max-w-3xl mx-auto p-4">
    <h2 class="text-2xl font-bold text-gray-800 mb-4">회원 목록</h2>
    <ul class="space-y-4">
      <MemberItem v-for="user in users" :key="user.email" :user="user" />
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import axios from "axios";
import MemberItem from "../components/member/MemberItem.vue";

const users = ref([]);

onMounted(async () => {
  try {
    const res = await axios.get("http://222.117.237.119:8111/users/list");
    users.value = res.data;
  } catch (error) {
    console.error("데이터 불러오기 실패:", error);
  }
});
</script>
