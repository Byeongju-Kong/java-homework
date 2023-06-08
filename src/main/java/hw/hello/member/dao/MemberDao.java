package hw.hello.member.dao;

import hw.hello.member.domain.Member;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {

    private static final String MEMBER_INSERT_QUERY = "INSERT INTO MEMBER "
            + "(name, id_number, password, phone_number, role_type) VALUES (?, ?, ?, ?, ?)";
    private static final String SINGLE_MEMBER_BY_ID_FIND_QUERY = "SELECT * FROM MEMBER WHERE member_id = ?";
    private static final String SINGLE_MEMBER_BY_ID_NUMBER_FIND_QUERY = "SELECT * FROM MEMBER WHERE id_number = ?";
    private static final String ALL_MEMBER_FIND_QUERY = "SELECT * FROM MEMBER WHERE role_type = ?";
    private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, rowNum) -> new Member(
            rs.getLong("member_id"),
            rs.getString("name"),
            rs.getInt("id_number"),
            rs.getString("password"),
            rs.getString("phone_number"),
            rs.getString("role")
    );

    private final JdbcTemplate jdbcTemplate;

    public MemberDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(int idNumber, String password, String name, String phoneNumber, String role) {
        jdbcTemplate.update(MEMBER_INSERT_QUERY, name, idNumber, password, phoneNumber, role);
    }

    public Member findByIdNumber(int idNumber) {
        return jdbcTemplate.queryForObject(SINGLE_MEMBER_BY_ID_NUMBER_FIND_QUERY, MEMBER_ROW_MAPPER, idNumber);
    }

    public Member findById(Long id) {
        return jdbcTemplate.queryForObject(SINGLE_MEMBER_BY_ID_FIND_QUERY, MEMBER_ROW_MAPPER, id);
    }

    public List<Member> findAllByRole(String role) {
        return jdbcTemplate.query(ALL_MEMBER_FIND_QUERY, MEMBER_ROW_MAPPER, role);
    }
}
