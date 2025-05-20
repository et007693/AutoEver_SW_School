import { defineStore } from "pinia";

export const useUserStore = defineStore("user", {
  state: () => ({
    userInfo: null,
  }),

  actions: {
    setUser(userValue) {
      this.userInfo = userValue;
    },
  },
  persist: true,
});
