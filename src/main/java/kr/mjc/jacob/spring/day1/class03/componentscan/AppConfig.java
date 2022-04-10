package kr.mjc.jacob.spring.day1.class03.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * p.51 applicationContext.xml을 Java-based configuration으로 수정
 */
@Configuration
@ComponentScan(basePackages = "kr.mjc.jacob.spring.day1.class03.componentscan")
public class AppConfig {
}
