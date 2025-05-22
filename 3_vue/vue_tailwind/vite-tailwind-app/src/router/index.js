import { createRouter, createWebHistory } from "vue-router";
import Home from "../pages/Home.vue";
// import About from "../pages/About_p.vue";
// import Profile from "../pages/Profile.vue";
import Login from "../pages/Login.vue";
import Signup from "../pages/SignUp.vue";
import Members from "../pages/Members.vue";
import Layout from "../Layout.vue/";
import ThemeSetting from "../pages/ThemeSetting.vue";
import Category from "../pages/Category.vue";
// import Chat from "../pages/Chat.vue";
import Board from "../pages/board/Board.vue";
import BoardWrite from "../pages/board/BoardWrite.vue";
import BoardDetail from "../pages/board/BoardDetail.vue";

const routes = [
  { path: "/", component: Login },
  {
    path: "/signup",
    component: Signup,
  },
  {
    path: "/home",
    component: Layout,
    children: [
      { path: "", component: Home },
      { path: "/members", component: Members },
      { path: "/category", component: Category },
      { path: "/boards", component: Board, children: [] },
      { path: "/boards/:id", name: BoardDetail, component: BoardDetail },
      { path: "/boards/write", name: BoardWrite, component: BoardWrite },
      { path: "/theme", component: ThemeSetting },
      // { path: "/chat", component: Chat },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
