import { createApp } from "vue";
import App from "./App.vue";
import "./assets/tailwind.css";

// 전역 상태 관리
import { createPinia } from "pinia";
import piniaPluginPersistedstate from "pinia-plugin-persistedstate";

// 라우터 설정
import router from "./router";

const app = createApp(App);

// pinia 플러그인 연결
const pinia = createPinia();
pinia.use(piniaPluginPersistedstate);

app.use(pinia);
app.use(router);

app.mount("#app");
