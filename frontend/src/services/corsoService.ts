import api from './api';
import type { Corso } from '../types';

/**
 * Ottiene la lista completa dei corsi dal backend.
 * Utilizza l'istanza axios 'api' configurata in api.ts
 */
export const fetchCorsi = async (): Promise<Corso[]> => {
    try {
        // Axios fa una chiamata GET a http://localhost:8080/api/corsi
        const response = await api.get<Corso[]>('/corsi');
        return response.data;
    } catch (error) {
        // Intercettiamo l'errore prima che faccia craschare l'interfaccia React
        console.error("Errore durante il caricamento dei corsi dal server:", error);
        throw error;
    }
};

/**
 * Ottiene i dettagli di un singolo corso dato il suo ID.
 */
export const fetchCorsoById = async (id: number): Promise<Corso> => {
    try {
        const response = await api.get<Corso>(`/corsi/${id}`);
        return response.data;
    } catch (error) {
        console.error(`Errore durante il caricamento del corso con id ${id}:`, error);
        throw error;
    }
};
