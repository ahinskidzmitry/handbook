<template>
    <div class="page">
        <div class="create-box">
            <button class="create-button" @click="createModalOpened = true">Добавить</button>
        </div>
        <ProfessionTable :professions="professions" @select="selectProfession" />
        <ManageProfessionModal v-if="editModalOpened" :profession="selectedProfession" @update="updateProfession"
            @delete="deleteProfession" @close="editModalOpened = false" />
        <CreateProfessionModal v-if="createModalOpened" @create="createProfession" @close="createModalOpened = false" />
        <ErrorMessage v-if="errorMessage" :message="errorMessage" @close="hideError" />
    </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref } from 'vue';
import ProfessionTable from '../components/professions/ProfessionTable.vue';
import ManageProfessionModal from '../components/professions/ManageProfessionModal.vue';
import type { Profession } from '../models/Profession';
import CreateProfessionModal from '../components/professions/CreateProfessionModal.vue';
import professionService from '../services/professionService';
import ErrorMessage from '../components/ErrorMessage.vue';


export default defineComponent({
    name: 'ProfessionsPage',
    components: {
        ProfessionTable,
        ManageProfessionModal,
        CreateProfessionModal,
        ErrorMessage
    },
    setup() {
        const professions = ref<Profession[]>([]);
        const editModalOpened = ref<boolean>(false);
        const createModalOpened = ref<boolean>(false);
        const selectedProfession = ref<Profession>({} as Profession);
        const errorMessage = ref<string>('');

        const selectProfession = (profession: Profession) => {
            editModalOpened.value = true;
            selectedProfession.value = { ...profession };
        }

        const hideError = () => {
            errorMessage.value = '';
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

        const createProfession = async (profession: Profession) => {
            try {
                createModalOpened.value = false;
                await professionService.postProfession(profession);
                fetchProfessions();
            } catch (error) {
                if (error instanceof Error) {
                    errorMessage.value = error.message;
                } else {
                    errorMessage.value = "Что-то пошло не так";
                }
            }
        }

        const updateProfession = async (profession: Profession) => {
            try {
                await professionService.patchProfession(profession.id, profession);
                editModalOpened.value = false;
                fetchProfessions();
            } catch (error) {
                if (error instanceof Error) {
                    errorMessage.value = error.message;
                } else {
                    errorMessage.value = "Что-то пошло не так";
                }
            }
        }

        const deleteProfession = async (profession: Profession) => {
            try {
                await professionService.deleteProfession(profession.id);
                editModalOpened.value = false;
                fetchProfessions();
            } catch (error) {
                if (error instanceof Error) {
                    errorMessage.value = error.message;
                } else {
                    errorMessage.value = "Что-то пошло не так";
                }
            }
        }

        onMounted(fetchProfessions);

        return {
            professions,
            editModalOpened,
            createModalOpened,
            selectedProfession,
            errorMessage,
            updateProfession,
            createProfession,
            deleteProfession,
            selectProfession,
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