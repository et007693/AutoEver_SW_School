<template>
  <div>
    <h2>{{ isLogin ? "환영합니다." : "로그인 후 사용하세요." }}</h2>
    <h2 v-if="isLogin">환영합니다.</h2>
  </div>
</template>
<script setup>
const isLogin = true;
</script>
<style lang=""></style>
