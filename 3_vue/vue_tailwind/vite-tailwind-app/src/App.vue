<template>
  <div
    :style="{ backgroundColor: themeStore.color }"
    class="min-h-screen transition-all"
  >
    <router-view />
    <Modal />
    <!-- <ImageUploader /> -->
  </div>
</template>

<script setup>
import { useThemeStore } from "@/stores/theme";
import Modal from "./components/base/BaseModal.vue";

const themeStore = useThemeStore();

import ImageUploader from "./pages/ImageUploader.vue";
</script>
