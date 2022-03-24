package kr.mjc.jacob.basics.collections;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * p.418 예제 7-7. 학생 클래스
 */
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Student {
	private int id;
	private String name;
}
