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
 * 회원 가입
 */
@Slf4j
public class AddUser {

  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    UserDao userDao = context.getBean(UserDao.class);

    Scanner scanner = new Scanner(System.in);
    System.out.print("Insert - email password name : ");
    User user = new User();
    user.setEmail(scanner.next());
    user.setPassword(scanner.next());
    user.setName(scanner.next());
    scanner.close();

    try {
      userDao.addUser(user);
      log.debug("저장 완료");
    } catch (DataAccessException e) { // 이메일 중복인 경우
      log.error(e.getCause().toString());
    }
  }
}
