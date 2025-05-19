<template>
  <div class="main">
    <p>아이디</p>
    <input v-model="form.email" type="text" />
    <p>{{ validEmail }}</p>
    <p>비밀번호</p>
    <input v-model="form.pwd" type="text" />
    <p>비밀번호 확인</p>
    <input type="text" v-model="form.pwdCheck" />
    <p>{{ validPwd }}</p>
    <p>이름</p>
    <input v-model="form.name" type="text" /><br />
    <button @click="handleSubmit">확인</button>
  </div>
</template>

<script setup>
import axios from "axios";
import { reactive, ref, watch } from "vue";

const validPwd = ref("비밀번호가 일치하지 않습니다.");
const validEmail = ref("이메일 형식이 일치하지 않습니다.");

const form = reactive({
  email: "",
  pwd: "",
  pwdCheck: "",
  name: "",
});

// 이메일 변경될 때만 감시
watch(
  () => form.email,
  (newEmail) => {
    checkEmail(newEmail);
  }
);

// 비밀번호 확인이 바뀔 때만 감시
watch(
  () => form.pwdCheck,
  () => {
    if (form.pwdCheck === form.pwd && form.pwdCheck !== "")
      validPwd.value = "비밀번호가 일치합니다.";
    else validPwd.value = "비밀번호가 일치하지 않습니다.";
  }
);

const checkEmail = (e) => {
  const validateEmail = /^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\.[A-Za-z0-9\\-]+/;

  if (!validateEmail.test(e) || !e) {
    validEmail.value = "이메일 형식이 일치하지 않습니다.";
    return;
  } else {
    validEmail.value = "이메일 형식이 일치합니다.";
  }
};

const handleSubmit = async () => {
  try {
    const payload = {
      email: form.email,
      pwd: form.pwd,
      name: form.name,
    };

    const res = await axios.post(
      "http://222.117.237.119:8111/auth/signup",
      payload
    );
    if (res.data) {
      alert("회원 가입 성공");
    } else {
      alert("회원 가입 실패");
    }
  } catch (err) {
    console.error(err);
    alert("가입 실패! 서버 오류 발생");
  }
};
</script>

<style lang="scss" scoped></style>
