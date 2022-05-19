-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2022 at 06:10 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `barber`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblantri`
--

CREATE TABLE `tblantri` (
  `nomorAntri` int(11) NOT NULL,
  `namaCustomer` varchar(255) NOT NULL,
  `nomorTelpon` bigint(12) NOT NULL,
  `tanggalBook` varchar(255) NOT NULL,
  `waktuBook` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblantri`
--

INSERT INTO `tblantri` (`nomorAntri`, `namaCustomer`, `nomorTelpon`, `tanggalBook`, `waktuBook`) VALUES
(1, 'Bambang', 987899878, '05-05-2022', '12:45'),
(2, 'Syuer', 987879878, '05-05-2022', '13:54'),
(3, 'Asep', 987779878, '05-05-2022', '14:12'),
(4, 'Goen', 967779878, '05-05-2022', '14:45');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblantri`
--
ALTER TABLE `tblantri`
  ADD PRIMARY KEY (`nomorAntri`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tblantri`
--
ALTER TABLE `tblantri`
  MODIFY `nomorAntri` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
