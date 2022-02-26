package kr.mjc.jacob.basics.exception;

import java.util.Scanner;

public class DivideByZero {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int dividend;
    int divisor;

    System.out.print("Input dividend : ");
    dividend = scanner.nextInt();
    System.out.print("Input divisor : ");
    divisor = scanner.nextInt();

    System.out.format("%d / %d = %d\n", dividend, divisor, dividend / divisor);
    scanner.close();
  }
}
