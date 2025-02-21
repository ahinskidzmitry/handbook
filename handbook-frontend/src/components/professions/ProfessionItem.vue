<template>
    <tr class="profession-item" @click="$emit('select', profession)">
        <td>{{ profession.name }}</td>
        <td>{{ profession.note }}</td>
    </tr>
</template>

<script lang="ts">
import { defineComponent, type PropType } from 'vue';
import type { Profession } from '../../models/Profession';

export default defineComponent({
    name: 'ProfessionItem',
    props: {
        profession: {
            type: Object as PropType<Profession>,
            required: true
        }
    }
})
</script>

<style scoped>
.profession-item {
    text-align: center;
}

.profession-item:hover {
    background-color: #333;
    cursor: pointer;
}

.profession-item td {
    padding: 10px 0;
    font-size: 20px;
    border: 2px solid white;
    border-spacing: 0;
}
</style>