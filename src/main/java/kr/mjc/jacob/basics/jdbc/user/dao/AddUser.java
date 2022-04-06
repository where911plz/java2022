package kr.mjc.jacob.basics.jdbc.user.dao;

import kr.mjc.jacob.basics.jdbc.DbException;
import kr.mjc.jacob.basics.jdbc.user.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * 회원 가입
 */
@Slf4j
public class AddUser {

  public static void main(String[] args) {
    UserDao userDao = new UserDaoImplUsingJdbcHelper();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Insert - email password name : ");
    User user = new User();
    user.setEmail(scanner.next());
    user.setPassword(scanner.next());
    user.setName(scanner.next());
    scanner.close();

    try {
      userDao.addUser(user);
      log.debug(user.toString());
    } catch (DbException e) { // 이메일 중복인 경우
      log.error(e.toString());
    }
  }
}
