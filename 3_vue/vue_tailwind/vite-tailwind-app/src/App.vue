<template>
  <div>
    <!-- router -->
    <div id="router">
      <router-view />
    </div>

    <!-- <LoginPage /> -->
    <!-- <SigUpPage /> -->
  </div>
</template>

<script setup>
import HelloWorld from "./components/HelloWorld.vue";
import BaseButton from "./base/BaseButton.vue";
import SigUpPage from "./pages/SignUpPage.vue";
// import LoginPage from "./pages/LoginPage.vue";
</script>
