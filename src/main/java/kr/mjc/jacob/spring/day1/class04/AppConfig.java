package kr.mjc.jacob.spring.day1.class04;

import kr.mjc.jacob.spring.day1.class02.TV;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public Speaker sonySpeaker() {
    return new SonySpeaker();
  }

  @Bean
  public Speaker appleSpeaker() {
    return new AppleSpeaker();
  }

  /**
   * Constructor-based dependency injection
   */
  @Bean
  public TV samsungTV() {
    return new SamsungTV(sonySpeaker());
  }

  /**
   * Setter-based dependency injection
   */
  @Bean
  public TV lgTV() {
    LgTV lgTV = new LgTV();
    lgTV.setSpeaker(appleSpeaker());
    return lgTV;
  }
}
