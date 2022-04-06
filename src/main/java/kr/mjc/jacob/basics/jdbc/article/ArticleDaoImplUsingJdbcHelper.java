package kr.mjc.jacob.basics.jdbc.article;

import kr.mjc.jacob.basics.jdbc.DataSourceFactory;
import kr.mjc.jacob.basics.jdbc.JdbcHelper;

import java.util.List;

public class ArticleDaoImplUsingJdbcHelper implements ArticleDao {

  private static final String LIST_ARTICLES = """
      select articleId, title, userId, name, cdate, udate from article
      order by articleId desc limit ?,?
      """;

  private static final String GET_ARTICLE = """
      select articleId, title, content, userId, name, cdate, udate from article
      where articleId=?
      """;

  private static final String ADD_ARTICLE =
      "insert article(title, content, userId, name) values (?,?,?,?)";

  private static final String UPDATE_ARTICLE =
      "update article set title=?, content=? where articleId=? and userId=?";

  private static final String DELETE_ARTICLE =
      "delete from article where articleId=? and userId=?";

  private final JdbcHelper jdbcHelper;

  public ArticleDaoImplUsingJdbcHelper() {
    jdbcHelper = new JdbcHelper(DataSourceFactory.getDataSource());
  }

  @Override
  public List<Article> listArticles(int count, int page) {
    int offset = (page - 1) * count;
    return jdbcHelper.list(LIST_ARTICLES, rs -> {
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
    return jdbcHelper.get(GET_ARTICLE, rs -> {
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
    jdbcHelper.update(ADD_ARTICLE, article.getTitle(), article.getContent(),
        article.getUserId(), article.getName());
  }

  @Override
  public int updateArticle(Article article) {
    return jdbcHelper.update(UPDATE_ARTICLE, article.getTitle(),
        article.getContent(), article.getArticleId(), article.getUserId());
  }

  @Override
  public int deleteArticle(int articleId, int userId) {
    return jdbcHelper.update(DELETE_ARTICLE, articleId, userId);
  }
}
