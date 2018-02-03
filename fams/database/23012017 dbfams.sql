-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.19-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for dbfams
DROP DATABASE IF EXISTS `dbfams`;
CREATE DATABASE IF NOT EXISTS `dbfams` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dbfams`;

-- Dumping structure for table dbfams.brand
DROP TABLE IF EXISTS `brand`;
CREATE TABLE IF NOT EXISTS `brand` (
  `idBrand` int(2) NOT NULL AUTO_INCREMENT,
  `brand` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idBrand`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table dbfams.brand: ~6 rows (approximately)
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` (`idBrand`, `brand`) VALUES
	(1, 'HP'),
	(2, 'Acer'),
	(3, 'Toshiba'),
	(4, 'Lenovo'),
	(5, 'Sony'),
	(6, 'IBM');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;

-- Dumping structure for table dbfams.classification
DROP TABLE IF EXISTS `classification`;
CREATE TABLE IF NOT EXISTS `classification` (
  `idClass` int(30) NOT NULL AUTO_INCREMENT,
  `classification` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idClass`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table dbfams.classification: ~2 rows (approximately)
/*!40000 ALTER TABLE `classification` DISABLE KEYS */;
INSERT INTO `classification` (`idClass`, `classification`) VALUES
	(1, 'Computer Equipment'),
	(2, 'Software');
/*!40000 ALTER TABLE `classification` ENABLE KEYS */;

