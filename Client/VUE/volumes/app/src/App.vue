<script setup>
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
</script>

<template>
  <header>
    <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />

      <nav>
        <RouterLink to="/">Home<br></RouterLink>
        <RouterLink to="/icon">Icons<br></RouterLink>
        <RouterLink to="/usuaris/llistat">Llistat<br></RouterLink>
        <RouterLink to="/usuaris/form">Formulari<br></RouterLink>

      </nav>
  </header>


  <main>
    <RouterView />
  </main>
</template>

<style scoped>

</style>
