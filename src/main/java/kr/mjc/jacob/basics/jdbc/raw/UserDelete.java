package kr.mjc.jacob.basics.jdbc.raw;

import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 회원 삭제
 */
@Slf4j
public class UserDelete {

  public static void main(String[] args) {
    DataSource ds = DataSourceFactory.getDataSource();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Delete - userId : ");
    // 입력
    String[] params = {scanner.next()};
    try (Connection con = ds.getConnection();
         PreparedStatement ps = con.prepareStatement(
             "delete from user where userId=?")) {
      ps.setString(1, params[0]);
      int updatedRows = ps.executeUpdate();

      if (updatedRows == 1)
        log.debug("삭제 성공. userId={}", params[0]);
      else
        log.debug("회원 없음. userId={}", params[0]);

    } catch (SQLException e) {
      log.error(e.toString());
    }
  }
}
