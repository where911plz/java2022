package kr.mjc.jacob.spring.day2.class06;

import kr.mjc.jacob.basics.jdbc.user.User;
import kr.mjc.jacob.basics.jdbc.user.dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImplUsingJdbcTemplate implements UserDao {

  private final JdbcTemplate jdbcTemplate;

  public UserDaoImplUsingJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<User> listUsers(int count, int page) {
    return null;
  }

  @Override
  public User getUser(int userId) {
    return null;
  }

  @Override
  public User login(String email, String password) {
    return null;
  }

  @Override
  public void addUser(User user) {

  }

  @Override
  public int updatePassword(int userId, String currentPassword,
      String newPassword) {
    return 0;
  }

  @Override
  public int deleteUser(int userId, String password) {
    return 0;
  }
}
