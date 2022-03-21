package kr.mjc.jacob.basics.concurrency;

/**
 * The Java Tutorials 예
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html">https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html</a>
 */
public class SleepMessages {
	public static void main(String args[]) {
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
			System.out.println(s);
		}

		System.out.println("main 스레드를 종료합니다.");
	}
}
