package kr.mjc.jacob.basics.jdbc.helper;

import kr.mjc.jacob.basics.jdbc.DbException;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * 회원 수정
 */
@Slf4j
public class UserUpdate {

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		Scanner scanner = new Scanner(System.in);
		System.out.print("userId email password name : ");
		// 입력
		int userId = scanner.nextInt();
		String email = scanner.next();
		String password = scanner.next();
		String name = scanner.next();

		try {
			int updatedRows = userDao.updateUser(userId, email, password, name);
			if (updatedRows >= 1)
				log.debug("수정 성공");
			else
				log.debug("회원 없음");
		} catch (DbException e) {
			log.debug("수정 못함");
		}
	}
}
