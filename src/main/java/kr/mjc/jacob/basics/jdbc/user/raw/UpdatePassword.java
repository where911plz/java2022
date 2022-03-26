package kr.mjc.jacob.basics.jdbc.user.raw;

import kr.mjc.jacob.basics.jdbc.DataSourceFactory;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 비밀번호 수정
 */
@Slf4j
public class UpdatePassword {

  public static void main(String[] args) {
    DataSource ds = DataSourceFactory.getDataSource();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Update password - userId currentPassword newPassword : ");
    // 입력
    Object[] params = {scanner.nextInt(), scanner.next(), scanner.next()};
    try (Connection con = ds.getConnection();
         PreparedStatement ps = con.prepareStatement(
             "update user set password=sha2(?,256) where userId=? and password=sha2(?,256)")) {
      ps.setObject(1, params[2]); // new password
      ps.setObject(2, params[0]); // userId
      ps.setObject(3, params[1]); // old password
      int updatedRows = ps.executeUpdate();

      if (updatedRows == 1)
        log.debug("수정 성공. userId={}", params[0]);
      else
        log.debug("수정 실패. userId={}", params[0]);
    } catch (SQLException e) {
      log.error(e.toString());
    }
  }
}
