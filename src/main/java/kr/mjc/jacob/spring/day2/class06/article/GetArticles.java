package kr.mjc.jacob.spring.day2.class06.article;

import kr.mjc.jacob.basics.jdbc.article.Article;
import kr.mjc.jacob.basics.jdbc.article.ArticleDao;
import kr.mjc.jacob.spring.day2.class06.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
public class GetArticles {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    ArticleDao articleDao = context.getBean(ArticleDao.class);

    Scanner scanner = new Scanner(System.in);
    System.out.print("articleId : ");
    int articleId = scanner.nextInt();
    scanner.close();

    Article article = articleDao.getArticle(articleId);
    if (article != null)
      log.debug(article.toString());
    else
      log.debug("해당 게시글 없음");
  }
}
