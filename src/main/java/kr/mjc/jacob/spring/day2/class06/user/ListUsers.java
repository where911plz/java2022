package kr.mjc.jacob.spring.day2.class06.user;

import kr.mjc.jacob.basics.jdbc.user.User;
import kr.mjc.jacob.basics.jdbc.user.dao.UserDao;
import kr.mjc.jacob.basics.jdbc.user.dao.UserDaoImplUsingJdbcHelper;
import kr.mjc.jacob.spring.day2.class06.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

/**
 * 회원 목록<br>
 * count와 page를 입력받아서 해당 목록을 가져온다.
 */
@Slf4j
public class ListUsers {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    UserDao userDao = context.getBean(UserDao.class);

    Scanner scanner = new Scanner(System.in);
    System.out.print("List - count page : ");
    int[] params = {scanner.nextInt(), scanner.nextInt()};
    scanner.close();

    List<User> userList = userDao.listUsers(params[0], params[1]);
    log.debug(userList.toString());
  }
}
