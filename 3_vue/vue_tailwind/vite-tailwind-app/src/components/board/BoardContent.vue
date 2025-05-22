<template>
  <div>
    <div class="text-sm text-gray-500 flex justify-between">
      <h1 class="text-3xl font-bold text-blue-600 mb-4">{{ board.title }}</h1>
      <div class="flex flex-col items-end">
        <p><strong>작성자:</strong> {{ board.email }}</p>
        <p>{{ formatDate(board.regDate) }}</p>
      </div>
      <div v-if="board.address">
        <p><strong>위치:</strong> {{ board.address }}</p>
      </div>
    </div>
    <div>
      <img
        :src="board.img"
        @error="onImgError"
        alt="Board image"
        class="w-full h-60 object-cover rounded mb-4 bg-gray-200"
      />

      <p class="text-gray-700 mb-6 whitespace-pre-line">
        {{ board.content }}
      </p>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { useBoardApi } from "../../api/board";
import dayjs from "dayjs";

const props = defineProps({
  id: String,
});

const { boardDetail, boardDelete } = useBoardApi();
const board = ref([]);

const fetchData = async () => {
  const res = await boardDetail(props.id);

  if (res.data) {
    board.value = res.data;
  } else {
    console.log("error");
  }
};

const formatDate = (date) => {
  return dayjs(date).format("YYYY.MM.DD HH:mm");
};

onMounted(fetchData);
</script>

<style scoped></style>
