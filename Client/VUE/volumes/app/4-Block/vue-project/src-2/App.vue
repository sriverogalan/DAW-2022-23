<script setup>
import { RouterLink, RouterView } from "vue-router";
</script>

<template>   
    <div id="app"> 
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/login">Login</RouterLink>
        <RouterLink to="/about">About</RouterLink>
        <RouterLink to="/icon">Icons</RouterLink>
        <RouterLink to="/usuaris">Usuaris</RouterLink>
        <RouterLink to="/usuaris/llistat">Llistat</RouterLink>
        <RouterLink to="/usuaris/form">Form</RouterLink> 
    </div>
    <RouterView />
</template>

<style scoped>
</style>
