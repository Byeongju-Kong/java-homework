package hw.hello.lecture.service;

import hw.hello.exception.ForbiddenException;
import hw.hello.lecture.dao.LectureDao;
import hw.hello.lecture.domain.Lecture;
import hw.hello.member.dao.MemberDao;
import hw.hello.member.domain.Member;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LectureService {

    private final LectureDao lectureDao;
    private final MemberDao memberDao;

    public LectureService(LectureDao lectureDao, MemberDao memberDao) {
        this.lectureDao = lectureDao;
        this.memberDao = memberDao;
    }

    @Transactional
    public void register(Long memberId, String name, int credit) {
        Member member = memberDao.findById(memberId);
        if (!member.isProfessor()) {
            throw new ForbiddenException("교수만 강의를 등록할 수 있습니다.");
        }
        lectureDao.save(memberId, name, credit);
    }

    @Transactional(readOnly = true)
    public List<Lecture> findAllLectures() {
        return lectureDao.findAll();
    }

    @Transactional(readOnly = true)
    public Lecture findLecture(Long lectureId) {
        return lectureDao.findById(lectureId);
    }

    @Transactional
    public void registerStudentToLecture(Long memberId, Long lectureId) {
        Member member = memberDao.findById(memberId);
        if (!member.isStudent()) { // 학생만 수강신청 가능
            throw new ForbiddenException("학생만 수강신청 가능");
        }
        lectureDao.saveStudentLecture(lectureId, memberId);
    }
}
