package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig=new AppConfig();
//        MemberService memberService= appConfig.memberService();
//        MemberService memberService=new MemberServiceImpl();

        ApplicationContext applicationContext=new AnnotationConfigReactiveWebApplicationContext(AppConfig.class);
        //->AppConfig 클래스를 가지고 스프링에서 환경설정한다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member : "+member.getName());
        System.out.println("findMember : "+findMember.getName());
    }
}
