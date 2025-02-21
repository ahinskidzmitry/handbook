import EmployeesPage from '../pages/EmployeesPage.vue'
import ProfessionsPage from '../pages/ProfessionsPage.vue'
import DepartmentsPage from '../pages/DepartmentsPage.vue'
import { createRouter, createWebHistory, type Router, type RouteRecordRaw } from 'vue-router';

const routes: Array<RouteRecordRaw> = [
    {
        path: '/employees',
        name: 'Employees',
        component: EmployeesPage,
    },
    {
        path: '/professions',
        name: 'Professions',
        component: ProfessionsPage,
    },
    {
        path: '/departments',
        name: 'Departments',
        component: DepartmentsPage,
    },
];

const router: Router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;