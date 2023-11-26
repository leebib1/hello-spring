package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDicountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //final이 붙은 필드를 가지고 생성자를 만들어준다.
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    private final MemberRepository memberRepository=new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy=new FixDicountPolicy();
    //단일 책임 원칙을 잘 수행한 코드
    //-> 할인 정책에 대한 코드를 따로 분리하지 않은 경우 할인 정책이 변경될 때 주문 쪽까지 함께 전체적으로 수정해야 한다.
//    private final DiscountPolicy discountPolicy=new RateDiscountPolicy(); //DIP, OCP를 위반한 코드
    //코드 수정이 일어난 위와 같은 코드는 DiscountPolicy 인터페이스에 의존하는 게 아닌 구현 객체에도 의존한 상태가 된다.
    //실제 구현 객체에도 의존하면서(DIP 위반) 정책이 변경될 때 OrderServiceImpl의 코드도 변경된다.(OCP 위반)

    //필드 주입
//    @Autowired private DiscountPolicy discountPolicy;
//    @Autowired private MemberRepository memberRepository;

    //인터페이스에만 의존하도록 설계하려면 인터페이스만 선언하면 되지만 NullPointException이 발생
    //->구현 객체를 대신 생성하고 주입해 줄 수 있는 역할이 필요 ->AppConfig가 해당 역할을 수행
    //OrderServiceImpl은 실행 전에 어떤 객체가 들어올지 알 수 없고 해당 부분은 AppCofig가 지정한다.

//    @Autowired(required = false) //Autowired가 실행될 때 주입 대상이 없으면 에러가 나기 때문에 주입 대상이 없어도 동작하게 하기 위해서 required 설정을 false로 둔다.
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy : "+discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }
//
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository : "+memberRepository);
//        this.memberRepository = memberRepository;
//    }

    @Autowired //의존관계 생성자 주입
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy : "+discountPolicy);
        System.out.println("memberRepository : "+memberRepository);
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    //일반 메소드 주입
    /*@Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository=memberRepository;
        this.discountPolicy=discountPolicy;
    }*/

    @Override
    public Order createOreder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        int discountPrice=discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
