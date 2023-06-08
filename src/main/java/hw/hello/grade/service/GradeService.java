package hw.hello.grade.service;

import hw.hello.exception.ForbiddenException;
import hw.hello.grade.dao.GradeDao;
import hw.hello.grade.domain.Grade;
import hw.hello.member.dao.MemberDao;
import hw.hello.member.domain.Member;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GradeService {

    private final GradeDao gradeDao;
    private final MemberDao memberDao;

    public GradeService(GradeDao gradeDao, MemberDao memberDao) {
        this.gradeDao = gradeDao;
        this.memberDao = memberDao;
    }

    @Transactional
    public void registerGrade(Long id, Long lectureId, Long studentId, double grade) {
        Member member = memberDao.findById(id);
        if(!member.isProfessor()) {
            throw new ForbiddenException("교수만 성적 등록 가능");
        }
        gradeDao.registerGrade(lectureId, studentId, grade);
    }

    @Transactional(readOnly = true)
    public List<Grade> findAllByLectureId(Long memberId, Long lectureId) {
        Member member = memberDao.findById(memberId);
        if(member.isStudent()) {
            throw new ForbiddenException("학생은 강의별 전체 성적 조회 불가능");
        }
        return gradeDao.findAllByLectureId(lectureId);
    }

    @Transactional(readOnly = true)
    public List<Grade> findAllByMemberId(Long memberId) {
        return gradeDao.findAllByMemberId(memberId);
    }
}
