package kr.mjc.jacob.basics.concurrency;

/**
 * SleepMessages를 별도 스레드로 돌리는 예
 *
 * @author Jacob
 */
public class SleepMessagesUsingThread {
	public static void main(String[] args) {
		new Thread(new RunnableTask()).start();
		System.out.format("%s 스레드를 종료합니다.\n", Thread.currentThread().getName());
	}
}

class RunnableTask implements Runnable {

	@Override
	public void run() {
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
	}
}
