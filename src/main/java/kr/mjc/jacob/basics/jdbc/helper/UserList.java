package kr.mjc.jacob.basics.jdbc.helper;

import kr.mjc.jacob.basics.jdbc.User;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Scanner;

@Slf4j
public class UserList {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		Scanner scanner = new Scanner(System.in);
		System.out.print("List - count page : ");
		// 입력
		int count = scanner.nextInt();
		int page = scanner.nextInt();
		List<User> userList = userDao.listUsers(count, page);

		// 출력
		log.debug(userList.toString());
	}
}
