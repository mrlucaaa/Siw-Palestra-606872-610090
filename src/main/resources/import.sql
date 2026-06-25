-- ==========================================
-- ISTRUTTORI (IDs: 1001 - 1005)
-- ==========================================
INSERT INTO istruttore (id, codice_tessera, nome, cognome, specializzazione) VALUES (1001, 1001, 'Marco', 'Rossi', 'Pesistica e Forza');
INSERT INTO istruttore (id, codice_tessera, nome, cognome, specializzazione) VALUES (1002, 1002, 'Giulia', 'Bianchi', 'Yoga e Pilates');
INSERT INTO istruttore (id, codice_tessera, nome, cognome, specializzazione) VALUES (1003, 1003, 'Alessandro', 'Verdi', 'CrossFit');
INSERT INTO istruttore (id, codice_tessera, nome, cognome, specializzazione) VALUES (1004, 1004, 'Chiara', 'Neri', 'Zumba e Cardio');
INSERT INTO istruttore (id, codice_tessera, nome, cognome, specializzazione) VALUES (1005, 1005, 'Luca', 'Gialli', 'Boxe e Arti Marziali');

-- ==========================================
-- CORSI (IDs: 1001 - 1008)
-- ==========================================
-- Date nel futuro per rispettare il vincolo @Future
INSERT INTO corso (id, capienza_max, data_ora, descrizione, nome, istruttore_id) VALUES (1001, 20, '2026-10-15 10:00:00', 'Corso intensivo per lo sviluppo della forza pura.', 'Powerlifting Base', 1001);
INSERT INTO corso (id, capienza_max, data_ora, descrizione, nome, istruttore_id) VALUES (1002, 15, '2026-10-16 18:00:00', 'Allenamento ad alta intensità per atleti esperti.', 'CrossFit Avanzato', 1003);
INSERT INTO corso (id, capienza_max, data_ora, descrizione, nome, istruttore_id) VALUES (1003, 25, '2026-10-17 08:30:00', 'Risveglio muscolare e stretching profondo per iniziare la giornata.', 'Yoga Mattutino', 1002);
INSERT INTO corso (id, capienza_max, data_ora, descrizione, nome, istruttore_id) VALUES (1004, 30, '2026-10-18 19:00:00', 'Allenamento cardio a ritmo di musica.', 'Zumba Fitness', 1004);
INSERT INTO corso (id, capienza_max, data_ora, descrizione, nome, istruttore_id) VALUES (1005, 10, '2026-10-19 13:00:00', 'Correzione posturale e core stability.', 'Pilates Posturale', 1002);
INSERT INTO corso (id, capienza_max, data_ora, descrizione, nome, istruttore_id) VALUES (1006, 12, '2026-10-20 18:30:00', 'Lezioni di prepugilistica e sparring.', 'Boxe Training', 1005);
INSERT INTO corso (id, capienza_max, data_ora, descrizione, nome, istruttore_id) VALUES (1007, 20, '2026-10-21 17:00:00', 'Forza e resistenza con Kettlebell.', 'Kettlebell Workout', 1001);
INSERT INTO corso (id, capienza_max, data_ora, descrizione, nome, istruttore_id) VALUES (1008, 15, '2026-10-22 20:00:00', 'Allenamento ad intervalli ad alta intensità.', 'HIIT Cardio', 1004);

-- ==========================================
-- UTENTI E CREDENZIALI (IDs: 1001 - 1010)
-- ==========================================
-- Admin
INSERT INTO utente (id, codice_fiscale, nome, cognome, email) VALUES (1001, 'ADMIN00000000000', 'Admin', 'Sistema', 'admin@siwfitness.it');
INSERT INTO credentials (id, username, password, ruolo, utente_id) VALUES (1001, 'admin', '{bcrypt}$2a$10$Gz2iczh/g58LY1oEYeZecu9Omr3Sfzzgfodgxpv6YtnnhDUicVSs2', 'ADMIN', 1001);

-- Istruttore Login
INSERT INTO utente (id, codice_fiscale, nome, cognome, email) VALUES (1011, 'ISTR000000000000', 'Marco', 'Rossi', 'marco.istruttore@siwfitness.it');
INSERT INTO credentials (id, username, password, ruolo, utente_id) VALUES (1011, 'istruttore', '{bcrypt}$2a$10$Txf41o1WzsyrAYimjeuQZu/wrW57LdjQtbs/y1j9WKef2T57aTBAO', 'ISTRUTTORE', 1011);

-- Utente Login
INSERT INTO utente (id, codice_fiscale, nome, cognome, email) VALUES (1012, 'UTEN000000000000', 'Utente', 'Semplice', 'utente.semplice@gmail.com');
INSERT INTO credentials (id, username, password, ruolo, utente_id) VALUES (1012, 'utente', '{bcrypt}$2a$10$g/rxi4WwNy24GcEUHOmGe.o7S97g41iH/XHi0cbCyw8oT8GQyx04u', 'CLIENTE', 1012);

