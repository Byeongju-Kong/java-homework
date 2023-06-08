package hw.hello.lecture.dao;

import hw.hello.lecture.domain.Lecture;
import hw.hello.member.domain.Member;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class LectureDao {

    private static final String LECTURE_INSERT_QUERY = "INSERT INTO LECTURE (professor_id, name, credit) VALUES (?, ?, ?)";
    private static final String SINGLE_LECTURE_SELECT_QUERY = "SELECT * FROM LECTURE l INNER JOIN Member m ON l.professor_id = m.member_id WHERE lecture_id = ?";
    private static final String ALL_LECTURE_SELECT_QUERY = "SELECT * FROM LECTURE l "
            + "INNER JOIN Member m ON l.professor_id = m.member_id";
    private static final RowMapper<Lecture> LECTURE_ROW_MAPPER = (rs, rowNum) ->
            new Lecture(
                    rs.getLong("l.lecture_id"),
                    rs.getString("m.name"),
                    rs.getString("m.phone_number"),
                    rs.getString("l.name"),
                    rs.getInt("l.credit"),
                    null
            );
    private static final String LECTURE_STUDENT_SELECT_QUERY = "SELECT * FROM MEMBER WHERE member_id in "
            + "(SELECT member_id FROM LECTURE_STUDENT WHERE lecture_id = ?)";
    private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, rowNum) -> new Member(
            rs.getLong("member_id"),
            rs.getString("name"),
            rs.getInt("id_number"),
            rs.getString("password"),
            rs.getString("phone_number"),
            rs.getString("role")
    );
    private static final String STUDENT_LECTURE_INSERT_QUERY = "INSERT INTO STUDENT_LECTURE "
            + "(lecture_id, member_id) VALUES (?, ?)";

    private final JdbcTemplate jdbcTemplate;

    public LectureDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Long professorId, String name, int credit) {
        jdbcTemplate.update(LECTURE_INSERT_QUERY, professorId, name, credit);
    }

    // 수강 인원과 함께 강의 목록 조회
    public Lecture findById(Long id) {
        Lecture lecture = jdbcTemplate.queryForObject(SINGLE_LECTURE_SELECT_QUERY,
                LECTURE_ROW_MAPPER, id);
        List<Member> students = jdbcTemplate.query(
                LECTURE_STUDENT_SELECT_QUERY, MEMBER_ROW_MAPPER, lecture.getId());
        return lecture.setStudents(students);
    }

    //  수강 인원은 함께 조회되지 않는 강의 목록
    public List<Lecture> findAll() {
        return jdbcTemplate.query(ALL_LECTURE_SELECT_QUERY, LECTURE_ROW_MAPPER);
    }

    public void saveStudentLecture(Long lectureId, Long studentId) {
        jdbcTemplate.update(STUDENT_LECTURE_INSERT_QUERY, lectureId, studentId);
    }
}
