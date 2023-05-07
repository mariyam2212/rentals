/**
 *
 */
package postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author fatimamariyam
 */

public class SQLDriver {

    private static SQLDriver instance;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost/rentals";
    private String username = "postgres";
    private String password = "1234";

    private SQLDriver() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static SQLDriver getInstance() {
        try {
            if (instance == null) {
                instance = new SQLDriver();
            } else if (instance.getConnection().isClosed()) {
                instance = new SQLDriver();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return instance;
    }
}
