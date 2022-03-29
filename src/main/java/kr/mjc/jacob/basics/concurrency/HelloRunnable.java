package kr.mjc.jacob.basics.concurrency;

/**
 * The Java tutorials 예제
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html">https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html</a>
 */
public class HelloRunnable implements Runnable {
  public static void main(String[] args) {
    System.out.format("%s : Hello from the main thread!\n",
        Thread.currentThread().getName());

    // Runnable 태스크를 Thread 클래스의 컨스트럭터에 넣어서 start()
    new Thread(new HelloRunnable()).start();

    // using lambda expression.
    // Runnable 구현체를 만들 필요 없이 run() 메서드를 구현
    new Thread(() -> System.out.format("%s : Hello from a thread!\n",
        Thread.currentThread().getName())).start();
  }

  @Override
  public void run() {
    System.out.format("%s : Hello from a thread!\n",
        Thread.currentThread().getName());
  }
}

