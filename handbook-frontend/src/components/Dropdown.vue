<template>
    <select v-model="selectedValue" @change="onChange" required>
        <option disabled value="">{{ defaultLabel }} *</option>
        <option v-for="profession in options" :key="profession.id" :value="profession">
            {{ profession.name }}
        </option>
    </select>
</template>

<script lang="ts">
import { defineComponent, ref, watch } from 'vue';
import type { Profession } from '../models/Profession';

export default defineComponent({
    name: 'Dropdown',
    props: {
        options: {
            type: Array as () => Profession[],
            required: true,
        },
        modelValue: {
            type: Object as () => Profession,
            default: null,
        },
        defaultLabel: {
            type: String,
            required: true
        }
    },
    emits: ['update:modelValue'],
    setup(props, { emit }) {
        const selectedValue = ref<Profession | String>(props.modelValue ? props.modelValue : "");

        watch(
            () => props.modelValue,
            (newValue) => {
                selectedValue.value = newValue;
            }
        );

        const onChange = () => {
            emit('update:modelValue', selectedValue.value);
        };

        return {
            selectedValue,
            onChange,
        };
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