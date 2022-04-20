package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    //ORDINAL 숫자가 순서대로 들어간다.(중간에 다른 숫자가 들어가면 망한다.)
    //STRING으로 써야 한다.
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //ready, comp
}
