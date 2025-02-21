<template>
    <div id="error-message" class="error-message">{{ message }}</div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
    name: 'ErrorMessage',
    props: {
        message: {
            type: String,
            required: true
        }
    },
    methods: {
        hideError() {
            this.$emit('close');
        }
    },
    mounted() {
        setTimeout(() => this.hideError(), 10000)
    }
})
</script>

<style scoped>
.error-message {
    position: fixed;
    left: 30px;
    bottom: 30px;
    background-color: rgba(255, 0, 0, 0.7);
    color: white;
    padding: 30px;
    border-radius: 5px;
    border: 3px solid white;
    font-size: 16px;
    z-index: 1000;
}
</style>