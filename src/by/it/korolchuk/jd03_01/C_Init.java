package by.it.korolchuk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class C_Init {

    static void init() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(Connect.url, Connect.user, Connect.password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `korolchuk` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `korolchuk` DEFAULT CHARACTER SET utf8 ;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `korolchuk`.`roles` (\n" +
                    "`id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "`role` VARCHAR(45) NULL,\n" +
                    "PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;\n");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `korolchuk`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `korolchuk`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");


            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `korolchuk`.`ads` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `description` VARCHAR(45) NULL,\n" +
                    "  `kindOfAnimal` VARCHAR(45) NULL,\n" +
                    "  `greed` VARCHAR(45) NULL,\n" +
                    "  `sex` VARCHAR(45) NULL,\n" +
                    "  `age` DECIMAL NULL,\n" +
                    "  `height` INT NULL,\n" +
                    "  `qualities` VARCHAR(45) NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_Ads_users1_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_ads_users`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `korolchuk`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;\n");


            statement.executeUpdate("INSERT INTO `korolchuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `korolchuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `korolchuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");

            statement.executeUpdate("INSERT INTO `korolchuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@mail.ru', 1);");
            statement.executeUpdate("INSERT INTO `korolchuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', 2);");
            statement.executeUpdate("INSERT INTO `korolchuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user2', 'qwerty', 'user2@mail.ru', 3);");
            statement.executeUpdate("INSERT INTO `korolchuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user3', 'zxnm', 'user3@tut.by', 3);");
            statement.executeUpdate("INSERT INTO `korolchuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user4', 'asdfhjk', 'user4@gmal.com', 2);");


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
