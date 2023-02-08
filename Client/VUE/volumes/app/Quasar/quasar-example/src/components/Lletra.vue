<template>
  <!-- <button>{{ valor }}</button> -->
  <q-btn round color="purple" :label="valor" @click="get"> </q-btn>
</template>

<script>
export default {
  name: "Lletra",
  props: {
    valor: {
      type: String,
      required: true,
    },
    isCorrect: {
        type: String,
        required: true,
    }
  },
  methods:{
    get(){
        this.$emit('calcularColor', this.valor);
    }
  }
};
</script>
