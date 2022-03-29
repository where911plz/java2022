package kr.mjc.jacob.basics.concurrency;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class HelloLogger {

  public static void main(String[] args) {
    Logger log = LoggerFactory.getLogger(HelloLogger.class);
    log.trace("DEBUG 레벨보다 세분화된 정보");
    log.debug("애플리케이션 디버그 정보");
    log.info("애플리케이션의 진행상황을 강조");
    log.warn("잠재적으로 유해항 상황 지정");
    log.error("오류 이벤트");
  }
}
