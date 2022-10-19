package com.melita.orderapprovalapi.order;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "order_approval")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer orderId;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String installationAddress;
    private String products;
    private LocalDateTime dateTimeInstallation;
    @Enumerated(EnumType.STRING)
    private State state;
    private String agentName;
    @CreationTimestamp
    private Instant createdAt;

    public enum State {
        PENDING,
        APPROVED
    }
    }

