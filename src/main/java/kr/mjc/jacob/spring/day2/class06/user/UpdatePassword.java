package kr.mjc.jacob.spring.day2.class06.user;

import kr.mjc.jacob.basics.jdbc.user.dao.UserDao;
import kr.mjc.jacob.basics.jdbc.user.dao.UserDaoImplUsingJdbcHelper;
import kr.mjc.jacob.spring.day2.class06.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 * 비밀번호 수정
 */
@Slf4j
public class UpdatePassword {

  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    UserDao userDao = context.getBean(UserDao.class);

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
