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
public class UserGet {
  public static void main(String[] args) {

    DataSource ds = DataSourceFactory.getDataSource();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Get - userId : ");
    // 입력
    String[] params = {scanner.next()};
    try (Connection con = ds.getConnection();
         PreparedStatement ps = con.prepareStatement(
             "select userId, email, name from user where userId=?")) {
      ps.setString(1, params[0]);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        User user = new User();
        user.setUserId(rs.getInt("userId"));
        user.setEmail(rs.getString("email"));
        user.setName(rs.getString("name"));
        log.debug(user.toString());
      } else {
        log.debug("회원 없음. userId={}", params[0]);
      }
    } catch (SQLException e) {
      log.error(e.toString());
    }
  }
}
