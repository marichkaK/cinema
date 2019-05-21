package com.websystique.springboot.api.configuration;

import com.websystique.springboot.api.messaging.stream.TicketStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(TicketStream.class)
public class StreamConfig {

}
