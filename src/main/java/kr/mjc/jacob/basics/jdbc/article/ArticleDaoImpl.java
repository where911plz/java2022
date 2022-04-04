package kr.mjc.jacob.basics.jdbc.article;

import kr.mjc.jacob.basics.jdbc.DataSourceFactory;
import kr.mjc.jacob.basics.jdbc.DbException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {

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

  private final DataSource ds;

  /**
   * default constructor
   */
  public ArticleDaoImpl() {
    ds = DataSourceFactory.getDataSource();
  }

  /**
   * 게시글 목록
   */
  @Override
  public List<Article> listArticles(int count, int page) {
    int offset = (page - 1) * count;
    try (Connection conn = ds.getConnection();
         PreparedStatement ps = conn.prepareStatement(LIST_ARTICLES)) {
      ps.setInt(1, offset);
      ps.setInt(2, count);
      ResultSet rs = ps.executeQuery();
      List<Article> articleList = new ArrayList<>();
      while (rs.next()) {
        Article article = new Article();
        article.setArticleId(rs.getInt("articleId"));
        article.setTitle(rs.getString("title"));
        article.setUserId(rs.getInt("userId"));
        article.setName(rs.getString("name"));
        article.setCdate(rs.getString("cdate"));
        article.setUdate(rs.getString("udate"));
        articleList.add(article);
      }
      return articleList;
    } catch (SQLException e) {
      throw new DbException(e);
    }
  }

  /**
   * 게시글 정보
   */
  @Override
  public Article getArticle(int articleId) {
    try (Connection conn = ds.getConnection();
         PreparedStatement ps = conn.prepareStatement(GET_ARTICLE)) {
      ps.setInt(1, articleId);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        Article article = new Article();
        article.setArticleId(rs.getInt("articleId"));
        article.setTitle(rs.getString("title"));
        article.setTitle(rs.getString("content"));
        article.setUserId(rs.getInt("userId"));
        article.setName(rs.getString("name"));
        article.setCdate(rs.getString("cdate"));
        article.setUdate(rs.getString("udate"));
        return article;
      }
      return null;
    } catch (SQLException e) {
      throw new DbException(e);
    }
  }

  /**
   * 게시글 쓰기
   */
  @Override
  public void addArticle(Article article) {
    try (Connection conn = ds.getConnection();
         PreparedStatement ps = conn.prepareStatement(ADD_ARTICLE)) {
      ps.setString(1, article.getTitle());
      ps.setString(2, article.getContent());
      ps.setInt(3, article.getUserId());
      ps.setString(4, article.getName());
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DbException(e);
    }
  }

  /**
   * 게시글 수정
   */
  @Override
  public int updateArticle(Article article) {
    try (Connection conn = ds.getConnection();
         PreparedStatement ps = conn.prepareStatement(UPDATE_ARTICLE)) {
      ps.setString(1, article.getTitle());
      ps.setString(2, article.getContent());
      ps.setInt(3, article.getArticleId());
      ps.setInt(4, article.getUserId());
      return ps.executeUpdate();
    } catch (SQLException e) {
      throw new DbException(e);
    }
  }

  /**
   * 게시글 삭제
   */
  @Override
  public int deleteArticle(int articleId, int userId) {
    try (Connection conn = ds.getConnection();
         PreparedStatement ps = conn.prepareStatement(DELETE_ARTICLE)) {
      ps.setInt(1, articleId);
      ps.setInt(2, userId);
      return ps.executeUpdate();
    } catch (SQLException e) {
      throw new DbException(e);
    }
  }
}
