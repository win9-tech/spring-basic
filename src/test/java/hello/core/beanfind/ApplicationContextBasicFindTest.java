package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanBytype(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByname(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

        //System.out.println("memberService = " + memberService); // Bean의 실제인스턴스
        //System.out.println("memberService.getClass() = " + memberService.getClass());//해당 인스턴스의 클래스 정보

    }
    @Test
    @DisplayName("구체 타입으로만 조회")
    void findBeanBytype2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);//구현에 의존해서 별로 좋은 코드는 아님
    }
    /*@Test
    @DisplayName("빈 이름으로 조회 x")
    void findBeanBytypeX(){
        MemberService memberService = ac.getBean("DDD",MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("DDD", MemberService.class));
    }*/
}
