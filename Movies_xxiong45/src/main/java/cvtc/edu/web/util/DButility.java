/**
 * 
 */
package cvtc.edu.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author fish
 *
 */
public class DButility {
	
	public static final int TIMEOUT = 30;
	
	private static final String DRIVER_NAME = "org.sqlite.JDBC";
	private static final String CONNECTION = "jdbc:sqlite:movie.db";
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		// register the driver
		Class.forName(DRIVER_NAME);
		
		// create the database connection
		return DriverManager.getConnection(CONNECTION);
		
	}
	
	public static void closeConnections(final Connection connection, final Statement statement) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
		} catch (final SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
}
