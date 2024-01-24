package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderSerivce orderSerivce;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderSerivce = appConfig.orderService();
    }
    @Test
    void createOrder(){
        Long memberId = 1l; //객체형식 null을 못넣어서 long으로 안하고 Long으로 하는거임
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderSerivce.createOrder(memberId, "orderA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
    @Test
    void fieldInjextionTest(){
    }
}
