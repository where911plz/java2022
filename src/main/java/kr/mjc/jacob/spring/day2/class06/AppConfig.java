package kr.mjc.jacob.spring.day2.class06;

import kr.mjc.jacob.basics.jdbc.DataSourceFactory;
import kr.mjc.jacob.basics.jdbc.article.ArticleDao;
import kr.mjc.jacob.basics.jdbc.user.dao.UserDao;
import kr.mjc.jacob.spring.day2.class06.article.ArticleDaoImplUsingJdbcTemplate;
import kr.mjc.jacob.spring.day2.class06.user.UserDaoImplUsingNamedParameterJdbcTemplate;
import lombok.extern.slf4j.Slf4j;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@Slf4j
public class AppConfig {
  @Bean
  public DataSource dataSource() {
    Properties props = new Properties();
    try {
      props.load(DataSourceFactory.class.getResourceAsStream("/db.properties"));
      return new MariaDbDataSource(props.getProperty("url"));
    } catch (IOException | SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }

  @Bean
  public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
    return new NamedParameterJdbcTemplate(dataSource());
  }

  @Bean
  public ArticleDao articleDao() {
    return new ArticleDaoImplUsingJdbcTemplate(jdbcTemplate());
  }

  @Bean
  public UserDao userDao() {
    // return new UserDaoImplUsingJdbcTemplate(jdbcTemplate());
    return new UserDaoImplUsingNamedParameterJdbcTemplate(jdbcTemplate(),
        namedParameterJdbcTemplate());
  }
}
