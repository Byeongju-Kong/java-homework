package hw.hello.grade.service;

import hw.hello.exception.ForbiddenException;
import hw.hello.exception.NotFoundException;
import hw.hello.grade.domain.Grade;
import hw.hello.grade.repository.GradeRepository;
import hw.hello.lecture.domain.Lecture;
import hw.hello.lecture.repository.LectureRepository;
import hw.hello.member.domain.Member;
import hw.hello.member.repository.MemberRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;
    private final MemberRepository memberRepository;
    private final LectureRepository lectureRepository;

    public GradeService(GradeRepository gradeRepository, MemberRepository memberRepository,
                        LectureRepository lectureRepository) {
        this.gradeRepository = gradeRepository;
        this.memberRepository = memberRepository;
        this.lectureRepository = lectureRepository;
    }

    @Transactional
    public void registerGrade(Long lectureId, Long studentId, int credit, double gradeValue) {
        Member member = memberRepository.findById(studentId)
                .orElseThrow(NotFoundException::member);
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(NotFoundException::lecture);
        if (!member.isProfessor()) {
            throw new ForbiddenException("교수만 성적 등록 가능");
        }
        Grade grade = Grade.initial(lecture, member, credit, gradeValue);
        gradeRepository.save(grade);
    }

    @Transactional(readOnly = true)
    public List<GradeResponse> findAllByLectureId(Long memberId, Long lectureId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(NotFoundException::lecture);
        if (member.isStudent()) {
            throw new ForbiddenException("학생은 강의별 전체 성적 조회 불가능");
        }
        return gradeRepository.findByLectureId(lectureId)
                .stream()
                .map(GradeResponse::new)
                .collect(Collectors.toUnmodifiableList());
    }

    @Transactional(readOnly = true)
    public List<GradeResponse> findAllByMemberId(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(NotFoundException::member);
        if (!member.isStudent()) {
            throw new ForbiddenException("학생만 개인 성적 조회 가능");
        }
        return gradeRepository.findByLectureId(memberId)
                .stream()
                .map(GradeResponse::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
