-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema korolchuk
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `korolchuk` ;

-- -----------------------------------------------------
-- Schema korolchuk
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `korolchuk` DEFAULT CHARACTER SET utf8 ;
USE `korolchuk` ;

-- -----------------------------------------------------
-- Table `korolchuk`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korolchuk`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korolchuk`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korolchuk`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `korolchuk`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korolchuk`.`ads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korolchuk`.`ads` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  `kindOfAnimal` VARCHAR(45) NULL,
  `greed` VARCHAR(45) NULL,
  `sex` VARCHAR(45) NULL,
  `age` DECIMAL NULL,
  `height` INT NULL,
  `qualities` VARCHAR(45) NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Ads_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_ads_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `korolchuk`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Data for table `korolchuk`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `korolchuk`;
INSERT INTO `korolchuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `korolchuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `korolchuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `korolchuk`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `korolchuk`;
INSERT INTO `korolchuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@mail.ru', 1);
INSERT INTO `korolchuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', 2);
INSERT INTO `korolchuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user2', 'qwerty', 'user2@mail.ru', 3);
INSERT INTO `korolchuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user3', 'zxnm', 'user3@tut.by', 3);
INSERT INTO `korolchuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user4', 'asdfhjk', 'user4@gmal.com', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `korolchuk`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `korolchuk`;
INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`)
VALUES (DEFAULT, 'Dooby the dog', 'a dog', 'without greed', 'male', 2, 45, 'needs training', 2);
INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`)
VALUES (DEFAULT, 'Maya the dog', 'a dog', 'wthout greed', 'female', 2, 60, 'disabled dog without a paw', 2);
INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`)
VALUES (DEFAULT, 'Max the parrot', 'a parrot', 'budgerigar', 'male', 5, NULL, 'warning: turns the air blue!', 2);
INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`)
VALUES (DEFAULT, 'Decorative rat', 'a rat', 'standard', 'female', 1, NULL, 'steals shining things', 2);
INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`)
VALUES (DEFAULT, 'Belka the old dog', 'a dog', 'without greed', 'female', 11, 55, 'ideal calm dog for phlegmatic people', 2);
INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`)
VALUES (DEFAULT, 'Tikhon the cat', 'a cat', 'reed cat', 'male', 4, 23, 'has diabetes, needs care', 2);
INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`)
VALUES (DEFAULT, 'Ginger Lucy', 'a dog', 'wthout greed', 'female', 5, 50, 'adores digging holes in a yard', 2);
INSERT INTO `korolchuk`.`ads` (`id`, `description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`)
VALUES (DEFAULT, 'Old Bobby', 'a cat', 'wthout greed', 'male', 13, 25, 'one-eyed pirate', 2);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
