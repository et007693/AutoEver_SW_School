<template>
  <div>
    <div v-for="user in users" :key="user.name">
      <MemberItem :user="user" />
    </div>
  </div>
</template>

<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";

const users = ref([]);

onMounted(async () => {
  try {
    const res = await axios.get("http://222.117.237.119:8111/users/list");
    console.log(res);

    if (res) {
      users.value = res.data;
      alert("success");
    } else {
      alert("fail");
    }
  } catch (e) {
    console.log(e);
    alert("error");
  }
});
</script>

<style scoped></style>
