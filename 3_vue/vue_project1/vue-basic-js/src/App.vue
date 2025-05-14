<script setup>
import DataBinding from "./components/DataBinding.vue";
import ConditionRenderer from "./components/ConditionRenderer.vue";
import IterableArray from "./components/IterableArray.vue";
import ClassBinding from "./components/ClassBinding.vue";
import Reacitve from "./components/Reacitve.vue";
import Computed from "./components/Computed.vue";
import Watch from "./components/Watch.vue";
import Prac1 from "./components/Prac1.vue";

import { ref } from "vue";

// const message = ref("Vue 3 시작하기");
// const text = ref("");
</script>

<template>
  <div>
    <!-- <h1>안녕하세요. 뷰를 공부하겠습니다.</h1>
  <input v-model="name" placeholder="이름 입력" />
  <h1>{{ text }}</h1> -->

    <h1>Component 영역입니다.</h1>
    <!-- <DataBinding /> -->
    <!-- <ConditionRenderer /> -->
    <!-- <IterableArray /> -->
    <!-- <ClassBinding /> -->
    <!-- <Reacitve /> -->
    <!-- <computed /> -->
    <!-- <Watch /> -->
    <Prac1 />
  </div>
</template>

<style scoped>
h1 {
  font-size: 24px;
  color: royalblue;
}

input {
  padding: 8px;
  font-size: 18px;
  margin-top: 10px;
}
</style>
