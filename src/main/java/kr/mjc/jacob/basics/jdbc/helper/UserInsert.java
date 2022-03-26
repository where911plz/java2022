package kr.mjc.jacob.basics.jdbc.helper;

import kr.mjc.jacob.basics.jdbc.DbException;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * 회원 가입
 */
@Slf4j
public class UserInsert {

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Insert - email password name : ");
		// 입력
		String email = scanner.next();
		String password = scanner.next();
		String name = scanner.next();
		try {
			userDao.addUser(email, password, name);
			log.debug("저장 성공");
		} catch (DbException e) {
			log.debug("저장 못함");
		}
	}
}
