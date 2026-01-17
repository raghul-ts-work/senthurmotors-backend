package com.example.SM.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/api/**")
                .allowedOrigins("https://senthurmotors-frontend.vercel.app")
                .allowedMethods("POST")
                .allowedHeaders("Content-Type")
                .allowCredentials(false);
    }
}
