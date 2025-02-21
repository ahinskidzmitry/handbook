<template>
    <div class="department-table">
        <table>
            <thead>
                <tr>
                    <th>Наименование</th>
                    <th>Примечание</th>
                </tr>
            </thead>
            <tbody>
                <DepartmentItem v-for="department in departments" :key="department.id" :department="department"
                    :depth="0" @select="selectDepartment" />
            </tbody>
        </table>
    </div>
</template>

<script lang="ts">
import { defineComponent, type PropType } from 'vue';
import type { Department } from '../../models/Department';
import DepartmentItem from './DepartmentItem.vue';

export default defineComponent({
    name: 'DepartmentTable',
    components: {
        DepartmentItem
    },
    props: {
        departments: {
            type: Object as PropType<Department[]>,
            required: true
        }
    },
    methods: {
        selectDepartment(department: Department) {
            this.$emit('select', department);
        }
    }
});
</script>

<style scoped>
.department-table {
    display: flex;
    flex-direction: column;
    color: white;
    padding: 0 10%;
}

.department-table table {
    width: 100%;
    margin-bottom: 20px;
    border: 2px solid white;
    border-collapse: collapse;
}

.department-table th {
    font-weight: bold;
    padding: 15px 0;
    border: 2px solid white;
}
</style>