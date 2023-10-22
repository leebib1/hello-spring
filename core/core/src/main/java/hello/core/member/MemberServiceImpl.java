package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //DIP 위반 구조
    private final MemberRepository memberRepository=new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member); //다형성에 의해 오버라이드한 save()가 호출
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
