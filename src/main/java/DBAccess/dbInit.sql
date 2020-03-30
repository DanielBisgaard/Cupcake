-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile


CREATE DATABASE  IF NOT EXISTS `OlskerCupCakes`;


USE `OlskerCupcakes`;


DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(90) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Role` varchar(20) NOT NULL DEFAULT 'Customer',
  `Credit` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

LOCK TABLES `Users` WRITE;
INSERT INTO `Users` VALUES
(1,'arbejd@cup.dk','cupcake','Employee', 0),
(2,'kagespiser3000@hotmail.com','eatsleeprepeat','Customer', 3257),
(3,'jegerenged@gmail.com','fedged','Customer',27);
UNLOCK TABLES;


DROP TABLE IF EXISTS `Orders`;
CREATE TABLE `Orders` (
  `OrderID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `PaidTime` datetime,
  PRIMARY KEY (`OrderID`),
  FOREIGN KEY (UserID) REFERENCES Users(UserID)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

LOCK TABLES `Orders` WRITE;
INSERT INTO `Orders` VALUES

UNLOCK TABLES;


DROP TABLE IF EXISTS `Top`;
CREATE TABLE `Top` (
  `TopID` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `Ingredient` varchar(90) NOT NULL,
  PRIMARY KEY (`TopID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Top` WRITE;
INSERT INTO `Top` VALUES
(1, 5,'Chocolate'),
(2, 5,'Blueberry'),
(3, 5,'Rasberry'),
(4, 6,'Crispy'),
(5, 6,'Strawberry'),
(6, 7,'Rum/Raisin'),
(7, 8,'Orange'),
(8, 8,'Lemon'),
(9, 9,'Blue cheese');
UNLOCK TABLES;


DROP TABLE IF EXISTS `Bot`;
CREATE TABLE `Bot` (
  `BotID` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `Ingredient` varchar(90) NOT NULL,
  PRIMARY KEY (`BotID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Bot` WRITE;
INSERT INTO `Bot` VALUES
(1,5,'Chocolate'),
(2,5,'Vanilla'),
(3,5,'Nutmeg'),
(4,6,'Pistacio'),
(5,6,'Almond');
UNLOCK TABLES;

DROP TABLE IF EXISTS `Product`;
CREATE TABLE `Product` (
  `ProductID` int(11) NOT NULL AUTO_INCREMENT,
  `TopID` int(11) NOT NULL,
  `BotID` int(11) NOT NULL,
  PRIMARY KEY (`ProductID`),
  FOREIGN KEY (TopID) REFERENCES Top(TopID),
  FOREIGN KEY (BotID) REFERENCES Bot(BotID)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

LOCK TABLES `Product` WRITE;
INSERT INTO `Product` VALUES

UNLOCK TABLES;


DROP TABLE IF EXISTS `OrderProductLink`;
CREATE TABLE `OrderProductLink` (
  `OrderLineID` int(11) NOT NULL AUTO_INCREMENT,
  `OrderID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `Count` int(11) NOT NULL,
  PRIMARY KEY (`OrderLineID`),
  FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
  FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

LOCK TABLES `OrderProductLink` WRITE;
INSERT INTO `OrderProductLink` VALUES

UNLOCK TABLES;

