package server.jwt.lhtp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import server.jwt.lhtp.service.FilesStorageService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

@SpringBootApplication
@EnableSwagger2
public class LhtpApplication implements CommandLineRunner {

    @Resource
    FilesStorageService filesStorageServicel;


    public static void main(String[] args) {
        SpringApplication.run(LhtpApplication.class, args);
    }

    @Override
    public void run(String... arg) throws Exception{

        filesStorageServicel.init();

    }


}
