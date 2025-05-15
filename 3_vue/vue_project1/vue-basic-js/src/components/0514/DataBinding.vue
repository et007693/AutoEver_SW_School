<!-- 화면을 그려주는 부분 -->
<template>
  <div>
    <h2>{{ refName }}</h2>
    <h2>{{ name }}</h2>

    <input :value="refName" @input="updateRefName($event)" /><br />
    <input :value="name" @input="updateName($event)" />
  </div>
</template>

<!-- 데이터 로직을 정의하는 부분 -->
<script setup>
import { ref } from "vue";
const refName = ref("장원영");
const name = "안유진";

const updateRefName = (e) => {
  refName.value = e.target.value;
};

const updateName = (e) => {
  name.value = e.target.value;
};
</script>

<style lang=""></style>
