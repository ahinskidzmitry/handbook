<template>
  <div class="main">
    <NavBar />
    <router-view />
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import ProfessionTable from './components/professions/ProfessionTable.vue';
import NavBar from './components/NavBar.vue';

export default defineComponent({
  name: 'App',
  components: {
    ProfessionTable,
    NavBar
  }
});
</script>

<style scoped>
.main {
  width: 100%;
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
</style>
