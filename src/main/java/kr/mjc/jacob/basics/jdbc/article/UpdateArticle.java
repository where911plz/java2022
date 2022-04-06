package kr.mjc.jacob.basics.jdbc.article;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class UpdateArticle {
  public static void main(String[] args) {
    ArticleDao articleDao = new ArticleDaoImplUsingRawJdbc();
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
    int updatedRows = articleDao.updateArticle(article);

    if (updatedRows >= 1)
      log.debug("수정 완료");
    else
      log.debug("해당 게시글이 없거나 작성자가 아님");
  }
}
