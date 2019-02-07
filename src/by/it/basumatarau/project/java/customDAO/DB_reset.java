package by.it.basumatarau.project.java.customDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import by.it.basumatarau.project.java.connection.DBConnectionData;

public class DB_reset {

    private static String URL_DB;
    private static String USER_DB;
    private static String PASSWORD_DB;

    static {
        URL_DB = DBConnectionData.URL_DB;
        USER_DB = DBConnectionData.USER_DB;
        PASSWORD_DB = DBConnectionData.PASSWORD_DB;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }
    public static void resetDB() {

        try (Connection connection =
                     DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB)
        ) {
            Statement statement = connection.createStatement();

            statement.executeUpdate("DROP TABLE IF EXISTS `basumatarau`.`Venues` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `basumatarau`.`Places` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `basumatarau`.`Users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `basumatarau`.`Roles` ;");
            statement.executeUpdate("DROP SCHEMA IF EXISTS `basumatarau` ;");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
