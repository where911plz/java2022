package kr.mjc.jacob.basics.concurrency;

/**
 * 공유 화장실
 *
 * @author Jacob
 */
public class RestRoom {
  public void use(long time1, long time2) {
    synchronized (this) {
      System.out.format("%s : 화장실에 들어갔다.\n", Thread.currentThread().getName());
      try {
        Thread.sleep(time1);
      } catch (InterruptedException e) {
      }
      System.out.format("%s : 화장실에서 나왔다.\n", Thread.currentThread().getName());
    }

    try {
      Thread.sleep(time2);
    } catch (InterruptedException e) {
    }
    System.out.format("%s : 손씻기 종료.\n", Thread.currentThread().getName());
  }
}
