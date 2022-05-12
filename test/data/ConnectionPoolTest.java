package data;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConnectionPoolTest {

	private ConnectionPool pool;
	
	@BeforeEach
	void createPool() {
		pool = ConnectionPool.getInstance(); 
	}
	
	@Test
	void getConnectionReturnsANotNullConnection() {
		
		Connection connection = pool.getConnection();
		
		assertTrue(connection != null);
		
	}
	
	@Test
	void freeConnectionClosesTheConnectionRetrievedFromThePool() {
		
		Connection connection = pool.getConnection();
		pool.freeConnection(connection);
		
		try {
			assertTrue(connection.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
