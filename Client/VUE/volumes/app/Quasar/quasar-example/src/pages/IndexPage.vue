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
    <q-table
      title="Sa meva tauleta"
      :rows="usuarisFilter"
      :columns="columnes" row-key="name"
    >
      <template v-slot:top-right>
        <q-input
          color="purple-6"
          v-model="filter"
          rounded
          outlined
          @update:model-value="filtrar"
        >
          <template v-slot:prepend>
            <q-icon name="search" />
          </template>
          <template v-slot:append>
            <q-icon name="account_circle" />
          </template>
        </q-input>
      </template>

      <template v-slot:body-cell-sexe="props">
        <q-td>
          <q-icon v-if="props.value === 'HOME'" name="male"></q-icon>
          <q-icon v-if="props.value === 'DONA'" name="female"></q-icon>
        </q-td>
      </template>
    </q-table>
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
        { name: "nom", label: "nom", field: "nom", align: "center", sortable: true },
        {
          name: "cognoms",
          label: "cognoms",
          field: "cognoms",
          align: "center",
          sortable: true,
        },
        { name: "sexe", label: "sexe", field: "sexe", align: "center", sortable: true },
      ],
      usuaris: [],
      usuarisFilter: [],
      filter: "",
    };
  },
  methods: {
    async loadUsuaris() {
      const usuaris = await this.$axios.get(
        "https://theteacher.codiblau.com/exercicis/other/usuaris/list"
      );
      this.usuaris = usuaris.data.map((u) => {
        return {
          nom: u.nom,
          cognoms: u.cognom1 + " " + u.cognom2,
          sexe: u.sexe,
        };
      });

      this.usuarisFilter = this.usuaris;
    },
    filtrar() {
      this.usuarisFilter = this.usuaris.filter((u) => {
        return (
          u.nom.toLowerCase().includes(this.filter.toLowerCase()) ||
          u.cognoms.toLowerCase().includes(this.filter.toLowerCase())
        );
      });
    },
  },
  mounted() {
    this.loadUsuaris();
  },
});
</script>