-- Dumping structure for table dbfams.department
DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `idDept` int(2) NOT NULL AUTO_INCREMENT,
  `department` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idDept`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table dbfams.department: ~7 rows (approximately)
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`idDept`, `department`) VALUES
	(1, 'CIT'),
	(2, 'Accounting'),
	(3, 'MIS'),
	(4, 'Administration'),
	(5, 'Sales'),
	(6, 'Engineering'),
	(7, 'Marketing');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

-- Dumping structure for table dbfams.employee
DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `idEmp` int(5) NOT NULL AUTO_INCREMENT,
  `fName` varchar(25) DEFAULT NULL,
  `midInit` varchar(1) DEFAULT NULL,
  `lName` varchar(25) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `contactNo` varchar(12) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `idDept` int(3) DEFAULT NULL,
  `idPosn` int(3) DEFAULT NULL,
  PRIMARY KEY (`idEmp`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table dbfams.employee: ~5 rows (approximately)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`idEmp`, `fName`, `midInit`, `lName`, `gender`, `email`, `contactNo`, `address`, `idDept`, `idPosn`) VALUES
	(1, 'Ann', 'M', 'Deloso', 'Female', 'anndeloso@gmail.com', '1111111', 'Auckland', 1, 1),
	(2, 'Juan', 'D', 'Dela Cruz', 'Male', 'juan@gmail.com', '11111', 'Auckalnd', 1, 2),
	(3, 'Kermits', NULL, 'Kier', 'Male', 'kier@gmail.com', '4536545646', 'Auckland, NZ', 2, 1),
	(4, 'Juana', NULL, 'Sanchez', 'Female', 'jsanchez@gmail.com', '022654795', 'Auckland, NZ', 4, 4),
	(5, 'Mary', NULL, 'Chua', 'Female', 'mchua@gmail.com', '02335847', 'Auckland, NZ', 5, 3);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping structure for table dbfams.fixedasset_tmp
DROP TABLE IF EXISTS `fixedasset_tmp`;
CREATE TABLE IF NOT EXISTS `fixedasset_tmp` (
  `idfa` int(3) NOT NULL AUTO_INCREMENT,
  `faCode` varchar(10) DEFAULT NULL,
  `dateAdded` date DEFAULT NULL,
  `product` varchar(50) DEFAULT NULL,
  `idClass` int(3) DEFAULT NULL,
  `idBrand` int(3) DEFAULT NULL,
  `manufacturer` varchar(50) DEFAULT NULL,
  `license` varchar(50) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `serialNo` varchar(20) DEFAULT NULL,
  `barcode` varchar(20) DEFAULT NULL,
  `cost` double(12,2) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `idSupplier` int(3) DEFAULT NULL,
  `currLoc` int(3) DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  `rcptInfo` varchar(50) DEFAULT NULL,
  `assetLife` int(2) DEFAULT NULL,
  `salvageVal` double(12,2) DEFAULT NULL,
  `datePurchase` date DEFAULT NULL,
  `dateWarranty` date DEFAULT NULL,
  `idRcv` int(3) DEFAULT NULL,
  PRIMARY KEY (`idfa`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Dumping data for table dbfams.fixedasset_tmp: ~4 rows (approximately)
/*!40000 ALTER TABLE `fixedasset_tmp` DISABLE KEYS */;
INSERT INTO `fixedasset_tmp` (`idfa`, `faCode`, `dateAdded`, `product`, `idClass`, `idBrand`, `manufacturer`, `license`, `model`, `serialNo`, `barcode`, `cost`, `description`, `idSupplier`, `currLoc`, `dateUpdated`, `rcptInfo`, `assetLife`, `salvageVal`, `datePurchase`, `dateWarranty`, `idRcv`) VALUES
	(1, 'FA-1', '2017-01-22', 'IBM Power 770 server', 1, 6, 'IBM', 'JHHFG67765', 'IBM Power 770 server', '012251', '78899', 10000.00, '1tb memory, 12x4.2GHz', 0, 4, '2017-01-22', '', 4, 2000.00, '2017-01-12', NULL, 1),
	(2, 'FA-2', '2017-01-22', 'Toshiba Laptop', 1, 3, 'Toshiba', '', 'T1000', '665582', '0228463', 2000.00, 'intel corei5, 8gb memory', 1, 2, '2017-01-22', '', 2, 800.00, '2017-01-10', '2018-01-10', 2),
	(3, 'FA-3', '2017-01-22', 'Lenovo Laptop', 1, 4, 'Lenovo', '', 'ideapad 10000', '3520005255', '002252362', 2500.00, 'intel core i5, 8gb memory', 1, 2, '2017-01-22', '', 2, 800.00, '2017-01-10', '2018-01-10', 2),
	(4, 'FA-4', '2017-01-23', 'Toshiba Notebook', 1, 3, 'Toshiba', '', 'Satellite Pro R50-C', '012025560', '234558599', 1500.00, 'Part Number - PS571A-01H00W', 1, 4, '2017-01-23', '', 2, 800.00, '2017-01-20', '2018-01-20', 3);
/*!40000 ALTER TABLE `fixedasset_tmp` ENABLE KEYS */;

-- Dumping structure for table dbfams.logs
DROP TABLE IF EXISTS `logs`;
CREATE TABLE IF NOT EXISTS `logs` (
  `idLogs` int(10) NOT NULL AUTO_INCREMENT,
  `idUser` int(10) DEFAULT NULL,
  `dateLog` date DEFAULT NULL,
  `ipAdd` varchar(20) DEFAULT NULL,
  `pcName` varchar(20) DEFAULT NULL,
  `trans` varchar(10) DEFAULT NULL,
  `transNo` int(10) DEFAULT NULL,
  `transFcn` varchar(10) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idLogs`)
) ENGINE=InnoDB AUTO_INCREMENT=283 DEFAULT CHARSET=latin1;

