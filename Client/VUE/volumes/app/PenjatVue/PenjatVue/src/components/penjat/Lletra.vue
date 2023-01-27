<template>
  <button @click="jugar()">
    <slot></slot>
  </button>
</template>

<script>
export default {
  name: "Lletra",
  props: {
    //Propiedades que se le pasan al componente booleano, string, array, etc
    lletra: {
      type: String,
      required: true,
    },
    methods:{
        
    }
  },
};
</script>

<style lang="scss" scoped></style>
