package kr.mjc.jacob.basics.jdbc.helper;

import kr.mjc.jacob.basics.jdbc.user.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class UserGet {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Get - userId : ");
		// 입력
		int userId = scanner.nextInt();
		User user = userDao.getUser(userId);
		log.debug(user.toString());
	}
}
