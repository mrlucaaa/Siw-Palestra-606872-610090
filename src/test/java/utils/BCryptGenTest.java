package utils;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptGenTest {
    @Test
    public void test() {
        System.out.println("HASH_ADMIN: " + new BCryptPasswordEncoder().encode("admin"));
    }
}
