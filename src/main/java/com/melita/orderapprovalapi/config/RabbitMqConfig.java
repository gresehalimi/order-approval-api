package com.melita.orderapprovalapi.config;

import com.melita.orderapprovalapi.order.inbound.OrderInboundingSettings;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMqConfig {

    private final OrderInboundingSettings settings;

    @Bean
    Queue queue() {
        return new Queue(settings.getQueue(), true);
    }

    @Bean
    Exchange mayExchange() {
        return ExchangeBuilder.directExchange(settings.getExchange()).durable(true).build();
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(mayExchange()).with(settings.getExchange()).noargs();
    }

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername(settings.getUsername());
        connectionFactory.setPassword(settings.getPassword());
        return connectionFactory;
    }
    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
