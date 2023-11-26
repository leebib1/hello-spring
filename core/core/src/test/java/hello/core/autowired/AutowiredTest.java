package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false) //실행 자체를 안 함
        public void setNoBean1(Member member) {
            System.out.println("nobean1 : "+member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("nobean2 : "+member);
        }

        @Autowired(required = false)
        public void setNoBean3(Optional<Member> member) {
            System.out.println("nobean3 : "+member);
        }
    }

}
