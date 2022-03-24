package kr.mjc.jacob.basics.jdbc.raw;

import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 회원 수정
 */
@Slf4j
public class UserUpdate {

  public static void main(String[] args) {
    DataSource ds = DataSourceFactory.getDataSource();
    Scanner scanner = new Scanner(System.in);
    System.out.print("email password name userId : ");
    // 입력
    String[] params =
        {scanner.next(), scanner.next(), scanner.next(), scanner.next()};
    try (Connection con = ds.getConnection();
         PreparedStatement ps = con.prepareStatement(
             "update user set email=?, password=sha2(?,256), name=? where userId=?")) {
      ps.setString(1, params[0]);
      ps.setString(2, params[1]);
      ps.setString(3, params[2]);
      ps.setString(4, params[3]);
      int updatedRows = ps.executeUpdate();

      if (updatedRows == 1)
        log.debug("수정 성공. userId={}", params[0]);
      else
        log.debug("회원 없음. userId={}", params[0]);
    } catch (SQLException e) {
      log.error(e.toString());
    }
  }
}
