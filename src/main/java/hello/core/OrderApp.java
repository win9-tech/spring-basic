package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderSerivce;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
    //    AppConfig appConfig = new AppConfig();
      //  MemberService memberService = appConfig.memberService();
        //OrderSerivce orderSerivce = appConfig.orderSerivce();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //ApplicationContext - 스프링 컨테이너, 인터페이스임

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderSerivce orderSerivce = applicationContext.getBean("orderService", OrderSerivce.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderSerivce.createOrder(memberId, "itemA", 10000);

        System.out.println("order = "+order);
    }
}
