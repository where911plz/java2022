package kr.mjc.jacob.basics.jdbc.helper;

import kr.mjc.jacob.basics.jdbc.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class UserLogin {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Login - email password : ");
		// 입력
		String email = scanner.next();
		String password = scanner.next();
		User user = userDao.login(email, password);
		if (user != null)
			log.debug(user.toString());
		else
			log.debug("로그인 실패");
	}
}
