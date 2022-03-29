package kr.mjc.jacob.basics.jdbc.helper;

import kr.mjc.jacob.basics.jdbc.DataSourceFactory;
import kr.mjc.jacob.basics.jdbc.JdbcHelper;
import kr.mjc.jacob.basics.jdbc.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao {

	private JdbcHelper dbHelper;

	public UserDao() {
		dbHelper = new JdbcHelper(DataSourceFactory.getDataSource());
	}

	private User mapResult(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt("userId"));
		user.setEmail(rs.getString("email"));
		user.setName(rs.getString("name"));
		return user;
	}

	public List<User> listUsers(int count, int page) {
		int offset = (page - 1) * count;
		String sql = "select userId, email, name from user limit ?,?";
		return dbHelper.list(sql, (rs) -> mapResult(rs), offset, count);
	}

	public User getUser(int userId) {
		String sql = "select userId, email, name from user where userId=?";
		return dbHelper.get(sql, (rs) -> mapResult(rs), userId);
	}

	public User login(String email, String password) {
		String sql =
				"select userId, email, name from user where email=? and password=sha2(?,256)";
		return dbHelper.get(sql, (rs) -> mapResult(rs), email, password);
	}

	public int addUser(String email, String password, String name) {
		String sql =
				"insert user(email, password, name) values(?,sha2(?,256),?)";
		return dbHelper.update(sql, email, password, name);
	}

	public int updateUser(int userId, String email, String password,
			String name) {
		String sql =
				"update user set email=?, password=sha2(?,256), name=? where userId=?";
		return dbHelper.update(sql, email, password, name, userId);
	}

	public int deleteUser(int userId) {
		String sql = "delete from user where userId=?";
		return dbHelper.update(sql, userId);
	}
}
