<template>
  <h1>{{ nom }}</h1>
  <table>
    <slot> </slot>
    <!--
    <tr>
      <th>Nom <button>Asc</button><button>Desc</button></th>
      <th>Cognoms <button @click="ordena('asc')">Asc</button><button @click="ordena('desc')">Desc</button></th>
    </tr>
    <tr v-for="u in usuaris">
      <Columna>{{ u.nom }}</Columna>
      <Columna>{{ u.cognoms }}</Columna>
    </tr>-->
  </table>
</template>

<script>
export default {
  name: "Taula",
  props: {
    nom: {
      type: String,
      required: true,
    },
    usuaris: {
      type: Array,
      required: true,
    },
  },
  methods:{
    ordena(ordre){
      if(ordre==='asc'){
        this.usuaris.sort((a,b)=>a.cognoms.localeCompare(b.cognoms));
      } else{
        this.usuaris.sort((a,b)=>b.cognoms.localeCompare(a.cognoms));
      }
    }
  }
};
</script>

<style>
table {
  border: solid 1px red;
}
</style>