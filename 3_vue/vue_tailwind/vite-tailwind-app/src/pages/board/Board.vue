<template>
  <div class="flex flex-col gap-11 p-7">
    <div class="flex justify-between items-center px-5">
      <h1 class="text-3xl text-white">📒 게시판</h1>
      <button
        class="bg-purple-700 text-white hover:bg-purple-500 transition-all duration-200 rounded-xl w-44 h-12"
        @click="goWritePage()"
      >
        ✏️ 글쓰기
      </button>
    </div>
    <div>
      <ul class="flex justify-center flex-wrap w-full gap-3">
        <li
          class="flex items-center p-4 bg-white min-h-40 w-[48%] rounded-lg shadow-md hover:shadow-lg transition-shadow"
          v-for="board in boards"
          :key="board.boardId"
          @click="goToDetail(board.boardId)"
        >
          <img
            :src="board.img"
            alt=""
            class="w-[40%] rounded-lg mr-5 bg-gray-500"
          />
          <div class="flex flex-col justify-around h-full w-full">
            <p>
              <span class="text-blue-400 text-lg mr-3">
                <strong>{{ board.title }}</strong>
              </span>
            </p>
            <p class="text-xs">{{ board.content }}</p>
            <div class="text-end text-xs self-end">
              <p class="text-gray-500">
                {{ board.email }}
              </p>
              <p>
                {{ formatTime(board.regDate) }}
              </p>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useBoardApi } from "../../api/board";
import { useRouter } from "vue-router";
import dayjs from "dayjs";
import relativeTime from "dayjs/plugin/relativeTime";
dayjs.extend(relativeTime);

const { boardList } = useBoardApi();
const router = useRouter();
const boards = ref([]);

const fetchBoard = async () => {
  const res = await boardList();
  if (res.data) {
    boards.value = res.data;
  } else {
    console.log("error");
  }
};

const formatTime = (time) => {
  return dayjs(time).fromNow();
};

const goToDetail = (id) => {
  router.push(`/boards/${id}`);
};

const goWritePage = () => {
  router.push(`/boards/write`);
};

onMounted(fetchBoard);
</script>

<style scoped></style>
