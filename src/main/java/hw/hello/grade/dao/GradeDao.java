package hw.hello.grade.dao;

import hw.hello.grade.domain.Grade;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class GradeDao {

    private static final String GRADE_INSERT_QUERY = "INSERT INTO GRADE (lecture_id, student_id, grade) VALUES (?, ?, ?)";
    private static final String GRADE_BY_LECTURE_SELECT_QUERY = "SELECT * from GRADE g "
            + "INNER JOIN MEMBER m ON g.student_id = m.member_id "
            + "INNER JOIN LECTURE l ON g.lecture_id = l.lecture_id "
            + "WHERE g.lecture_id = ?";
    private static final String GRADE_BY_MEMBER_SELECT_QUERY = "SELECT * from GRADE g "
            + "INNER JOIN MEMBER m ON g.student_id = m.member_id "
            + "INNER JOIN LECTURE l ON g.lecture_id = l.lecture_id "
            + "WHERE g.student_id = ?";
    private static final RowMapper<Grade> GRADE_ROW_MAPPER = (rs, rowNum) -> new Grade(
            rs.getLong("g.id"),
            rs.getString("l.name"),
            rs.getString("m.name"),
            rs.getInt("l.credit"),
            rs.getDouble("g.grade")
    );

    private final JdbcTemplate jdbcTemplate;

    public GradeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void registerGrade(Long lectureId, Long studentId, double grade) {
        jdbcTemplate.update(GRADE_INSERT_QUERY, lectureId, studentId, grade);
    }

    public List<Grade> findAllByLectureId(Long lectureId) {
        return jdbcTemplate.query(GRADE_BY_LECTURE_SELECT_QUERY, GRADE_ROW_MAPPER, lectureId);
    }

    public List<Grade> findAllByMemberId(Long memberId) {
        return jdbcTemplate.query(GRADE_BY_MEMBER_SELECT_QUERY, GRADE_ROW_MAPPER, memberId);

    }
}
