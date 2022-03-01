package kr.mjc.jacob.basics.exception;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ListOfNumbers example of The Java Tutorials
 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html">https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html</a>
 */
public class ListOfNumbers {

  private int[] list;
  private static final int SIZE = 10;

  /**
   * Default contstructor. list를 초기화한다.
   */
  public ListOfNumbers() {
    list = new int[SIZE];
    for (int i = 0; i < SIZE; i++) {
      list[i] = i;
    }
  }

  /**
   * OutFile.txt에 list의 값들을 출력한다.
   */
  public void writeList() {
    try {
      PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));

      for (int i = 0; i < SIZE; i++) {
        out.format("Value at: %d = %d\n", i, list[i]);
      }
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * ListOfNumbers를 테스트하는 main() 메서드
   */
  public static void main(String[] args) {
    ListOfNumbers listOfNumbers = new ListOfNumbers();
    listOfNumbers.writeList();
  }
}
