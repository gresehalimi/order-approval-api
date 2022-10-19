package com.melita.orderapprovalapi.order;

import com.melita.orderapprovalapi.error.OrderApprovalApiError;
import com.melita.orderapprovalapi.error.OrderApprovalApiException;

public class OrderNotFound extends OrderApprovalApiException {

    public OrderNotFound(String message) {
        super(OrderApprovalApiError.ORDER_NOT_FOUND, message);
    }

    public OrderNotFound(Integer id) {
        this("" + id);
    }
}
