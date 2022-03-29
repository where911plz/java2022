package kr.mjc.jacob.basics.concurrency;

/**
 * 한개의 프린터를 여러 스레드가 사용하는 예
 *
 * @author Jacob
 */
public class SharedPrinterEx {
  public static void main(String[] args) {
    final Printer printer = new Printer();

    new Thread(() -> printer.println("ABCDE")).start();
    new Thread(() -> printer.println("abcde")).start();
  }
}
