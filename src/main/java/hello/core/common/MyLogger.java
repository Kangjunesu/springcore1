package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
@Scope(value = "request") // 요청마다 생성되고, 요청이 끝나면 소멸
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