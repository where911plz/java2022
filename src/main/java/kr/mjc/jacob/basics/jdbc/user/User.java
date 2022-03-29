package kr.mjc.jacob.basics.jdbc.user;

import lombok.Data;

@Data
public class User {
	int userId;
	String email;
	String password;
	String name;

	@Override
	public String toString() {
		// 비밀번호는 표현하지 않는다.
		return String.format("\nUser{userId=%d, email=%s, name=%s}", userId,
				email, name);
	}
}
