package server.jwt.lhtp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class LhtpApplication {


    public static void main(String[] args) {
        SpringApplication.run(LhtpApplication.class, args);
    }


}
