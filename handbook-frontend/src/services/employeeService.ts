import type { AxiosResponse } from "axios"
import axios from "axios"
import type { Employee } from "../models/Employee";


const API_URL = 'http://localhost:8080/employees'

const employeeService = {

    async getEmployees(): Promise<Employee[]> {
        try {
            const response: AxiosResponse<Employee[]> = await axios.get(API_URL);
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

    async postEmployee(employee: Employee): Promise<void> {
        try {
            await axios.post(API_URL, employee);
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

    async patchEmployee(employeeId: number, employee: Employee) {
        try {
            await axios.patch(`${API_URL}/${employeeId}`, employee);
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

    async deleteEmployee(employeeId: number) {
        try {
            await axios.delete(`${API_URL}/${employeeId}`);
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

export default employeeService;