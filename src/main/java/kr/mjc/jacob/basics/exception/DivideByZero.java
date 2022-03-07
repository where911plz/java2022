package kr.mjc.jacob.basics.exception;

import java.util.Scanner;

/**
 * 예제 3-14 0으로 나누기 예외 발생으로 프로그램이 강제 종료되는 경우
 */
public class DivideByZero {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Input dividend : ");
		int dividend = scanner.nextInt();
		System.out.print("Input divisor : ");
		int divisor = scanner.nextInt();

		System.out.format("%d / %d = %d\n", dividend, divisor,
				dividend / divisor);

		scanner.close();
		System.out.println("scanner를 닫고 프로그램을 종료합니다.");
	}
}
