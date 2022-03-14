package kr.mjc.jacob.basics.generics;

/**
 * IntegerBox와 StringBox 테스트
 */
public class BoxTest {
  public static void main(String[] args) {
    StringBox stringBox = new StringBox();
    stringBox.set("abc");
    String s = stringBox.get();

    // autoboxing: primitive value를 wrapper class의 object로 변환
    Integer a = 5;
    // unboxing: wrapper class object를 primitive value로 변환
    int b = a;

    IntegerBox integerBox = new IntegerBox();
    integerBox.set(5);
    int i = integerBox.get();
  }
}
