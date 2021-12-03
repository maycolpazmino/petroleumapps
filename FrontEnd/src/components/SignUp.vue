<template>
  <div class="signUp_user">
    <div class="container_signUp_user">
      <p></p>
      <h2>Sign Up</h2>

      <form v-on:submit.prevent="processSignUp">
        <input type="text" v-model="user.username" placeholder="Username" />
        <br />

        <input
          type="email"
          v-model="user.emailEstudiante"
          placeholder="Email"
        />
        <br />

        <input type="password" v-model="user.password" placeholder="Password" />
        <br />

        <input
          type="text"
          v-model="user.nombresEstudiante"
          placeholder="First name"
        />
        <br />

        <input
          type="text"
          v-model="user.apellidosEstudiante"
          placeholder="Last name"
        />
        <br />

        <button type="submit">Sign Up</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import swal from "sweetalert";

export default {
  name: "SignUp",

  data: function() {
    return {
      user: {
        username: "",
        emailEstudiante: "",
        password: "",
        nombresEstudiante: "",
        apellidosEstudiante: "",
      },
    };
  },

  methods: {
    processSignUp: function() {
      axios
        .post(
          "https://simuladoresbe.herokuapp.com/users/usuarios/",
          this.user,
          {
            headers: {},
          }
        )
        .then((result) => {
          let dataSignUp = {
            username: this.user.username,
            token_access: result.data.access,
            token_refresh: result.data.refresh,
          };

          this.$emit("completedSignUp", dataSignUp);
        })
        .catch((error) => {
          swal("La tutoria no fue agendada!", "", "error");
        });
    },
  },
};
</script>

<style>
.signUp_user {
  margin: 0;
  padding: 0%;
  height: 100%;
  width: 100%;

  display: flex;
  justify-content: center;
  align-items: center;
}

.container_signUp_user {
  border: 3px solid #283747;
  border-radius: 15px;
  width: 25%;
  height: 90%;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.signUp_user h2 {
  color: #283747;
}

.signUp_user form {
  width: 70%;
}

.signUp_user input {
  height: 35px;
  width: 100%;

  box-sizing: border-box;
  padding: 10px 20px;
  margin: 5px 0;

  border: 1px solid #283747;
}

.signUp_user button {
  width: 100%;
  height: 40px;

  color: #e5e7e9;
  background: #283747;
  border: 1px solid #e5e7e9;

  border-radius: 5px;
  padding: 10px 25px;
  margin: 5px 0 25px 0;
}

.signUp_user button:hover {
  color: #e5e7e9;
  background: crimson;
  border: 1px solid #283747;
}
</style>
