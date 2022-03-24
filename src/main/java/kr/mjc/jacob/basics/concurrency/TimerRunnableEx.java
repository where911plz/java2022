package kr.mjc.jacob.basics.concurrency;

/**
 * p.700 예제 13-2 Runnable 인터페이스를 이용하여
 * 1초 단위로 출력하는 타이머 스레드 만들기 수정
 */
public class TimerRunnableEx {
	public static void main(String[] args) {
		TimerRunnableEx ex = new TimerRunnableEx();
		// lambda expression
		new Thread(() -> ex.printNumbers()).start();
		// method reference
		new Thread(ex::printNumbers).start();
		System.out.format("%s 스레드를 종료합니다.\n", Thread.currentThread().getName());
	}

	public void printNumbers() {
		String threadName = Thread.currentThread().getName();
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000); // 1000ms 동안 suspend
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.format("%s : %d\n", threadName, i);
		}
	}
}