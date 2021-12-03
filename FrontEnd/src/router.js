import Vue from "vue";
import Router from "vue-router";
import App from "@/components/App";
import LogIn from "@/components/LogIn";
import SignUp from "@/components/SignUp";
import Home from "@/components/Home";
import ListSimuladores from "@/components/Simuladores/ListSimuladores";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "App",
      component: App,
    },
    {
      path: "/user/logIn",
      name: "logIn",
      component: LogIn,
    },
    {
      path: "/user/signUp",
      name: "signUp",
      component: SignUp,
    },
    {
      path: "/user/home",
      name: "home",
      component: Home,
    },
    {
      path: "/user/aplications",
      name: "ListSimuladores",
      component: ListSimuladores,
    },
  ],
  mode: "history",
});
