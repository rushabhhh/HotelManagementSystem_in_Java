-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2024 at 01:05 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `roombookings`
--

CREATE TABLE `roombookings` (
  `guestname` varchar(20) NOT NULL,
  `checkin` date NOT NULL,
  `checkout` date NOT NULL,
  `roomtype` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roombookings`
--

INSERT INTO `roombookings` (`guestname`, `checkin`, `checkout`, `roomtype`) VALUES
('Admin', '2023-11-16', '2023-11-17', 'Dorm'),
('Admin', '2023-11-23', '2023-11-27', 'Dorm'),
('Admin', '2024-01-05', '2024-01-06', 'Normal'),
('Admin', '2024-01-12', '2024-01-13', 'Deluxe'),
('Admin', '2024-01-05', '2024-01-06', 'Dorm'),
('Admin', '2024-01-05', '2024-01-06', 'Dorm'),
('Admin', '2024-01-05', '2024-01-06', 'Dorm'),
('Admin', '2024-01-05', '2024-01-06', 'Dorm'),
('Admin', '2024-01-12', '2024-01-13', 'Dorm'),
('Admin', '2024-01-12', '2024-01-13', 'Deluxe');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `roomtype` varchar(10) NOT NULL,
  `status` int(11) NOT NULL,
  `checkout` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`roomtype`, `status`, `checkout`) VALUES
('normal', 0, '2024-01-06'),
('ac', 1, NULL),
('deluxe', 0, '2024-01-13'),
('dorm', 0, '2024-01-13');

-- --------------------------------------------------------

--
-- Table structure for table `userdata`
--

CREATE TABLE `userdata` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `blisscoin` int(11) NOT NULL DEFAULT 0,
  `pin` int(3) NOT NULL DEFAULT 123,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userdata`
--

INSERT INTO `userdata` (`username`, `password`, `blisscoin`, `pin`, `email`) VALUES
('Admin', '12', 16337, 0, 'admin@bliss.com');

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`root`@`localhost` EVENT `UpdateRoomAvailability` ON SCHEDULE EVERY 1 DAY STARTS '2023-10-01 21:44:00' ENDS '2028-10-31 21:40:09' ON COMPLETION NOT PRESERVE ENABLE DO BEGIN
    -- Update rooms from unavailable to available when sysdate = checkoutdate
    UPDATE rooms
    SET status = '1', checkout = NULL
    WHERE status = '0' AND CURDATE() >= checkout;
END$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
