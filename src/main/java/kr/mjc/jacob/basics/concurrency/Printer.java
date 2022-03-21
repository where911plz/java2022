package kr.mjc.jacob.basics.concurrency;

/**
 * 어떤 프린터. 한글자 출력하는데 10ms 소요
 *
 * @author Jacob
 */
public class Printer {
	public void println(String str) {
		for (char c : str.toCharArray()) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(c);
		}
		System.out.println();
	}
}
