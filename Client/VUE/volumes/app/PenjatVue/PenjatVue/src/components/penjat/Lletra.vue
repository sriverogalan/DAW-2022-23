<template>
  <button @click="jugar()">
    <slot></slot>
  </button>
</template>

<script>
export default {
  name: "Lletra",
  props: {
    lletra: String,
    required: true,
  },
  methods: {
    jugar() {
      this.$emit("jugar", this.lletra);
    },
  },
};
</script>

<style lang="scss" scoped></style>
