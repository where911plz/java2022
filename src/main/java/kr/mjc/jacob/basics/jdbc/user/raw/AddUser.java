package kr.mjc.jacob.basics.jdbc.user.raw;

import kr.mjc.jacob.basics.jdbc.DataSourceFactory;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 회원 가입
 */
@Slf4j
public class AddUser {

  public static void main(String[] args) {
    DataSource ds = DataSourceFactory.getDataSource();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Insert - email password name : ");
    // 입력
    String[] params = {scanner.next(), scanner.next(), scanner.next()};
    scanner.close();

    try (Connection conn = ds.getConnection();
         PreparedStatement ps = conn.prepareStatement(
             "insert user(email, password, name) values(?,sha2(?,256),?)")) {
      ps.setString(1, params[0]);
      ps.setString(2, params[1]);
      ps.setString(3, params[2]);
      ps.executeUpdate();
      log.info("저장 성공");
    } catch (SQLException e) {
      log.error(e.toString());
    }
  }
}
