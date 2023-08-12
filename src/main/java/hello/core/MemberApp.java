package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();  // memberService를 직접 메인메서드에서 생성하는게 아닌 appconfig로

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // AppConfig에 있는 설정 정보를 갖고 스프링이 @Beab붙은 것들을 컨테이너에 넣고 관리

        MemberService memberService =
                applicationContext.getBean("memberService", MemberService.class); // AppConfig에서 찾을 객체, 타입을 MemberService.class

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
