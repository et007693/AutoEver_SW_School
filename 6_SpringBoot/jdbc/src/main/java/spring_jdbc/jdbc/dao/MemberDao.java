package spring_jdbc.jdbc.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spring_jdbc.jdbc.dto.MemberDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberDao {
    private JdbcTemplate jdbcTemplate; // JDBC Template 의존성 주입
    // SQL문 작성
    // 전체 회원 조회
    private static final String SELECT_ALL = "select * from mini_member";

    // 이베일로 회원 조회
    private static final String SELECT_BY_EMAIL = "select * from mini_member where email = ?";

    // 회원 등록
    private static final String INSERT = "insert into mini_member (email, password, name) values(?, ?, ?)";

    // 회원 수정
    private static final String UPDATE = "update mini_member set password = ?, name = ? where email = ?";

    // 회원 삭제
    private static final String DELETE = "delete from mini_member where email = ?";

    // 전체 회원 조회 메서드
    public List<MemberDto> findAll() {
        return jdbcTemplate.query(SELECT_ALL, new MemberRowMapper());
    }

    // 이메일로 회원 조회 메서드
    public MemberDto findByEmail(String email) {
        return jdbcTemplate.queryForObject(SELECT_BY_EMAIL, new MemberRowMapper(), email);
    }
    // 회원 등록
    public int insert(MemberDto memberDto) {
        return jdbcTemplate.update(INSERT, memberDto.getEmail(), memberDto.getPassword(), memberDto.getName());
    }

    // 회원 수정
    public int update(String email, MemberDto memberDto) {
        return jdbcTemplate.update(UPDATE, memberDto.getPassword(), memberDto.getName(), email);
    }

    // 회원 삭제
    public int delete(String email) {
        return jdbcTemplate.update(DELETE, email);
    }

    public static class MemberRowMapper implements RowMapper<MemberDto> {
        public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new MemberDto(
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getTimestamp("reg_date").toLocalDateTime()
            );
        }
    }
}
