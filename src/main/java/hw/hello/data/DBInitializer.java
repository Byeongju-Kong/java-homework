package hw.hello.data;

import hw.hello.grade.repository.GradeRepository;
import hw.hello.lecture.domain.Lecture;
import hw.hello.lecture.domain.MemberLecture;
import hw.hello.lecture.repository.LectureRepository;
import hw.hello.lecture.repository.MemberLectureRepository;
import hw.hello.member.domain.Member;
import hw.hello.member.repository.MemberRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer {

    private final MemberRepository memberRepository;
    private final GradeRepository gradeRepository;
    private final LectureRepository lectureRepository;
    private final MemberLectureRepository memberLectureRepository;

    public DBInitializer(MemberRepository memberRepository,
                         GradeRepository gradeRepository,
                         LectureRepository lectureRepository,
                         MemberLectureRepository memberLectureRepository) {
        this.memberRepository = memberRepository;
        this.gradeRepository = gradeRepository;
        this.lectureRepository = lectureRepository;
        this.memberLectureRepository = memberLectureRepository;
    }

    @PostConstruct
    public void init() {
        Member admin = Member.newMember(
                "관리자", 20170000, "asdf123!!", "010-1234-1234", "ADMIN");
        Member student1 = Member.newMember(
                "고민호", 20182670, "asdf123!!", "010-5473-6760", "STUDENT");
        Member student2 = Member.newMember(
                "공병주", 20172703, "asdf123!!", "010-5590-3624", "STUDENT");
        Member professor1 = Member.newMember(
                "다니엘", 20170001, "asdf123!!", "010-1111-1111", "PROFESSOR");

        Lecture lecture1 = new Lecture(null, professor1, "고급자바프로그래밍", 3, null);

        MemberLecture memberLecture1 = new MemberLecture(student1, lecture1);

        memberRepository.saveAll(List.of(admin, student1, student2, professor1));
        lectureRepository.saveAll(List.of(lecture1));
        memberLectureRepository.saveAll(List.of(memberLecture1));
    }
}
