package kr.mjc.jacob.basics.lambdaexp;

/**
 * 추상 메서드가 한 개만 있는 functional interface
 *
 * @author Jacob
 */
@FunctionalInterface
public interface Greeting {

	void greet(String name); // public abstract
}
