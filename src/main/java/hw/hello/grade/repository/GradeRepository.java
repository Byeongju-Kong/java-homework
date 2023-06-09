package hw.hello.grade.repository;

import hw.hello.grade.domain.Grade;
import hw.hello.member.domain.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    List<Grade> findByLectureId(Long lectureId);

    List<Grade> findByStudent(Member student);

    Grade findByLectureIdAndStudentId(Long lectureId, Long studentId);

    void deleteByLectureIdAndStudentId(Long lectureId, Long studentId);

    void deleteByStudentId(Long studentId);
}
