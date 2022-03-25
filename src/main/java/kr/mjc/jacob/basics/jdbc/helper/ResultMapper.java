package kr.mjc.jacob.basics.jdbc.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultMapper<T> {
	T map(ResultSet rs) throws SQLException;
}
