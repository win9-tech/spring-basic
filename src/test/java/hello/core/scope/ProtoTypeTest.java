package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class ProtoTypeTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);
        System.out.println("find Bean1");
        ProtoTypeBean bean1 = ac.getBean(ProtoTypeBean.class);
        System.out.println("find Bean2");
        ProtoTypeBean bean2 = ac.getBean(ProtoTypeBean.class);

        ac.close();
        assertThat(bean1).isNotSameAs(bean2);
    }
    @Scope("prototype")
    static class ProtoTypeBean{
        @PostConstruct
        public void init(){
            System.out.println("init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("destroy");
        }
    }
}
