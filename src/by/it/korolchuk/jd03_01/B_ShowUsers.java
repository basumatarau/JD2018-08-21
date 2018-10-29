package by.it.korolchuk.jd03_01;

import java.sql.*;

class B_ShowUsers {

    static void showUsers() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(Connect.url, Connect.user, Connect.password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()) {
                String getUser = resultSet.getString("login") + ", "
                        + resultSet.getString("password") + ", "
                        + resultSet.getString("email");
                System.out.println(getUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
