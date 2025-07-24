-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 24, 2025 at 02:55 PM
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
  `NationalId` int(11) NOT NULL,
  `NationalName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `national`
--

INSERT INTO `national` (`NationalId`, `NationalName`) VALUES
(5, 'Germany'),
(3, 'Japan'),
(4, 'Korea'),
(2, 'USA'),
(1, 'Vietnam');

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `PlayerId` int(11) NOT NULL,
  `NationalId` int(11) DEFAULT NULL,
  `PlayerName` varchar(255) NOT NULL,
  `HighScore` int(11) DEFAULT NULL,
  `Level` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`PlayerId`, `NationalId`, `PlayerName`, `HighScore`, `Level`) VALUES
(1, 1, 'Player 1', 100, 2),
(2, 2, 'Player 2', 1050, 10),
(3, 3, 'Player 3', 200, 5),
(4, 2, 'Player 4', 5000, 25),
(5, 4, 'Player 5', 3200, 18),
(6, 1, 'Player 6', 850, 8),
(7, 3, 'Player 7', 1500, 12),
(8, 5, 'Player 8', 7500, 30),
(9, 4, 'Player 9', 950, 9),
(10, 1, 'Player 10', 450, 6),
(11, 2, 'Player 11', 6000, 28),
(12, 2, 'TopGun', 9999, 50);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `national`
--
ALTER TABLE `national`
  ADD PRIMARY KEY (`NationalId`),
  ADD UNIQUE KEY `NationalName` (`NationalName`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`PlayerId`),
  ADD KEY `NationalId` (`NationalId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `national`
--
ALTER TABLE `national`
  MODIFY `NationalId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `PlayerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `player_ibfk_1` FOREIGN KEY (`NationalId`) REFERENCES `national` (`NationalId`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
