<template>
    <tr class="department-item" @click="$emit('select', department)">
        <td class="department-name" v-html="prepareIndent(depth) + department.name"></td>
        <td class="department-note">{{ department.note }}</td>
    </tr>
    <DepartmentItem v-for="child in department.children" :key="child.id" :department="child" :depth="depth + 1"
        @select="selectDepartment" />
</template>

<script lang="ts">
import { defineComponent, type PropType } from 'vue';
import type { Department } from '../../models/Department';

export default defineComponent({
    name: 'DepartmentItem',
    props: {
        department: {
            type: Object as PropType<Department>,
            required: true
        },
        depth: {
            type: Number,
            required: true
        }
    },
    emits: ['select'],
    methods: {
        selectDepartment(department: Department) {
            this.$emit('select', department);
        },

        prepareIndent(depth: number) {
            return '&nbsp;'.repeat(depth * 4) + '— ';
        }
    }
})
</script>

<style scoped>
.department-item {
    margin: 15px 15px;
}

.department-name {
    padding-left: 100px;
}

.department-note {
    text-align: center;
}

.department-item:hover {
    background-color: #333;
    cursor: pointer;
}

.department-item td {
    padding: 10px 0;
    font-size: 20px;
    border: 2px solid white;
    border-spacing: 0;
}
</style>