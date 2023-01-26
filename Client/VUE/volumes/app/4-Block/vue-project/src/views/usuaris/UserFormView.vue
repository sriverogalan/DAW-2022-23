<template lang="">
  <h1> Formulari d'usuari </h1> <h1 v-if="idusuari"> usuaris {{ idusuari }} carregat </h1>
  <button @click="save">Guardar</button>
  <router-link :to="{ name: 'UserListView' }">Tornar</router-link>
</template>
<script>
import axios from 'axios';
export default {
  name: "UserFormView",
  data() {
    return {
      idusuari: null,
      displaySubjects: false,
      paramId: null,
    };
  },
  created() {
    // created es un hook de vue que se ejecuta cuando se crea el componente
    if (this.$route.params.idusuari) {
      this.idusuari = this.$route.params.idusuari;
    }

    this.init();
  },
  methods: {
    init() {
      const paramId = this.$route.params.idusuari;
      if (paramId) {
        this.paramId = paramId;
      }
      const paramDisplay = this.$route.query.display;
      if (paramDisplay) {
        this.displaySubjects = paramDisplay === "subjects";
      }
    },
    async save() {
      axios.interceptors.request.use(
        function (config) { 
          config.headers.Authorization = "token1234";
          return config;
        },
        function (error) {
          // Do something with request error
          return Promise.reject(error);
        }
      );

      // Add a response interceptor
      axios.interceptors.response.use(
        function (response) {
          console.log(config);
          if (response.status === 200) {
            console.log("OK");
          } else {
            alert("Error")
          }
          return response;
        },
        function (error) {
          // Any status codes that falls outside the range of c cause this function to trigger
          // Do something with response error
          return Promise.reject(error);
        }
      );

      const peticio = await axios.get(
        "https://theteacher.codiblau.com/exercicis/other/color?min=24&max=244"
      );
      console.log(peticio.status, peticio.data.color);
    },
  },
};
</script>
<style lang="" scoped></style>
