package com.websystique.springboot.eureka.zuul.security;

import com.websystique.springboot.common.security.JwtConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public JwtConfig jwtConfig() {
        return new JwtConfig();
    }
}
