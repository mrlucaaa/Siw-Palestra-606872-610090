import axios from 'axios';

/**
 * Istanza globale di Axios.
 * Invece di scrivere tutto l'URL per ogni singola chiamata di rete,
 * configuriamo qui il baseURL che punta al nostro server Spring Boot.
 * 
 * Tutte le chiamate future (es. api.get('/corsi')) useranno questa configurazione base.
 */
const api = axios.create({
    baseURL: 'http://localhost:8080/api', // L'URL e porta del nostro backend Java
    headers: {
        'Content-Type': 'application/json'
    }
});

export default api;
