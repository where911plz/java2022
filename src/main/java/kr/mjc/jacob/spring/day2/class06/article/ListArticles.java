package kr.mjc.jacob.spring.day2.class06.article;

import kr.mjc.jacob.basics.jdbc.article.Article;
import kr.mjc.jacob.basics.jdbc.article.ArticleDao;
import kr.mjc.jacob.spring.day2.class06.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

@Slf4j
public class ListArticles {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    ArticleDao articleDao = context.getBean(ArticleDao.class);

    Scanner scanner = new Scanner(System.in);
    System.out.print("count page : ");
    int count = scanner.nextInt();
    int page = scanner.nextInt();
    scanner.close();

    List<Article> articleList = articleDao.listArticles(count, page);
    log.debug(articleList.toString());
  }
}
