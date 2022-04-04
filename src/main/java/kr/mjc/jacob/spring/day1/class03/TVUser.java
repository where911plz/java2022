package kr.mjc.jacob.spring.day1.class03;

import kr.mjc.jacob.spring.day1.class02.LgTV;
import kr.mjc.jacob.spring.day1.class02.SamsungTV;
import kr.mjc.jacob.spring.day1.class02.TV;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * p.53 TVUser.java 수정
 */
public class TVUser {
  public static void main(String[] args) {
    // AppConfig 클래스에서 구성한대로 빈을 구성한다.
    // 빈들을 보관한 영역을 applicationContext라 한다.
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);

    // context에서 SamsungTV 타입의 빈을 꺼낸다.
    TV samsungTV = context.getBean(SamsungTV.class);
    samsungTV.powerOn();
    samsungTV.powerOff();

    // context에서 LgTV 타입의 빈을 꺼낸다.
    TV lgTV = context.getBean(LgTV.class);
    lgTV.powerOn();
    lgTV.powerOff();
  }
}
