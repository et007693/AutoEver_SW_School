import { createRouter, createWebHistory } from "vue-router";
import Home from "../pages/Home.vue";
import About from "../pages/About.vue";
import Profile from "../pages/Profile.vue";
import Login from "../pages/LoginPage.vue";
import Signup from "../pages/SignUpPage.vue";
import Layout from "./Layout.vue/";

// const routes = [
//   { path: "/", component: Home },
//   { path: "/about", component: About },
//   { path: "/profile/:username", component: Profile },
// ];

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
      { path: "/about", component: About },
      { path: "profile/:username", component: Profile },
      { path: "" },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
