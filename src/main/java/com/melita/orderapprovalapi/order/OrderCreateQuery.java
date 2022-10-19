package com.melita.orderapprovalapi.order;

import lombok.Builder;
import lombok.Getter;
import lombok.With;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Builder
@Getter
@With
public class OrderCreateQuery {

    private final Integer id;
    private final String customerName;
    private final String customerPhone;
    private final String customerEmail;
    private final String installationAddress;
    private final String products;
    private final LocalDateTime dateTimeInstallation;
    private final Order.State state;
    @CreationTimestamp
    private final Instant createdAt;
}
