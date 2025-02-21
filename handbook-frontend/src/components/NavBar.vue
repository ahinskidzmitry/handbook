<template>
  <nav class="navbar">
    <router-link to="/employees">Employees</router-link>
    <router-link to="/professions">Professions</router-link>
    <router-link to="/departments">Departments</router-link>
  </nav>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'NavBar'
});
</script>

<style scoped>
.navbar {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  background-color: #333;
  color: white;
  padding: 10px;
  display: flex;
  justify-content: space-around;
  z-index: 1000;
}

.navbar a {
  color: white;
  text-decoration: none;
  padding: 10px 15px;
}

.navbar a:hover {
  background-color: #555;
}
</style>