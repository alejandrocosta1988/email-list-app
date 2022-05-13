package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Email;

public class EmailDB {

	public static int insertEmail(Email email) {
		
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "INSERT INTO table_users (first_name, last_name, email) VALUES (?, ?, ?)";
		
		try {
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email.getFirstName());
			preparedStatement.setString(2, email.getLastName());
			preparedStatement.setString(3, email.getEmailAddress());
			
			return preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
			
		} finally {
			
			DBUtil.closePreparedStatement(preparedStatement);
			pool.freeConnection(connection);
			
		}
	}
}
