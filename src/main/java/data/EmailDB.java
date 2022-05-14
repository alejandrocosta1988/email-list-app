package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Email;

public class EmailDB {
	
	public static void deleteEmail(String emailAddress) {
		
		Integer emailId = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		ResultSet resultSet = null;
		PreparedStatement selectPreparedStatement = null;
		PreparedStatement deletePreparedStatement = null;
		
		String query = "SELECT * FROM table_users WHERE email = ?";
		String deleteQuery = "DELETE FROM table_users WHERE user_id = ?";
		
		try {
			
			selectPreparedStatement = connection.prepareStatement(query);
			selectPreparedStatement.setString(1, emailAddress);
			resultSet = selectPreparedStatement.executeQuery();
			if (resultSet.next()) {
				emailId = resultSet.getInt("user_id");
			}
			
			deletePreparedStatement = connection.prepareStatement(deleteQuery);
			deletePreparedStatement.setInt(1, emailId);
			deletePreparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			DBUtil.closePreparedStatement(selectPreparedStatement);
			DBUtil.closePreparedStatement(deletePreparedStatement);
			DBUtil.closeResultSet(resultSet);
			pool.freeConnection(connection);
			
		}
		
	}
	
	
	public static List<Email> getEmailsFromDatabase() {
		
		List<Email> emails = new ArrayList<>();
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		ResultSet resultSet = null;
		
		String query = "SELECT * FROM table_users";
		
		try {
			
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				
				Email email = new Email(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("email"));
				emails.add(email);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			DBUtil.closeResultSet(resultSet);
			pool.freeConnection(connection);
			
		}
		
		return emails;
	}

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

			DBUtil.closeResultSet(resultSet);
			DBUtil.closePreparedStatement(preparedStatement);
			pool.freeConnection(connection);
			
		}
		
	}
	
	
}
