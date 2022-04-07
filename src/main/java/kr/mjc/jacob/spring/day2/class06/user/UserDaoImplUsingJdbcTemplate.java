package kr.mjc.jacob.spring.day2.class06.user;

import kr.mjc.jacob.basics.jdbc.DbException;
import kr.mjc.jacob.basics.jdbc.user.User;
import kr.mjc.jacob.basics.jdbc.user.dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImplUsingJdbcTemplate implements UserDao {

  private static final String LIST_USERS =
      "select userId, email, name from user order by userId desc limit ?,?";

  private static final String GET_USER =
      "select userId, email, name from user where userId=?";

  private static final String LOGIN =
      "select userId, email, name from user where email=? and password=sha2(?,256)";

  private static final String ADD_USER =
      "insert user(email, password, name) values(?,sha2(?,256),?)";

  private static final String UPDATE_PASSWORD =
      "update user set password=sha2(?,256) where userId=? and password=sha2(?,256)";

  private static final String DELETE_USER =
      "delete from user where userId=? and password=sha2(?,256)";

  private final JdbcTemplate jdbcTemplate;

  public UserDaoImplUsingJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  /**
   * 회원 목록
   *
   * @param count 목록의 갯수
   * @param page  페이지
   * @return 회원 목록
   */
  @Override
  public List<User> listUsers(int count, int page) {
    int offset = (page - 1) * count;  // 목록의 시작 시점
    return jdbcTemplate.query(LIST_USERS, (rs, rowNum) -> map(rs, rowNum),
        offset, count);
  }

  /**
   * 회원정보 조회
   *
   * @param userId 회원번호
   * @return 회원 정보
   */
  @Override
  public User getUser(int userId) {
    return jdbcTemplate.queryForObject(GET_USER,
        (rs, rowNum) -> map(rs, rowNum), userId);
  }

  /**
   * 로그인
   *
   * @param email    이메일
   * @param password 비밀번호
   * @return 로그인 성공하면 회원정보, 실패하면 NULL
   */
  @Override
  public User login(String email, String password) {
    return jdbcTemplate.queryForObject(LOGIN, (rs, rowNum) -> map(rs, rowNum),
        email, password);
  }

  /**
   * 회원 가입
   *
   * @param user 회원정보
   * @throws DbException 이메일 중복으로 회원가입 실패 시
   */
  @Override
  public void addUser(User user) throws DbException {
    jdbcTemplate.update(ADD_USER, user.getEmail(), user.getPassword(),
        user.getName());
  }

  /**
   * 비밀번호 수정
   *
   * @param userId          회원번호
   * @param currentPassword 현재 비밀번호
   * @param newPassword     새 비밀번호
   * @return 수정 성공시 1, 회원이 없거나 비밀번호가 틀리면 0
   */
  @Override
  public int updatePassword(int userId, String currentPassword,
      String newPassword) {
    return jdbcTemplate.update(UPDATE_PASSWORD, newPassword, userId,
        currentPassword);
  }

  /**
   * 회원 삭제
   *
   * @param userId   회원번호
   * @param password 비밀번호
   * @return 삭제 성공시 1, 회원번호가 없거나 비밀번호가 틀리면 0
   */
  @Override
  public int deleteUser(int userId, String password) throws DbException {
    return jdbcTemplate.update(DELETE_USER, userId, password);
  }

  /**
   * resultSet을 user object로 매핑한다.
   */
  private User map(ResultSet rs, int rowNum) throws SQLException {
    User user = new User();
    user.setUserId(rs.getInt("userId"));
    user.setEmail(rs.getString("email"));
    user.setName(rs.getString("name"));
    return user;
  }
}
