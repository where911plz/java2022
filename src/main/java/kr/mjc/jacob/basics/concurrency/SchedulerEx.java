package kr.mjc.jacob.basics.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 스케줄러 (일정 간격으로 태스크를 실행)
 *
 * @author Jacob
 */
public class SchedulerEx {

	public static void main(String[] args) {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		Runnable beeper = () -> System.out.print("beep ");

		// (task, initialDeday, period, unit)
		// beeper 태스크를 3초 후부터 1초 간격으로 실행
		scheduler.scheduleAtFixedRate(beeper, 3, 1, TimeUnit.SECONDS);
	}
}
