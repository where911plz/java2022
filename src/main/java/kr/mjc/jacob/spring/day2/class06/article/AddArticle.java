package kr.mjc.jacob.spring.day2.class06.article;

import kr.mjc.jacob.basics.jdbc.article.Article;
import kr.mjc.jacob.basics.jdbc.article.ArticleDao;
import kr.mjc.jacob.spring.day2.class06.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.Scanner;

@Slf4j
public class AddArticle {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    ArticleDao articleDao = context.getBean(ArticleDao.class);

    Scanner scanner = new Scanner(System.in).useDelimiter("//");
    System.out.print("title// : ");
    String title = scanner.next();
    System.out.print("content// : ");
    String content = scanner.next();
    scanner.close();

    Article article = new Article();
    article.setTitle(title);
    article.setContent(content);
    article.setUserId(1);
    article.setName("Jacob");

    try {
      articleDao.addArticle(article);
      log.debug("저장 완료");
    } catch (DataAccessException e) { // 회원이 없음
      log.error(e.toString());
    }
  }
}
