CREATE DATABASE `tictactoe`;
use tictactoe;
CREATE TABLE `player` (
  `user_name` varchar(45) NOT NULL,
  `player_id` int NOT NULL AUTO_INCREMENT,
  `status` int NOT NULL,
  `score` int DEFAULT '0',
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`user_name`),
  UNIQUE KEY `player_id_UNIQUE` (`player_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `game` (
  `game_id` int NOT NULL AUTO_INCREMENT,
  `player1_username` varchar(45) NOT NULL,
  `player2_username` varchar(45) NOT NULL,
  `cell_0` int DEFAULT NULL,
  `cell_1` int DEFAULT NULL,
  `cell_2` int DEFAULT NULL,
  `cell_3` int DEFAULT NULL,
  `cell_4` int DEFAULT NULL,
  `cell_5` int DEFAULT NULL,
  `cell_6` int DEFAULT NULL,
  `cell_7` int DEFAULT NULL,
  `cell_8` int DEFAULT NULL,
  `winner` varchar(45) NOT NULL,
  `game_date` timestamp NOT NULL,
  PRIMARY KEY (`game_id`),
  KEY `player1_username_idx` (`player1_username`),
  KEY `player2_username_idx` (`player2_username`),
  CONSTRAINT `player1_username` FOREIGN KEY (`player1_username`) REFERENCES `player` (`user_name`),
  CONSTRAINT `player2_username` FOREIGN KEY (`player2_username`) REFERENCES `player` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
