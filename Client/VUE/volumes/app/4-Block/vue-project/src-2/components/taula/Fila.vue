<template>
  <tr>
    <slot> </slot></tr>
</template>

<script>
export default { 
  name: "Fila",
  props: {
    ordenacio: {
      type: Function,
      required: false,
    },
  },
}
</script>

<style> 
table th {
  text-transform: uppercase;
}

table td {
  color: blue;
}
</style>