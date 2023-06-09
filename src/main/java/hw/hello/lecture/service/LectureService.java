package hw.hello.lecture.service;

import hw.hello.exception.ForbiddenException;
import hw.hello.lecture.dao.LectureDao;
import hw.hello.lecture.domain.Lecture;
import hw.hello.lecture.domain.MemberLecture;
import hw.hello.lecture.repository.LectureRepository;
import hw.hello.lecture.repository.MemberLectureRepository;
import hw.hello.member.dao.MemberDao;
import hw.hello.member.domain.Member;
import hw.hello.member.repository.MemberRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LectureService {

    private final MemberRepository memberRepository;
    private final LectureRepository lectureRepository;
    private final MemberLectureRepository memberLectureRepository;

    public LectureService(MemberRepository memberRepository, LectureRepository lectureRepository,
                          MemberLectureRepository memberLectureRepository) {
        this.memberRepository = memberRepository;
        this.lectureRepository = lectureRepository;
        this.memberLectureRepository = memberLectureRepository;
    }

    @Transactional
    public void register(Long memberId, String name, int credit) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow();
        if (!member.isProfessor()) {
            throw new ForbiddenException("교수만 강의를 등록할 수 있습니다.");
        }
        Lecture lecture = Lecture.initial(member, name, credit);
        lectureRepository.save(lecture);
    }

    @Transactional(readOnly = true)
    public List<Lecture> findAllLectures() {
        return lectureRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Lecture findLecture(Long lectureId) {
        return lectureRepository.findById(lectureId)
                .orElseThrow();
    }

    @Transactional
    public void registerStudentToLecture(Long memberId, Long lectureId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow();
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow();
        if (!member.isStudent()) {
            throw new ForbiddenException("학생만 수강신청 가능");
        }
        MemberLecture memberLecture = new MemberLecture(member, lecture);
        memberLectureRepository.save(memberLecture);
    }
}
