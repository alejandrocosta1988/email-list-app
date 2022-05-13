package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {

	public static void closePreparedStatement(PreparedStatement preparedStatement) {
		try {
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
