<template>
  <div
    class="flex flex-col items-center justify-center min-h-screen bg-white px-4"
  >
    <h1 class="text-2xl font-semibold mb-8">Login</h1>

    <div class="w-full max-w-md mx-auto space-y-4">
      <input
        v-model="email"
        type="email"
        placeholder="이메일"
        class="input-box"
      />
      <input
        v-model="pw"
        type="password"
        placeholder="비밀번호"
        class="input-box"
      />
      <button
        @click="onLogin"
        :disabled="!canLogin"
        class="w-full py-3 mt-4 rounded-xl text-white font-bold"
        :class="
          canLogin
            ? 'bg-green-600 hover:bg-green-700'
            : 'bg-gray-400 cursor-not-allowed'
        "
      >
        로그인
      </button>

      <div class="text-sm text-center mt-4">
        계정이 없으신가요?
        <router-link to="/signup" class="text-blue-500 hover:underline">
          회원가입
        </router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";
import { useModalState } from "@/stores/Modal";

const router = useRouter();
const modal = useModalState();

const email = ref("");
const pw = ref("");

// 로그인 조건: 이메일과 비밀번호가 모두 입력되었을 때
const canLogin = computed(() => email.value.length > 0 && pw.value.length > 0);

async function onLogin() {
  if (!canLogin.value) return;

  try {
    //const user = await login(id.value, pw.value);
    const payload = {
      email: email.value,
      pwd: pw.value,
    };
    const res = await axios.post(
      "http://222.117.237.119:8111/auth/login",
      payload
    );
    if (res.data) {
      console.log("로그인 성공:");
      localStorage.setItem("isLogin", "TRUE");
      localStorage.setItem("email", email.value);
      router.push("/home");
    } else {
      modal.Open({
        title: "로그인 실패",
        message: "이메일 또는 비밀번호를 확인하세요",
        buttons: [{ label: "확인", onclick: () => modal.Close() }],
      });
    }
  } catch (err) {
    modal.Open({
      title: "서버 통신 에러",
      message: "서버 상태를 확인해주세요.",
      buttons: [{ label: "확인", onclick: () => modal.Close() }],
    });
  }
}
</script>

<style scoped>
.input-box {
  @apply w-full px-4 py-3 border border-gray-400 rounded-full;
}
</style>
