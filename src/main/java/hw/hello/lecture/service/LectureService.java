package hw.hello.lecture.service;

import hw.hello.exception.ForbiddenException;
import hw.hello.exception.NotFoundException;
import hw.hello.lecture.domain.Lecture;
import hw.hello.lecture.domain.MemberLecture;
import hw.hello.lecture.repository.LectureRepository;
import hw.hello.lecture.repository.MemberLectureRepository;
import hw.hello.member.domain.Member;
import hw.hello.member.repository.MemberRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
                .orElseThrow(NotFoundException::member);
        if (!member.isProfessor()) {
            throw new ForbiddenException("교수만 강의를 등록할 수 있습니다.");
        }
        Lecture lecture = Lecture.initial(member, name, credit);
        lectureRepository.save(lecture);
    }

    @Transactional(readOnly = true)
    public List<LectureInfoResponse> findAllLectures() {
        return lectureRepository.findAll()
                .stream()
                .map(LectureInfoResponse::new)
                .collect(Collectors.toUnmodifiableList());
    }

    @Transactional(readOnly = true)
    public List<LectureInfoResponse> findByProfessorId(Long professorId) {
        return lectureRepository.findByProfessorId(professorId)
                .stream()
                .map(LectureInfoResponse::new)
                .collect(Collectors.toUnmodifiableList());
    }

    @Transactional(readOnly = true)
    public LectureInfoResponse findLecture(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(NotFoundException::lecture);
        return new LectureInfoResponse(lecture);
    }

    @Transactional
    public void registerStudentToLecture(Long memberId, Long lectureId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(NotFoundException::member);
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(NotFoundException::lecture);
        if (!member.isStudent()) {
            throw new ForbiddenException("학생만 수강신청 가능");
        }
        MemberLecture memberLecture = new MemberLecture(member, lecture);
        try {
            memberLectureRepository.save(memberLecture);
        } catch (Exception e) {
            throw new ForbiddenException("이미 신청한 강의입니다");
        }
    }
}
