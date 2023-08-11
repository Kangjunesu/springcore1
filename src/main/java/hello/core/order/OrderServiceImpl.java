package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();  //회원 찾기
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();  //할인 정책 일단 고정으로
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);   // 회원 정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice);  // 회원 정보를 넘김

        return new Order(memberId, itemName, itemPrice, discountPrice);  //주문을 반환
    }
}
