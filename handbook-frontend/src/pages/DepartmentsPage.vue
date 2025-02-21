<template>
    <div class="page">
        <div class="create-box">
            <button class="create-button" @click="createModalOpened = true">Добавить</button>
        </div>
        <DepartmentTable :departments="departments" @select="selectDepartment" />
        <ManageDepartmentModal v-if="editModalOpened" :departments="departments" :department="selectedDepartment"
            @update="updateDepartment" @delete="deleteDepartment" @close="editModalOpened = false" />
        <CreateDepartmentModal v-if="createModalOpened" @create="createDepartment" @close="createModalOpened = false"
            :departments="departments" />
        <ErrorMessage v-if="errorMessage" :message="errorMessage" @close="hideError" />
    </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref } from 'vue';
import DepartmentTable from '../components/departments/DepartmentTable.vue';
import ManageDepartmentModal from '../components/departments/ManageDepartmentModal.vue';
import type { Department } from '../models/Department';
import CreateDepartmentModal from '../components/departments/CreateDepartmentModal.vue';
import departmentService from '../services/departmentService';
import ErrorMessage from '../components/ErrorMessage.vue';

export default defineComponent({
    name: 'DepartmentsPage',
    components: {
        DepartmentTable,
        ManageDepartmentModal,
        CreateDepartmentModal, 
        ErrorMessage
    },
    setup() {
        const departments = ref<Department[]>([]);
        const editModalOpened = ref<boolean>(false);
        const createModalOpened = ref<boolean>(false);
        const selectedDepartment = ref<Department>({} as Department);
        const errorMessage = ref<string>('');

        const selectDepartment = (department: Department) => {
            editModalOpened.value = true;
            selectedDepartment.value = { ...department };
        }

        const hideError = () => {
            errorMessage.value = '';
        }

        const fetchDepartments = async () => {
            try {
                departments.value = await departmentService.getDepartments();
            } catch (error) {
                if (error instanceof Error) {
                    errorMessage.value = error.message;
                } else {
                    errorMessage.value = "Что-то пошло не так";
                }
            }
        }

        const createDepartment = async (department: Department) => {
            try {
                createModalOpened.value = false;
                await departmentService.postDepartment(department);
                fetchDepartments();
            } catch (error) {
                if (error instanceof Error) {
                    errorMessage.value = error.message;
                } else {
                    errorMessage.value = "Что-то пошло не так";
                }
            }
        }

        const updateDepartment = async (department: Department) => {
            try {
                await departmentService.patchDepartment(department.id, department);
                editModalOpened.value = false;
                fetchDepartments();
            } catch (error) {
                if (error instanceof Error) {
                    errorMessage.value = error.message;
                } else {
                    errorMessage.value = "Что-то пошло не так";
                }
            }
        }

        const deleteDepartment = async (department: Department) => {
            try {
                await departmentService.deleteDepartment(department.id);
                editModalOpened.value = false;
                fetchDepartments();
            } catch (error) {
                if (error instanceof Error) {
                    errorMessage.value = error.message;
                } else {
                    errorMessage.value = "Что-то пошло не так";
                }
            }
        }

        onMounted(fetchDepartments);

        return {
            departments,
            editModalOpened,
            createModalOpened,
            selectedDepartment,
            errorMessage,
            updateDepartment,
            createDepartment,
            deleteDepartment,
            selectDepartment,
            hideError
        }
    },
});
</script>

<style scoped>
.page {
    width: 100%;
    min-height: 100vh;
    margin-top: 100px;
    font-size: 24px;
}

.create-box {
    display: flex;
    flex-direction: column;
    align-items: end;
    margin: 0px 10% 30px 10%;
}

.create-button {
    background-color: #4CAF50;
    padding: 10px 30px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-weight: bold;
    color: #fff;
}

.create-button:hover {
    background-color: #3e8e41;
}
</style>