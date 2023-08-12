package hello.core.beanfind;
import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import
        org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.*;
class ApplicationContextBasicFindTest {  // 스프링 빈 조회
    AnnotationConfigApplicationContext ac = new
            AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService",   //ac.getBean
                MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }//어떤게 객체 인스턴스인지.  memberService가 MemberServiceImpl의 인스턴스이면 성공

    @Test
    @DisplayName("이름 없이 타입만으로 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);  // 인터페이스 조회
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체 타입으로 조회")  // 좋은 경우는 아님.
    void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService",
                MemberServiceImpl.class);                               //Impl 구체 클래스로 조회
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX() {
        //ac.getBean("xxxxx", MemberService.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () ->  // assertThrows 예외처리. 예외가 터져야 테스트가 성공처리
                ac.getBean("xxxxx", MemberService.class));
    }
}
