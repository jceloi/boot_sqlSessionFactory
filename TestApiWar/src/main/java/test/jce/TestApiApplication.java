package test.jce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@EnableConfigurationProperties
@SpringBootApplication
public class TestApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(TestApiApplication.class, args);
    }


}
