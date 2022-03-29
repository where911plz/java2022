package kr.mjc.jacob.basics.lambdaexp;

/**
 * 인사 실행기
 *
 * @author Jacob
 */
public class HelloMachine {

	/**
	 * 인사를 두번하는 메서드.
	 * functional interface의 메서드를 실행한다.
	 */
	public void helloTwice(Greeting greeting, String name) {
		for (int i = 0; i < 2; i++) {
			greeting.greet(name);
		}
	}
}
