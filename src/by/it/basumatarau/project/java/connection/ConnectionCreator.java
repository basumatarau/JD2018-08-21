package by.it.basumatarau.project.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator implements DBConnectionData {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    private static Connection connection;

    //synchronized?!
    public synchronized static Connection getConnection() throws SQLException {
        if(connection==null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL_CONTEXT, USER_DB, PASSWORD_DB);
            System.out.println("connection created...");
        }
        return connection;
    }
}