-- Clienti (La password per tutti è "password")
INSERT INTO utente (id, codice_fiscale, nome, cognome, email) VALUES (1002, 'RSSMRA80A01H501U', 'Mario', 'Rossi', 'mario.rossi@gmail.com');
INSERT INTO credentials (id, username, password, ruolo, utente_id) VALUES (1002, 'mariorossi', '{bcrypt}$2a$10$X/r9h0k4K8uP.9X0X6E9x.5H0zY1jQpQyB8wG.gO1qL.7eU8W.0y', 'CLIENTE', 1002);

INSERT INTO utente (id, codice_fiscale, nome, cognome, email) VALUES (1003, 'BNCGLA85B41H501R', 'Giulia', 'Bianchi', 'giulia.bianchi@gmail.com');
INSERT INTO credentials (id, username, password, ruolo, utente_id) VALUES (1003, 'giuliab', '{bcrypt}$2a$10$X/r9h0k4K8uP.9X0X6E9x.5H0zY1jQpQyB8wG.gO1qL.7eU8W.0y', 'CLIENTE', 1003);

INSERT INTO utente (id, codice_fiscale, nome, cognome, email) VALUES (1004, 'VRDLCA90C01H501Q', 'Luca', 'Verdi', 'luca.verdi@gmail.com');
INSERT INTO credentials (id, username, password, ruolo, utente_id) VALUES (1004, 'lucav', '{bcrypt}$2a$10$X/r9h0k4K8uP.9X0X6E9x.5H0zY1jQpQyB8wG.gO1qL.7eU8W.0y', 'CLIENTE', 1004);

INSERT INTO utente (id, codice_fiscale, nome, cognome, email) VALUES (1005, 'MRNFRC95D41H501Z', 'Francesca', 'Marini', 'fra.marini@gmail.com');
INSERT INTO credentials (id, username, password, ruolo, utente_id) VALUES (1005, 'framarini', '{bcrypt}$2a$10$X/r9h0k4K8uP.9X0X6E9x.5H0zY1jQpQyB8wG.gO1qL.7eU8W.0y', 'CLIENTE', 1005);

INSERT INTO utente (id, codice_fiscale, nome, cognome, email) VALUES (1006, 'CNTNTN88E01H501X', 'Antonio', 'Conti', 'antonio.conti@gmail.com');
INSERT INTO credentials (id, username, password, ruolo, utente_id) VALUES (1006, 'antonio.conti', '{bcrypt}$2a$10$X/r9h0k4K8uP.9X0X6E9x.5H0zY1jQpQyB8wG.gO1qL.7eU8W.0y', 'CLIENTE', 1006);

INSERT INTO utente (id, codice_fiscale, nome, cognome, email) VALUES (1007, 'FBRMTA92F41H501Y', 'Marta', 'Fabbri', 'marta.fabbri@gmail.com');
INSERT INTO credentials (id, username, password, ruolo, utente_id) VALUES (1007, 'martafabbri', '{bcrypt}$2a$10$X/r9h0k4K8uP.9X0X6E9x.5H0zY1jQpQyB8wG.gO1qL.7eU8W.0y', 'CLIENTE', 1007);

INSERT INTO utente (id, codice_fiscale, nome, cognome, email) VALUES (1008, 'GRCSTF82G01H501W', 'Stefano', 'Greco', 'stefano.greco@gmail.com');
INSERT INTO credentials (id, username, password, ruolo, utente_id) VALUES (1008, 'stefanog', '{bcrypt}$2a$10$X/r9h0k4K8uP.9X0X6E9x.5H0zY1jQpQyB8wG.gO1qL.7eU8W.0y', 'CLIENTE', 1008);

INSERT INTO utente (id, codice_fiscale, nome, cognome, email) VALUES (1009, 'SRTLCU89H41H501V', 'Lucia', 'Sarti', 'lucia.sarti@gmail.com');
INSERT INTO credentials (id, username, password, ruolo, utente_id) VALUES (1009, 'lucias', '{bcrypt}$2a$10$X/r9h0k4K8uP.9X0X6E9x.5H0zY1jQpQyB8wG.gO1qL.7eU8W.0y', 'CLIENTE', 1009);

INSERT INTO utente (id, codice_fiscale, nome, cognome, email) VALUES (1010, 'MNCNCL98I01H501T', 'Nicola', 'Mancini', 'nicola.mancini@gmail.com');
INSERT INTO credentials (id, username, password, ruolo, utente_id) VALUES (1010, 'nicolam', '{bcrypt}$2a$10$X/r9h0k4K8uP.9X0X6E9x.5H0zY1jQpQyB8wG.gO1qL.7eU8W.0y', 'CLIENTE', 1010);

