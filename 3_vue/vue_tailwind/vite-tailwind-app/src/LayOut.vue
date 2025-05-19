<template>
  <div>
    <header style="background: #eee; padding: 1rem">공통 헤더</header>

    <main class="flex-1 p-4">
      <router-view />
    </main>

    <footer style="background: #eee; padding: 1rem; text-align: center">
      ⓒ 2025 Vue 예제 사이트, 모든 권리 보유.
    </footer>
  </div>
</template>

<script setup></script>

<style scoped></style>
