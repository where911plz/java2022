package kr.mjc.jacob.basics.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	Integer userId;
	String email;
	String password;
	String name;

	@Override
	public String toString() {
		return "User{" + "userId=" + userId + ", email='" + email + '\'' +
				", name='" + name + '\'' + '}';
	}
}
