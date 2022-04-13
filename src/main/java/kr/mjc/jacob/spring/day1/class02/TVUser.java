package kr.mjc.jacob.spring.day1.class02;

/**
 * p.44 TVUser.java
 */
public class TVUser {
  public static void main(String[] args) {
    TV samsungTV = new SamsungTV();
    samsungTV.powerOn();
    samsungTV.powerOff();

    TV lgTV = new LgTV();
    lgTV.powerOn();
    lgTV.powerOff();
  }
}
