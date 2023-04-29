/**
 * 
 */
package postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author fatimamariyam
 *
 */
public class SQLDriver {
	final String url = "jdbc:postgresql://localhost/rentals";
	final String user = "postgres";
	final String password = "1234";

	public Connection getDriver() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}
}
