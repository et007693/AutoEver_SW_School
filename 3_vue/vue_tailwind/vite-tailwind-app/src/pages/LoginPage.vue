<template>
  <div class="min-h-screen flex items-center justify-center bg-gray-100">
    <div class="w-full max-w-md bg-white p-8 rounded-lg shadow-md">
      <h2 class="text-2xl font-bold text-center text-gray-800 mb-6">로그인</h2>
      <form @submit.prevent="handleLogin">
        <div class="mb-4">
          <label for="email" class="block text-gray-700 mb-1">이메일</label>
          <input
            v-model="email"
            id="email"
            type="email"
            required
            class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
            placeholder="you@example.com"
          />
        </div>
        <div class="mb-6">
          <label for="password" class="block text-gray-700 mb-1"
            >비밀번호</label
          >
          <input
            v-model="password"
            id="password"
            type="password"
            required
            class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
            placeholder="••••••••"
          />
        </div>
        <button
          type="submit"
          class="w-full bg-blue-600 hover:bg-blue-700 text-white font-semibold py-2 px-4 rounded-md transition-colors"
        >
          로그인
        </button>
      </form>
      <p class="mt-4 text-sm text-center text-gray-600">
        계정이 없으신가요?
        <a href="#" class="text-blue-600 hover:underline">회원가입</a>
      </p>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";

const email = ref("");
const password = ref("");

const handleLogin = () => {
  console.log("로그인 시도:", email.value, password.value);
  // 여기에 실제 로그인 로직 (API 호출 등) 추가 가능
};
</script>
