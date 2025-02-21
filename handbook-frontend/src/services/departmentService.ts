import type { AxiosResponse } from "axios"
import axios from "axios"
import type { Department } from "../models/Department";


const API_URL = 'http://localhost:8080/departments'

const departmentService = {

    async getDepartments(): Promise<Department[]> {
        try {
            const response: AxiosResponse<Department[]> = await axios.get(API_URL);
            return response.data;
        } catch (error: any) {
            if (axios.isAxiosError(error)) {
                if (error.response) {
                    if (error.response.status == 500) {
                        throw new Error("Что-то пошло не так");
                    } else {
                        throw new Error(error.response.data);
                    }
                } else {
                    throw new Error("Что-то пошло не так");
                }
            } else {
                throw new Error("Что-то пошло не так");
            }
        }
    },

    async postDepartment(department: Department): Promise<void> {
        try {
            await axios.post(API_URL, department);
        } catch (error: any) {
            if (axios.isAxiosError(error)) {
                if (error.response) {
                    if (error.response.status == 500) {
                        throw new Error("Что-то пошло не так");
                    } else {
                        throw new Error(error.response.data);
                    }
                } else {
                    throw new Error("Что-то пошло не так");
                }
            } else {
                throw new Error("Что-то пошло не так");
            }
        }
    },

    async patchDepartment(departmentId: number, department: Department) {
        try {
            await axios.patch(`${API_URL}/${departmentId}`, department);
        } catch (error: any) {
            if (axios.isAxiosError(error)) {
                if (error.response) {
                    if (error.response.status == 500) {
                        throw new Error("Что-то пошло не так");
                    } else {
                        throw new Error(error.response.data);
                    }
                } else {
                    throw new Error("Что-то пошло не так");
                }
            } else {
                throw new Error("Что-то пошло не так");
            }
        }
    },

    async deleteDepartment(departmentId: number) {
        try {
            await axios.delete(`${API_URL}/${departmentId}`);
        } catch (error: any) {
            if (axios.isAxiosError(error)) {
                if (error.response) {
                    if (error.response.status == 500) {
                        throw new Error("Что-то пошло не так");
                    } else {
                        throw new Error(error.response.data);
                    }
                } else {
                    throw new Error("Что-то пошло не так");
                }
            } else {
                throw new Error("Что-то пошло не так");
            }
        }
    }
};

export default departmentService;