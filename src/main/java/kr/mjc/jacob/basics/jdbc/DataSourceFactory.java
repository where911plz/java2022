package kr.mjc.jacob.basics.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
public class DataSourceFactory {

	private static DataSource singleton = null;

	public static DataSource getDataSource() {

		if (singleton == null) {
			Properties props = new Properties();
			try {
				DriverManager.getConnection("");
				props.load(DataSourceFactory.class.getResourceAsStream(
						"/db.properties"));
				singleton = new MariaDbDataSource(props.getProperty("url"));
			} catch (IOException | SQLException e) {
				log.error(e.toString());
			}
		}
		return singleton;
	}
}
