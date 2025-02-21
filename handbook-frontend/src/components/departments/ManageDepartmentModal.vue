<template>
    <div class="modal-overlay">
        <div class="modal">
            <div class="modal-header">
                <h2>Редактировать департамент</h2>
                <button class="close-button" @click="$emit('close')">Закрыть</button>
            </div>
            <div class="modal-body">
                <form @submit.prevent="$emit('update', department)">
                    <DepartmentDropdown :departments="prepareDetachedStructure(departments)" :department="department" />
                    <label>
                        * Наименование:
                        <input  type="text" v-model="department.name" required />
                    </label>
                    <label>
                        Примечание:
                        <input type="text" v-model="department.note" />
                    </label>
                    <div class="modal-actions">
                        <button type="submit" class="save-button">Сохранить</button>
                        <button @click.prevent="$emit('delete', department)" class="delete-button">Удалить</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { defineComponent, type PropType } from 'vue';
import type { Department } from '../../models/Department';
import DepartmentDropdown from './DepartmentDropdown.vue';
import { flatDepartments } from '../../util/departmentUtils';

export default defineComponent({
    name: 'ManageDepartmentModal',
    components: {
        DepartmentDropdown
    },
    props: {
        department: {
            type: Object as PropType<Department>,
            required: true
        },
        departments: {
            type: Object as PropType<Department[]>,
            required: true
        }
    },
    setup() {
        const prepareDetachedStructure = (departments: Department[]) => {
            return flatDepartments(departments);
        }

        return {
            prepareDetachedStructure
        };
    }
})
</script>

<style scoped>
.modal-overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 1000;
}

.modal {
    background-color: #fff;
    border-radius: 8px;
    padding: 30px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    width: 80%;
    max-width: 500px;
}

.modal-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 10%;
    font-size: 24px;
}

.close-button {
    background-color: transparent;
    border: none;
    font-size: 24px;
    cursor: pointer;
    color: #aaa;
}

.close-button:hover {
    color: #333;
}

.modal-body label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
    font-size: 20px;
}

.modal-body input[type="text"],
.modal-body input[type="number"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

.modal-actions {
    display: flex;
    justify-content: flex-end;
    gap: 10px;
}

.save-button,
.delete-button {
    padding: 10px 15px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-weight: bold;
    color: #fff;
}

.save-button {
    background-color: #4CAF50;
}

.delete-button {
    background-color: #f44336;
}

.save-button:hover {
    background-color: #3e8e41;
}

.delete-button:hover {
    background-color: #da190b;
}
</style>