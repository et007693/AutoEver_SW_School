<template>
  <div class="signup-container">
    <div class="signup-box">
      <h2>회원가입</h2>
      <form @submit.prevent="handleSignUp">
        <div class="input-group">
          <label for="name">이름</label>
          <input
            v-model="name"
            id="name"
            type="text"
            required
            placeholder="홍길동"
          />
        </div>

        <div class="input-group">
          <label for="email">이메일</label>
          <input
            v-model="email"
            id="email"
            type="email"
            required
            placeholder="you@example.com"
          />
        </div>

        <div class="input-group">
          <label for="password">비밀번호</label>
          <input
            v-model="password"
            id="password"
            type="password"
            required
            placeholder="••••••••"
          />
        </div>

        <div class="input-group">
          <label for="confirmPassword">비밀번호 확인</label>
          <input
            v-model="confirmPassword"
            id="confirmPassword"
            type="password"
            required
            placeholder="••••••••"
          />
        </div>

        <button type="submit" class="submit-btn">회원가입</button>
      </form>
      <p class="login-link">
        이미 계정이 있으신가요?
        <a href="#">로그인</a>
      </p>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";

const name = ref("");
const email = ref("");
const password = ref("");
const confirmPassword = ref("");

const handleSignUp = () => {
  if (password.value !== confirmPassword.value) {
    alert("비밀번호가 일치하지 않습니다.");
    return;
  }
  console.log("회원가입 정보:", {
    name: name.value,
    email: email.value,
    password: password.value,
  });
};

const validEmail = async () => {
  // const reget = /^[1-zA-z0-9_.]
};
</script>

<style scoped>
.signup-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f0f2f5;
}

.signup-box {
  width: 100%;
  max-width: 420px;
  background-color: #fff;
  padding: 32px;
  border-radius: 8px;
  box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
  text-align: center;
}

h2 {
  font-size: 26px;
  font-weight: 700;
  margin-bottom: 24px;
  color: #333;
}

.input-group {
  margin-bottom: 18px;
  text-align: left;
}

.input-group label {
  display: block;
  font-weight: 600;
  font-size: 14px;
  margin-bottom: 6px;
  color: #555;
}

.input-group input {
  width: 100%;
  padding: 10px 12px;
  font-size: 15px;
  border: 1px solid #ccc;
  border-radius: 4px;
  outline: none;
  box-sizing: border-box;
}

.input-group input:focus {
  border-color: #007bff;
}

.submit-btn {
  width: 100%;
  padding: 12px;
  background-color: #007bff;
  color: white;
  font-size: 16px;
  font-weight: 600;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-top: 10px;
  transition: background-color 0.3s;
}

.submit-btn:hover {
  background-color: #0056b3;
}

.login-link {
  margin-top: 16px;
  font-size: 14px;
  color: #666;
}

.login-link a {
  color: #007bff;
  text-decoration: none;
}

.login-link a:hover {
  text-decoration: underline;
}
</style>