-- ==========================================
-- PRENOTAZIONI
-- ==========================================
INSERT INTO prenotazione (id, data_creazione, stato, corso_id, utente_id) VALUES (1001, '2026-06-20 10:00:00', 'ATTIVA', 1001, 1002);
INSERT INTO prenotazione (id, data_creazione, stato, corso_id, utente_id) VALUES (1002, '2026-06-21 11:30:00', 'ATTIVA', 1001, 1003);
INSERT INTO prenotazione (id, data_creazione, stato, corso_id, utente_id) VALUES (1003, '2026-06-22 09:15:00', 'ATTIVA', 1002, 1004);
INSERT INTO prenotazione (id, data_creazione, stato, corso_id, utente_id) VALUES (1004, '2026-06-22 14:00:00', 'ATTIVA', 1002, 1005);
INSERT INTO prenotazione (id, data_creazione, stato, corso_id, utente_id) VALUES (1005, '2026-06-23 08:45:00', 'DISDETTA', 1003, 1006);
INSERT INTO prenotazione (id, data_creazione, stato, corso_id, utente_id) VALUES (1006, '2026-06-23 10:20:00', 'ATTIVA', 1003, 1007);
INSERT INTO prenotazione (id, data_creazione, stato, corso_id, utente_id) VALUES (1007, '2026-06-23 16:30:00', 'ATTIVA', 1004, 1008);
INSERT INTO prenotazione (id, data_creazione, stato, corso_id, utente_id) VALUES (1008, '2026-06-24 12:10:00', 'ATTIVA', 1004, 1009);
INSERT INTO prenotazione (id, data_creazione, stato, corso_id, utente_id) VALUES (1009, '2026-06-24 15:00:00', 'ATTIVA', 1005, 1010);
INSERT INTO prenotazione (id, data_creazione, stato, corso_id, utente_id) VALUES (1010, '2026-06-24 17:45:00', 'ATTIVA', 1006, 1002);
INSERT INTO prenotazione (id, data_creazione, stato, corso_id, utente_id) VALUES (1011, '2026-06-24 18:00:00', 'ATTIVA', 1007, 1003);
INSERT INTO prenotazione (id, data_creazione, stato, corso_id, utente_id) VALUES (1012, '2026-06-24 19:30:00', 'ATTIVA', 1008, 1004);

-- ==========================================
-- RECENSIONI
-- ==========================================
INSERT INTO recensione (id, data_ora, numero_stelle, testo, corso_id, utente_id) VALUES (1001, '2026-05-15 10:00:00', 5, 'Corso fantastico, Marco è bravissimo!', 1001, 1002);
INSERT INTO recensione (id, data_ora, numero_stelle, testo, corso_id, utente_id) VALUES (1002, '2026-05-16 11:00:00', 4, 'Molto faticoso ma ne vale la pena.', 1001, 1003);
INSERT INTO recensione (id, data_ora, numero_stelle, testo, corso_id, utente_id) VALUES (1003, '2026-05-17 12:30:00', 5, 'CrossFit di altissimo livello. Consigliato.', 1002, 1004);
INSERT INTO recensione (id, data_ora, numero_stelle, testo, corso_id, utente_id) VALUES (1004, '2026-05-18 09:15:00', 3, 'Bello, ma l''orario è un po'' scomodo per me.', 1002, 1005);
INSERT INTO recensione (id, data_ora, numero_stelle, testo, corso_id, utente_id) VALUES (1005, '2026-05-19 14:45:00', 5, 'Giulia ti fa rinascere. Perfetto per iniziare la giornata.', 1003, 1006);
INSERT INTO recensione (id, data_ora, numero_stelle, testo, corso_id, utente_id) VALUES (1006, '2026-05-20 16:20:00', 4, 'Rilassante e stimolante allo stesso tempo.', 1003, 1007);
INSERT INTO recensione (id, data_ora, numero_stelle, testo, corso_id, utente_id) VALUES (1007, '2026-05-21 19:30:00', 5, 'Divertentissimo! Si suda e si balla.', 1004, 1008);
INSERT INTO recensione (id, data_ora, numero_stelle, testo, corso_id, utente_id) VALUES (1008, '2026-05-22 20:10:00', 5, 'La mia lezione preferita della settimana.', 1004, 1009);
INSERT INTO recensione (id, data_ora, numero_stelle, testo, corso_id, utente_id) VALUES (1009, '2026-05-23 13:00:00', 4, 'Ottimo per la schiena. Lo consiglio.', 1005, 1010);
INSERT INTO recensione (id, data_ora, numero_stelle, testo, corso_id, utente_id) VALUES (1010, '2026-05-24 18:45:00', 5, 'Luca è un istruttore eccezionale. Boxe vera.', 1006, 1002);
