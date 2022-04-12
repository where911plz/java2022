package kr.mjc.jacob.spring.day2;

import kr.mjc.jacob.basics.jdbc.article.ArticleDao;
import kr.mjc.jacob.basics.jdbc.user.dao.UserDao;
import kr.mjc.jacob.spring.day2.class06.dao.ArticleDaoUsingJdbcTemplate;
import kr.mjc.jacob.spring.day2.class06.dao.UserDaoUsingJdbcTemplate;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * JdbcTemplate과 Dao들 구성
 */
@Configuration
@PropertySource("classpath:db.properties")
public class AppConfig {

  @Autowired
  Environment env;

  @Bean
  public DataSource dataSource() throws SQLException {
    return new MariaDbDataSource(env.getProperty("url"));
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  public UserDao userDao(JdbcTemplate jdbcTemplate) {
    return new UserDaoUsingJdbcTemplate(jdbcTemplate);
  }

  @Bean
  public ArticleDao articleDao(JdbcTemplate jdbcTemplate) {
    return new ArticleDaoUsingJdbcTemplate(jdbcTemplate);
  }
}
