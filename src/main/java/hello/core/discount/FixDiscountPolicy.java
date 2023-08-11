package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {  // 정액 할인 정책 구현체

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {  // Enum은 == 쓰는게 맞음.
            return discountFixAmount;
        } else {
            return 0;
        }
    }

}
