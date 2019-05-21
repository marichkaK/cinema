package com.websystique.springboot.ticket.ingestor.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("mongo")
public class MongoProps {

    private String host;
    private Integer port;
    private String databaseName;
}
