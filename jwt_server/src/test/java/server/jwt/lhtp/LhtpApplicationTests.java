package server.jwt.lhtp;

import antlr.collections.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import server.jwt.lhtp.entity.Role;
import server.jwt.lhtp.entity.User;
import server.jwt.lhtp.repository.UserRepository;

import java.util.*;
import java.util.stream.Stream;

@SpringBootTest
class LhtpApplicationTests {



    @Autowired
    private UserRepository userRepository;


    @Test
    void contextLoads() {
      Optional<User> user = userRepository.findByUsername("admin");

        System.out.println(user.toString());
    }

    @Test
    void testFindUser(){
        Optional<User> user = userRepository.findUserById(2);

        System.out.println(user.toString());
        Set<Role> roles = user.get().getRoles();

        for (Role role: roles) {
            System.out.println(role.getName());
        }
    }

}
