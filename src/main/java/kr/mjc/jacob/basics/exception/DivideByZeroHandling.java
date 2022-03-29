package kr.mjc.jacob.basics.exception;

import java.util.Scanner;

/**
 * 예제 3-15 0으로 나눌 때 발생하는 ArithmeticException 예외 처리
 */
public class DivideByZeroHandling {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input dividend : ");
    int dividend = scanner.nextInt();
    System.out.print("Input divisor : ");
    int divisor = scanner.nextInt();

    try {
      System.out.format("%d / %d = %d\n", dividend, divisor,
          dividend / divisor);
    } catch (ArithmeticException e) {
      e.printStackTrace();
    }
    scanner.close();
    System.out.println("scanner를 닫고 프로그램을 종료합니다.");
  }
}
