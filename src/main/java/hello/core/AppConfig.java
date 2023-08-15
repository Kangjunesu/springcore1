package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

        // @Bean memberService -> new MemoryMemberRepository() 호출
        // @Bean orderService -> new MemoryMemberRepository() 또 호출

        //soutm 예상
//        call AppConfig.memberService
//        call AppConfig.memberRepository
//        call AppConfig.memberRepository
//        call AppConfig.orderService
//        call AppConfig.memberRepository

        //실제
        //call AppConfig.memberService
        //call AppConfig.memberRepository
        //call AppConfig.orderService
//스프링이 싱글톤을 보장했음. @Configuration을 없애면 예상대로 나옴

@Configuration  // 설정 정보, 구성 정보
public class AppConfig {  // 전체 동작 방식을 구성(config), 구현객체 생성, 연결.

    @Bean
    public MemberService memberService() {  //생성자 주입
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),  // 설계에 대한 그림이 구성정보에 드러나게
                discountPolicy());  // 역할과 구현클래스가 파악하기 쉽게.
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
