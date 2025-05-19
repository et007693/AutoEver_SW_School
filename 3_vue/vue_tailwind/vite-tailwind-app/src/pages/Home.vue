<template>
  <div>
    <h1>홈입니다</h1>
    <p>가장 먼저 보이는 페이지입니다.</p>
    <router-link to="/about">소개 페이지로 이동</router-link>
    <br />
    <router-link :to="`/profile/${name}`">프로필 페이지로 이동</router-link>
    <br />
    <input
      v-model="name"
      @keyup.enter="goToProfile"
      class="border px-3 py-2 rounded w-full max-w-md mb-4"
      placeholder=":이름을 입력하세요."
    />
    <button
      @click="goToProfile"
      class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
    >
      프로필 보기
    </button>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";

const name = ref("");
const router = useRouter();
const goToProfile = () => {
  router.push(`profile/${name.value}`);
};
</script>

<style scoped></style>
