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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;
    private final MemberRepository memberRepository;
    private final LectureRepository lectureRepository;

    @Transactional
    public void registerGrade(Long memberId, Long lectureId, Long studentId, double gradeValue) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(NotFoundException::member);
        Member student = memberRepository.findById(studentId)
                .orElseThrow(NotFoundException::member);
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(NotFoundException::lecture);
        if (!member.isProfessor()) {
            throw new ForbiddenException("교수만 성적 등록 가능");
        }
        Grade grade = Grade.initial(lecture, student, gradeValue);
        gradeRepository.save(grade);
    }

    @Transactional(readOnly = true)
    public GradeResponses findAllByMemberId(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(NotFoundException::member);
        if (!member.isStudent()) {
            throw new ForbiddenException("학생만 개인 성적 조회 가능");
        }
        List<Grade> grades = gradeRepository.findByStudent(member);
        return new GradeResponses(grades);
    }

    @Transactional
    public void modifyGrade(Long memberId, Long lectureId, Long studentId, double gradeValue) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(NotFoundException::member);
        if (!member.isProfessor()) {
            throw new ForbiddenException("교수만 성적 입력 및 수정 가능");
        }
        Grade grade = gradeRepository.findByLectureIdAndStudentId(lectureId, studentId);
        grade.modifyGrade(gradeValue);
    }
}
