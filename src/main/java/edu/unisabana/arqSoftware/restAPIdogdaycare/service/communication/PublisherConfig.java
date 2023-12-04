package edu.unisabana.arqSoftware.restAPIdogdaycare.service.communication;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherConfig {

    @Value("${rabbitMSA.fanout.exchange}")
    private String fanoutExchange;

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchange, true, false);
    }
}
