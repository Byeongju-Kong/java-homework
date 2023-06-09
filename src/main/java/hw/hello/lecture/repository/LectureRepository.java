package hw.hello.lecture.repository;

import hw.hello.lecture.domain.Lecture;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

    List<Lecture> findByProfessorId(Long professorId);
}
