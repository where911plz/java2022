package kr.mjc.jacob.basics.lambdaexp;

/**
 * 메서드 레퍼런스를 테스트하는 main 클래스
 */
public class MethodReferenceTest {

  public static void main(String[] args) {
    new MethodReferenceTest().go();
  }

  void go() {
    HelloMachine helloMachine = new HelloMachine();

    // lambda expression
    helloMachine.helloTwice(name -> System.out.println("Hello " + name),
        "Rachel");

    // static method reference
    helloMachine.helloTwice(MethodReferenceTest::sayStaticHello, "Rachel");

    // instance method reference
    helloMachine.helloTwice(this::sayHello, "Rachel");
  }

  static void sayStaticHello(String name) {
    System.out.println("안녕하세요 Static " + name);
  }

  void sayHello(String name) {
    System.out.println("안녕하세요 " + name);
  }
}
