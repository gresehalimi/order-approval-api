package com.melita.orderapprovalapi.order.inbound;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderInbounding {

    private Integer orderId;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String installationAddress;
    private String products;
    private String dateTimeInstallation;
}
