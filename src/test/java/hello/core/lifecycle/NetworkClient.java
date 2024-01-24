package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient{
    private String url;

    public NetworkClient(){
        System.out.println("생성자를 호출 url =" + url);
    }
    public void setUrl(String url){
        this.url = url;
    }
    public void connect(){
        System.out.println("connect = " + url);
    }
    public void call(String message){
        System.out.println("call: "+url+" memssege = "+message);
    }
    public void disconnect(){
        System.out.println("close: "+url);
    }

    @PostConstruct
    public void init() throws Exception { //속성이 설정되고 바로
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }
    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
