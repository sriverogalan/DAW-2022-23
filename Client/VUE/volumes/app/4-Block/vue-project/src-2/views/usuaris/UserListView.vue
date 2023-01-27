<template lang="">
    <RouterLink to="form">Form</RouterLink>
    <h2 v-if="idusuari">
        usuaris {{ idusuari }} carregat</h2>
    <h3 v-if="displaySubjects"> Asignatura </h3>


    <h1>
        Llistat d'usuaris
    </h1>
</template>
<script>

export default {
    name: "UserListView",
    data() {
        return {
            idusuari: 0,
            displaySubjects: false,
            subjects: []
        }
    }
    
}
</script>
<style lang="" scoped>
    
</style>