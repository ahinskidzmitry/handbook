<template>
    <tr class="employee-item" @click="$emit('select', employee)">
        <td>{{ employee.name }}</td>
        <td>{{ employee.profession.name }}</td>
        <td>{{ employee.department.name }}</td>
        <td>{{ employee.note }}</td>
    </tr>
</template>

<script lang="ts">
import { defineComponent, type PropType } from 'vue';
import type { Employee } from '../../models/Employee';

export default defineComponent({
    name: 'EmployeeItem',
    props: {
        employee: {
            type: Object as PropType<Employee>,
            required: true
        }
    }
})
</script>

<style scoped>
.employee-item {
    text-align: center;
}

.employee-item:hover {
    background-color: #333;
    cursor: pointer;
}

.employee-item td {
    padding: 10px 0;
    font-size: 20px;
    border: 2px solid white;
    border-spacing: 0;
}
</style>