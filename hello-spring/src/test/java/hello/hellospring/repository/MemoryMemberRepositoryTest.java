package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest { //클래스 실행으로 아래 작성한 테스트 메소드를 한 번에 테스트 가능
    //Test코드는 메소드 실행 순서가 임의로 실행되기 때문에 각 테스트 코드는 순서에 의존적이면 안 된다.
    MemoryMemberRepository repository=new MemoryMemberRepository();

    @AfterEach //test코드 실행 마다 실행되는 메소드
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result=repository.findById(member.getId()).get();
        //assertEquals(member, result); //다른 객체면 AssertionFiledError를 띄워준다.
        assertThat(member).isEqualTo(result); //static import 해두면 클래스 접근 없이 사용 가능
    }

    @Test
    public void findByName(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result=repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
        //assertThat(result).isEqualTo(member2); ->error
    }

    @Test
    public void findAll(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result=repository.findAll();

        assertThat(result.size()).isEqualTo(2);
        //assertThat(result.size()).isEqualTo(1); ->error 기대 값은 2개인데 1개라고 뜸
    }
}
