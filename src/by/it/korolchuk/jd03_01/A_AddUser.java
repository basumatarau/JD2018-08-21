package by.it.korolchuk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class A_AddUser {

    static void addUser() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(Connect.url, Connect.user, Connect.password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `korolchuk`.`users`(`id`, `login`, `password`, `email`, `roles_id`) " +
                    "VALUES (DEFAULT,'mylogin','mypassword','123@mail.ru',2");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
