<template>
    <div class="profession-table">
        <table>
            <thead>
                <tr>
                    <th>Наименование</th>
                    <th>Примечание</th>
                </tr>
            </thead>
            <tbody>
                <ProfessionItem v-for="profession in professions" :key="profession.id" :profession="profession"
                    @select="selectProfession" />
            </tbody>
        </table>
    </div>
</template>

<script lang="ts">
import { defineComponent, type PropType } from 'vue';
import type { Profession } from '../../models/Profession';
import ProfessionItem from './ProfessionItem.vue';

export default defineComponent({
    name: 'ProfessionTable',
    components: {
        ProfessionItem
    },
    props: {
        professions: {
            type: Object as PropType<Profession[]>,
            required: true
        }
    },
    methods: {
        selectProfession(profession: Profession) {
            this.$emit('select', profession);
        }
    }
});
</script>

<style scoped>
.profession-table {
    display: flex;
    flex-direction: column;
    color: white;
    padding: 0 10%;
}

.profession-table table {
    width: 100%;
    margin-bottom: 20px;
    border: 2px solid white;
    border-collapse: collapse;
}

.profession-table th {
    font-weight: bold;
    padding: 15px 0;
    border: 2px solid white;
}
</style>