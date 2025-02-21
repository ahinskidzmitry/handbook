<template>
    <div class="modal-overlay">
        <div class="modal">
            <div class="modal-header">
                <h2>Добавить профессию</h2>
                <button class="close-button" @click="$emit('close')">Закрыть</button>
            </div>
            <div class="modal-body">
                <form @submit.prevent="$emit('create', profession)">
                    <label>
                        * Наименование:
                        <input type="text" v-model="profession.name" required />
                    </label>
                    <label>
                        Примечание:
                        <input type="text" v-model="profession.note" />
                    </label>
                    <div class="modal-actions">
                        <button type="submit" class="save-button">Создать</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue';
import type { Profession } from '../../models/Profession';

export default defineComponent({
    name: 'CreateProfessionModal',
    setup() {
        const profession = ref<Profession>({} as Profession);

        return {
            profession
        };
    }
});
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

.save-button {
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

.save-button:hover {
    background-color: #3e8e41;
}
</style>