package ru.springbootstrap;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.springbootstrap.config.security.SecurityConfig;

@SpringBootApplication
@Configuration
@Import({ SecurityConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}