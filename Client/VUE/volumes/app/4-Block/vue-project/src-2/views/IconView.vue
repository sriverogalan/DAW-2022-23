<template>
  <input type="text" v-model="cerca" @input="filtreUsuaris" />
  <button @click="cercar">Cerca</button>
  <h2 :class="{ error: !svg.label }">{{ svg.label }}</h2>
  <div v-if="!message">
    <svg :width="svg.width" :height="svg.height">
      <path :d="svg.path"></path>
    </svg>
  </div>

  <Taula :nom="' Taula ' + message" :usuaris="usuarisFilter" />
  <Taula :nom="`Taula 2 ${message}`" :usuaris="usuarisFilter" />

  <Taula nom="Taula de prova">
    <Fila>
      <Columna :is-header="true">Nom</Columna>
      <Columna 
      :is-header="true" 
      :sortable="true"
      @sort-asc="ordenar('asc')"
      @sort-desc="ordenar('desc')"
      >Cognoms</Columna>
      <Columna :is-header="true">Edad</Columna>
    </Fila>
    <Fila>
      <Columna>Miquel</Columna>
      <Columna>Gaia</Columna>
      <Columna>124</Columna>
    </Fila>
    <Fila v-for="usuari in usuaris">
      <Columna>{{usuari.nom}}</Columna>
      <Columna>{{usuari.cognoms}}</Columna>
      <Columna>{{usuari.id}}</Columna>
    </Fila> 
  </Taula>

  <button @click="loadUsuaris">Load usuaris</button>
</template>


<script>
import Taula from "@/components/taula/Taula.vue";
import Fila from "@/components/taula/Fila.vue";
import Columna from "@/components/taula/Columna.vue";

export default {
  data() {
    return {
      svg: {},
      message: "",
      notroba: "no s'ha trobat",
      usuaris: [],
      usuarisFilter: [],
    };
  },
  components: { Taula, Fila, Columna },
  methods: {
    async cercar() {
      const cercaFetch = await fetch(
        `https://theteacher.codiblau.com/exercicis/other/icons/get?nom=${this.cerca}`
      );
      if (cercaFetch.status === 200) {
        this.svg = await cercaFetch.json();
        this.message = this.notroba;
      } else {
        this.message = await cercaFetch.text();
      }
    },
    async loadUsuaris() {
      const usuarisFetch = await fetch(
        `https://theteacher.codiblau.com/exercicis/other/usuaris/list`
      );
      const usuarisJson = await usuarisFetch.json();
      this.usuaris = usuarisJson.map((u) => {
        return {
          id: u.idusuari,
          nom: u.nom,
          cognoms: u.cognom1 + " " + u.cognom2,
        };
      });
      this.usuarisFilter = this.usuaris;
    },
    async filtreUsuaris() {
      this.usuarisFilter = this.usuaris.filter((u) => {
       return u.nom.toLowerCase().includes(this.cerca.toLowerCase()) || u.cognoms.toLowerCase().includes(this.cerca.toLowerCase())
      });
    },
    async ordenar(ordre){
      console.log(ordre)
      if(ordre==='asc'){
        this.usuaris.sort((a,b)=>a.cognoms.localeCompare(b.cognoms));
      } else{
        this.usuaris.sort((a,b)=>b.cognoms.localeCompare(a.cognoms));
      }
    }
  },
};
</script>

<style scoped >
.error {
  color: red;
}
</style>