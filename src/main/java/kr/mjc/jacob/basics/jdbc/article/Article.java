package kr.mjc.jacob.basics.jdbc.article;


import lombok.Data;

@Data
public class Article {
  int articleId;
  String title;
  String content;
  int userId;
  String name;
  String cdate;
  String udate;

  @Override
  public String toString() {
    return String.format(
        "\narticleId=%d, title=%s, content=%s, userId=%d, name=%s, cdate=%s, udate=%s",
        articleId, title, content, userId, name, cdate, udate);
  }
}
