package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    //자바 코드로 스프링 빈 등록

//    @Autowired
//    private DataSource dataSource;

//    private EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em=em;
//    }

    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//
//        //return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource); //다형성 활용
//        //스프링 컨테이너가 지원해준다. Repository를 변경하고 다른 코드를 전체적으로 바꾸지 않고 SpringConfing에서만 변경할 수 있다.
////        return new JdbcTemplateMemberRepository((JdbcTemplate) dataSource);
//        return new JpaMemberRepository(em);
//    }
}
