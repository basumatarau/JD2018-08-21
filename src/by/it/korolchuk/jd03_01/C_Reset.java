package by.it.korolchuk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class C_Reset {

    static void reset() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(Connect.url, Connect.user, Connect.password);
             Statement statement = connection.createStatement())
        {
            statement.executeUpdate("DROP TABLE IF EXISTS `korolchuk`.`ads` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `korolchuk`.`users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `korolchuk`.`roles` ;");
            statement.executeUpdate("DROP SCHEMA IF EXISTS `korolchuk` ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
