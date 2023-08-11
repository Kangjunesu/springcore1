package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {  // 전체 동작 방식을 구성(config), 구현객체 생성, 연결.

    public MemberService memberService() {  //생성자 주입
        return new MemberServiceImpl(new MemoryMemberRepository());  // MemberServiceImpl 구현체를 생성할때 MemoryMemberRepository를 주입
    }
    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }
}
