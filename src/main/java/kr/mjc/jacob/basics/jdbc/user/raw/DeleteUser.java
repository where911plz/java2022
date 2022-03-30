package kr.mjc.jacob.basics.jdbc.user.raw;

import kr.mjc.jacob.basics.jdbc.DataSourceFactory;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * userId와 password로 회원 삭제
 */
@Slf4j
public class DeleteUser {

  public static void main(String[] args) {
    DataSource ds = DataSourceFactory.getDataSource();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Delete - userId password : ");
    // 입력
    Object[] params = {scanner.nextInt(), scanner.next()};
    scanner.close();

    try (Connection conn = ds.getConnection();
         PreparedStatement ps = conn.prepareStatement(
             "delete from user where userId=? and password=sha2(?,256)")) {
      ps.setObject(1, params[0]);
      ps.setObject(2, params[1]);
      int updatedRows = ps.executeUpdate();

      if (updatedRows >= 1)
        log.debug("삭제 성공. userId={}", params[0]);
      else
        log.debug("삭제 실패. userId={}", params[0]);

    } catch (SQLException e) {
      log.error(e.toString());
    }
  }
}
