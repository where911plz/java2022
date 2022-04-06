package kr.mjc.jacob.basics.jdbc.article;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Scanner;

@Slf4j
public class ListArticles {
  public static void main(String[] args) {
    ArticleDao articleDao = new ArticleDaoImplUsingJdbcHelper();
    Scanner scanner = new Scanner(System.in);
    System.out.print("count page : ");
    int count = scanner.nextInt();
    int page = scanner.nextInt();
    scanner.close();

    List<Article> articleList = articleDao.listArticles(count, page);
    log.debug(articleList.toString());
  }
}
