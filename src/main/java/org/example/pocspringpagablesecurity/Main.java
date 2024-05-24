package org.example.pocspringpagablesecurity;

import org.example.pocspringpagablesecurity.app.AppConfig;
import org.example.pocspringpagablesecurity.app.SecurityConfig;
import org.example.pocspringpagablesecurity.app.WebConfig;
import org.example.pocspringpagablesecurity.app.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
@ComponentScan(useDefaultFilters = false)
@Import({
        SecurityConfig.class,
        WebSecurityConfig.class,
        WebConfig.class,
        AppConfig.class,
})
//@EnableSpringDataWebSupport // enabling this will break
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
