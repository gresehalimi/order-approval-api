package com.melita.orderapprovalapi.order.inbound;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class OrderInboundingSettings {

    String message;
    String host;
    String username;
    String password;
    String port;
    String exchange;
    String routingkey;
    String queue;
}