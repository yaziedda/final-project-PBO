-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.21-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for fp_pbo
CREATE DATABASE IF NOT EXISTS `fp_pbo` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `fp_pbo`;


-- Dumping structure for table fp_pbo.app_user_data
CREATE TABLE IF NOT EXISTS `app_user_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `role` int(11) NOT NULL COMMENT '0 admin, 1 user, 2 manager',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `latest_login` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table fp_pbo.app_user_data: ~2 rows (approximately)
/*!40000 ALTER TABLE `app_user_data` DISABLE KEYS */;
INSERT INTO `app_user_data` (`id`, `nama`, `username`, `password`, `role`, `created_at`, `latest_login`) VALUES
	(1, 'Yazied DAA', 'admin', 'admin', 0, '2017-11-20 23:37:49', '2017-12-11 22:04:05'),
	(10, 'Yazied', '1187', '123123', 2, '2017-12-09 01:39:01', '2017-12-09 01:39:20');
/*!40000 ALTER TABLE `app_user_data` ENABLE KEYS */;


-- Dumping structure for table fp_pbo.app_user_regist
CREATE TABLE IF NOT EXISTS `app_user_regist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ktp` varchar(50) DEFAULT NULL,
  `nik` varchar(50) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `bagian` varchar(50) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ktp` (`ktp`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table fp_pbo.app_user_regist: ~2 rows (approximately)
/*!40000 ALTER TABLE `app_user_regist` DISABLE KEYS */;
INSERT INTO `app_user_regist` (`id`, `ktp`, `nik`, `nama`, `bagian`, `created_at`, `updated_at`) VALUES
	(1, 'qewq', 'qwe', 'qeq', 'qwe', '2017-12-11 23:17:02', '2017-12-11 23:17:02'),
	(2, '123', '111', 'qeq', 'qweqw', '2017-12-11 23:17:09', '2017-12-11 23:17:09');
/*!40000 ALTER TABLE `app_user_regist` ENABLE KEYS */;


-- Dumping structure for table fp_pbo.master_barang
CREATE TABLE IF NOT EXISTS `master_barang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

-- Dumping data for table fp_pbo.master_barang: ~2 rows (approximately)
/*!40000 ALTER TABLE `master_barang` DISABLE KEYS */;
INSERT INTO `master_barang` (`id`, `nama`, `qty`, `created_at`, `updated_at`) VALUES
	(26, 'Laptop Lenovo 14 inch', 40, '2017-12-09 00:22:31', '2017-12-13 02:45:44'),
	(27, 'Proyektor Infocus', 50, '2017-12-09 00:23:11', '2017-12-09 00:23:11');
/*!40000 ALTER TABLE `master_barang` ENABLE KEYS */;


-- Dumping structure for table fp_pbo.trx_pinjam
CREATE TABLE IF NOT EXISTS `trx_pinjam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `id_barang` int(11) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Dumping data for table fp_pbo.trx_pinjam: ~10 rows (approximately)
/*!40000 ALTER TABLE `trx_pinjam` DISABLE KEYS */;
INSERT INTO `trx_pinjam` (`id`, `id_user`, `id_barang`, `qty`, `status`, `created_at`, `updated_at`) VALUES
	(3, 2, 26, 1, 1, '2017-12-12 00:10:53', '2017-12-13 02:37:14'),
	(4, 2, 26, 1, 1, '2017-12-12 00:10:55', '2017-12-13 02:39:06'),
	(5, 2, 26, 1, 1, '2017-12-12 00:10:57', '2017-12-13 02:39:12'),
	(6, 2, 26, 1, 1, '2017-12-12 00:10:58', '2017-12-13 02:39:16'),
	(7, 2, 26, 5, 1, '2017-12-12 00:14:16', '2017-12-13 02:39:20'),
	(8, 2, 26, 4, 1, '2017-12-12 00:15:27', '2017-12-13 02:38:56'),
	(9, 2, 26, 3, 1, '2017-12-12 00:15:52', '2017-12-13 02:39:29'),
	(10, 2, 26, 3, 0, '2017-12-12 00:16:40', '2017-12-12 00:16:40'),
	(11, 2, 26, 4, 0, '2017-12-12 00:16:53', '2017-12-12 00:16:53'),
	(13, 2, 26, 9, 0, '2017-12-13 01:21:05', '2017-12-13 01:21:05'),
	(14, 2, 26, 3, 0, '2017-12-13 02:42:55', '2017-12-13 02:42:55'),
	(15, 2, 27, 40, 0, '2017-12-13 02:48:05', '2017-12-13 02:48:05'),
	(16, 2, 27, 1, 0, '2017-12-13 02:48:55', '2017-12-13 02:48:55');
/*!40000 ALTER TABLE `trx_pinjam` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
