package kr.mjc.jacob.spring.day2.class06.article;

import kr.mjc.jacob.basics.jdbc.article.Article;
import kr.mjc.jacob.basics.jdbc.article.ArticleDao;
import kr.mjc.jacob.spring.day2.class06.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
public class UpdateArticle {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    ArticleDao articleDao = context.getBean(ArticleDao.class);

    Scanner scanner = new Scanner(System.in).useDelimiter("//");
    System.out.print("articleId// : ");
    int articleId = scanner.nextInt();
    System.out.print("title// : ");
    String title = scanner.next();
    System.out.print("content// : ");
    String content = scanner.next();
    scanner.close();

    Article article = new Article();
    article.setArticleId(articleId);
    article.setTitle(title);
    article.setContent(content);
    article.setUserId(1);

    if (articleDao.updateArticle(article) >= 1)
      log.debug("수정 완료");
    else
      log.debug("해당 게시글이 없거나 작성자가 아님");
  }
}
