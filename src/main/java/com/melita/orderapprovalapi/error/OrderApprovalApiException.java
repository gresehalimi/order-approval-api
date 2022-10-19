package com.melita.orderapprovalapi.error;

public class OrderApprovalApiException extends RuntimeException {

    private final OrderApprovalApiError error;

    public OrderApprovalApiException(OrderApprovalApiError error) {
        this.error = error;
    }

    public OrderApprovalApiException(OrderApprovalApiError error, String message) {
        super(message);
        this.error = error;
    }

    public OrderApprovalApiError getError(){
        return error;
    }
}
