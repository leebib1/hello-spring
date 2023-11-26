package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(
        //excludeFilters : 지정한 것을 스프링 빈으로 등록하는 것들 중에서 제외한다
        //기존 예제 코드를 만들어둔 것이 있기 때문에 수동 등록한 것과 구분해서 확인하기 위해 제외
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
        //basePackages : 컴포넌트 스캔을 시작할 탐색 위치를 지정하는 속성
        basePackages = "hello.core"
)
public class AutoAppConfig {

//    @Bean("memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
