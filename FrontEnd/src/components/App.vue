<template>
  <div id="app" class="app">
    <div class="header">
      <h1>Petroleum Apps</h1>
      <nav>
        <button style="margin: 5px" v-if="is_auth" v-on:click="loadHome">
          Home
        </button>
        <button style="margin: 5px" v-if="is_auth" v-on:click="loadSimuladores">
          Applications
        </button>
        <button style="margin: 5px" v-if="is_auth" v-on:click="logOut">
          Sign Out
        </button>
        <button style="margin: 5px" v-if="!is_auth" v-on:click="loadLogIn">
          Log In
        </button>
        <button style="margin: 5px" v-if="!is_auth" v-on:click="loadSignUp">
          Sign Up
        </button>
      </nav>
    </div>

    <div class="main-component">
      <router-view
        v-on:completedLogIn="completedLogIn"
        v-on:completedSignUp="completedSignUp"
        v-on:logOut="logOut"
      >
      </router-view>
    </div>

    <div class="footer">
      <h2>
        Contact:
        <br />
        mepazmino@alumnoeseit.edu.co
        <br />
        Phone: 314-340-6491
        <br />
        Petroleum Apps<br />Copyright © 2021
      </h2>
    </div>
  </div>
</template>

<script>
import swal from "sweetalert";
export default {
  name: "App",

  data: function() {
    return {
      is_auth: false,
    };
  },

  components: {},

  methods: {
    verifyAuth: function() {
      this.is_auth = localStorage.getItem("isAuth") || false;

      if (this.is_auth == false) this.$router.push({ name: "logIn" });
      else this.$router.push({ name: "home" });
    },

    loadLogIn: function() {
      this.$router.push({ name: "logIn" });
    },

    loadSignUp: function() {
      this.$router.push({ name: "signUp" });
    },

    completedLogIn: function(data) {
      localStorage.setItem("isAuth", true);
      localStorage.setItem("username", data.username); // venia por defecto

      localStorage.setItem("token_access", data.token_access);
      localStorage.setItem("token_refresh", data.token_refresh);
      swal("¡Successful authentication!", "", "success");
      this.verifyAuth();
    },

    completedSignUp: function(data) {
      swal("Successful Signup", "", "success");
      this.completedLogIn(data);
    },

    loadHome: function() {
      this.$router.push({ name: "home" });
    },

    loadSimuladores: function() {
      this.$router.push({ name: "ListSimuladores" });
    },

    logOut: function() {
      localStorage.clear();
      swal({
        title: "Session Closed!",
        text: "Come back soon!",
      });
      this.verifyAuth();
    },
  },

  created: function() {
    this.verifyAuth();
  },
};
</script>

<style>
body {
  margin: 0 0 0 0;
}

.header {
  margin: 0%;
  padding: 35px;
  width: 100%;
  height: 8vh;
  min-height: 80px;

  background-color: #283747;
  color: #e5e7e9;

  display: flex;
  justify-content: space-between;
  align-items: center;
}

.header h1 {
  width: 40%;
  text-align: center;
}

.header nav {
  height: 60%;
  width: 25%;

  display: flex;
  align-items: center;

  font-size: 15px;
}

.header nav button {
  color: #e5e7e9;
  background: #283747;
  border: 2px solid #e5e7e9;

  border-radius: 5px;
  padding: 5px 10px;
}

.header nav button:hover {
  color: #283747;
  background: #e5e7e9;
  border: 2px solid #e5e7e9;
}

.main-component {
  height: 70vh;
  margin: 0%;
  padding: 0%;

  background: #fdfefe;
}

.footer {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 18vh;
  min-height: 0px;

  background-color: #283747;
  color: #e5e7e9;
}

.footer h2 {
  width: 100%;
  height: 100%;

  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 13px;
  text-align: center;
}
</style>
