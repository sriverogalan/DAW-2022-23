<template lang=""> 
    <h1>
        Formulari d'usuari
    </h1>
    <h1 v-if="idusuari">
        usuaris {{ idusuari }} carregat
    </h1>
    <h3 v-if="displaySubjects"> Te sujetos </h3>
</template>
<script>
export default {
    name: "UserFormView",
    data(){
        return{
            idusuari:null,
            displaySubjects: false,
        }
    },
    created(){
        // created es un hook de vue que se ejecuta cuando se crea el componente
        if (this.$route.params.idusuari){
            this.idusuari = this.$route.params.idusuari;
        }

        this.init();
    },
    methods:{
         init() {
            const paramDisplay = this.$route.query.displayzubjects;
            console.log( this.$route.query)
            if (paramDisplay){
                this.displaySubjects = paramDisplay === 'true';
            }
        }
    },
    
}
</script>
<style lang="" scoped>
    
</style>