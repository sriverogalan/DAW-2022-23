<template>
    <h1>Formulari usuaris</h1>
    <h2 v-if="idusuari">Usuari {{ idusuari }} carregat</h2>

    <h3 v-if="displaySubjects">Mostrant asignatura {{ displaySubjects }} </h3>

    <button @click="save">Desar Usuari</button>

</template>

<script>

import axios from 'axios';


export default {
    name: "UsuariFormView",

    data() {
        return {
            idusuari: '',
            displaySubjects: false
        }
    },

    methods: {
        created() {
            const paramId = this.$route.params.idusuari;

            //url: http://localhost:8080/usuaris/1
            if (this.$route.params.idusuari) {
                this.idusuari = paramId;
            }

            //url: http://localhost:8080/usuaris/1?displaySubjects=1
            const paramDisplaySubjects = this.$route.query.displaySubjects;
            if (paramDisplaySubjects) {
                this.displaySubjects = paramDisplaySubjects === "true"
            }
        },

        async save() {
            //desar usuari
            //en acabar redirigir a llistat


            // Add a request interceptor
            axios.interceptors.request.use(function (config) {
                console.log("Request",config);
                //Afegir un header authorization amb el token amb nom Authorization

                config.headers.Authorization = 'token1234';

                return config;
            }, function (error) {
                // Do something with request error
                return Promise.reject(error);
            });

            // Add a response interceptor
            axios.interceptors.response.use(function (response) {
                console.log("Response",response);
                if (response.status === 400) {
                    alert("Error");
                }
                return response;
            }, function (error) {
                // Any status codes that falls outside the range of 2xx cause this function to trigger
                // Do something with response error
                return Promise.reject(error);
            });


            const peticio = await axios.get('https://theteacher.codiblau.com/exercicis/other/color?min=100&max=500');
            console.log(peticio.status, peticio.data);

            //redirecciona a /usuaris/llistat
            this.$router.push('/usuaris/llistat');
        }
    },
}
</script>

<style lang="scss" scoped>

</style>