-- Dumping data for table dbfams.logs: ~281 rows (approximately)
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
INSERT INTO `logs` (`idLogs`, `idUser`, `dateLog`, `ipAdd`, `pcName`, `trans`, `transNo`, `transFcn`, `remarks`, `status`) VALUES
	(2, 1, '2016-12-09', '192.168.1.65', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, '0', 'login'),
	(3, 1, '2016-12-09', '192.168.1.65', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, '0', 'login'),
	(4, 1, '2016-12-09', '192.168.1.65', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, '0', 'login'),
	(5, 1, '2016-12-09', '192.168.1.65', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, '0', 'login'),
	(6, 1, '2016-12-09', '192.168.1.65', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, '0', 'login'),
	(7, 1, '2016-12-09', '192.168.1.65', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, '0', 'login'),
	(8, 1, '2016-12-09', '192.168.1.65', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, '0', 'login'),
	(9, 1, '2016-12-09', '192.168.1.65', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, '0', 'login'),
	(10, 1, '2016-12-09', 'null', 'null', 'login', NULL, NULL, '0', 'login'),
	(11, 1, '2016-12-09', '192.168.1.65', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, '0', 'login'),
	(12, 1, '2016-12-09', '192.168.1.65', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, '0', 'login'),
	(13, 0, '2016-12-11', '192.168.1.66', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, '0', 'new'),
	(14, 1001, '2016-12-11', '192.168.1.66', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(15, 0, '2016-12-11', '192.168.1.66', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(16, 0, '2016-12-11', '192.168.1.66', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(17, 0, '2016-12-11', '192.168.1.66', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(18, 0, '2016-12-13', '192.168.1.66', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(19, 0, '2016-12-13', '192.168.1.66', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(20, 0, '2016-12-13', '192.168.1.66', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(21, 0, '2016-12-13', '192.168.1.66', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(22, 0, '2016-12-13', '192.168.1.66', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(23, 0, '2016-12-14', '192.168.1.66', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(24, 1001, '2017-01-03', 'null', 'null', 'login', NULL, NULL, NULL, 'new'),
	(25, 0, '2017-01-03', 'null', 'null', 'login', NULL, NULL, NULL, 'new'),
	(26, 0, '2017-01-03', 'null', 'null', 'login', NULL, NULL, NULL, 'new'),
	(27, 0, '2017-01-03', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(28, 0, '2017-01-03', 'null', 'null', 'login', NULL, NULL, NULL, 'new'),
	(29, 1001, '2017-01-03', 'null', 'null', 'login', NULL, NULL, NULL, 'new'),
	(30, 1001, '2017-01-03', 'null', 'null', 'login', NULL, NULL, NULL, 'new'),
	(31, 1001, '2017-01-03', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(32, 1001, '2017-01-04', '192.168.1.6', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(33, 1001, '2017-01-04', '192.168.1.6', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(34, 1001, '2017-01-04', '192.168.1.6', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(35, 1001, '2017-01-05', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(36, 1001, '2017-01-05', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(37, 1001, '2017-01-05', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(38, 1001, '2017-01-05', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(39, 1001, '2017-01-05', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(40, 1001, '2017-01-05', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(41, 1001, '2017-01-05', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(42, 1001, '2017-01-05', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(43, 1001, '2017-01-05', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(44, 1001, '2017-01-05', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(45, 1001, '2017-01-05', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(46, 1001, '2017-01-06', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(47, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(48, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(49, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(50, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(51, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(52, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(53, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(54, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(55, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(56, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(57, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(58, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(59, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(60, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(61, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(62, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(63, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(64, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(65, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(66, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(67, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(68, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(69, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(70, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(71, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(72, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(73, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(74, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(75, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(76, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(77, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(78, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(79, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(80, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(81, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(82, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(83, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(84, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(85, 1001, '2017-01-07', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(86, 1001, '2017-01-10', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(87, 1001, '2017-01-10', '192.168.1.71', 'DESKTOP-5QNHC3G', 'login', NULL, NULL, NULL, 'new'),
	(88, 1001, '2017-01-10', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', 0, 'INSERT', NULL, 'NEW'),
	(89, 1001, '2017-01-10', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(90, 1001, '2017-01-10', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(91, 1001, '2017-01-10', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(92, 1001, '2017-01-10', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(93, 1001, '2017-01-12', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(94, 1001, '2017-01-12', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(95, 1001, '2017-01-12', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(96, 1001, '2017-01-12', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(97, 1001, '2017-01-12', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(98, 1001, '2017-01-12', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(99, 1001, '2017-01-12', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(100, 1001, '2017-01-13', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(101, 1001, '2017-01-13', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(102, 1001, '2017-01-13', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(103, 1001, '2017-01-13', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(104, 1001, '2017-01-13', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(105, 1001, '2017-01-13', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(106, 1001, '2017-01-13', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(107, 1001, '2017-01-13', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(108, 1001, '2017-01-13', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(109, 1001, '2017-01-13', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(110, 1001, '2017-01-13', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(111, 1001, '2017-01-13', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(112, 1001, '2017-01-14', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(113, 1001, '2017-01-14', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(114, 1001, '2017-01-14', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(115, 1001, '2017-01-15', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(116, 1001, '2017-01-15', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(117, 1001, '2017-01-15', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(118, 1001, '2017-01-15', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(119, 1001, '2017-01-15', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(120, 1001, '2017-01-15', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(121, 1001, '2017-01-15', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(122, 1001, '2017-01-15', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(123, 1001, '2017-01-16', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(124, 1001, '2017-01-16', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(125, 1001, '2017-01-16', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(126, 1001, '2017-01-16', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(127, 1001, '2017-01-16', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(128, 1001, '2017-01-16', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(129, 1001, '2017-01-16', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(130, 1001, '2017-01-16', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(131, 1001, '2017-01-16', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(132, 1001, '2017-01-17', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(133, 1001, '2017-01-17', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(134, 1001, '2017-01-17', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(135, 1001, '2017-01-17', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(136, 1001, '2017-01-17', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(137, 1001, '2017-01-17', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(138, 1001, '2017-01-17', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(139, 1001, '2017-01-17', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(140, 1001, '2017-01-17', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(141, 1001, '2017-01-17', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(142, 1001, '2017-01-17', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(143, 1001, '2017-01-17', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(144, 1001, '2017-01-17', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(145, 1001, '2017-01-20', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(146, 1001, '2017-01-20', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(147, 1001, '2017-01-20', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(148, 1001, '2017-01-20', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(149, 1001, '2017-01-20', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(150, 1001, '2017-01-20', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(151, 1001, '2017-01-20', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(152, 1001, '2017-01-20', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(153, 1001, '2017-01-20', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(154, 1001, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(155, 1001, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(156, 1001, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(157, 1001, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(158, 1001, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(159, 1001, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(160, 1001, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(161, 1001, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(162, 1001, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(163, 1001, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(164, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(165, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(166, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(167, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(168, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(169, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(170, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(171, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(172, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(173, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(174, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(175, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(176, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(177, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(178, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(179, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(180, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(181, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(182, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(183, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(184, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(185, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(186, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(187, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(188, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(189, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(190, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(191, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(192, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(193, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(194, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(195, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(196, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(197, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(198, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(199, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(200, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(201, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(202, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(203, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(204, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(205, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(206, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(207, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(208, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(209, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(210, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(211, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(212, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(213, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(214, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(215, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(216, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(217, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(218, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(219, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(220, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(221, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(222, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(223, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(224, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(225, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(226, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(227, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(228, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(229, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(230, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(231, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(232, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(233, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(234, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(235, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(236, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(237, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(238, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(239, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(240, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(241, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(242, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(243, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(244, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(245, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(246, 0, '2017-01-21', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(247, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(248, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(249, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(250, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(251, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(252, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(253, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(254, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(255, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(256, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(257, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(258, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(259, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(260, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(261, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(262, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(263, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(264, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(265, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(266, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(267, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(268, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(269, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(270, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(271, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(272, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(273, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(274, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(275, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(276, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(277, 0, '2017-01-22', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(278, 0, '2017-01-23', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(279, 0, '2017-01-23', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(280, 0, '2017-01-23', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(281, 0, '2017-01-23', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW'),
	(282, 0, '2017-01-23', '192.168.1.71', 'DESKTOP-5QNHC3G', 'LOGIN', NULL, 'INSERT', NULL, 'NEW');
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;

-- Dumping structure for table dbfams.maintenance
DROP TABLE IF EXISTS `maintenance`;
CREATE TABLE IF NOT EXISTS `maintenance` (
  `idMntn` int(3) NOT NULL AUTO_INCREMENT,
  `mntnNo` varchar(10) DEFAULT NULL,
  `idTrnsctn` int(3) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `details` varchar(1000) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  `rtrndBy` int(3) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`idMntn`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table dbfams.maintenance: ~3 rows (approximately)
/*!40000 ALTER TABLE `maintenance` DISABLE KEYS */;
INSERT INTO `maintenance` (`idMntn`, `mntnNo`, `idTrnsctn`, `startDate`, `endDate`, `details`, `status`, `rtrndBy`, `remarks`) VALUES
	(1, 'MX-1', 6, '2017-01-15', '2017-01-16', 'reformat', 'on-progress', 1, 'done - returned'),
	(2, 'MX-2', 7, '2017-01-20', '2017-01-21', 'reformat', 'maintenance ', 4, 'fixed'),
	(3, 'MX-3', 12, '2017-01-23', '2017-01-23', 'reformat', 'maintenance ', 3, 'done ');
/*!40000 ALTER TABLE `maintenance` ENABLE KEYS */;

-- Dumping structure for table dbfams.position
DROP TABLE IF EXISTS `position`;
CREATE TABLE IF NOT EXISTS `position` (
  `idPosn` int(2) NOT NULL AUTO_INCREMENT,
  `position` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idPosn`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table dbfams.position: ~4 rows (approximately)
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` (`idPosn`, `position`) VALUES
	(1, 'Office Clerk'),
	(2, 'kkjhj'),
	(3, 'Manager'),
	(4, 'Supervisor');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;

-- Dumping structure for table dbfams.privilege
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE IF NOT EXISTS `privilege` (
  `idPriv` int(11) NOT NULL AUTO_INCREMENT,
  `privilege` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idPriv`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table dbfams.privilege: ~0 rows (approximately)
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;

-- Dumping structure for table dbfams.pullout
DROP TABLE IF EXISTS `pullout`;
CREATE TABLE IF NOT EXISTS `pullout` (
  `idPo` int(3) NOT NULL AUTO_INCREMENT,
  `poNo` varchar(10) DEFAULT NULL,
  `iTrnsctn` int(3) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idPo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table dbfams.pullout: ~2 rows (approximately)
/*!40000 ALTER TABLE `pullout` DISABLE KEYS */;
INSERT INTO `pullout` (`idPo`, `poNo`, `iTrnsctn`, `remarks`, `status`) VALUES
	(1, 'PO-1', 8, '', 'sold'),
	(2, 'PO-2', 13, 'done', 'sold');
/*!40000 ALTER TABLE `pullout` ENABLE KEYS */;

-- Dumping structure for table dbfams.receiving
DROP TABLE IF EXISTS `receiving`;
CREATE TABLE IF NOT EXISTS `receiving` (
  `idRcv` int(3) NOT NULL AUTO_INCREMENT,
  `rcvNo` varchar(10) DEFAULT NULL,
  `idTrnsctn` int(3) DEFAULT NULL,
  PRIMARY KEY (`idRcv`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table dbfams.receiving: ~3 rows (approximately)
/*!40000 ALTER TABLE `receiving` DISABLE KEYS */;
INSERT INTO `receiving` (`idRcv`, `rcvNo`, `idTrnsctn`) VALUES
	(1, 'RCV-1', 5),
	(2, 'RCV-2', 9),
	(3, 'RCV-3', 10);
/*!40000 ALTER TABLE `receiving` ENABLE KEYS */;

-- Dumping structure for table dbfams.status
DROP TABLE IF EXISTS `status`;
CREATE TABLE IF NOT EXISTS `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table dbfams.status: ~1 rows (approximately)
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` (`id`, `status`) VALUES
	(1, 'brand new');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;

-- Dumping structure for table dbfams.supplier
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `idSupplier` int(11) NOT NULL AUTO_INCREMENT,
  `supplier` varchar(50) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `contactNo` varchar(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idSupplier`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table dbfams.supplier: ~4 rows (approximately)
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` (`idSupplier`, `supplier`, `address`, `contactNo`, `email`) VALUES
	(1, 'Noel Leeming', 'Queen street', '121212', 'noelleeming@gmail.com'),
	(2, 'PB Technologies', 'Queenstreet', '131313', 'pbtech@gmail.com'),
	(3, 'Fujitsu', 'Auckland', '025200', 'fujitso@gmail.com'),
	(4, 'Interpace', 'Auckland', '2520365', 'interpace@gmail.com');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;

-- Dumping structure for table dbfams.transaction
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE IF NOT EXISTS `transaction` (
  `idTrnsctn` int(3) NOT NULL AUTO_INCREMENT,
  `idFa` int(3) NOT NULL DEFAULT '0',
  `faCode` varchar(10) NOT NULL DEFAULT '0',
  `trnsctn` varchar(30) DEFAULT NULL,
  `trnsctnId` int(3) DEFAULT NULL,
  `trnsctnNo` varchar(10) DEFAULT NULL,
  `trnsctnDate` date DEFAULT NULL,
  `trnsctnBy` int(3) DEFAULT NULL,
  `location` int(3) DEFAULT NULL,
  `inCharge` int(3) DEFAULT NULL,
  `approvedBy` int(3) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idTrnsctn`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table dbfams.transaction: ~11 rows (approximately)
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` (`idTrnsctn`, `idFa`, `faCode`, `trnsctn`, `trnsctnId`, `trnsctnNo`, `trnsctnDate`, `trnsctnBy`, `location`, `inCharge`, `approvedBy`, `remarks`, `status`) VALUES
	(2, 1, 'FA-1', 'transfer', 1, 'TX-1', '2017-01-22', 1001, 3, 1, 5, 'Transfer', 'done'),
	(3, 2, 'FA-2', 'maintenance', 1, 'MX-1', '2017-01-22', 1001, 6, 1, 4, 'fixed', 'done'),
	(5, 0, '', 'receiving', 1, 'RCV-1', '2017-01-22', 1001, 4, 3, 0, 'done', 'Brand New'),
	(6, 1, 'FA-1', 'maintenance', 1, 'MX-1', '2017-01-22', 1001, 1, 3, 2, 'done - returned', 'done'),
	(7, 1, 'FA-1', 'maintenance', 2, 'MX-2', '2017-01-22', 1001, 4, 1, 3, 'fixed', 'done'),
	(8, 1, 'FA-1', 'pullout', 1, 'PO-1', '2017-01-22', 1001, 0, 1001, 3, '', 'done'),
	(9, 0, '', 'receiving', 2, 'RCV-2', '2017-01-22', 1001, 2, 3, 0, 'done ', 'Brand New'),
	(10, 0, '', 'receiving', 3, 'RCV-3', '2017-01-23', 1001, 4, 3, 0, 'done receive', 'Brand New'),
	(11, 4, 'FA-4', 'transfer', 2, 'TX-2', '2017-01-23', 1001, 4, 1, 1, 'new owner', 'done'),
	(12, 4, 'FA-4', 'maintenance', 3, 'MX-3', '2017-01-23', 1001, 4, 5, 2, 'done ', 'done'),
	(13, 4, 'FA-4', 'pullout', 2, 'PO-2', '2017-01-23', 1001, 0, 1001, 4, 'done', 'done');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;

-- Dumping structure for table dbfams.transfer
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE IF NOT EXISTS `transfer` (
  `idTrans` int(3) NOT NULL AUTO_INCREMENT,
  `transNo` varchar(10) DEFAULT NULL,
  `idTrnsctn` int(3) NOT NULL,
  PRIMARY KEY (`idTrans`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table dbfams.transfer: ~2 rows (approximately)
/*!40000 ALTER TABLE `transfer` DISABLE KEYS */;
INSERT INTO `transfer` (`idTrans`, `transNo`, `idTrnsctn`) VALUES
	(1, 'TX-1', 2),
	(2, 'TX-2', 11);
/*!40000 ALTER TABLE `transfer` ENABLE KEYS */;

-- Dumping structure for table dbfams.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `idEmp` int(10) DEFAULT NULL,
  `privilege` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table dbfams.user: ~1 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`idUser`, `username`, `password`, `idEmp`, `privilege`) VALUES
	(1, 'amd', 'passamd', 1001, '1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
