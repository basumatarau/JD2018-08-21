package by.it.korolchuk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class A_AddData {
    
    static  void  addData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(Connect.url, Connect.user, Connect.password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`) " +
                    "VALUES (DEFAULT, 'Dooby the dog', 'a dog', 'without greed', 'male', 2, 45, 'needs training', 2);");
            statement.executeUpdate("INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`) " +
                    "VALUES (DEFAULT, 'Maya the dog', 'a dog', 'wthout greed', 'female', 2, 60, 'disabled dog without a paw', 2);");
            statement.executeUpdate("INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`) " +
                    "VALUES (DEFAULT, 'Max the parrot', 'a parrot', 'budgerigar', 'male', 5, NULL, 'warning: turns the air blue!', 2);");
            statement.executeUpdate("INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`) " +
                    "VALUES (DEFAULT, 'Decorative rat', 'a rat', 'standard', 'female', 1, NULL, 'steals shining things', 2);");
            statement.executeUpdate("INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`)" +
                    " VALUES (DEFAULT, 'Belka the old dog', 'a dog', 'without greed', 'female', 11, 55, 'ideal calm dog for phlegmatic people', 2);");
            statement.executeUpdate("INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`) " +
                    "VALUES (DEFAULT, 'Tikhon the cat', 'a cat', 'reed cat', 'male', 4, 23, 'has diabetes, needs care', 2);");
            statement.executeUpdate("INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`) " +
                    "VALUES (DEFAULT, 'Ginger Lucy', 'a dog', 'wthout greed', 'female', 5, 50, 'adores digging holes in a yard', 2);");
            statement.executeUpdate("INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`) " +
                    "VALUES (DEFAULT, 'Old Bobby', 'a cat', 'wthout greed', 'male', 13, 25, 'one-eyed pirate', 2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
