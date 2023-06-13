package hw.hello.data;

import hw.hello.grade.domain.Grade;
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
    private final LectureRepository lectureRepository;
    private final GradeRepository gradeRepository;
    private final MemberLectureRepository memberLectureRepository;

    public DBInitializer(MemberRepository memberRepository,
                         LectureRepository lectureRepository,
                         GradeRepository gradeRepository, MemberLectureRepository memberLectureRepository) {
        this.memberRepository = memberRepository;
        this.lectureRepository = lectureRepository;
        this.gradeRepository = gradeRepository;
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
        Member professor2 = Member.newMember(
                "김철수", 20170002, "asdf123!!", "010-4442-7567", "PROFESSOR");
        Member professor3 = Member.newMember(
                "손흥민", 20170003, "asdf123!!", "010-1513-4515", "PROFESSOR");

        Lecture lecture1 = new Lecture(null, professor1, "고급자바프로그래밍", 3, null, null);
        Lecture lecture2 = new Lecture(null, professor2, "놀이행복론", 2, null, null);
        Lecture lecture3 = new Lecture(null, professor3, "인간관계론", 1, null, null);

        MemberLecture memberLecture1 = new MemberLecture(student1, lecture1);
        MemberLecture memberLecture2 = new MemberLecture(student2, lecture1);
        MemberLecture memberLecture3 = new MemberLecture(student2, lecture2);
        Grade grade1 = Grade.initial(lecture1, student2, 4.5);
        Grade grade2 = Grade.initial(lecture2, student2, 3.5);

        memberRepository.saveAll(List.of(admin, student1, student2, professor1, professor2, professor3));
        lectureRepository.saveAll(List.of(lecture1, lecture2, lecture3));
        memberLectureRepository.saveAll(List.of(memberLecture1, memberLecture2, memberLecture3));
        gradeRepository.saveAll(List.of(grade1, grade2));
    }
}
