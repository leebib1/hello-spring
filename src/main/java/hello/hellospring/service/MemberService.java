package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){ //외부에서 레포지토리를 넣어준다 ->DI(의존성 주입)
        this.memberRepository=memberRepository;
    }
    
    public Long join(Member member){ //회원 가입
        //같은 이름 회원 x
        vaildateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void vaildateDuplicateMember(Member member){ //회원 중복 검사
        //Optional<Member> result = memberRepository.findByName(member.getName());
        //result.orElseGet() -> 값이 있으면 꺼내고 아니면 꺼내지 않는
        //result.ifPresent(m->{ //null이 아니고 값이 있으면 동작. Optional을 사용 안 할 때는 null인 경우를 분기처리
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() { //전체 회원 조회
        return memberRepository.findAll();
    }
    
    public  Optional<Member> findOne(Long memberId){ //ID로 조회
        return memberRepository.findById(memberId);
    }
}
