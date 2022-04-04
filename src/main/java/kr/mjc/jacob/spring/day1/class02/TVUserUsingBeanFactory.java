package kr.mjc.jacob.spring.day1.class02;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class TVUserUsingBeanFactory {
  public static void main(String[] args) {
    BeanFactory factory = new BeanFactory();

    System.out.print("Input bean's name : ");

    try (Scanner scanner = new Scanner(System.in)) {
      String beanName = scanner.next();
      TV tv = (TV) factory.getBean(beanName);
      tv.powerOn();
    } catch (Exception e) {
      log.error("해당 이름의 TV 인스턴스가 없습니다.");
    }
  }
}
