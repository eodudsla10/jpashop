package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

//필드를 내장하기 위해 설정(Address -> city, street, zipcode 3개의 필드가 생성)
@Embeddable
@Getter
public class Address {

    private String city;

    private String street;
    private String zipcode;

    //기본생성자 : proxy를 사용하기 위해서 사용해야 한다.
    //함부로 생성하는 것을 방지하기 위해 public -> protected로 설정
    protected Address() {
    }

    //@Setter를 사용하지 않고 생성자를 통해서 생성
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
