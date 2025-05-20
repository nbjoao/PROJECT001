package dev.byte_forge.project001.user;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import dev.byte_forge.project001.config.RabbitMQProperties;

@Service
public class UserEventPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQProperties properties;

    public UserEventPublisher(RabbitTemplate rabbitTemplate, RabbitMQProperties properties) {
        this.rabbitTemplate = rabbitTemplate;
        this.properties = properties;
    }

    public void sendVerificationMessage(String email) {
        System.out.println(properties.getExchange());
        System.out.println(properties.getRoutingKey());
        rabbitTemplate.convertAndSend(properties.getExchange(), properties.getRoutingKey(), email); 
    }

}
