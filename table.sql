DROP DATABASE  IF EXISTS `spring_library`;

CREATE DATABASE  IF NOT EXISTS `spring_library`;
USE `spring_library`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: http://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `users` 
VALUES 
('firat','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
('sait','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
('tom','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('firat','ROLE_MEMBER'),
('sait','ROLE_MEMBER'),
('sait','ROLE_ADMIN'),
('tom','ROLE_ADMIN');


DROP TABLE IF EXISTS `publisher`;
CREATE TABLE `publisher` (
  `id` int(11) primary key AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `details` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `publisher` 
VALUES 
("1",'ithaki Yayinlari','Uzman Yayimci'),
("2",'Metis Yayinlari','Uzman Yayimci'),
("3",'Say  Yayinlari','Uzman Yayimci'),
("4",'Huseyin Firat','Caylak Yayimci');


DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` int(11) primary key AUTO_INCREMENT ,
  `name` varchar(50) NOT NULL,
  `details` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `author` 
VALUES 
("1",'Peyami Safa','Uzman Yazar'),
("2",'Sabahattin Ali','Uzman Yazar'),
("3",'Lev Tolstoy','Uzman Yazar'),
("4",'Huseyin Firat','Caylak Coder');


DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
 `id` int(11) primary key AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `subtitle` varchar(50) NOT NULL,
  `series_name` varchar(50) NOT NULL,
  `author_id` int(11),
  `publisher_id` int(11),
  `isbn` int(11) NOT NULL,
  `details` varchar(50) NOT NULL,
  UNIQUE KEY `author_idx_1` (`author_id`,`id`),
  UNIQUE KEY `publisher_idx_1` (`publisher_id`,`id`),
  CONSTRAINT `author_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  CONSTRAINT `publisher_ibfk_1` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `book` 
VALUES 
("1",'Otomatik Portokal','Modern Klasik','Ilk seri','1','4','11','Ornek'),
("2",'Beyaz Dis','Modern Klasik','2. Cilt','3','2','22','Ornek'),
("3",'Kürk Mantolu Madonna','Klasik','Efsane seri','2','2','33','Ornek'),
("4",'Tutunamayanlar','Tutunamayanlarin Klasigi','Bir Firat klasigi','4','4','44','Ornek');
