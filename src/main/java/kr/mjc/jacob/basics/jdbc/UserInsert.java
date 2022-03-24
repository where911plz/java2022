package kr.mjc.jacob.basics.jdbc;

import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

@Slf4j
public class UserInsert {

	public static void main(String[] args) {
		DataSource ds = DataSourceFactory.getDataSource();
		Scanner scanner = new Scanner(System.in);
		System.out.print("email, password, name : ");
		String[] params = {scanner.next(), scanner.next(), scanner.next()};
		try (Connection con = ds.getConnection();
			 PreparedStatement ps = con.prepareStatement(
					 "insert user values(null, ?,sha2(?,256),?)")) {
			ps.setString(1, params[0]);
			ps.setString(2, params[1]);
			ps.setString(3, params[2]);
			ps.executeUpdate();
			log.info("저장 완료");
		} catch (SQLException e) {
			log.error(e.toString());
		}
	}
}
