package hw.hello.lecture.repository;

import hw.hello.lecture.domain.MemberLecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberLectureRepository extends JpaRepository<MemberLecture, Long> {

    void deleteByMemberIdAndLectureId(Long memberId, Long lectureId);
}
