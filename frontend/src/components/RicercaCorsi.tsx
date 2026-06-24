import React, { useState, useEffect } from 'react';
import type { Corso } from '../types';
import { fetchCorsi } from '../services/corsoService';

const RicercaCorsi: React.FC = () => {
    // 1. Stato per i dati completi
    const [corsi, setCorsi] = useState<Corso[]>([]);
    
    // 2. Stato per il testo di ricerca
    const [searchTerm, setSearchTerm] = useState<string>('');

    // 3. Eseguire la chiamata API al caricamento
    useEffect(() => {
        const loadCorsi = async () => {
            try {
                const data = await fetchCorsi();
                setCorsi(data);
            } catch (error) {
                console.error("Impossibile caricare i corsi", error);
            }
        };

        // Chiamiamo subito la funzione appena definita
        loadCorsi();
    }, []); // Array vuoto = esegui solo al mount

    // 4. Calcolare i dati filtrati in memoria
    const corsiFiltrati = corsi.filter((corso) => 
        corso.nome.toLowerCase().includes(searchTerm.toLowerCase())
    );

    return (
        <section className="sec sec--dark" style={{ minHeight: '100vh', paddingTop: '4rem' }}>
            <div className="wrap">
                <h2 style={{ fontSize: '5rem', marginBottom: '3rem' }}>I NOSTRI CORSI</h2>
                
                <div style={{ marginBottom: '4rem' }}>
                    <input 
                        type="text" 
                        placeholder="Cerca un corso..." 
                        value={searchTerm}
                        onChange={(e) => setSearchTerm(e.target.value)} 
                        style={{
                            padding: '1rem 0',
                            width: '100%',
                            border: 'none',
                            borderBottom: '2px solid rgba(255,255,255,0.2)',
                            background: 'transparent',
                            color: 'var(--paper)',
                            fontSize: '3rem',
                            fontFamily: "'Barlow Condensed', sans-serif",
                            outline: 'none',
                            textTransform: 'uppercase',
                            fontWeight: 900
                        }}
                    />
                </div>

                <div style={{ display: 'flex', flexDirection: 'column' }}>
                    {corsiFiltrati.length === 0 ? (
                        <p>Nessun corso trovato per la tua ricerca.</p>
                    ) : (
                        corsiFiltrati.map((corso) => (
                            <div className="card" key={corso.id}>
                                <div className="card__content">
                                    <span className="card__tag tag-red">{corso.istruttoreNome} {corso.istruttoreCognome}</span>
                                    <h3>{corso.nome}</h3>
                                </div>
                                <p style={{ flex: 1, marginTop: '1.5rem' }}>{corso.descrizione}</p>
                                <div style={{ display: 'flex', alignItems: 'center' }}>
                                    <a 
                                        href={`http://localhost:8080/corsi/${corso.id}`}
                                        style={{
                                            background: 'rgba(255,255,255,0.03)',
                                            border: '1px solid rgba(255,255,255,0.05)',
                                            color: 'var(--paper)',
                                            padding: '1rem 2rem',
                                            fontFamily: "'Barlow Condensed', sans-serif",
                                            fontWeight: 900,
                                            fontSize: '1.1rem',
                                            cursor: 'pointer',
                                            textTransform: 'uppercase',
                                            letterSpacing: '2px',
                                            textDecoration: 'none',
                                            display: 'inline-block'
                                        }}>Vedi Dettagli</a>
                                </div>
                            </div>
                        ))
                    )}
                </div>
            </div>
        </section>
    );
};

export default RicercaCorsi;
