package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    //@id : 해당 프로퍼티가 테이블의 주키(primary key) 역할을 한다는 것을 나타낸다
    //@GeneratedValue : 주키의 값을 위한 자동 생성 전략을 명시하는데 사용한다.
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

//  Address의 내장 필드를 사용하기 위해 생성
    @Embedded
    private Address address;

    //일대다 관계
    //읽기전용
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
