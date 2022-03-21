package kr.mjc.jacob.basics.concurrency;

/**
 * SleepMessages 스레드를 lambda expression으로 실행
 *
 * @author Jacob
 */
public class SleepMessagesUsingLambdaExpression {
	public static void main(String[] args) {

		new Thread(() -> {
			String[] importantInfo =
					{"Mares eat oats", "Does eat oats", "Little lambs eat ivy",
							"A kid will eat ivy too"};

			for (String s : importantInfo) {
				//Pause for 4 seconds
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//Print a message
				System.out.format("%s : %s\n", Thread.currentThread().getName(), s);
			}
		}).start();

		System.out.format("%s 스레드를 종료합니다.\n", Thread.currentThread().getName());
	}
}
