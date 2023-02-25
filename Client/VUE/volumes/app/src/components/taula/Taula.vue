<template>
    <h1>{{ nom }}</h1>
    <table>
        <slot></slot>
        <!-- <tr>
            <th>Nom <button>Asc</button> <button>Desc</button></th>
            <th>Cognoms <button @click="ordena('asc')">Asc</button> <button @click="ordena('desc')">Desc</button></th>

        </tr>
        <tr v-for="u in usuaris">
            <th>{{ u.nom }}</th>
            <th>{{ u.cognoms }}</th>
        </tr> -->
    </table>
</template>

<script>

export default {
    name: "Taula",
    props: {
        nom: { //Aqui se le pasa el nombre de la tabla y debe ser un string
            type: String,
            required: true,
        },

        usuaris: {
            type: Array,
            required: false,
        },

        ordenacio:{
            type: Function,
            required: false
        }
    },

    methods: {
        ordena(ordre) {

            if (ordre === 'asc') {
                this.usuaris.sort((a,b) => a.cognoms.localeCompare(b.cognoms))
            }else this.usuaris.sort((a,b) => b.cognoms.localeCompare(a.cognoms))
        }
    }
}

</script>

<style scoped>

table {
    border: solid 1px red;
    text-align: left;
}

table th {
    text-transform: uppercase;
}

table td {
    color: blue;
}
</style>