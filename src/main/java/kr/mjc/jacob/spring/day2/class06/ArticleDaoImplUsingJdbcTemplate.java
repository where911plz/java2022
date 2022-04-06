package kr.mjc.jacob.spring.day2.class06;

import kr.mjc.jacob.basics.jdbc.article.Article;
import kr.mjc.jacob.basics.jdbc.article.ArticleDao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ArticleDaoImplUsingJdbcTemplate implements ArticleDao {

  String LIST_ARTICLES = """
      select articleId, title, userId, name, cdate, udate from article
      order by articleId desc limit ?,?
      """;

  String GET_ARTICLE = """
      select articleId, title, content, userId, name, cdate, udate from article
      where articleId=?
      """;

  String ADD_ARTICLE =
      "insert article(title, content, userId, name) values (?,?,?,?)";

  String UPDATE_ARTICLE =
      "update article set title=?, content=? where articleId=? and userId=?";

  String DELETE_ARTICLE = "delete from article where articleId=? and userId=?";

  private final JdbcTemplate jdbcTemplate;

  public ArticleDaoImplUsingJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Article> listArticles(int count, int page) {
    int offset = (page - 1) * count;
    return jdbcTemplate.query(LIST_ARTICLES, (rs, nowNum) -> {
      Article article = new Article();
      article.setArticleId(rs.getInt("articleId"));
      article.setTitle(rs.getString("title"));
      article.setUserId(rs.getInt("userId"));
      article.setName(rs.getString("name"));
      article.setCdate(rs.getString("cdate"));
      article.setUdate(rs.getString("udate"));
      return article;
    }, offset, count);
  }

  @Override
  public Article getArticle(int articleId) {
    return jdbcTemplate.queryForObject(GET_ARTICLE, (rs, rowNum) -> {
      Article article = new Article();
      article.setArticleId(rs.getInt("articleId"));
      article.setTitle(rs.getString("title"));
      article.setContent(rs.getString("content"));
      article.setUserId(rs.getInt("userId"));
      article.setName(rs.getString("name"));
      article.setCdate(rs.getString("cdate"));
      article.setUdate(rs.getString("udate"));
      return article;
    }, articleId);
  }

  @Override
  public void addArticle(Article article) {
    jdbcTemplate.update(ADD_ARTICLE, article.getTitle(), article.getContent(),
        article.getUserId(), article.getName());
  }

  @Override
  public int updateArticle(Article article) {
    return jdbcTemplate.update(UPDATE_ARTICLE, article.getTitle(),
        article.getContent(), article.getArticleId(), article.getUserId());
  }

  @Override
  public int deleteArticle(int articleId, int userId) {
    return jdbcTemplate.update(DELETE_ARTICLE, articleId, userId);
  }
}
