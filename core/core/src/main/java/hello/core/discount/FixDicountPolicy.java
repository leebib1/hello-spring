package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixDiscountPolicy")
public class FixDicountPolicy implements DiscountPolicy{
    
    private int discountFixAmount=1000; //천원 고정 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){ //Enum 타입은 == 비교
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
