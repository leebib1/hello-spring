package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.order.RateDiscountPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //애플리케이션의 구성 정보를 담는 클래스로 지정하는 애너테이션
public class AppConfig { //애플리케이션에 대한 구성 설정을 해당 클래스가 전부 할 수 있도록 지정.
    @Bean //@Bean 애너테이션을 이용하면 스프링 빈 컨테이너에 등록된다.
    //@Bean을 사용한 모든 메소드를 호출해서 반환된 객체를 스프링 컨테이너에 등록.
    public MemberService memberService(){

        return new MemberServiceImpl(memberRepository()); //생성자 주입 의존관계
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        //다른 service에서 memberRepository를 불러다 쓰더라도 변경 사항이 생겼을 때 리턴값만 변경해주면 된다.
        //역할이 확실하게 구분된다.
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDicountPolicy();
        return new RateDiscountPolicy(); //할인 정책이 바뀌더라도 사용 영역의 코드를 수정 하지 않고 설정 하는 부분만 수정
    }
}
