<template>
  <div class="p-6 space-y-6">
    <h1 class="text-xl font-bold">🎨 테마 색상 선택</h1>
    <div class="flex gap-3 flex-wrap">
      <button
        v-for="c in colors"
        :key="c"
        @click="setColor(c)"
        :style="{ backgroundColor: c }"
        class="px-4 py-2 rounded text-white font-bold shadow"
      >
        {{ c }}
      </button>
    </div>
  </div>
</template>

<script setup>
import { useThemeStore } from "@/stores/theme";

const themeStore = useThemeStore();
const setColor = themeStore.setColor;
const colors = ["orange", "green", "lightgrey", "grey", "royalblue"];
</script>
