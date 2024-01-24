package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;// 이러면 MyLogger를 찾는게 아니라 MyLogger를 찾을수있는

    @RequestMapping("log-demo")
    @ResponseBody
    public void logDemo(HttpServletRequest request){

        String requestURL = request.getRequestURL().toString(); //GETREQUESTURI랑 다름
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
    }
}
