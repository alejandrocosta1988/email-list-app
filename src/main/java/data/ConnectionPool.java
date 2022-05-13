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
		
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/onlineSQL?autoReconnect=true");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setInitialSize(10);
		dataSource.setMaxTotal(100);
		dataSource.setMaxIdle(30);
		dataSource.setMaxWaitMillis(10000);
		dataSource.setRemoveAbandonedOnBorrow(true);
		dataSource.setRemoveAbandonedOnMaintenance(true);
		dataSource.setRemoveAbandonedTimeout(60);
		dataSource.setLogAbandoned(true);
	
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
