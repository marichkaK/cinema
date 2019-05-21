package com.websystique.springboot.ticket.ingestor.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongo(MongoProps props) {
        return new MongoClient(props.getHost(), props.getPort());
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient, MongoProps props) {
        return new MongoTemplate(mongoClient, props.getDatabaseName());
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(Include.NON_NULL);

        return objectMapper;
    }
}
