package server.jwt.lhtp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import server.jwt.lhtp.entity.User;
import server.jwt.lhtp.repository.UserRepository;

import java.util.Optional;

@SpringBootTest
class LhtpApplicationTests {



    @Autowired
    private UserRepository userRepository;


    @Test
    void contextLoads() {
      Optional<User> user = userRepository.findByUsername("admin");

        System.out.println(user.toString());
    }

}
