package kr.mjc.jacob.spring.day2.class06.user;

import kr.mjc.jacob.basics.jdbc.user.User;
import kr.mjc.jacob.basics.jdbc.user.dao.UserDao;
import kr.mjc.jacob.spring.day2.class06.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.Scanner;

/**
 * 이메일과 비밀번호로 로그인 한다.
 */
@Slf4j
public class Login {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    UserDao userDao = context.getBean(UserDao.class);

    Scanner scanner = new Scanner(System.in);
    System.out.print("Login - email password : ");
    String[] params = {scanner.next(), scanner.next()};
    scanner.close();

    try {
      User user = userDao.login(params[0], params[1]);
      log.debug(user.toString());
    } catch (DataAccessException e) { // 로그인 실패
      log.error(e.toString());
    }
  }
}
