package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)//이걸 하면 프로바이더 없어도 댐 가짜 프록시객체를 줌(웹프록시아니여도사용가능)
//프로바이더 프록시든 진짜 요청이 들어오기전까지 지연처리한다는 점이 중요한거임
public class MyLogger {
    private String uuid;
    @Setter
    private String requestURL;

    public void log(String message){

        System.out.println("[" + uuid+ "]" +"["+requestURL+"] "+message);
    }
    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid+ "] request scope create"+this);
    }
    @PreDestroy
    public void close(){
        System.out.println("[" + uuid+ "] request scope close"+this);
    }
}
