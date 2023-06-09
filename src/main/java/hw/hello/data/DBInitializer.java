package hw.hello.data;

import hw.hello.member.domain.Member;
import hw.hello.member.repository.MemberRepository;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer {

    private final MemberRepository memberRepository;

    public DBInitializer(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostConstruct
    public void init(){
        Member member = Member.newMember(
                "관리자", 20170000, "asdf123!!", "010-1234-1234", "ADMIN");
        memberRepository.save(member);
    }
}
