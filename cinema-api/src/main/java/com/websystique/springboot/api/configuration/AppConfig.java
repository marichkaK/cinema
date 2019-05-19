package com.websystique.springboot.api.configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class AppConfig {

    @Autowired
    private Jackson2ObjectMapperBuilder objectMapperBuilder;

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = objectMapperBuilder.build();
        objectMapper.setSerializationInclusion(Include.NON_NULL);

        return objectMapper;
    }
}
