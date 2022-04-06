package kr.mjc.jacob.spring.day2.class06.article;

import kr.mjc.jacob.basics.jdbc.article.ArticleDao;
import kr.mjc.jacob.spring.day2.class06.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
public class DeleteArticle {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    ArticleDao articleDao = context.getBean(ArticleDao.class);

    Scanner scanner = new Scanner(System.in);
    System.out.print("articleId : ");
    int articleId = scanner.nextInt();
    scanner.close();

    int updatedRows = articleDao.deleteArticle(articleId, 1);
    if (updatedRows >= 1)
      log.debug("삭제 완료");
    else
      log.debug("해당 게시글이 없거나 작성자가 아님");
  }
}
