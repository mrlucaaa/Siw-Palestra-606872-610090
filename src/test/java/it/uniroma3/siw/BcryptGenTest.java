package it.uniroma3.siw;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptGenTest {

    @Test
    public void generateHashes() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("ADMIN_HASH: " + encoder.encode("admin"));
        System.out.println("ISTRUTTORE_HASH: " + encoder.encode("istruttore"));
        System.out.println("UTENTE_HASH: " + encoder.encode("utente"));
    }
}
