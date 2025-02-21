import type { AxiosResponse } from "axios"
import type { Profession } from "../models/Profession"
import axios from "axios"


const API_URL = 'http://localhost:8080/professions'

const professionService = {

    async getProfessions(): Promise<Profession[]> {
        try {
            const response: AxiosResponse<Profession[]> = await axios.get(API_URL);
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

    async postProfession(profession: Profession): Promise<void> {
        try {
            await axios.post(API_URL, profession);
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

    async patchProfession(professionId: number, profession: Profession) {
        try {
            await axios.patch(`${API_URL}/${professionId}`, profession);
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

    async deleteProfession(professionId: number) {
        try {
            await axios.delete(`${API_URL}/${professionId}`);
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

export default professionService;