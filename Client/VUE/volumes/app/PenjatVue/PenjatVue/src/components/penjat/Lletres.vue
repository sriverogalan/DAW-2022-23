<template>
    <slot></slot>
</template>

<script>
    export default {
        name: "Lletres",
        props: {
            nom: {
                type: String,
                required: true,
            },
        },
        methods: {
            jugar() {
                this.$emit('jugar');
            }
        }
    }
</script>

<style scoped>
    slot{}
</style>