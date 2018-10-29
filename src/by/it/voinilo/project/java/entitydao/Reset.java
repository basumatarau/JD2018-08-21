package by.it.voinilo.project.java.entitydao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Reset {

    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }


        try (Connection connection =
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB);
        ) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `voinilo` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `voinilo` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `voinilo`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `voinilo`.`roleparam` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_roleparam_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_roleparam_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `voinilo`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `voinilo`.`ads` (\n" +
                    "                      `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "                      `description` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL, \n" +
                    "                      `address` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,  \n" +
                    "                      `name` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL, \n" +
                    "                      `price` INT(11) NOT NULL, \n" +
                    "                      `condition` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL, \n" +
                    "                      `number` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL, \n" +
                    "                      `roles_id` INT(11) NOT NULL, \n" +
                    "                      PRIMARY KEY (`id`), \n" +
                    "                      INDEX `fk_ads_roles1_idx` (`roles_id` ASC), \n" +
                    "                      CONSTRAINT `fk_ads_roles1` \n" +
                    "                      FOREIGN KEY (`roles_id`) \n" +
                    "                       REFERENCES `voinilo`.`roleparam` (`id`) \n" +
                    "                      ON DELETE CASCADE \n" +
                    "                     ON UPDATE CASCADE) \n" +
                    "                    ENGINE = InnoDB;\n");
            statement.executeUpdate("INSERT INTO `voinilo`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');\n");
            statement.executeUpdate("INSERT INTO `voinilo`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `voinilo`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `voinilo`.`roleparam` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@mail.ru', 1);");
            statement.executeUpdate("INSERT INTO `voinilo`.`roleparam` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', 2);");
            statement.executeUpdate("INSERT INTO `voinilo`.`ads` (`id`, `description`, `address`, `name`, `price`, `condition`, `number`, `roles_id`) VALUES (DEFAULT, 'bla-bla-bla', 'центральная,2,кв 33', 'galaxy s6', 50, 'good', '1', 2);\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
