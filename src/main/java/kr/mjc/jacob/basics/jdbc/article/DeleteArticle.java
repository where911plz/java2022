package kr.mjc.jacob.basics.jdbc.article;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class DeleteArticle {
  public static void main(String[] args) {
    ArticleDao articleDao = new ArticleDaoImplUsingJdbcHelper();
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
