package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
// 요청마다 생성되고, 요청이 끝나면 소멸
// MyLogger의 가짜 프록시 클래스를 만들어두고 HTTP request와 상관 없이 가짜 프록시 클래스를 다른 빈에 미리 주입.
//스프링 컨테이너는 CGLIB라는 바이트코드를 조작하는 라이브러리를 사용해서, MyLogger를 상속받은 가짜 프록시 객체를 생성
//진짜 객체 조회를 꼭 필요한 시점까지 지연처리
public class MyLogger {  //로그를 출력하기 위한 클래스
    private String uuid;
    private String requestURL;
    public void setRequestURL(String requestURL) {  //requestURL은 빈이 생성되는 시점에는 알수 없으므로
        this.requestURL = requestURL;               // 외부에서 setter로 입력받음
    }
    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }
    @PostConstruct //빈 생섬 시점에 자동으로 초기화 메서드 실행
    public void init() {
        uuid = UUID.randomUUID().toString();// 유니크한 ID가 생성됨. 절대 안겹침.
        System.out.println("[" + uuid + "] request scope bean create:" + this);
    }
    @PreDestroy  //빈 소멸시점에 종료메세지 남김
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }
}