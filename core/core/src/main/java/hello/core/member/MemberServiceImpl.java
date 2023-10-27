package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //DIP 위반 구조
//    private final MemberRepository memberRepository=new MemoryMemberRepository();
    private final MemberRepository memberRepository; //MemoryMemberRepository에 대한 코드가 사라지고 인터페이스에만 의존

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member); //다형성에 의해 오버라이드한 save()가 호출
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
