package hello.core.member;

public class MemberServiceImpl implements MemberService{  //인터페이스 구현

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //join에서 save를 호출하면 다형성에 의해 MemoryMemberRepository에 있는 save가 호출됨
    public void join(Member member) {
        memberRepository.save(member);
    }
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
