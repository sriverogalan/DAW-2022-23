<template>
  <td v-if="!isHeader"><slot></slot></td> 
  <th v-else>
    <slot></slot>
    <button v-if="sortable" @click="sortedBy('asc')">Sort</button>
    <button v-if="sortable" @click="sortedBy('desc')">Desc</button>
  </th> 
</template>

<script>
export default {
  name: "Columna",
  props: {
    sortable: {
      type: Boolean,
      required: false,
    },
    isHeader: {
      type: Boolean,
      required: false,
    }, 
  },
  methods: {
    sortedBy(type){
      if(type === 'asc'){
        this.$emit('sortAsc')
      } else{ 
        this.$emit('sortDesc')
      }
    }
  },
};
</script>

<style>
</style>