package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

//필드를 내장하기 위해 설정(Address -> city, street, zipcode 3개의 필드가 생성)
@Embeddable
@Getter
@Setter
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
