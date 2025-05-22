<template>
  <div class="min-h-[90vh] flex justify-center items-center py-10">
    <div class="bg-white p-6 rounded shadow-md w-full max-w-3xl">
      <h1 class="text-2xl font-bold mb-6">📝 게시글 작성</h1>

      <div class="mb-4">
        <label class="block font-semibold mb-1">제목</label>
        <input v-model="form.title" class="input-box" placeholder="제목" />
      </div>

      <div class="mb-4">
        <label class="block font-semibold mb-1">카테고리</label>
        <select
          v-model="form.categoryId"
          class="input-box"
          placeholder="카테고리 선택"
        >
          <option disabled selected value="">카테고리를 선택하세요</option>
          <option
            v-for="cat in catData"
            :key="cat.categoryId"
            :value="cat.categoryId"
          >
            {{ cat.categoryName }}
          </option>
        </select>
      </div>

      <div class="mb-4">
        <label class="block font-semibold mb-1">내용</label>
        <textarea
          v-model="form.content"
          class="input-box h-40"
          placeholder="내용을 입력하세요"
        ></textarea>
      </div>

      <div class="mb-6">
        <!-- <ImageUpload /> -->
      </div>

      <button
        class="bg-blue-700 hover:bg-blue-600 text-white font-semibold py-2 px-6 rounded"
        @click="submit"
      >
        등록하기
      </button>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";
import { useBoardApi } from "@/api/board";
import { useModalState } from "../../stores/Modal";
import { useUserStore } from "@/stores/User";
// import ImageUpload from "../../components/ImageUpload.vue";

const { boardWrite, cateList } = useBoardApi();
const modal = useModalState();
const router = useRouter();
const userStore = useUserStore();
const catData = ref([]);

const form = ref({
  email: userStore.userInfo.email,
  title: "",
  categoryId: null,
  content: "",
  img: "",
});

const getData = async () => {
  const res = await cateList();
  if (res.data) {
    catData.value = res.data;
  } else {
    console.log("error");
  }
};

const submit = async () => {
  const { email, title, categoryId, content, img } = form.value;
  if (!email || !title || !content || !categoryId) {
    modal.Open({
      title: "게시글 작성 실패",
      message: "모든 항목을 입력해주세요",
      buttons: [
        {
          label: "확인",
          onClick: () => {
            modal.Close();
          },
        },
      ],
    });
    return;
  }

  try {
    const res = await boardWrite(email, title, categoryId, content, img);
    if (res.data) {
      modal.Open({
        title: "작성 완료",
        message: "게시글이 성공적으로 작성되었습니다.",
        buttons: [
          {
            label: "확인",
            onClick: () => {
              modal.Close();
              router.push("/boards");
            },
          },
        ],
      });
    }
  } catch (err) {
    console.error(err);
    alert("게시글 작성 중 오류가 발생했습니다.");
  }
};

onMounted(getData);
</script>

<style scoped>
.input-box {
  @apply w-full p-3 border border-gray-300 rounded;
}
</style>
