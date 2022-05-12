package data;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

class ConnectionPoolTest {

	@Test
	void getDataSourceConnectionReturnsANotNullConnection() {
		
		Connection connection = ConnectionPool.getConnection();
		
		assertTrue(connection != null);
		
	}

}
