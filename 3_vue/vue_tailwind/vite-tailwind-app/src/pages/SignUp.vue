<template>
  <div
    class="flex flex-col items-center justify-center min-h-screen bg-white px-4"
  >
    <h1 class="text-2xl font-semibold mb-8">Sign Up</h1>

    <div class="w-full max-w-md mx-auto space-y-4">
      <BaseInput
        v-model="form.email"
        placeholder="이메일"
        @input="validateEmail"
      />
      <p
        v-if="form.email"
        :class="isEmailValid ? 'text-green-500' : 'text-red-500'"
      >
        {{ emailMessage }}
      </p>

      <BaseInput
        v-model="form.password"
        placeholder="패스워드"
        type="password"
        @input="validatePassword"
      />

      <p
        v-if="form.password"
        :class="isPasswordValid ? 'text-green-500' : 'text-red-500'"
      >
        {{ passwordMessage }}
      </p>

      <BaseInput
        v-model="form.confirmPassword"
        placeholder="패스워드"
        type="password"
        @input="validateConfirmPassword"
      />

      <p
        v-if="form.confirmPassword"
        :class="isConfirmPasswordValid ? 'text-green-500' : 'text-red-500'"
      >
        {{ confirmPasswordMessage }}
      </p>

      <BaseInput v-model="form.name" placeholder="이름" />

      <BaseButton :disabled="!canSubmit" @click="submit">NEXT</BaseButton>
    </div>
  </div>
</template>

<script setup>
import { reactive, ref, computed } from "vue";
import { useUserStore } from "@/stores/User";
import { useModalState } from "@/stores/Modal";
import { useRouter } from "vue-router";
import { useAuthApi } from "../api/auth";

import axios from "axios";
import BaseButton from "../components/base/BaseButton.vue";
import BaseInput from "../components/base/BaseInput.vue";

// API
const { signup, exists } = useAuthApi;

// 전역변수
const userStore = useUserStore();
const setUser = userStore.setUser;
const modal = useModalState();
const router = useRouter();

// ✅ 상태 정의: 하나의 객체로 통합
const form = reactive({
  email: "",
  password: "",
  confirmPassword: "",
  name: "",
});

// 메시지 및 유효성
const emailMessage = ref("");
const passwordMessage = ref("");
const confirmPasswordMessage = ref("");
const isEmailValid = ref(false);
const isPasswordValid = ref(false);
const isConfirmPasswordValid = ref(false);

// 이메일 형식 및 중복 확인
const validateEmail = async () => {
  const regex = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
  if (!regex.test(form.email)) {
    emailMessage.value = "이메일 형식이 올바르지 않습니다.";
    isEmailValid.value = false;
    return;
  }

  //const available = await exists(form.email);
  const res = await axios.get(
    `http://222.117.237.119:8111/auth/exists/${form.email}`
  );
  if (res.data) {
    emailMessage.value = "사용 가능한 이메일입니다.";
    isEmailValid.value = true;
  } else {
    emailMessage.value = "중복된 이메일입니다.";
    isEmailValid.value = false;
  }
};

// 비밀번호 검사
const validatePassword = () => {
  const regex = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,25}$/;
  if (!regex.test(form.password)) {
    passwordMessage.value = "숫자+영문자 조합으로 8자리 이상 입력해주세요!";
    isPasswordValid.value = false;
  } else {
    passwordMessage.value = "안전한 비밀번호에요 :)";
    isPasswordValid.value = true;
  }
};

// 비밀번호 확인
const validateConfirmPassword = () => {
  if (form.password !== form.confirmPassword) {
    confirmPasswordMessage.value = "비밀번호가 일치하지 않습니다.";
    isConfirmPasswordValid.value = false;
  } else {
    confirmPasswordMessage.value = "비밀번호가 일치합니다 :)";
    isConfirmPasswordValid.value = true;
  }
};

// 제출 조건
const canSubmit = computed(
  () =>
    isEmailValid.value &&
    isPasswordValid.value &&
    isConfirmPasswordValid.value &&
    form.name.length > 0
);

// 제출 처리
const submit = async () => {
  const res = await signup(form.email, form.password, form.name);
  if (res.data) {
    router.push("/");
  } else {
    modal.Open({
      title: "회원 가입 실패",
      message: "회원 가입에 실패하였습니다.",
      buttons: [
        {
          label: "확인",
          onClick: () => {
            modal.Close();
          },
        },
      ],
    });
  }

  try {
    const payload = {
      email: form.email,
      pwd: form.password,
      name: form.name,
    };
    const res = await axios.post(
      "http://222.117.237.119:8111/auth/signup",
      payload
    );
    console.log(res.data);
    if (res.data) {
      modal.Open({
        title: "회원 가입 성공",
        message: "환영합니다.",
        buttons: [
          {
            label: "확인",
            onClick: () => {
              modal.Close();
              router.push("/");
            },
          },
        ],
      });
      setUser(payload);
    } else {
      modal.Open({
        title: "회원 가입 실패",
        message: "회원 가입에 실패하였습니다.",
        buttons: [
          {
            label: "확인",
            onClick: () => {
              modal.Close();
            },
          },
        ],
      });
    }
  } catch (err) {
    console.error(err);
    modal.Open({
      title: "서버 오류",
      message: "회원 가입에 실패하였습니다.",
      buttons: [
        {
          label: "확인",
          onClick: () => {
            modal.Close();
          },
        },
      ],
    });
    alert("가입 실패! 서버 오류 발생");
  }
};
</script>

<style scoped>
.input-box {
  @apply w-full px-4 py-3 border border-gray-400 rounded-full;
}
</style>
