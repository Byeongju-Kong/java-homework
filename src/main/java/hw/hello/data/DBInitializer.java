package hw.hello.data;

import hw.hello.grade.repository.GradeRepository;
import hw.hello.member.domain.Member;
import hw.hello.member.repository.MemberRepository;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBInitializer {

    private final MemberRepository memberRepository;
    private final GradeRepository gradeRepository;

    public DBInitializer(MemberRepository memberRepository,
                         GradeRepository gradeRepository) {
        this.memberRepository = memberRepository;
        this.gradeRepository = gradeRepository;
    }

    @PostConstruct
    public void init(){
        Member admin = Member.newMember(
                "관리자", 20170000, "asdf123!!", "010-1234-1234", "ADMIN");
        Member student1 = Member.newMember(
                "고민호", 20182670, "asdf123!!", "010-5473-6760", "STUDENT");
        Member student2 = Member.newMember(
                "공병주", 20172703, "asdf123!!", "010-5590-3624", "STUDENT");
        Member professor1 = Member.newMember(
                "다니엘", 20170001, "asdf123!!", "010-1111-1111", "PROFESSOR");
        memberRepository.saveAll(List.of(admin, student1, student2, professor1));
    }
}
