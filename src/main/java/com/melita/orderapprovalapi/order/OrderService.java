package com.melita.orderapprovalapi.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderStorage storage;

    public void approveOrder(Integer orderId) {
        Order order = storage.findOrderById(orderId);
        order.setState(Order.State.APPROVED);
        storage.store(order);
        //TODO Publish approved event to taking api so the order can be sent to the fulfilment system
    }
}
