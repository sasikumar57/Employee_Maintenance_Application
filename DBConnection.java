package employeeMaintanance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Empdb";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Sasi@2001";
    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            }
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return conn;
    }
}

