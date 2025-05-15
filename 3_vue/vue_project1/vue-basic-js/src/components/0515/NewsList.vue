<template>
  <div class="container">
    <ul>
      <li
        class="news-list"
        v-for="n in prop.news"
        :key="n.title"
        @click="clickNews(n.content)"
      >
        {{ n.title }}
      </li>
    </ul>
    <div class="news-detail"><NewsItem :detail="newsDetail" /></div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import NewsItem from "./NewsItem.vue";

const newsDetail = ref("");

const prop = defineProps({
  news: Array,
});

function clickNews(detail) {
  newsDetail.value = detail;
}
</script>

<style scoped>
.container {
  margin-top: 50px;
  background-color: beige;
  padding: 10%;
  min-height: 400px;
  display: flex;
  justify-content: flex-start;
  gap: 50px;
  border-radius: 10px;
}

.news-list {
  display: flex;
  flex: 1;
}

ul {
  display: flex;
  flex-direction: column;
  padding: 0;
}

li {
  position: relative;
  display: flex;
  align-items: center;
  cursor: pointer;
  height: 30%;
}

.news-detail {
  width: 80%;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: white;
  border-radius: 10px;
  margin-left: 50px;
}
</style>
