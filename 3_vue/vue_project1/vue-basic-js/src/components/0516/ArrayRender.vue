<template>
  <div>
    <div id="user">
      <ul>
        <li
          v-for="user in users"
          :key="user.id"
          @click="showTodo(user.id)"
          @dblclick="removeUser(user.id)"
        >
          이름 : {{ user.userName }}, 이메일 : {{ user.email }}
        </li>
      </ul>

      <p>
        <input
          v-model="inputName"
          @keydown.enter="addUser"
          placeholder="이름을 입력해주세요."
        />
      </p>
    </div>

    <div id="to-do" v-if="currentUser">
      <ul>
        <strong>이름: {{ currentUser.userName }}</strong>
        <li
          v-for="(todo, index) in currentUser.toDo"
          :key="index"
          @dblclick="removeTodo(index)"
        >
          {{ todo }}
        </li>
      </ul>
      <input
        v-model="inputTodo"
        @keydown.enter="addTodo"
        placeholder="할 일을 입력해주세요"
      />
    </div>
  </div>
</template>

<script setup>
import { watch, ref, reactive } from "vue";

const inputName = ref("");
const nextId = ref(3);
const inputTodo = ref("");
const targetUserID = ref("");
const currentUser = ref();

const stored = localStorage.getItem("users");
const users = ref(
  stored
    ? JSON.parse(stored)
    : [
        { id: 1, userName: "지훈", email: "test1@test.com", toDo: ["HTML"] },
        { id: 2, userName: "마리", email: "test2@test.com", toDo: ["CSS"] },
        { id: 3, userName: "민혁", email: "test3@test.com", toDo: ["Vue"] },
      ]
);

const showTodo = (id) => {
  targetUserID.value = id;
  currentUser.value = users.value.find((user) => user.id === id);
};

const addUser = () => {
  if (!inputName.value.trim()) return;
  users.value.push({
    id: nextId.value++,
    userName: inputName.value,
    email: `test${nextId.value}@text.com`,
    toDo: [],
  });

  inputName.value = "";
};

const removeUser = (id) => {
  users.value = users.value.filter((user) => user.id !== id);
};

const addTodo = () => {
  if (!inputTodo.value.trim()) return;
  const targetUser = users.value.find((user) => user.id === targetUserID.value);
  targetUser.toDo.push(inputTodo.value);
  inputTodo.value = "";
};

const removeTodo = (todoId) => {
  const targetUser = users.value.find((user) => user.id === targetUserID.value);

  if (targetUser) {
    targetUser.toDo.splice(todoId, 1);
  }
};

watch(
  users,
  (newVal) => {
    localStorage.setItem("users", JSON.stringify(newVal));
  },
  { deep: true }
);
</script>

<style scoped></style>
