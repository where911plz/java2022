package kr.mjc.jacob.spring.day1.class03;

import kr.mjc.jacob.spring.day1.class02.LgTV;
import kr.mjc.jacob.spring.day1.class02.SamsungTV;
import kr.mjc.jacob.spring.day1.class02.TV;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUser {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);

    TV samsungTV = context.getBean(SamsungTV.class);
    samsungTV.powerOn();
    samsungTV.powerOff();

    TV lgTV = context.getBean(LgTV.class);
    lgTV.volumeUp();
    lgTV.volumeDown();
  }
}
