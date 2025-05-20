<template>
  <div class="user-info">
    <p>이름 : {{ userInfo.name }}</p>
    <p>이메일 : {{ userInfo.email }}</p>
  </div>
  <div class="min-h-screen bg-transparent flex items-center justify-center p-4">
    <div class="grid grid-cols-2 gap-4 w-full max-w-4xl">
      <button
        class="bg-transparent border border-white text-white font-semibold py-6 rounded-lg"
        @click="navigateTo('/members')"
      >
        회원리스트
      </button>
      <button
        class="bg-transparent border border-white text-white font-semibold py-6 rounded-lg"
        @click="navigateTo('/boards')"
      >
        게시판
      </button>
      <button
        class="bg-transparent border border-white text-white font-semibold py-6 rounded-lg"
        @click="navigateTo('/category')"
      >
        카테고리
      </button>
      <button
        class="bg-transparent border border-white text-white font-semibold py-6 rounded-lg"
        @click="navigateTo('/theme')"
      >
        테마 설정
      </button>
      <button
        class="bg-transparent border border-white text-white font-semibold py-6 rounded-lg"
        @click="navigateTo('/category')"
      >
        카테고리 설정
      </button>
      <button
        class="bg-transparent border border-white text-white font-semibold py-6 rounded-lg"
        @click="navigateTo('/Chat')"
      >
        채팅
      </button>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { onMounted } from "vue";
import { useUserStore } from "@/stores/User";

const router = useRouter();
const userStore = useUserStore();
const userInfo = userStore.userInfo;

const navigateTo = (path) => {
  router.push(path);
};

onMounted(() => {
  const isLogin = localStorage.getItem("isLogin");
  if (isLogin !== "TRUE") {
    router.push("/");
  }
});
</script>
