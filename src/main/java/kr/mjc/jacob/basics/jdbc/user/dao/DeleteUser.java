package kr.mjc.jacob.basics.jdbc.user.dao;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * userId와 password로 회원 삭제
 */
@Slf4j
public class DeleteUser {

  public static void main(String[] args) {
    UserDao userDao = new UserDaoImplUsingJdbcHelper();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Delete - userId password : ");
    int userId = scanner.nextInt();
    String password = scanner.next();
    scanner.close();

    int updatedRows = userDao.deleteUser(userId, password);
    if (updatedRows >= 1)
      log.debug("삭제 완료");
    else
      log.debug("삭제 실패"); // 회원번호가 없거나 비밀번호 틀림
  }
}
