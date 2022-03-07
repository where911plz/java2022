package kr.mjc.jacob.basics.exception;

import java.util.Arrays;

/**
 * 예외의 생성과 처리를 테스트하기 위한 예제
 */
public class MyStack {

	Object[] objects;
	private int position = 0;

	/**
	 * 스택을 초기화하는 컨스트럭터
	 *
	 * @param size 스택의 크기
	 */
	public MyStack(int size) {
		objects = new Object[size];
	}

	/**
	 * 스택에 오브젝트를 넣는다.
	 *
	 * @param obj 스택에 넣는 오브젝트
	 * @throws StackOverflowException 스택의 크기를 초과할 때 던진다.
	 */
	public void push(Object obj) throws StackOverflowException {
		if (position >= objects.length) throw new StackOverflowException();
		objects[position++] = obj;
	}

	/**
	 * 스택에서 오브젝트를 꺼낸다.
	 *
	 * @return 스택에서 꺼낸 오브젝트
	 * @throws StackEmptyException 스택이 비어있을 때 던진다.
	 */
	public Object pop() throws StackEmptyException {
		if (position <= 0) throw new StackEmptyException();
		return objects[--position];
	}

	@Override
	public String toString() {
		return Arrays.toString(objects);
	}

	/**
	 * MyStack을 테스트하는 main() 메서드
	 */
	public static void main(String[] args) {
		MyStack myStack = new MyStack(3);

		try {
			myStack.push(5);
			myStack.push(3.14);
			myStack.push("abc");

			System.out.println(myStack);
			System.out.println(myStack.pop());
			System.out.println(myStack.pop());
			System.out.println(myStack.pop());
		} catch (StackEmptyException e) {
			System.err.println("스택이 비었습니다.");
		} catch (StackOverflowException e) {
			System.err.println("스택이 넘칩니다.");
		}
	}
}
