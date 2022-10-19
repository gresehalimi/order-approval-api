package com.melita.orderapprovalapi.agent;

import com.melita.orderapprovalapi.common.Country;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "agent")
@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String publicId;
    private String email;
    private String city;
    private Country country;
    private Availability availability;

    enum Availability{
        NOT_AVAILABLE,
        AVAILABLE
    }
}
