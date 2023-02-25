<template>
<h1>Llistat d'usuaris</h1>
<RouterLink to="/usuaris/form">Formulari<br></RouterLink>

</template>

<script>
    export default {
        name: "UsuariListView",

        async created(){
            const peticio = await this.$axios.get('https://theteacher.codiblau.com/exercicis/other/color?min=100&max=500');
            console.log(peticio.status, peticio.data);
        }
    }
</script>

<style lang="scss" scoped>

</style>