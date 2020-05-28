import com.backward.auth.AuthServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AuthServerApplication.class})
public class AuthTest {

    @Test
    public void one(){
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }
}
