package kr.mjc.jacob.spring.day1.class03.componentscan;

import kr.mjc.jacob.spring.day1.class02.TV;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * p.42 SamsungTV.java
 */
@Component
@Slf4j
public class SamsungTV implements TV {

  /**
   * Default constructor
   */
  public SamsungTV() {
    log.debug("samsungTV 인스턴스 생성됨.");
  }

  @Override
  public void powerOn() {
    log.debug("samsungTV power on.");
  }

  @Override
  public void powerOff() {
    log.debug("samsungTV power off.");
  }

  @Override
  public void volumeUp() {
    log.debug("samsungTV volume up.");
  }

  @Override
  public void volumeDown() {
    log.debug("samsungTV volume down.");
  }
}
