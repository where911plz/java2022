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
 * userId로 회원정보를 가져온다.
 */
@Slf4j
public class GetUser {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    UserDao userDao = context.getBean(UserDao.class);

    Scanner scanner = new Scanner(System.in);
    System.out.print("Get - userId : ");
    int userId = scanner.nextInt();
    scanner.close();

    try {
      User user = userDao.getUser(userId);
    } catch (DataAccessException e) { // 결과가 없을 경우
      log.error(e.toString());
    }
  }
}
