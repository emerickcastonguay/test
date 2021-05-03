package dev.fyloz.colval.jee.thymeleaf.cours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

@SpringBootApplication(exclude = ThymeleafAutoConfiguration.class)
public class CoursApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoursApplication.class, args);
    }
}
