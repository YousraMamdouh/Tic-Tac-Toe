create database tictactoe;
use tictactoe;

CREATE TABLE `game` (
  `game_id` int NOT NULL AUTO_INCREMENT,
  `player1_id` int NOT NULL,
  `player2_id` int NOT NULL,
  `cell_zero` float DEFAULT NULL,
  `cell_1` float DEFAULT NULL,
  `cell_2` float DEFAULT NULL,
  `cell_3` float DEFAULT NULL,
  `cell_4` float DEFAULT NULL,
  `cell_5` float DEFAULT NULL,
  `cell_6` float DEFAULT NULL,
  `cell_7` float DEFAULT NULL,
  `cell_8` float DEFAULT NULL,
  `winner` int DEFAULT NULL,
  `game_date` timestamp NOT NULL,
  PRIMARY KEY (`game_id`),
  KEY `player1_id_idx` (`player1_id`),
  KEY `player2_id_idx` (`player2_id`),
  CONSTRAINT `player1_id` FOREIGN KEY (`player1_id`) REFERENCES `player` (`player_id`),
  CONSTRAINT `player2_id` FOREIGN KEY (`player2_id`) REFERENCES `player` (`player_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `player` (
  `player_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `full_name` varchar(45) DEFAULT NULL,
  `score` int DEFAULT '0',
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`player_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
