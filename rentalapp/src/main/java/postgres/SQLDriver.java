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

	private static Connection con = null;

	static
	{
		String url = "jdbc:postgresql://localhost/rentals";
		String user = "postgres";
		String pass = "1234";
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		return con;
	}
}
