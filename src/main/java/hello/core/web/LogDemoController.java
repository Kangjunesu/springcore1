package hello.core.web;

import hello.core.common.MyLogger;

import hello.core.logdemo.LogDemoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor  // 생성자 자동 주입
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) { //HttpServletRequest Http요청정보를 받을 수 있음
        String requestURL = request.getRequestURL().toString(); // 고객이 어떤 url로 요청했는지 알 수 있음
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }

}