package com.melita.orderapprovalapi.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
class OrderStorage {
    private final OrderRepository repository;

    Order store(Order order) {
        return repository.saveAndFlush(order);
    }

    public Order findOrderById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new OrderNotFound(id));
    }
}
