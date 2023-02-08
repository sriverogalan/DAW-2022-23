<template>
  <h1>Penjat</h1>
  <div class="paraules">
    <span v-for="ll of paraulaEncriptada" class="text-center">&nbsp;{{ ll }}&nbsp;</span>
    <span class="text-center">{{ paraula }}</span>
  </div>
  <div class="lletres">
    <Lletra v-for="lletra in lletres" :valor="lletra" @click="jugar(lletra)" />
  </div>
</template>

<script>
import { defineComponent } from "vue";
import Lletra from "../components/Lletra.vue";

export default defineComponent({
  name: "Penjat",
  components: {
    Lletra,
  },
  data() {
    return {
      lletres: [],
      paraula: "",
      paraulaEncriptada: "",
    };
  },
  created() {
    this.lletres = "abcdefghijklmnopqrstuvwxyz".split("");

    const paraules = [];
    paraules.push("javascript");
    paraules.push("typescript");
    paraules.push("java");
    paraules.push("python");
    paraules.push("c");
    paraules.push("go");
    this.paraula = paraules[Math.floor(Math.random() * paraules.length)];

    this.paraulaEncriptada = this.paraula.split("").map((lletra) => {
      return "_";
    });
  },
  methods: {
    isCorrect() {
      return this.paraula === this.paraulaEncriptada.join("");
    },
    jugar(lletra) {
      if (this.paraula.includes(lletra)) {
        for (let i = 0; i < this.paraula.length; i++) {
          if (this.paraula[i] === lletra) {
            this.paraulaEncriptada[i] = lletra;
          }
        }
      }
    },
  },
});
</script>

<style scoped>
h1 {
  text-align: center;
}
.lletres {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
.paraules{
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
}
</style>
