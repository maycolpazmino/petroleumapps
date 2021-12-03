<template>
  <div class="greetings">
    <h1>
      Welcome <span> {{ username }} </span>!
      <p>
        If you are an ESEIT student, in this page you will find the project that
        seeks to create a conglomerate of applications about Petroleum
        Engineering, which are focused on reinforcing the knowledge acquired in
        the classroom and take it to didactic and practical applications for
        various branches of Petroleum Engineering.<br /><br />
      </p>
      <b-button
        href="https://javadl.oracle.com/webapps/download/AutoDL?BundleId=245448_4d5417147a92418ea8b615e228bb6935"
        variant="info"
        >Donwload Java JRE</b-button
      >
    </h1>
  </div>
</template>

<script>
export default {
  name: "Home",

  data: function() {
    return {
      username: localStorage.getItem("username") || "none",
    };
  },
};
</script>

<style>
.greetings {
  margin: 0;
  padding: 0%;
  height: 80%;
  width: 100%;

  display: flex;
  justify-content: center;
  align-items: center;
}

.greetings h1 {
  font-size: 50px;
  color: #283747;
  text-align: center;
  padding: 100px 20px 30px 20px;
}

.greetings p {
  font-size: 20px;
  text-align: justify;

  padding: 40px 100px 0px 100px;
}

.greetings span {
  color: #283747;
}
</style>
