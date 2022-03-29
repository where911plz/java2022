package kr.mjc.jacob.basics.jdbc.user.raw;

import kr.mjc.jacob.basics.jdbc.DataSourceFactory;
import kr.mjc.jacob.basics.jdbc.user.User;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * userId로 회원정보를 가져온다.
 */
@Slf4j
public class GetUser {
	public static void main(String[] args) {

		DataSource ds = DataSourceFactory.getDataSource();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Get - userId : ");
		// 입력
		int userId = scanner.nextInt();
		try (Connection conn = ds.getConnection();
			 PreparedStatement ps = conn.prepareStatement(
					 "select userId, email, name from user where userId=?")) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				log.debug(user.toString());
			} else {
				log.debug("회원 없음. userId={}", userId);
			}
		} catch (SQLException e) {
			log.error(e.toString());
		}
	}
}
