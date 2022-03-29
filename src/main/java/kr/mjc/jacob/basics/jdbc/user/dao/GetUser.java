package kr.mjc.jacob.basics.jdbc.user.dao;

import kr.mjc.jacob.basics.jdbc.user.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * userId로 회원정보를 가져온다.
 */
@Slf4j
public class GetUser {
  public static void main(String[] args) {
    UserDao userDao = new UserDaoImpl();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Get - userId : ");
    User user = userDao.getUser(scanner.nextInt());
    if (user != null)
      log.debug(user.toString());
    else
      log.debug("회원 없음");
  }
}
