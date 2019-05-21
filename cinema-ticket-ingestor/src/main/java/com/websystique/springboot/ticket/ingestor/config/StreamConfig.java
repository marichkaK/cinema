package com.websystique.springboot.ticket.ingestor.config;

import com.websystique.springboot.ticket.ingestor.messaging.TicketStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(TicketStream.class)
public class StreamConfig {

}
