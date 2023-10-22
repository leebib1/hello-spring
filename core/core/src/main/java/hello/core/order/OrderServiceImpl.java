package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDicountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository=new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy=new FixDicountPolicy();
    //단일 책임 원칙을 잘 수행한 코드
    //-> 할인 정책에 대한 코드를 따로 분리하지 않은 경우 할인 정책이 변경될 때 주문 쪽까지 함께 전체적으로 수정해야 한다.

    @Override
    public Order createOreder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        int discountPrice=discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
