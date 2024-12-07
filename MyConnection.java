import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * MyConnection class for establishing a database connection.
 */
public class MyConnection {

    public static Connection getConnection() {
        Connection con = null;
        try {
            // Load the MySQL JDBC Driver (Updated class name)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appuser", "root", "041423");
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Driver not found: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Failed to connect to the database: " + ex.getMessage());
        }
        return con;
    }

    
    public static void main(String[] args) {
        Connection con = MyConnection.getConnection();
        if (con != null) {
            System.out.println("Connection successful!");
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}