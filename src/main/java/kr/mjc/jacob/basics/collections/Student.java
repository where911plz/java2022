package kr.mjc.jacob.basics.collections;

import java.util.Objects;

/**
 * p.418 예제 7-7. 학생 클래스
 */
public class Student {
  private int id;
  private String name;

  public Student(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Student) {
      Student s = (Student) o;
      return this.id == s.getId() && Objects.equals(this.name, s.getName());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
