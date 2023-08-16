package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;  //인터페이스에만 의존하도록 변경
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);   // 회원 정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice);  // 회원 정보를 넘김

        return new Order(memberId, itemName, itemPrice, discountPrice);  //주문을 반환
    }

    //싱글톤 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
