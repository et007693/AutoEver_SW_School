<script setup>
// 0514
import DataBinding from "./components/0514/DataBinding.vue";
import ConditionRenderer from "./components/0514/ConditionRenderer.vue";
import IterableArray from "./components/0514/IterableArray.vue";
import ClassBinding from "./components/0514/ClassBinding.vue";
import Reacitve from "./components/0514/Reacitve.vue";
import Computed from "./components/0514/Computed.vue";
import Watch from "./components/0514/Watch.vue";
import Prac1 from "./components/0514/Prac1.vue";

// 0515
import Cardview from "./components/0515/CardView.vue";
import Prac2 from "./components/0515/Prac2.vue";
import ChildComponent from "./components/0515/ChildComponent.vue";
import UserCard from "./pages/UserCard.vue";
import News from "./components/0515/News.vue";

// 0516
import ArrayRender from "./components/0516/ArrayRender.vue";
import EventHandler from "./components/0516/EventHandler.vue";
import EventRef from "./components/0516/EventRef.vue";
import MemberList from "./components/0516/MemberList.vue";
import SelectBox from "./components/0516/SelectBox.vue";
import SignUp from "./components/0516/SignUp.vue";

import { reactive, ref } from "vue";
// const member = reactive({
//   name: "",
//   job: "",
//   age: 0,
// });

// const people = reactive([
//   { name: "장원영", age: 22, addr: "서울시 강남구 역삼동", isAdult: true },
//   { name: "장원영", age: 22, addr: "서울시 강남구 역삼동", isAdult: true },
//   { name: "장원영", age: 22, addr: "서울시 강남구 역삼동", isAdult: true },
//   { name: "장원영", age: 22, addr: "서울시 강남구 역삼동", isAdult: true },
//   { name: "장원영", age: 22, addr: "서울시 강남구 역삼동", isAdult: true },
//   { name: "장원영", age: 22, addr: "서울시 강남구 역삼동", isAdult: true },
//   { name: "장원영", age: 22, addr: "서울시 강남구 역삼동", isAdult: true },
//   { name: "장원영", age: 22, addr: "서울시 강남구 역삼동", isAdult: true },
//   { name: "장원영", age: 22, addr: "서울시 강남구 역삼동", isAdult: true },
//   { name: "장원영", age: 22, addr: "서울시 강남구 역삼동", isAdult: true },
// ]);

// const message = ref("안녕하세요");
// const hadleMessage = (payload) => {
//   message.value = payload;
// };
</script>

<template>
  <div>
    <h1>Component 영역입니다.</h1>
    <!-- <h1>안녕하세요. 뷰를 공부하겠습니다.</h1>
    <input v-model="name" placeholder="이름 입력" />
    <h1>{{ text }}</h1> -->

    <!-- <input v-model="member.name" placeholder="이름 입력" />
    <br />
    <input v-model="member.job" placeholder="직업 입력" />
    <br />
    <input v-model.number="member.age" placeholder="나이 입력" /> -->

    <!-- <DataBinding /> -->
    <!-- <ConditionRenderer /> -->
    <!-- <IterableArray /> -->
    <!-- <ClassBinding /> -->
    <!-- <Reacitve /> -->
    <!-- <computed /> -->
    <!-- <Watch /> -->
    <!-- <Prac1 /> -->

    <!-- <Cardview :user="member" /> -->
    <!-- <Prac2 :users="people" /> -->
    <!-- <UserCard /> -->
    <!-- <div>
      <ChildComponent @send-message="hadleMessage" />
      <h2>부모 컴포넌트</h2>
      <p>자식에게 받은 메시지 : {{ message }}</p>
    </div> -->
    <!-- <News /> -->

    <!-- <ArrayRender /> -->
    <!-- <EventHandler /> -->
    <!-- <EventRef /> -->
    <!-- <MemberList /> -->
    <!-- <SelectBox /> -->
    <SignUp />
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
