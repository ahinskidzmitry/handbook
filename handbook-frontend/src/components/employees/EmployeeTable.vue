<template>
    <div class="employee-table">
        <table>
            <thead>
                <tr>
                    <th>ФИО</th>
                    <th>Профессия</th>
                    <th>Отдел</th>
                    <th>Примечание</th>
                </tr>
            </thead>
            <tbody>
                <EmployeeItem v-for="employee in employees" :key="employee.id" :employee="employee"
                    @select="selectEmployee" />
            </tbody>
        </table>
    </div>
</template>

<script lang="ts">
import { defineComponent, type PropType } from 'vue';
import type { Employee } from '../../models/Employee';
import EmployeeItem from './EmployeeItem.vue';

export default defineComponent({
    name: 'EmployeeTable',
    components: {
        EmployeeItem
    },
    props: {
        employees: {
            type: Object as PropType<Employee[]>,
            required: true
        }
    },
    methods: {
        selectEmployee(employee: Employee) {
            this.$emit('select', employee);
        }
    }
});
</script>

<style scoped>
.employee-table {
    display: flex;
    flex-direction: column;
    color: white;
    padding: 0 10%;
}

.employee-table table {
    width: 100%;
    margin-bottom: 20px;
    border: 2px solid white;
    border-collapse: collapse;
}

.employee-table th {
    font-weight: bold;
    padding: 15px 0;
    border: 2px solid white;
}
</style>