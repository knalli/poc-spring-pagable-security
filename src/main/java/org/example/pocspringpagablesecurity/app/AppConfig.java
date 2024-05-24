package org.example.pocspringpagablesecurity.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyController myController(){
        return new MyController();
    }

}
