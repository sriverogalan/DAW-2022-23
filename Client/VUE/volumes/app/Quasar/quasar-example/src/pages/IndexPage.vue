<template>
  <q-page class="flex flex-center">
    <img
      alt="Quasar logo"
      src="~assets/quasar-logo-vertical.svg"
      style="width: 200px; height: 200px"
    />
    <p>{{ date }}</p>
    <q-date
      v-model="date"
      :landscape="false"
      title="AniversariSergi"
      mask="YYYY/MM/DD"
      first-day-of-week="1"
      color="purple-6"
      multiple
    />
  </q-page> 

  <div class="q-pa-md">
    <q-table title="Sa meva tauleta" :rows="files" :columns="columnes" row-key="name" />
  </div>
</template>

<script>
import { defineComponent, ref } from "vue";

export default defineComponent({
  name: "IndexPage",
  data() {
    return {
      date: ref("2002/11/19"),
      columnes: [
        { name: "nom", label: "nom", field: "nom", sortable: true },
        { name: "cognoms", label: "cognoms", field: "cognoms", sortable: true },
      ],
      files: [],
    };
  },
  methods: {
    async loadUsuaris() {
      const usuaris = await this.$axios.get(
        "https://theteacher.codiblau.com/exercicis/other/usuaris/list"
      );
      this.files = usuaris.data.map((u) => {
        return {
          nom: u.nom,
          cognoms: u.cognom1 + " " + u.cognom2,
        };
      });
    },
  },
  mounted() {
    this.loadUsuaris();
  },
});
</script>
