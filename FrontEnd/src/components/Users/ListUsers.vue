<template lang="html">
  <div class="container">
    <div class="row">
      <div class="col text-left">
        <div class="">
          <p></p>
          <h2>Usuarios Registrados</h2>
          <p></p>
        </div>
        <div class="col-md-12">
          <b-table striped hover :items="usuarios" :fields="fields"> </b-table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import swal from "sweetalert";

export default {
  data() {
    return {
      fields: [
        { key: "nombresEstudiante", label: "Nombres" },
        { key: "apellidosEstudiante", label: "Apellidos" },
        { key: "username", label: "Username" },
        { key: "emailEstudiante", label: "Email" },
      ],
      usuarios: [],
    };
  },

  methods: {
    getUsers() {
      const path = "https://innovalau-be.herokuapp.com/users/";
      axios
        .get(path)
        .then((response) => {
          this.usuarios = response.data;
        })
        .catch((error) => {
          swal("", "", "error");
        });
    },
  },
  created() {
    this.getUsers();
  },
};
</script>
<style lang="css" scoped></style>
