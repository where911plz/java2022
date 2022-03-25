package kr.mjc.jacob.basics.jdbc.raw;

import kr.mjc.jacob.basics.jdbc.User;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class UserList {
	public static void main(String[] args) {

		DataSource ds = DataSourceFactory.getDataSource();
		Scanner scanner = new Scanner(System.in);
		System.out.print("List - count page : ");
		// 입력
		int count = scanner.nextInt();
		int page = scanner.nextInt();
		int offset = (page - 1) * count;
		List<User> userList = new ArrayList<>();
		try (Connection con = ds.getConnection();
			 PreparedStatement ps = con.prepareStatement(
					 "select userId, email, name from user limit ?,?")) {
			ps.setInt(1, offset);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				userList.add(user);
			}
		} catch (SQLException e) {
			log.error(e.toString());
		}

		// 출력
		log.debug(userList.toString());
	}
}
