package kr.mjc.jacob.spring.day2;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * basePackages 아래에서 컴포넌트를 스캔해서 구성
 */
@Configuration
@ComponentScan(basePackages = "kr.mjc.jacob.spring.day2.class06.dao")
@PropertySource("classpath:db.properties")
public class AppConfigComponentScan {

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
  public NamedParameterJdbcTemplate namedParameterJdbcTemplate(
      JdbcTemplate jdbcTemplate) {
    return new NamedParameterJdbcTemplate(jdbcTemplate);
  }
}
