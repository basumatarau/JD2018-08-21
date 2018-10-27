package by.it.korolchuk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class B_AddRoles {

       static void addRoles() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(Connect.url, Connect.user, Connect.password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `korolchuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `korolchuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `korolchuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
