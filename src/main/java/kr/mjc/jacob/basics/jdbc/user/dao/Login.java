package kr.mjc.jacob.basics.jdbc.user.dao;

import kr.mjc.jacob.basics.jdbc.user.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * 이메일과 비밀번호로 로그인 한다.
 */
@Slf4j
public class Login {
  public static void main(String[] args) {
    UserDao userDao = new UserDaoImplUsingJdbcHelper();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Login - email password : ");
    String[] params = {scanner.next(), scanner.next()};
    scanner.close();

    User user = userDao.login(params[0], params[1]);
    if (user != null)
      log.debug(user.toString());
    else
      log.debug("로그인 실패");
  }
}
