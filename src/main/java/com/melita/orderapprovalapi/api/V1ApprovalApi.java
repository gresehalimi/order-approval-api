package com.melita.orderapprovalapi.api;


import com.melita.orderapprovalapi.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/approve/v1")
public class V1ApprovalApi {

    private final OrderService service;


    @PostMapping(value = "{orderId}")
    void approve(HttpServletRequest request, @PathVariable Integer orderId) {
        service.approveOrder(orderId);
    }
}
