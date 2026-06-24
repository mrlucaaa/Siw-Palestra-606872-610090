package utils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptGen {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("admin: " + encoder.encode("admin"));
        System.out.println("istruttore: " + encoder.encode("istruttore"));
        System.out.println("utente: " + encoder.encode("utente"));
    }
}
