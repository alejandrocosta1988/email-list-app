package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPool {

	private static ConnectionPool pool = null;
	private static BasicDataSource dataSource = null;
	
	private ConnectionPool() {
		
		try {
			dataSource = new BasicDataSource();
			Properties properties = new Properties();
			InputStream inputStream = new FileInputStream("src/db.properties");
			properties.load(inputStream);
			dataSource.setDriverClassName(properties.getProperty("DRIVER_CLASS"));
			dataSource.setUrl(properties.getProperty("DB_CONNECTION_URL"));
			dataSource.setUsername(properties.getProperty("DB_USER"));
			dataSource.setPassword(properties.getProperty("DB_PWD"));
			dataSource.setInitialSize(10);
			dataSource.setMaxTotal(100);
			dataSource.setMaxIdle(30);
			dataSource.setMaxWaitMillis(10000);
			dataSource.setRemoveAbandonedOnBorrow(true);
			dataSource.setRemoveAbandonedOnMaintenance(true);
			dataSource.setRemoveAbandonedTimeout(60);
			dataSource.setLogAbandoned(true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static synchronized ConnectionPool getInstance() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}
	
	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void freeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
