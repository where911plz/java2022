package kr.mjc.jacob.basics.exception;

import java.util.Arrays;

/**
 * 예제 3-16 범위를 벗어난 배열의 접근
 */
public class ArrayExceptionMain {
  public static void main(String[] args) {
    int[] intArray = new int[5];
    try {
      for (int i = 0; i < 6; i++)
        intArray[i] = i;
    } catch (ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    }
    System.out.println(Arrays.toString(intArray));
  }
}
