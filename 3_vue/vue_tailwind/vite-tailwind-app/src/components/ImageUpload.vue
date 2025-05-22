<template>
  <div>
    <input type="file" @change="handleFileChange" />
    <div v-if="imageName">
      <img :src="imageName" alt="uploaded" class="mt-4 max-w-xs" />
    </div>
    <button @click="uploadImage">업로드</button>
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
import { app } from "@/api/firebase";

const file = ref(null);
const imageName = ref("");
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
    imageName.value = url;
    return url; // 업로드된 이미지 URL을 반환
  } catch (err) {
    alert("업로드 실패: " + err.message);
  }
};

defineExpose({
  uploadImage,
});
</script>
