package kr.mjc.jacob.basics.jdbc.user.raw;

import kr.mjc.jacob.basics.jdbc.DataSourceFactory;
import kr.mjc.jacob.basics.jdbc.user.User;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 이메일과 비밀번호로 로그인 한다.
 */
@Slf4j
public class Login {

  public static void main(String[] args) {
    DataSource ds = DataSourceFactory.getDataSource();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Login - email password : ");
    // 입력
    String[] params = {scanner.next(), scanner.next()};
    scanner.close();

    try (Connection conn = ds.getConnection();
         PreparedStatement ps = conn.prepareStatement(
             "select userId, email, name from user where email=? and password=sha2(?,256)")) {
      ps.setString(1, params[0]);
      ps.setString(2, params[1]);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        User user = new User();
        user.setUserId(rs.getInt("userId"));
        user.setEmail(rs.getString("email"));
        user.setName(rs.getString("name"));
        log.debug("로그인 성공 : {}", user);
      } else {
        log.debug("로그인 실패");
      }
    } catch (SQLException e) {
      log.error(e.toString());
    }
  }
}
