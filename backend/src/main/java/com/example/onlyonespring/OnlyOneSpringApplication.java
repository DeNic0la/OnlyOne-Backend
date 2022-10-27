package com.example.onlyonespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class OnlyOneSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlyOneSpringApplication.class, args);
    }

    @Bean // TODO: ALEX or someone else, idc: clean this up, this probably should not be here but it works so idc.
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
