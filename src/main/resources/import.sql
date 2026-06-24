-- 1. ADMIN
INSERT INTO utente (id, nome, cognome, codice_fiscale, email) VALUES (1, 'Amministratore', 'Sistema', 'CFADMIN000000000', 'admin@siw.it');
INSERT INTO credentials (id, username, password, ruolo, utente_id) VALUES (1, 'admin', '{noop}admin', 'ADMIN', 1);
UPDATE utente SET credentials_id = 1 WHERE id = 1;

-- 2. ISTRUTTORE (per accedere con ruolo istruttore)
INSERT INTO utente (id, nome, cognome, codice_fiscale, email) VALUES (2, 'Luca', 'Bianchi', 'LUIBNH80A01H501Z', 'luca.bianchi@siw.it');
INSERT INTO credentials (id, username, password, ruolo, utente_id) VALUES (2, 'istruttore', '{noop}admin', 'ISTRUTTORE', 2);
UPDATE utente SET credentials_id = 2 WHERE id = 2;

-- 3. UTENTE GENERICO (CLIENTE)
INSERT INTO utente (id, nome, cognome, codice_fiscale, email) VALUES (3, 'Mario', 'Rossi', 'MRORSS80A01H501Z', 'mario.rossi@siw.it');
INSERT INTO credentials (id, username, password, ruolo, utente_id) VALUES (3, 'utente', '{noop}admin', 'CLIENTE', 3);
UPDATE utente SET credentials_id = 3 WHERE id = 3;

-- Dati istruttori (Tabella separata nel tuo modello, per i corsi)
INSERT INTO istruttore (id, codice_tessera, nome, cognome, specializzazione) VALUES (1, 1001, 'Luca', 'Bianchi', 'Pesistica e Forza');
INSERT INTO istruttore (id, codice_tessera, nome, cognome, specializzazione) VALUES (2, 1002, 'Giulia', 'Verdi', 'Yoga e Flessibilità');
INSERT INTO istruttore (id, codice_tessera, nome, cognome, specializzazione) VALUES (3, 1003, 'Marco', 'Neri', 'Calisthenics');

-- Corsi
INSERT INTO corso (id, nome, descrizione, capienza_max, data_ora, istruttore_id) VALUES (1, 'Corso Base Powerlifting', 'Approccio ai fondamentali: squat, panca e stacco con tecnica corretta.', 15, '2026-07-01 18:00:00', 1);
INSERT INTO corso (id, nome, descrizione, capienza_max, data_ora, istruttore_id) VALUES (2, 'Hatha Yoga', 'Rilassamento e flessibilità per principianti.', 20, '2026-07-02 10:00:00', 2);
INSERT INTO corso (id, nome, descrizione, capienza_max, data_ora, istruttore_id) VALUES (3, 'Calisthenics Avanzato', 'Skills a corpo libero: front lever, muscle up e planche.', 10, '2026-07-03 19:30:00', 3);
INSERT INTO corso (id, nome, descrizione, capienza_max, data_ora, istruttore_id) VALUES (4, 'Preparazione Atletica', 'Condizionamento generale per atleti.', 25, '2026-07-04 17:00:00', 1);

-- Allineamento delle sequence (necessario per non avere conflitti con i nuovi ID generati in Hibernate 6/PostgreSQL)
ALTER SEQUENCE IF EXISTS utente_seq RESTART WITH 100;
ALTER SEQUENCE IF EXISTS credentials_seq RESTART WITH 100;
ALTER SEQUENCE IF EXISTS istruttore_seq RESTART WITH 100;
ALTER SEQUENCE IF EXISTS corso_seq RESTART WITH 100;
ALTER SEQUENCE IF EXISTS hibernate_sequence RESTART WITH 100;
