package kr.mjc.jacob.spring.day1.class03;

import kr.mjc.jacob.spring.day1.class02.LgTV;
import kr.mjc.jacob.spring.day1.class02.SamsungTV;
import kr.mjc.jacob.spring.day1.class02.TV;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean
  public TV samsungTV() {
    return new SamsungTV();
  }

  @Bean
  public TV lgTV() {
    return new LgTV();
  }
}
