<template>
  <div class="p-6 space-y-4">
    <input type="file" @change="handleFileChange" />
    <button
      @click="uploadImage"
      class="bg-blue-500 text-white px-4 py-2 rounded"
    >
      업로드
    </button>
    <div v-if="imageUrl">
      <img :src="imageUrl" alt="uploaded" class="mt-4 max-w-xs" />
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import {
  getStorage,
  ref as storageRef,
  uploadBytes,
  getDownloadURL,
} from "firebase/storage";
import { app } from "@/api/firebase"; // 여기에서 firebase App 객체 export 하고 있어야 함

const file = ref(null);
const imageUrl = ref("");

// 스토리지 인스턴스
const storage = getStorage(app);

const handleFileChange = (e) => {
  file.value = e.target.files[0];
};

const uploadImage = async () => {
  if (!file.value) {
    alert("파일을 선택하세요.");
    return;
  }

  try {
    const imageRef = storageRef(storage, `uploads/${file.value.name}`);
    await uploadBytes(imageRef, file.value);
    const url = await getDownloadURL(imageRef);
    imageUrl.value = url;
  } catch (err) {
    alert("업로드 실패: " + err.message);
  }
};
</script>
