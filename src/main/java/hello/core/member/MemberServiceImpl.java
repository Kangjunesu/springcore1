package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{  //인터페이스 구현

    private final MemberRepository memberRepository;  // MemoryMemberRepository 의존안하고, MemberRepository 인터페이스만 의존.(추상화에만 의존 DIP)

    @Autowired // 자동 의존관계 주입.
    public MemberServiceImpl(MemberRepository memberRepository) {  // 생성자 주입
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        memberRepository.save(member);
    }
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //싱글톤 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
