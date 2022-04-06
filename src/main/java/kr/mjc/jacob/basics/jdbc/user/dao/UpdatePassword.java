package kr.mjc.jacob.basics.jdbc.user.dao;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * 비밀번호 수정
 */
@Slf4j
public class UpdatePassword {

  public static void main(String[] args) {
    UserDao userDao = new UserDaoImplUsingRawJdbc();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Update password - userId currentPassword newPassword : ");
    int userId = scanner.nextInt();
    String currentPassword = scanner.next();
    String newPassword = scanner.next();
    scanner.close();

    int updatedRows =
        userDao.updatePassword(userId, currentPassword, newPassword);
    if (updatedRows >= 1)
      log.debug("수정 성공");
    else
      log.debug("수정 실패"); // 회원번호가 없거나 비밀번호 틀림
  }
}
