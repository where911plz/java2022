package kr.mjc.jacob.basics.jdbc.helper;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * 회원 삭제
 */
@Slf4j
public class UserDelete {

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Delete - userId : ");
		// 입력
		int userId = scanner.nextInt();
		int updatedRows = userDao.deleteUser(userId);
		if (updatedRows >= 1)
			log.debug("삭제 성공");
		else
			log.debug("회원 없음");
	}
}
