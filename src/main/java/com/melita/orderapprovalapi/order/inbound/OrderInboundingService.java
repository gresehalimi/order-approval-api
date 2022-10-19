package com.melita.orderapprovalapi.order.inbound;

import com.melita.orderapprovalapi.order.Order;
import com.melita.orderapprovalapi.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderInboundingService implements RabbitListenerConfigurer {

    private final OrderRepository orderRepository;

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
    }

    @RabbitListener(queues = "order.queue")
    public void receiveMessage(OrderInbounding orderInbounding){
        log.info("received message" + orderInbounding);
        orderRepository.saveAndFlush(Order.builder()
                .orderId(orderInbounding.getOrderId())
                .customerName(orderInbounding.getCustomerName())
                .customerEmail(orderInbounding.getCustomerEmail())
                .customerPhone(orderInbounding.getCustomerPhone())
                .installationAddress(orderInbounding.getInstallationAddress())
                .products(orderInbounding.getProducts())
                .state(Order.State.PENDING)
                .agentName("TO_BE_ASSIGNED")
                .dateTimeInstallation(LocalDateTime.parse(orderInbounding.getDateTimeInstallation(), DateTimeFormatter.ISO_DATE_TIME))
                .build());
    }
}


