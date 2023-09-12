package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    //ctrl+shift+T 로 테스트 클래스 생성 가능
    //MemberService memberService=new MemberService();
    //MemoryMemberRepository memberRepository=new MemoryMemberRepository();
    //new를 이용해서 새로 생성해서 인스턴스가 다른 객체를 계속 생성해서 사용하는 것이 좋지 않음
    //Map을 static으로 선언해두어서 문제가 현재 코드에서는 문제가 없지만 다른 경우를 위해서 같은 인스턴스를 사용하도록 변경한다.
    MemoryMemberRepository memberRepository;
    MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        memberRepository=new MemoryMemberRepository();
        memberService=new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }
    @Test
    void 회원가입() {//테스트 코드는 직관적으로 확인하기 위해 한글로 사용해도 무방함 ->어차피 빌드 될 때 테스트 코드가 포함되지 않음
        //테스트 코드를 만들 때, 정상 로직 보다 예외가 발생하는 로직을 찾아서 실행시켜보는 것이 중요
        //given : 어떤 것이 주어졌을 때
        Member member=new Member();
        member.setName("hello");
        //when : 언제
        Long saveId=memberService.join(member);
        //then : 어떤 결과를 낼지
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1=new Member();
        member1.setName("spring");

        Member member2=new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, ()->memberService.join(member2)); //IllegalStateException이 발생하는지 확인 가능
        /*try {
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/


        //then

    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}