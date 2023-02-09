<template>
  <header>
    <slot name="titol" />
  </header>
  <q-img :src="path" fit="contain" width="360px">
    <slot />
  </q-img>
</template>

<script>
export default {
  name: "Lletra",
  props: {
    path: {
      type: String,
      required: true,
    },
  },
  methods: {},
};
</script>

<style></style>
