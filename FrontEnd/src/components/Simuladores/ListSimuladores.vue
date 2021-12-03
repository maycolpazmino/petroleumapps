<template lang="html">
  <div class="container">
    <div class="row">
      <div class="col text-left">
        <div class="">
          <p></p>
          <h2>Available Apps</h2>
        </div>

         <b-row class="mt-4">
            <b-col cols="12" md="3">
               <b-card
               img-src="https://petroleumapp.000webhostapp.com/aplications/GeoMaster2.jpeg"
               img-alt="Card image"
               img-top
               >
               <b-card-text>
                  PVTPEDIA
               </b-card-text>

               <b-button
                  href="https://petroleumapp.000webhostapp.com/aplications/GeoMaster.jar"
                  variant="dark"
                  >Download Application</b-button
               >
               </b-card>
            </b-col>

            <b-col cols="12" md="3">
               <b-card
               img-src="https://petroleumapp.000webhostapp.com/aplications/PVTpedia.jpeg"
               img-alt="Card image"
               img-top
               >
               <b-card-text>
                  GeoMaster Academic
               </b-card-text>

               <b-button
                  href="https://petroleumapp.000webhostapp.com/aplications/Simuladores.jar"
                  variant="dark"
                  >Download Application</b-button
               >
               </b-card>
            </b-col>
         </b-row>
        </br>
        <b-button :to="{ name: 'home' }" variant="primary">Return</b-button>
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
        { key: "nombre", label: "Nombre Simulador" },
        { key: "descripcion", label: "Descripción" },
        { key: "simulador", label: "Simulador" },
      ],
      tutorias: [],
    };
  },

  methods: {
    getSimuladores() {
      const path = "https://simuladoresbe.herokuapp.com/users/simuladores/";
      axios
        .get(path)
        .then((response) => {
          this.tutorias = response.data;
        })
        .catch((error) => {
          swal("", "", "error");
        });
    },
  },
  created() {
    this.getSimuladores();
  },
};
</script>
<style lang="css" scoped></style>
