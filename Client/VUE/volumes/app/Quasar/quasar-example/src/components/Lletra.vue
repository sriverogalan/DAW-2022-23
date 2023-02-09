<template>
  <q-btn round :color="color" :label="valor" size="md" class="q-ma-xs"> </q-btn>
</template>

<script>
export default {
  name: "Lletra",
  props: {
    valor: {
      type: String,
      required: true,
    },
    color: {
      type: String,
      required: true,
    },
  },
  methods: {
    get() {
      this.$emit("calcularColor", this.valor);
    },
  },
};
</script>
