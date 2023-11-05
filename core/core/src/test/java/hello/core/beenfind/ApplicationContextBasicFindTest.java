package hello.core.beenfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("타입으로 조회")
    void findBeanType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanType2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class); //인스턴스 타입을 보고 찾기 때문에 구현 객체로 찾아도 가능하다
        //인터페이스에 의존해야하기 때문에 좋은 코드는 아니다.
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanNameX(){
//        MemberService xxxx = ac.getBean("xxxx", MemberService.class); //NoSuchBeanDefinitionException: No bean named 'xxxx' available 예외 발생
        assertThrows(NoSuchBeanDefinitionException.class, ()-> ac.getBean("xxxx", MemberService.class));
        //해당 예외가 발생했을 때 성공
    }
}
