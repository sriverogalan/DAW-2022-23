<template>
    <td v-if="!this.isHeader">
        <slot></slot>
    </td>

    <th v-if="this.isHeader">
        <slot></slot>
        <button v-if="sorteable" @click="sortBy('asc')">Asc</button>
        <button v-if="sorteable" @click="sortBy('desc')" >Desc</button>
</th>
</template>

<script>

export default {

    name: "Columna",
    props: { //Propiedades que se le pasan al componente booleano, string, array, etc
        isHeader: {
            type: Boolean,
            required: false,
            default: false
        },
        sorteable:{
            type: Boolean,
            required: false,
        }
    },

    methods:{
        sortBy(type) {

            if(type==='asc'){
                this.$emit('sortAsc');
            } else this.$emit('sortDesc');
        }
    }

}
</script>

<style scoped>

</style>
