<template>
  <input type="text" v-model="cerca" />
      <button @click="cercar">Cerca</button>
      <h2 :class="{error:!svg.label}">{{ svg.label }}</h2>
      <div v-if="!message">
        <svg :width="svg.width" :height="svg.height">
          <path :d="svg.path"></path>
        </svg>
      </div>
</template>

<script>
export default {
  data() {
          return {
            svg: {},
            message: "",
            notroba: "no s'ha trobat",
          };
        },
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
        },
}
</script>

<style scoped > 
      .error {
        color: red;
      }
</style>