package kr.mjc.jacob.basics.generics;

/**
 * IntegerBox와 StringBox 테스트
 */
public class BoxTest {
  public static void main(String[] args) {
    IntegerBox integerBox = new IntegerBox();
    integerBox.set(5);
    int i = integerBox.get();

    StringBox stringBox = new StringBox();
    stringBox.set("abc");
    String s = stringBox.get();
  }
}
