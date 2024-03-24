package hello.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter //@Data는 불필요한 것들까지 전부 만들기 때문에 보통 사용하지 않는 것이 좋다.
public class Item {

    private Long id;
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
