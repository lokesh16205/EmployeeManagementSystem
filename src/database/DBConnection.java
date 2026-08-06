package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/employee_management_system";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lokesh2005@16";
    private static Connection connection;
    public static Connection getConnection() {

        try {

            if (connection == null || connection.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return connection;
    }
}