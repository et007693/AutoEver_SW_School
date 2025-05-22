<template>
  <div class="p-6">
    <h1 class="text-2xl font-semibold text-gray-800 mb-4">📂 카테고리 관리</h1>

    <div class="mb-6">
      <input
        v-model="inputCategory"
        type="text"
        class="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
        placeholder="새 카테고리 이름을 입력하세요"
        @keydown.enter.prevent="addCategory()"
      />
      <button
        @click="addCategory"
        class="mt-3 w-full bg-blue-800 text-white py-2 rounded-lg hover:bg-blue-700 transition duration-200"
      >
        카테고리 추가
      </button>
    </div>

    <div v-if="catList.length > 0">
      <h2 class="text-lg font-semibold text-gray-700 mb-4">💬 카테고리 목록</h2>
      <ul class="space-y-4">
        <li
          v-for="category in catList"
          :key="category.categoryId"
          class="flex justify-between items-center bg-gray-50 p-4 rounded-md shadow-md hover:bg-gray-100 transition duration-200"
          :class="{ flash: category.isNew }"
        >
          <span class="text-gray-800">{{ category.categoryName }}</span>
        </li>
      </ul>
    </div>

    <div v-else class="text-center text-gray-500">
      <p>현재 등록된 카테고리가 없습니다. 카테고리를 추가해 주세요.</p>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useBoardApi } from "../api/board";
import { useUserStore } from "../stores/User";

const { cateList, cateInsert } = useBoardApi();
const catList = ref([]);
const inputCategory = ref("");
const userEmail = useUserStore().userInfo.email;

const getData = async () => {
  const res = await cateList();
  if (res.data) {
    catList.value = res.data;
  }
};

const addCategory = async () => {
  if (!inputCategory.value.trim()) {
    alert("카테고리 이름을 입력하세요.");
    return;
  }

  const res = await cateInsert(userEmail, inputCategory.value);
  if (res.data) {
    const newCategory = {
      categoryId: res.data.categoryId,
      categoryName: inputCategory.value,
      isNew: true,
    };
    catList.value.push(newCategory);
    inputCategory.value = "";

    setTimeout(() => {
      newCategory.isNew = false;
    }, 1000);
  } else {
    alert("카테고리 추가 실패.");
  }
};

onMounted(getData);
</script>

<style scoped>
@keyframes flash {
  0% {
    background-color: #d2e623;
  }
  50% {
    background-color: #fffd8b;
  }
  100% {
    background-color: #f3f4f6;
  }
}

.flash {
  animation: flash 1s ease-out;
}
</style>
