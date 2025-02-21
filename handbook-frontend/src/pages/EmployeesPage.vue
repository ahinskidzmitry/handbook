<template>
    <div class="page">
        <div class="create-box">
            <button class="create-button" @click="createModalOpened = true">Добавить</button>
        </div>
        <EmployeeTable :employees="employees" @select="selectEmployee" />
        <ManageEmployeeModal v-if="editModalOpened" :employee="selectedEmployee" @update="updateEmployee"
            @delete="deleteEmployee" @close="editModalOpened = false" :departments="departments"
            :professions="professions" />
        <CreateEmployeeModal v-if="createModalOpened" @create="createEmployee" @close="createModalOpened = false"
            :departments="departments" :professions="professions" />
        <ErrorMessage v-if="errorMessage" :message="errorMessage" @close="hideError" />
    </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref } from 'vue';
import EmployeeTable from '../components/employees/EmployeeTable.vue';
import ManageEmployeeModal from '../components/employees/ManageEmployeeModal.vue';
import type { Employee } from '../models/Employee';
import CreateEmployeeModal from '../components/employees/CreateEmployeeModal.vue';
import employeeService from '../services/employeeService';
import ErrorMessage from '../components/ErrorMessage.vue';
import departmentService from '../services/departmentService';
import type { Department } from '../models/Department';
import type { Profession } from '../models/Profession';
import professionService from '../services/professionService';


export default defineComponent({
    name: 'EmployeesPage',
    components: {
        EmployeeTable,
        ManageEmployeeModal,
        CreateEmployeeModal,
        ErrorMessage
    },
    setup() {
        const employees = ref<Employee[]>([]);
        const departments = ref<Department[]>([]);
        const professions = ref<Profession[]>([]);
        const editModalOpened = ref<boolean>(false);
        const createModalOpened = ref<boolean>(false);
        const selectedEmployee = ref<Employee>({} as Employee);
        const errorMessage = ref<string>('');

        const selectEmployee = (employee: Employee) => {
            editModalOpened.value = true;
            selectedEmployee.value = { ...employee };
        }

        const hideError = () => {
            errorMessage.value = '';
        }

        const fetchEmployees = async () => {
            try {
                employees.value = await employeeService.getEmployees();
            } catch (error) {
                if (error instanceof Error) {
                    errorMessage.value = error.message;
                } else {
                    errorMessage.value = "Что-то пошло не так";
                }
            }
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

        const fetchProfessions = async () => {
            try {
                professions.value = await professionService.getProfessions();
            } catch (error) {
                if (error instanceof Error) {
                    errorMessage.value = error.message;
                } else {
                    errorMessage.value = "Что-то пошло не так";
                }
            }
        }

        const createEmployee = async (employee: Employee) => {
            try {
                createModalOpened.value = false;
                await employeeService.postEmployee(employee);
                fetchEmployees();
            } catch (error) {
                if (error instanceof Error) {
                    errorMessage.value = error.message;
                } else {
                    errorMessage.value = "Что-то пошло не так";
                }
            }
        }

        const updateEmployee = async (employee: Employee) => {
            try {
                await employeeService.patchEmployee(employee.id, employee);
                editModalOpened.value = false;
                fetchEmployees();
            } catch (error) {
                if (error instanceof Error) {
                    errorMessage.value = error.message;
                } else {
                    errorMessage.value = "Что-то пошло не так";
                }
            }
        }

        const deleteEmployee = async (employee: Employee) => {
            try {
                await employeeService.deleteEmployee(employee.id);
                editModalOpened.value = false;
                fetchEmployees();
            } catch (error) {
                if (error instanceof Error) {
                    errorMessage.value = error.message;
                } else {
                    errorMessage.value = "Что-то пошло не так";
                }
            }
        }

        onMounted(() => {
            fetchEmployees();
            fetchDepartments();
            fetchProfessions();
        });

        return {
            employees,
            departments,
            professions,
            editModalOpened,
            createModalOpened,
            selectedEmployee,
            errorMessage,
            updateEmployee,
            createEmployee,
            deleteEmployee,
            selectEmployee,
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