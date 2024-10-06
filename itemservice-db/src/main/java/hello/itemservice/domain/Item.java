package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity //JPA가 사용하는 객체라는 뜻의 애노테이션. 속성으로 name을 작성할 수 있지만 클래스명과 테이블명이 동일하면 생략 가능
public class Item {

    @Id //테이블의 PK와 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", length = 10) //객체의 필드와 테이블의 컬럼을 매핑. 카멀케이스를 언더스코어로 자동 변환하기 때문에 name 속성 생략 가능
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
