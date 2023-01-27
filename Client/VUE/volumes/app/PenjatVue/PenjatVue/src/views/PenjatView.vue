<template>
  <h1>{{resultat}}</h1>
  <div id="juego">
    <img src="pathSelected" alt="mi imagen" /> 
      <p>{{ paraulaSeleccionada }}</p> 
      <Lletres v-for="ll in abecedari">
        <Lletra>{{ ll }}</Lletra>
      </Lletres> 
  </div> 
</template>

<script>
import Lletra from "@/components/penjat/Lletra.vue";
import Lletres from "@/components/penjat/Lletres.vue";
 

export default {
  name: "PenjatView",
  data() {
    return {
      abecedari: "abcdefghijklmnopqrstuvwxyzñçáàéèíóòú",
      lletres: [],
      paraula: "",
      paraulaSeleccionada: "",
      paraules: ["windows", "linux", "mac"],
      vides: 1,
      videsMax: 7,
      resultat: "",
      pathSelected: "",
      path: [
        "../assets/img/1.PNG",
        "../assets/img/2.PNG",
        "../assets/img/3.PNG",
        "../assets/img/4.PNG",
        "../assets/img/5.PNG",
        "../assets/img/6.PNG",
        "../assets/img/7.PNG",
      ],
      extension: ".PNG",
    };
  },
  components: {
    Lletres,
    Lletra,
  },
  methods: {
    init() {
      this.paraulaSeleccionada = this.paraula;
      this.paraula = "";
      for (let i = 0; i < this.paraulaSeleccionada.length; i++) {
        this.paraula += " __ ";
      }
      this.pathSelected = this.path[0];
    },  
  },
};
</script>

<style scoped>
#lletres {
  width: 100%;
  height: 100%;
  object-fit: cover;
  position: absolute;
  top: 0;
  left: 0;
  z-index: -1;
}
div {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  align-content: center;
}

img{
  border: red solid 3px;

}
</style>
