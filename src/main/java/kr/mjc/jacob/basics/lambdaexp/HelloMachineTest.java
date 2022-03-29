package kr.mjc.jacob.basics.lambdaexp;

/**
 * HelloWorld를 테스트하는 main 클래스
 */
public class HelloMachineTest {

  public static void main(String[] args) {

    HelloMachine helloMachine = new HelloMachine();

    // 영어 인사하기
    EnglishGreeting englishGreeting = new EnglishGreeting();
    helloMachine.helloTwice(englishGreeting, "Rachel");

    // 프랑스어 인사하기 (anonymous class. 클래스 이름이 없음)
    Greeting frenchGreeting = new Greeting() {
      @Override
      public void greet(String name) {
        System.out.println("Bonjour " + name);
      }
    };
    helloMachine.helloTwice(frenchGreeting, "Rachel");

    // 한국어 인사하기
    helloMachine.helloTwice(new Greeting() {
      @Override
      public void greet(String name) {
        System.out.println("안녕하세요 " + name);
      }
    }, "Rachel");

    // lambda expression. 메서드 내부만 넣는다.
    helloMachine.helloTwice((name) -> {
      System.out.println("안녕하세요 " + name);
    }, "Lambda Expression");

    // lambda expression.
    // 인자가 한개일 때 괄호 필요없음.
    // 내용이 한줄일 때 블럭 필요없음.
    helloMachine.helloTwice(name -> System.out.println("Hola " + name),
        "Rachel");
  }
}

class EnglishGreeting implements Greeting {
  @Override
  public void greet(String name) {
    System.out.println("Hello " + name);
  }
}
