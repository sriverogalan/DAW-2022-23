<template>
  <h1>Penjat</h1>
  <div class="col-sm-12 text-center">
    <Imatge :path="`penjat/${errors + 1}.PNG`">
      <template v-slot:titol>
        <h1>Penjat v2.0</h1>
      </template>
      <template v-slot:default>
        <div class="absolute-bottom text-subtitle1 text-center">{{ missatge }}</div>
      </template>
    </Imatge>
  </div>
  <div class="paraules">
    <span v-for="ll of paraulaEncriptada" class="text-center">&nbsp;{{ ll }}&nbsp;</span>
  </div>
  <div class="lletres">
    <Lletra
      v-for="lletra in lletres"
      :valor="lletra"
      :color="getColor(lletra)"
      @click="jugar(lletra)"
    />
  </div>
</template>

<script>
import { defineComponent } from "vue";
import Imatge from "../components/Imatge.vue";
import Lletra from "../components/Lletra.vue";

const MAX_ERRORS = 6;

export default defineComponent({
  name: "Penjat",
  components: {
    Lletra,
    Imatge,
  },
  data() {
    return {
      lletres: [],
      lletresEmprades: [],
      paraula: "",
      paraulaEncriptada: "",
      errors: 0,
      missatge: "",
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

    this.missatge = "Te queden " + MAX_ERRORS + " intents";
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
      } else {
        this.errors++;
        this.missatge = "Te queden " + (MAX_ERRORS - this.errors) + " intents";
        if (this.errors === MAX_ERRORS) {
          this.missatge = "Has perdut";
          this.lletres = [];
        }
      }
    
      if (win()) {
        this.missatge = "Has guanyat";
        this.lletres = [];
        document.querySelector(".paraules").style.color = "green";
      }

      this.lletresEmprades.push(lletra);
    },
    getColor(lletra) {
      if (this.lletresEmprades.includes(lletra)) {
        if (this.paraulaEncriptada.includes(lletra)) {
          return "green";
        }
        return "red";
      }
      return "primary";
    },
    win(){
      if (this.paraulaEncriptada.includes(this.lletresEmprades)){
        return true;
      } 
      return false;
    }
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
.paraules {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.green {
  background-color: green;

}
</style>
