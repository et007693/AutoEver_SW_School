<template>
  <div class="p-5 max-w-3xl min-h-lvh mx-auto bg-white rounded-lg gap-5">
    <BoardContent :id="boardId" />
    <BoardComment :id="boardId" />
  </div>
</template>

<script setup>
import { useRoute } from "vue-router";
import BoardComment from "../../components/board/BoardComment.vue";
import BoardContent from "../../components/board/BoardContent.vue";

const route = useRoute();
const boardId = route.params.id;
</script>

<style scoped></style>
