package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforEach(){
        AppConfig appConfig=new AppConfig();
        memberService= appConfig.memberService();
        orderService= appConfig.orderService();
    }
    @Test
    void createOrder(){
        Long memberId=1L;
        Member member=new Member(memberId, "memberA", Grade.VIP);

//        Order order=orderService.createOreder(memberId, "itemA", 100000);
//        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void fieldInjectionTest() {
//        OrderServiceImpl orderService=new OrderServiceImpl();
        //필드 주입 한 경우, setter 메소드를 따로 지정해서 넣어주지 않으면 에러가 발생함
        orderService.createOreder(1L, "itemA", 10000);
    }
}
