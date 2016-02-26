-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema korporativ_portal
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema korporativ_portal
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `korporativ_portal` DEFAULT CHARACTER SET utf8 ;
USE `korporativ_portal` ;

-- -----------------------------------------------------
-- Table `korporativ_portal`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`country` (
  `id_country` INT NOT NULL AUTO_INCREMENT,
  `country_name` VARCHAR(60) NOT NULL,
  `short_country_name` VARCHAR(45) NULL,
  `key_phone` VARCHAR(45) NULL,
  PRIMARY KEY (`id_country`),
  UNIQUE INDEX `country_name_UNIQUE` (`country_name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korporativ_portal`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`city` (
  `id_city` INT NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(45) NULL,
  `id_country` INT NOT NULL,
  PRIMARY KEY (`id_city`),
  INDEX `fk_city_country1_idx` (`id_country` ASC),
  CONSTRAINT `fk_city_country1`
    FOREIGN KEY (`id_country`)
    REFERENCES `korporativ_portal`.`country` (`id_country`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korporativ_portal`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`department` (
  `id_department` INT NOT NULL AUTO_INCREMENT,
  `name_division` VARCHAR(60) NOT NULL,
  `count_employees` INT NOT NULL,
  `way_work` VARCHAR(45) NULL,
  PRIMARY KEY (`id_department`),
  UNIQUE INDEX `id_division_UNIQUE` (`id_department` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korporativ_portal`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`post` (
  `id_post` INT NOT NULL AUTO_INCREMENT,
  `name_post` VARCHAR(60) NOT NULL,
  `rang` VARCHAR(45) NOT NULL,
  `income` INT NOT NULL,
  `working_schedule` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_post`),
  UNIQUE INDEX `id_post_UNIQUE` (`id_post` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korporativ_portal`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`person` (
  `id_person` INT NOT NULL AUTO_INCREMENT,
  `firts_name` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `sex` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `e-mail` VARCHAR(45) NOT NULL,
  `link_self_site` VARCHAR(45) NOT NULL,
  `id_city` INT NOT NULL,
  `reiting` DOUBLE NOT NULL,
  `id_division` INT NOT NULL,
  `id_post` INT NOT NULL,
  PRIMARY KEY (`id_person`),
  INDEX `fk_person_city1_idx` (`id_city` ASC),
  INDEX `fk_person_division1_idx` (`id_division` ASC),
  INDEX `fk_person_post1_idx` (`id_post` ASC),
  CONSTRAINT `fk_person_city1`
    FOREIGN KEY (`id_city`)
    REFERENCES `korporativ_portal`.`city` (`id_city`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_person_division1`
    FOREIGN KEY (`id_division`)
    REFERENCES `korporativ_portal`.`department` (`id_department`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_person_post1`
    FOREIGN KEY (`id_post`)
    REFERENCES `korporativ_portal`.`post` (`id_post`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korporativ_portal`.`type_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`type_user` (
  `id_type_user` INT NOT NULL AUTO_INCREMENT,
  `name_type` VARCHAR(45) NOT NULL,
  `access_level` INT NOT NULL,
  PRIMARY KEY (`id_type_user`),
  UNIQUE INDEX `id_type_user_UNIQUE` (`id_type_user` ASC),
  UNIQUE INDEX `access_level_UNIQUE` (`access_level` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korporativ_portal`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`user` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(130) NOT NULL,
  `status_session` TINYINT(1) NULL DEFAULT 0,
  `status_active` TINYINT(1) NULL DEFAULT 1,
  `id_person` INT NOT NULL,
  `id_type_user` INT NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  INDEX `fk_user_person1_idx` (`id_person` ASC),
  UNIQUE INDEX `person_id_person_UNIQUE` (`id_person` ASC),
  UNIQUE INDEX `id_user_UNIQUE` (`id_user` ASC),
  INDEX `fk_user_type_user1_idx` (`id_type_user` ASC),
  CONSTRAINT `fk_user_person1`
    FOREIGN KEY (`id_person`)
    REFERENCES `korporativ_portal`.`person` (`id_person`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_type_user1`
    FOREIGN KEY (`id_type_user`)
    REFERENCES `korporativ_portal`.`type_user` (`id_type_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korporativ_portal`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`message` (
  `id_message` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(500) NOT NULL,
  `id_user_sender` INT NOT NULL,
  `date` DATETIME NULL DEFAULT NOW(),
  PRIMARY KEY (`id_message`),
  INDEX `fk_message_user1_idx` (`id_user_sender` ASC),
  CONSTRAINT `fk_message_user1`
    FOREIGN KEY (`id_user_sender`)
    REFERENCES `korporativ_portal`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korporativ_portal`.`record`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`record` (
  `id_record` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(1000) NOT NULL,
  `user_id_user` INT NOT NULL,
  `date` DATETIME NULL DEFAULT NOW(),
  PRIMARY KEY (`id_record`),
  INDEX `fk_record_user1_idx` (`user_id_user` ASC),
  CONSTRAINT `fk_record_user1`
    FOREIGN KEY (`user_id_user`)
    REFERENCES `korporativ_portal`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korporativ_portal`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`comment` (
  `id_comment` INT NOT NULL,
  `content` VARCHAR(1000) NOT NULL,
  `record_id_record` INT NOT NULL,
  `date` DATETIME NULL DEFAULT NOW(),
  PRIMARY KEY (`id_comment`),
  INDEX `fk_comment_record1_idx` (`record_id_record` ASC),
  CONSTRAINT `fk_comment_record1`
    FOREIGN KEY (`record_id_record`)
    REFERENCES `korporativ_portal`.`record` (`id_record`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korporativ_portal`.`like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`like` (
  `record_id_record` INT NOT NULL,
  `date` DATETIME NULL DEFAULT NOW(),
  `user_id_user` INT NOT NULL,
  `comment_id_comment` INT NOT NULL,
  PRIMARY KEY (`record_id_record`, `user_id_user`),
  INDEX `fk_like_record1_idx` (`record_id_record` ASC),
  INDEX `fk_like_user1_idx` (`user_id_user` ASC),
  INDEX `fk_like_comment1_idx` (`comment_id_comment` ASC),
  CONSTRAINT `fk_like_record1`
    FOREIGN KEY (`record_id_record`)
    REFERENCES `korporativ_portal`.`record` (`id_record`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_like_user1`
    FOREIGN KEY (`user_id_user`)
    REFERENCES `korporativ_portal`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_like_comment1`
    FOREIGN KEY (`comment_id_comment`)
    REFERENCES `korporativ_portal`.`comment` (`id_comment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korporativ_portal`.`calendar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`calendar` (
  `id_calendar` INT NOT NULL AUTO_INCREMENT,
  `week` INT(2) NOT NULL,
  `quartal` INT(1) NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id_calendar`),
  UNIQUE INDEX `id_time_UNIQUE` (`id_calendar` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korporativ_portal`.`type_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`type_task` (
  `id_type_task` INT NOT NULL AUTO_INCREMENT,
  `name_type_task` VARCHAR(45) NOT NULL,
  `complication` FLOAT NOT NULL,
  PRIMARY KEY (`id_type_task`),
  UNIQUE INDEX `id_type_task_UNIQUE` (`id_type_task` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korporativ_portal`.`task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`task` (
  `id_task` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NULL,
  `id_data_begin` INT NOT NULL,
  `id_data_end` INT NOT NULL,
  `id_type_task` INT NOT NULL,
  `current` TINYINT(1) NULL,
  PRIMARY KEY (`id_task`),
  UNIQUE INDEX `id_task_UNIQUE` (`id_task` ASC),
  INDEX `fk_task_time1_idx` (`id_data_begin` ASC),
  INDEX `fk_task_time2_idx` (`id_data_end` ASC),
  INDEX `fk_task_type_task1_idx` (`id_type_task` ASC),
  CONSTRAINT `fk_task_time1`
    FOREIGN KEY (`id_data_begin`)
    REFERENCES `korporativ_portal`.`calendar` (`id_calendar`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_task_time2`
    FOREIGN KEY (`id_data_end`)
    REFERENCES `korporativ_portal`.`calendar` (`id_calendar`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_task_type_task1`
    FOREIGN KEY (`id_type_task`)
    REFERENCES `korporativ_portal`.`type_task` (`id_type_task`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korporativ_portal`.`task_has_person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`task_has_person` (
  `id_task` INT NOT NULL,
  `id_person` INT NOT NULL,
  PRIMARY KEY (`id_task`, `id_person`),
  INDEX `fk_task_has_person_person1_idx` (`id_person` ASC),
  INDEX `fk_task_has_person_task1_idx` (`id_task` ASC),
  CONSTRAINT `fk_task_has_person_task1`
    FOREIGN KEY (`id_task`)
    REFERENCES `korporativ_portal`.`task` (`id_task`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_task_has_person_person1`
    FOREIGN KEY (`id_person`)
    REFERENCES `korporativ_portal`.`person` (`id_person`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korporativ_portal`.`message_receiver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `korporativ_portal`.`message_receiver` (
  `id_message` INT NOT NULL,
  `id_user_receiver` INT NOT NULL,
  PRIMARY KEY (`id_message`, `id_user_receiver`),
  INDEX `fk_message_has_user_user1_idx` (`id_user_receiver` ASC),
  INDEX `fk_message_has_user_message1_idx` (`id_message` ASC),
  CONSTRAINT `fk_message_has_user_message1`
    FOREIGN KEY (`id_message`)
    REFERENCES `korporativ_portal`.`message` (`id_message`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_message_has_user_user1`
    FOREIGN KEY (`id_user_receiver`)
    REFERENCES `korporativ_portal`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
