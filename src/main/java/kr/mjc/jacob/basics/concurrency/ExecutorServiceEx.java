package kr.mjc.jacob.basics.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * high level concurrency (스레드 풀 사용) 예
 *
 * @author Jacob
 */
public class ExecutorServiceEx {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		ExecutorServiceEx ex = new ExecutorServiceEx();
		for (int i = 0; i < 100; i++) {
			service.execute(() -> ex.work());
			//new Thread(() -> ex.run()).start();
		}
		service.shutdown();
	}

	/**
	 * 실행시간 1000ms 걸리는 어떤 작업
	 */
	private void work() {
		String threadName = Thread.currentThread().getName();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ignored) {
		}
		System.out.format("%s : 작업 종료\n", threadName);
	}
}
