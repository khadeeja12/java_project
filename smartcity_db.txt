-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 25, 2024 at 06:03 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smartcity_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `entity`
--

DROP TABLE IF EXISTS `entity`;
CREATE TABLE IF NOT EXISTS `entity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `entity_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `entity`
--

INSERT INTO `entity` (`id`, `entity_name`) VALUES
(1, 'hotel'),
(3, 'Transporatation'),
(4, 'Resorts'),
(5, 'Toursists spots');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `usertype` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`, `usertype`) VALUES
(1, 'admin', 'admin', 'admin'),
(2, 'merin1', 'merin11', 'customer'),
(3, 'tom', 'jerry', 'customer');

-- --------------------------------------------------------

--
-- Table structure for table `places`
--

DROP TABLE IF EXISTS `places`;
CREATE TABLE IF NOT EXISTS `places` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(20) NOT NULL,
  `area_desc` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `places`
--

INSERT INTO `places` (`id`, `area`, `area_desc`) VALUES
(3, 'Munnar', 'Serene beauty'),
(2, 'Alapuzha', 'Nature beauty'),
(1, 'Kochi', 'A Beautiful place');

-- --------------------------------------------------------

--
-- Table structure for table `spot`
--

DROP TABLE IF EXISTS `spot`;
CREATE TABLE IF NOT EXISTS `spot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `placeid` int(11) NOT NULL,
  `entityid` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(70) NOT NULL,
  `rating` varchar(10) NOT NULL,
  `timing` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `placeid` (`placeid`),
  KEY `entityid` (`entityid`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spot`
--

INSERT INTO `spot` (`id`, `placeid`, `entityid`, `name`, `address`, `rating`, `timing`) VALUES
(5, 1, 5, 'LulU mall', 'edapally', '4.5', '10 am to 11 pm'),
(6, 1, 5, 'Hill palace', 'thripunithara', '3', '10 am to 5 pm'),
(7, 1, 3, 'KOCHI METRO', 'ALUVA TO SN', '4.5', '6.30 am to 11 pm'),
(8, 2, 5, 'Kumarakom House Boats', 'Alapuzha Kumarakom', '4', '10 am to 5 pm'),
(9, 3, 3, 'KSRTC BUS', 'ALUVA TO MUNNAR', '2.5', '6.30 am');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
