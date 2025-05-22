<template>
  <div class="flex flex-col gap-4">
    <div>
      <h2 class="text-xl font-semibold mb-4 text-gray-800">💬 댓글</h2>
      <ul class="space-y-4">
        <li
          v-for="comment in comments"
          :key="comment.commentId"
          class="border rounded-md p-4 bg-gray-50"
        >
          <div class="flex justify-between mb-2 text-sm text-gray-600">
            <span class="font-medium">{{ comment.email }}</span>
            <span>{{ formatDate(comment.regDate) }}</span>
          </div>
          <p class="text-gray-800 text-sm whitespace-pre-line">
            {{ comment.content }}
          </p>
        </li>
      </ul>
    </div>

    <div class="bg-white rounded-lg">
      <h2 class="text-lg font-semibold mb-2">✏️ 댓글 작성</h2>
      <textarea
        v-model="newComment"
        placeholder="댓글을 입력하세요..."
        class="w-full border rounded p-2 resize-none min-h-[80px] focus:outline-blue-400"
        @keydown.enter.prevent="submitComment()"
      ></textarea>
      <div class="flex justify-end mt-2">
        <button
          @click="submitComment()"
          class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
        >
          등록
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { useBoardApi } from "../../api/board";
import { useUserStore } from "../../stores/User";
import { useModalState } from "../../stores/Modal";
import dayjs from "dayjs";

const props = defineProps({
  id: String,
});

const { commentList, commentWrite } = useBoardApi();
const comments = ref([]);
const newComment = ref("");
const userEmail = useUserStore().userInfo.email;
const modal = useModalState();

const fetchData = async () => {
  const res = await commentList(props.id);
  if (res.data) {
    comments.value = res.data;
  } else {
    console.log("error");
  }
};

const formatDate = (date) => {
  return dayjs(date).format("YYYY.MM.DD HH:mm");
};

const submitComment = async () => {
  const res = await commentWrite(userEmail, props.id, newComment.value);
  if (res.data) {
    newComment.value = "";
    await fetchData();
  }
};

onMounted(fetchData);
</script>

<style scoped></style>
