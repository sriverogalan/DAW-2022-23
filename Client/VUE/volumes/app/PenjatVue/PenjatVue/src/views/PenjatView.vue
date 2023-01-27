<template>
  <h1>{{ resultat }}</h1>
  <div>
    <img :src="`${path}${vides}${extension}`" alt="mi imagen" />
  </div>
  <div id="paraula">
    <button @click="init()" id="jugar">Jugar</button>
    <p>{{ paraula }}</p>
  </div>
  <div id="juego">
    <Lletres v-for="ll in abecedari">
      <Lletra
        class="lletra"
        :id="ll"
        :lletra="ll"
        @jugar="comprobarLletra(ll)"
        disabled
        >{{ ll }}</Lletra
      >
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
      lletresSeleccionades: [],
      paraula: "",
      encriptada: "",
      paraules: ["windows", "linux", "mac"],
      vides: 1,
      videsMax: 7,
      resultat: "",
      pathSelected: "",
      path: "/img/",
      extension: ".PNG",
    };
  },
  components: {
    Lletres,
    Lletra,
  },
  methods: {
    init() {
      this.reset();
      this.encriptada = this.paraulaAleatoria();
      this.encriptada = this.encriptada.toLowerCase();
      this.paraula = this.encriptada
        .split("")
        .map((l) => (l === " " ? " " : " __ "))
        .join("");
      this.resultat = "";
      this.abecedari.split("").forEach((lletra) => {
        document.querySelector("#" + lletra).disabled = false;
      });
    },
    paraulaAleatoria() {
      return this.paraules[
        Math.floor(Math.random() * this.paraules.length)
      ].toUpperCase();
    },
    comprobarLletra(lletra) {
      if (this.encriptada.includes(lletra)) {
        this.lletresSeleccionades.push(lletra);
        document.querySelector("#" + lletra).disabled = true;
        document.querySelector("#" + lletra).style.backgroundColor = "green";
      } else {
        this.vides++;
        document.querySelector("#" + lletra).disabled = true;
        document.querySelector("#" + lletra).style.backgroundColor = "red";
      }
      this.jugar();
    },
    jugar() {
      this.paraula = this.encriptada
        .split("")
        .map((l) => (this.lletresSeleccionades.includes(l) ? l : " __ "))
        .join("");
      this.pintaSiGuanya();
    },
    pintaSiGuanya() {
      if (this.vides === this.videsMax) {
        this.resultat = "Has perdido";
        this.allDisabled();
      }
      if (this.paraula === this.encriptada) {
        this.resultat = "Has ganado";
        this.allDisabled();
      }
    },
    allDisabled() {
      this.abecedari.split("").forEach((lletra) => {
        document.querySelector("#" + lletra).disabled = true;
      });
    },
    reset() {
      this.vides = 1;
      this.lletresSeleccionades = [];
      this.abecedari.split("").forEach((lletra) => {
        document.querySelector("#" + lletra).disabled = false;
        document.querySelector("#" + lletra).style.backgroundColor = "#4CAF50";
      });
    },
  },
};
</script>

<style scoped>
.lletra {
  background-color: #4caf50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.lletra:hover {
  background-color: #ffb370;
}

#jugar {
  background-color: #4caf50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

h1 {
  color: rgb(255, 131, 131);
}

#paraula {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  align-content: center;
}

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

img {
  border: red solid 3px;
}
p {
  text-align: center;
}
h1 {
  text-align: center;
}
</style>
