-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.11


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema kohana
--

CREATE DATABASE IF NOT EXISTS kohana;
USE kohana;

--
-- Definition of table `category_mst`
--

DROP TABLE IF EXISTS `category_mst`;
CREATE TABLE `category_mst` (
  `code` char(3) NOT NULL,
  `name` varchar(256) NOT NULL,
  `image` varchar(45) DEFAULT NULL,
  `supcat_code` char(3) DEFAULT NULL,
  PRIMARY KEY (`code`) USING BTREE,
  KEY `FK_category_mst_1` (`supcat_code`),
  CONSTRAINT `FK_category_mst_1` FOREIGN KEY (`supcat_code`) REFERENCES `category_mst` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category_mst`
--

/*!40000 ALTER TABLE `category_mst` DISABLE KEYS */;
INSERT INTO `category_mst` (`code`,`name`,`image`,`supcat_code`) VALUES 
 ('GIA','Hoa giả',NULL,'HOA'),
 ('HOA','Hoa các loại',NULL,NULL),
 ('MGC','Móc gắn chìa khóa',NULL,'QLN'),
 ('QLN','Quà lưu niệm',NULL,NULL),
 ('TNB','Thú nhồi bông',NULL,'QLN'),
 ('TUO','Hoa tươi',NULL,'HOA'),
 ('VON','Hoa vôn',NULL,'HOA');
/*!40000 ALTER TABLE `category_mst` ENABLE KEYS */;


--
-- Definition of table `order`
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `status_code` char(3) NOT NULL,
  `orderby_name` varchar(256) NOT NULL,
  `orderby_phone` varchar(20) NOT NULL,
  `orderby_address` varchar(1000) DEFAULT NULL,
  `orderfor_name` varchar(256) NOT NULL,
  `orderfor_phone` varchar(20) NOT NULL,
  `orderfor_address` varchar(1000) NOT NULL,
  `payment_code` char(3) NOT NULL,
  `bank_name` varchar(100) DEFAULT NULL,
  `bank_account_number` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order_1` (`status_code`) USING BTREE,
  KEY `FK_order_2` (`payment_code`),
  CONSTRAINT `FK_order_1` FOREIGN KEY (`status_code`) REFERENCES `order_status_mst` (`code`),
  CONSTRAINT `FK_order_2` FOREIGN KEY (`payment_code`) REFERENCES `payment_mst` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order`
--

/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;


--
-- Definition of table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
CREATE TABLE `order_product` (
  `order_id` int(10) unsigned NOT NULL,
  `product_id` int(10) unsigned NOT NULL,
  `quantity` int(10) unsigned NOT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `FK_order_product_2` (`product_id`),
  CONSTRAINT `FK_order_product_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_order_product_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_product`
--

/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_product` ENABLE KEYS */;


--
-- Definition of table `order_status_mst`
--

DROP TABLE IF EXISTS `order_status_mst`;
CREATE TABLE `order_status_mst` (
  `code` char(3) NOT NULL,
  `description` varchar(256) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_status_mst`
--

/*!40000 ALTER TABLE `order_status_mst` DISABLE KEYS */;
INSERT INTO `order_status_mst` (`code`,`description`) VALUES 
 ('CAN','Bị hủy'),
 ('DLR','Đang giao hàng'),
 ('FIN','Đã xong'),
 ('NEW','Chưa đọc'),
 ('WTR','Chờ nhận tiền');
/*!40000 ALTER TABLE `order_status_mst` ENABLE KEYS */;


--
-- Definition of table `payment_mst`
--

DROP TABLE IF EXISTS `payment_mst`;
CREATE TABLE `payment_mst` (
  `code` char(3) NOT NULL,
  `description` varchar(256) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment_mst`
--

/*!40000 ALTER TABLE `payment_mst` DISABLE KEYS */;
INSERT INTO `payment_mst` (`code`,`description`) VALUES 
 ('CSH','Tiền mặt'),
 ('TRF','Chuyển ngân hàng');
/*!40000 ALTER TABLE `payment_mst` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category_code` char(3) NOT NULL,
  `subcat_code` char(3) NOT NULL,
  `name` varchar(256) NOT NULL,
  `detail` text,
  `price` int(10) unsigned DEFAULT NULL,
  `sale_price` int(10) unsigned DEFAULT NULL,
  `quantity` int(10) unsigned DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `special` tinyint(1) DEFAULT NULL,
  `sale` tinyint(1) DEFAULT NULL,
  `name_search` varchar(256) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_product_1` (`category_code`) USING BTREE,
  KEY `FK_product_2` (`subcat_code`) USING BTREE,
  CONSTRAINT `FK_product_1` FOREIGN KEY (`category_code`) REFERENCES `category_mst` (`code`),
  CONSTRAINT `FK_product_2` FOREIGN KEY (`subcat_code`) REFERENCES `category_mst` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`,`category_code`,`subcat_code`,`name`,`detail`,`price`,`sale_price`,`quantity`,`image`,`special`,`sale`,`name_search`) VALUES 
 (2,'HOA','GIA','ten','mo ta',123,100,2,'http://www.aihat.vn:8080/aihat//img/client/FeaturedClips.png',1,1,'ten'),
 (4,'HOA','VON','gau bong 2','gau bong chu gi 1',1001,901,121,'http://profile.ak.fbcdn.net/hprofile-ak-snc4/211531_1390007523_697494_q.jpg',0,1,'gau bong 2');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
