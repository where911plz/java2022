package kr.mjc.jacob.basics.generics;

/**
 * A Simple Box Class
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/generics/types.html">https://docs.oracle.com/javase/tutorial/java/generics/types.html</a>
 */
public class Box {
  private Object object;

  public void set(Object object) {
    this.object = object;
  }

  public Object get() {
    return object;
  }

  public static void main(String[] args) {
    Box box1 = new Box();
    box1.set(5);
    int i = (Integer) box1.get();

    box1.set("abc");
    String s = (String) box1.get();

    // compile ok, run failure
    int x = (Integer) box1.get();
  }
}
