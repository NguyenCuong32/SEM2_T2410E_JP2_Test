-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 24, 2025 at 02:37 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `herogame`
--

-- --------------------------------------------------------

--
-- Table structure for table `national`
--

CREATE TABLE `national` (
  `national_id` int(11) NOT NULL,
  `national_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `national`
--

INSERT INTO `national` (`national_id`, `national_name`) VALUES
(5, 'Canada'),
(3, 'Japan'),
(4, 'Korea'),
(2, 'USA'),
(1, 'Vietnam');

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `player_id` int(11) NOT NULL,
  `player_name` varchar(255) NOT NULL,
  `high_score` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `national_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`player_id`, `player_name`, `high_score`, `level`, `national_id`) VALUES
(1, 'Player 1', 100, 2, 1),
(2, 'Player 2', 1050, 10, 2),
(4, 'TopScorer', 5000, 25, 2),
(5, 'toan 1', 150, 3, 1),
(6, 'toan 2', 250, 5, 2),
(7, 'toan 3', 350, 7, 3),
(8, 'toan 4', 450, 9, 4),
(9, 'toan 5', 550, 11, 5),
(10, 'toan 6', 650, 13, 1),
(11, 'toan 7', 750, 15, 2),
(12, 'toan 8', 850, 17, 3),
(13, 'toan 9', 950, 19, 4),
(14, 'toan 10', 1150, 21, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `national`
--
ALTER TABLE `national`
  ADD PRIMARY KEY (`national_id`),
  ADD UNIQUE KEY `national_name_UNIQUE` (`national_name`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`player_id`),
  ADD KEY `fk_Player_National_idx` (`national_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `national`
--
ALTER TABLE `national`
  MODIFY `national_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `player_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `fk_Player_National` FOREIGN KEY (`national_id`) REFERENCES `national` (`national_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
