package com.melita.orderapprovalapi.order;

import com.melita.orderapprovalapi.error.OrderApprovalApiException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    private static final Integer ORDER_ID = 1;

    @Mock OrderStorage storage;
    @InjectMocks OrderService underTest;

    @Captor ArgumentCaptor<Order> orderCaptor;

    @Test
    void approve_shouldApproveOrder() {
        Order order = Order.builder().orderId(ORDER_ID).state(Order.State.PENDING).build();
        when(storage.findOrderById(any())).thenReturn(order);
        underTest.approveOrder(ORDER_ID);
        verify(storage).store(orderCaptor.capture());
        assertEquals(order.getOrderId(), order.getOrderId());
        assertEquals(Order.State.APPROVED, order.getState());
    }

    @Test
    void approve_shouldThrowOnMissingOrder() {
       when(storage.findOrderById(any())).thenThrow(new OrderNotFound("invalid"));
       assertThrows(OrderNotFound.class, () -> underTest.approveOrder(ORDER_ID));
    }
}
