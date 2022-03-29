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
    UserDao userDao = new UserDaoImpl();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Login - email password : ");
    User user = userDao.login(scanner.next(), scanner.next());
    if (user != null)
      log.debug(user.toString());
    else
      log.debug("로그인 실패");
  }
}
