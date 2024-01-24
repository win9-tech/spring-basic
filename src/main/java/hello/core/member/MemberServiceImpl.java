package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; //

    @Autowired //ac.getBean(MemberRepository.class) 타입으로 찾아옴
    public MemberServiceImpl(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
    //구현체가 하나만 있을때는 impl이라고 많이 쓴다.
    //테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}

