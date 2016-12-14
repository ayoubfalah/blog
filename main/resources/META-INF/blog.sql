-- -----------------------------------------------------
-- Schema BLOG
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BLOG` DEFAULT CHARACTER SET latin1 ;
USE `BLOG` ;

-- -----------------------------------------------------
-- Table `BLOG`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BLOG`.`USER` (
  `Id`    INT(11)     AUTO_INCREMENT,
  `Fname` VARCHAR(45) NOT NULL,
  `Lname` VARCHAR(45) NOT NULL,

  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BLOG`.`POST`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BLOG`.`POST` (
  `Id`    INT(11)      AUTO_INCREMENT,
  `Title` VARCHAR(100) NOT NULL,
  `Description` TEXT   NOT NULL,
  `User_Id` INT(11)    NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),

  FOREIGN KEY (`User_Id`)
    REFERENCES `BLOG`.`USER` (`Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BLOG`.`COMMENTS_ON`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BLOG`.`COMMENTS_ON` (
  `User_Id` INT(11) NOT NULL,
  `Post_Id` INT(11) NOT NULL,
  `Openion` TEXT NULL DEFAULT NULL,

  PRIMARY KEY (`User_Id`, `Post_Id`),
  FOREIGN KEY (`User_Id`)
    REFERENCES `BLOG`.`USER` (`Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (`Post_Id`)
    REFERENCES `BLOG`.`POST` (`Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;