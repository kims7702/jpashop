package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@SequenceGenerator(
 name = "DELIVERY_SEQ_GENERATOR",
 sequenceName = "DELIVERY_SEQ",
 initialValue = 1,
 allocationSize = 1
)
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "DELIVERY_SEQ_GENERATOR")
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery",fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; // READY,COMP
}
