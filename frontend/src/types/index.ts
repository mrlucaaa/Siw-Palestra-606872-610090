/**
 * Rappresenta la struttura dei dati (DTO) che ci invia il backend per un Corso.
 * Questa interfaccia assicura che TypeScript conosca esattamente i campi disponibili.
 */
export interface Corso {
    id: number;
    nome: string;
    descrizione: string;
    capienzaMax: number;
    
    // In Java è LocalDateTime, nel JSON in arrivo da Spring Boot diventa una stringa ISO (es. "2026-07-01T18:00:00")
    dataOra: string;
    
    // Dati estratti dall'Istruttore per evitare la dipendenza ciclica
    istruttoreId: number;
    istruttoreNome: string;
    istruttoreCognome: string;
}
