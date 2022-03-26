package kr.mjc.jacob.basics.jdbc;

import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DbHelper {

	private DataSource ds;

	public DbHelper(DataSource ds) throws DbException {
		this.ds = ds;
	}

	public <T> List<T> list(String sql, ResultMapper<T> mapper,
			Object... params) throws DbException {
		try (Connection con = ds.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {
			setParameters(ps, params);
			ResultSet rs = ps.executeQuery();
			List<T> list = new ArrayList<>();
			while (rs.next()) {
				list.add(mapper.map(rs));
			}
			return list;
		} catch (SQLException e) {
			log.error(e.toString());
			throw new DbException(e);
		}
	}

	public <T> T get(String sql, ResultMapper<T> mapper, Object... params)
			throws DbException {
		try (Connection con = ds.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {
			setParameters(ps, params);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return mapper.map(rs);
			else
				return null;
		} catch (SQLException e) {
			log.error(e.toString());
			throw new DbException(e);
		}
	}

	public int update(String sql, Object... params) {
		try (Connection con = ds.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {
			setParameters(ps, params);
			return ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e.toString());
			throw new DbException(e);
		}
	}

	private void setParameters(PreparedStatement ps, Object... params)
			throws SQLException {
		try {
			for (int i = 0; i < params.length; i++)
				ps.setObject(i + 1, params[i]);
		} catch (SQLException e) {
			throw e;
		}
	}

}
