package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000")
public class Item {

//    @NotNull(groups = UpdateCheck.class) //수정시에만 적용
    private Long id;

//    @NotBlank(message = "공백X", groups = {UpdateCheck.class, SaveCheck.class}) //빈값+공백만 있는 경우 허용하지 않는다.
    private String itemName;

//    @NotNull(groups = {UpdateCheck.class, SaveCheck.class}) //Null 값을 허용하지 않는다.
//    @Range(min = 1000, max = 1000000, groups = {UpdateCheck.class, SaveCheck.class}) //지정 범위 안의 값이어야 한다.
    private Integer price;

//    @NotNull(groups = {UpdateCheck.class, SaveCheck.class})
//    @Max(value = 9999, groups = SaveCheck.class) //최대 지정값까지만 허용한다. 등록시에만 적용
    private Integer quantity;

//    public Item() {
//    }
//
//    public Item(String itemName, Integer price, Integer quantity) {
//        this.itemName = itemName;
//        this.price = price;
//        this.quantity = quantity;
//    }
}
