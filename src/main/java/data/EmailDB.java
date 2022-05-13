package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public static boolean emailExistsInDataBase(Email email) {
		
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String emailAddress = email.getEmailAddress();
		String query = "SELECT email FROM table_users WHERE email = ?";
		
		try {
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, emailAddress);
			resultSet = preparedStatement.executeQuery();
			return resultSet.next();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
			
		} finally {

			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil.closePreparedStatement(preparedStatement);
			pool.freeConnection(connection);
			
		}
		
	}
	
	
}
