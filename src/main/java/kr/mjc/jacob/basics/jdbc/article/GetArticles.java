package kr.mjc.jacob.basics.jdbc.article;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class GetArticles {
  public static void main(String[] args) {
    ArticleDao articleDao = new ArticleDaoImplUsingRawJdbc();
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
