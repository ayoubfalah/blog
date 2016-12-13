DROP SCHEMA IF EXISTS `BLOG`;
CREATE SCHEMA `BLOG`;
USE `BLOG`;

DROP TABLE IF EXISTS `POST`;
CREATE TABLE `POST`
(
    `Id`           INT          AUTO_INCREMENT,
    `Title`        VARCHAR(100) NOT NULL,
    `Description`  TEXT         NOT NULL,
    
    PRIMARY KEY (`Id`)
);

DROP TABLE IF EXISTS `COMMENT`;
CREATE TABLE `COMMENT`
(
    `Id`       INT AUTO_INCREMENT,
    `Post_Id`  INT,
    `Body`     TEXT,

    PRIMARY KEY (`Id`),
    FOREIGN KEY (`Post_Id`) REFERENCES `POST`(`Id`)
);