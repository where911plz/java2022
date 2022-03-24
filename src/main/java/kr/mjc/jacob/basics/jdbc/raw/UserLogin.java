package kr.mjc.jacob.basics.jdbc.raw;

import kr.mjc.jacob.basics.jdbc.User;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

@Slf4j
public class UserLogin {
  public static void main(String[] args) {

    DataSource ds = DataSourceFactory.getDataSource();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Login - email password : ");
    // 입력
    String[] params = {scanner.next(), scanner.next()};
    try (Connection con = ds.getConnection();
         PreparedStatement ps = con.prepareStatement(
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
