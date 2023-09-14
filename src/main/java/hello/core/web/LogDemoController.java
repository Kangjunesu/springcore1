package hello.core.web;

import hello.core.common.MyLogger;

import hello.core.logdemo.LogDemoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor  // 생성자 자동 주입
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerProvider; // MyLogger를 주입받는게 아닌 MyLogger를 찾을수 있는
                                            // dependency Lookup(의존 관계 조회 탐색) 할 수 있는 애가 주입됨
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) { //HttpServletRequest Http요청정보를 받을 수 있음
        String requestURL = request.getRequestURL().toString(); // 고객이 어떤 url로 요청했는지 알 수 있음
        MyLogger myLogger = myLoggerProvider.getObject(); // 여기서 myLogger를 받음
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";

    }

}