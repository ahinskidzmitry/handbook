<template>
    <select v-model="department.parentId">
        <option :value="undefined">Выберите родительский отдел</option>
        <option v-for="dept in departments" :value="dept.id">{{ dept.name }}</option>
    </select>
</template>

<script lang="ts">
import { defineComponent, type PropType } from 'vue';
import type { Department } from '../../models/Department';

export default defineComponent({
    name: 'Dropdown',
    props: {
        departments: {
            type: Object as PropType<Department[]>,
            required: true
        },
        department: {
            type: Object as PropType<Department>,
            required: true
        }
    },
});
</script>

<style scoped>
select {
    width: 100%;
    padding: 8px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color: #fff;
    cursor: pointer;
    margin-bottom: 15px;
}

select:focus {
    outline: none;
    border-color: #007bff;
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}
</style>