# class registration

1. CREATE USER 'classregistration'@'localhost' IDENTIFIED BY 'classregistration';
2. GRANT ALL PRIVILEGES ON * . * TO 'classregistration'@'localhost';
3. CREATE DATABASE registrationdb;


CREATE TABLE `student` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `redId` int(11) NOT NULL unique,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
 `email` varchar(255) DEFAULT NULL unique,
  PRIMARY KEY (`studentId`)
)