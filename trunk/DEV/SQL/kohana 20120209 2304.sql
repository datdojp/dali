-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.16


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
  `order` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`code`) USING BTREE,
  KEY `FK_category_mst_1` (`supcat_code`),
  CONSTRAINT `FK_category_mst_1` FOREIGN KEY (`supcat_code`) REFERENCES `category_mst` (`code`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category_mst`
--

/*!40000 ALTER TABLE `category_mst` DISABLE KEYS */;
INSERT INTO `category_mst` (`code`,`name`,`image`,`supcat_code`,`order`) VALUES 
 ('ASM','Áo sơ mi',NULL,'TTR',NULL),
 ('ATH','Áo thun',NULL,'TTR',NULL),
 ('BBI','Barbie',NULL,'HLN',5),
 ('CHB','Hoa chia buồn',NULL,'HTU',5),
 ('CXH','Cây xanh',NULL,'HTU',1),
 ('HBO','Hoa bó',NULL,'HTU',2),
 ('HCB','Hoa cắm bình',NULL,'HTU',4),
 ('HCM','Hoa chúc mừng',NULL,'HTU',6),
 ('HCU','Hoa cưới',NULL,'HTU',5),
 ('HGI','Hoa giỏ',NULL,'HTU',3),
 ('HGY','Hoa giấy',NULL,'HNT',1),
 ('HLN','Hàng lưu niệm',NULL,NULL,3),
 ('HNT','Hoa nghệ thuật',NULL,NULL,2),
 ('HTU','Hoa tươi',NULL,NULL,1),
 ('HVI','Hoa vải',NULL,'HNT',3),
 ('HVN','Hoa voan',NULL,'HNT',2),
 ('KHH','Khung hình',NULL,'HLN',4),
 ('MKH','Móc khóa',NULL,'HLN',2),
 ('TBG','Thú bông',NULL,'HLN',1),
 ('TTR','Thời trang',NULL,NULL,4),
 ('TXK','Tui xách',NULL,'HLN',3);
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
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_order_1` (`status_code`) USING BTREE,
  KEY `FK_order_2` (`payment_code`),
  CONSTRAINT `FK_order_1` FOREIGN KEY (`status_code`) REFERENCES `order_status_mst` (`code`),
  CONSTRAINT `FK_order_2` FOREIGN KEY (`payment_code`) REFERENCES `payment_mst` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order`
--

/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` (`id`,`status_code`,`orderby_name`,`orderby_phone`,`orderby_address`,`orderfor_name`,`orderfor_phone`,`orderfor_address`,`payment_code`,`bank_name`,`bank_account_number`,`time`) VALUES 
 (1,'NEW','Peter Pan','0906618475','05 Vo Thi Sau','Peter Pan','0906618475','05 Vo Thi Sau','TRF','VietTin Bank','2673478904','2011-11-23 12:40:54');
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
INSERT INTO `order_product` (`order_id`,`product_id`,`quantity`) VALUES 
 (1,48,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`,`category_code`,`subcat_code`,`name`,`detail`,`price`,`sale_price`,`quantity`,`image`,`special`,`sale`,`name_search`) VALUES 
 (47,'HTU','HGI','HG01','',250,NULL,NULL,'http://a6.sphotos.ak.fbcdn.net/hphotos-ak-ash4/298312_112172682225807_100002992260129_87566_1182375496_n.jpg',1,0,'hg01'),
 (48,'HTU','HGI','HG02','',370,NULL,NULL,'http://a4.sphotos.ak.fbcdn.net/hphotos-ak-ash4/294219_112172712225804_100002992260129_87567_1381794847_n.jpg',1,0,'hg02'),
 (49,'HTU','HGI','HG03','',320,NULL,NULL,'http://a3.sphotos.ak.fbcdn.net/hphotos-ak-ash4/299255_112172752225800_100002992260129_87568_2110795932_n.jpg',1,0,'hg03'),
 (50,'HTU','HGI','HG04 ','',250,NULL,NULL,'http://a5.sphotos.ak.fbcdn.net/hphotos-ak-snc7/298325_112172782225797_100002992260129_87569_1733177019_n.jpg',1,0,'hg04 '),
 (51,'HTU','HGI','HG05','',300,NULL,NULL,'http://a2.sphotos.ak.fbcdn.net/hphotos-ak-ash4/301360_112172808892461_100002992260129_87570_669980973_n.jpg',1,0,'hg05'),
 (52,'HTU','HGI','HG06','',200,NULL,NULL,'http://a8.sphotos.ak.fbcdn.net/hphotos-ak-ash4/293983_112172828892459_100002992260129_87571_52410299_n.jpg',1,0,'hg06'),
 (53,'HTU','HGI','HG07','',280,NULL,NULL,'http://a6.sphotos.ak.fbcdn.net/hphotos-ak-ash4/297481_112172852225790_100002992260129_87572_153926414_n.jpg',1,0,'hg07'),
 (54,'HTU','HGI','HG08','',250,NULL,NULL,'http://a4.sphotos.ak.fbcdn.net/hphotos-ak-ash4/315891_112172878892454_100002992260129_87573_116448623_n.jpg',1,0,'hg08'),
 (55,'HTU','HGI','HG09','',170,NULL,NULL,'http://a1.sphotos.ak.fbcdn.net/hphotos-ak-snc7/298062_112172905559118_100002992260129_87574_337213124_n.jpg',1,0,'hg09'),
 (56,'HTU','HGI','HG10','',200,NULL,NULL,'http://a7.sphotos.ak.fbcdn.net/hphotos-ak-ash4/307793_112172935559115_100002992260129_87575_2047108910_n.jpg',1,0,'hg10'),
 (57,'HTU','HGI','HG11','',200,NULL,NULL,'http://a5.sphotos.ak.fbcdn.net/hphotos-ak-ash4/316626_112172948892447_100002992260129_87576_1504959544_n.jpg',1,0,'hg11'),
 (58,'HTU','HGI','HG12','',120,NULL,NULL,'http://a3.sphotos.ak.fbcdn.net/hphotos-ak-ash4/320825_112172975559111_100002992260129_87577_1546300809_n.jpg',1,0,'hg12'),
 (59,'HTU','HGI','HG13','',180,NULL,NULL,'http://a4.sphotos.ak.fbcdn.net/hphotos-ak-ash4/306307_112172988892443_100002992260129_87578_858060007_n.jpg',1,0,'hg13'),
 (60,'HTU','HGI','HG14','',230,NULL,NULL,'http://a6.sphotos.ak.fbcdn.net/hphotos-ak-ash4/306315_112173025559106_100002992260129_87579_1118285616_n.jpg',1,0,'hg14'),
 (61,'HTU','HGI','HG15','',210,NULL,NULL,'http://a1.sphotos.ak.fbcdn.net/hphotos-ak-ash4/299284_112173102225765_100002992260129_87581_391365574_n.jpg',1,0,'hg15'),
 (62,'HTU','HGI','HG16','',250,NULL,NULL,'http://a3.sphotos.ak.fbcdn.net/hphotos-ak-ash4/297054_112173125559096_100002992260129_87582_1747411756_n.jpg',1,0,'hg16'),
 (63,'HTU','HGI','HG17','',450,NULL,NULL,'http://a5.sphotos.ak.fbcdn.net/hphotos-ak-ash4/317023_112173142225761_100002992260129_87583_1355846192_n.jpg',1,0,'hg17'),
 (64,'HTU','HGI','HG18','',300,NULL,NULL,'http://a8.sphotos.ak.fbcdn.net/hphotos-ak-ash4/302061_112173172225758_100002992260129_87584_151647459_n.jpg',1,0,'hg18'),
 (65,'HTU','HGI','HG19','',280,NULL,NULL,'http://a2.sphotos.ak.fbcdn.net/hphotos-ak-ash4/311734_112173195559089_100002992260129_87585_711232463_n.jpg',1,0,'hg19'),
 (66,'HTU','HGI','HG20','',220,NULL,NULL,'http://a4.sphotos.ak.fbcdn.net/hphotos-ak-ash4/299766_112173232225752_100002992260129_87586_626740488_n.jpg',1,0,'hg20'),
 (67,'HTU','HGI','HG21','',200,NULL,NULL,'http://a6.sphotos.ak.fbcdn.net/hphotos-ak-ash4/314323_112173268892415_100002992260129_87587_691001772_n.jpg',1,0,'hg21'),
 (68,'HTU','HGI','HGT01','',NULL,NULL,NULL,'http://a5.sphotos.ak.fbcdn.net/hphotos-ak-snc7/312274_101518269957915_100002992260129_11288_573331119_n.jpg',0,0,'hgt01'),
 (69,'HTU','HGI','HGT02','',NULL,NULL,NULL,'http://a2.sphotos.ak.fbcdn.net/hphotos-ak-ash4/315495_101518393291236_100002992260129_11291_26498457_n.jpg',0,0,'hgt02'),
 (70,'HTU','HGI','HGT03','',NULL,NULL,NULL,'http://a6.sphotos.ak.fbcdn.net/hphotos-ak-ash4/314887_101518486624560_100002992260129_11293_1826295673_n.jpg',0,0,'hgt03'),
 (71,'HTU','HGI','HGT04','',NULL,NULL,NULL,'http://a5.sphotos.ak.fbcdn.net/hphotos-ak-ash4/319588_101518729957869_100002992260129_11297_1267951243_n.jpg',0,0,'hgt04'),
 (72,'HTU','HGI','HGT05','',NULL,NULL,NULL,'http://a2.sphotos.ak.fbcdn.net/hphotos-ak-snc7/314931_101518853291190_100002992260129_11300_992053192_n.jpg',0,0,'hgt05'),
 (73,'HTU','HGI','HGT06','',NULL,NULL,NULL,'http://a6.sphotos.ak.fbcdn.net/hphotos-ak-snc7/320917_101518933291182_100002992260129_11302_1571294046_n.jpg',0,0,'hgt06'),
 (74,'HTU','HGI','HGT07','',NULL,NULL,NULL,'http://a7.sphotos.ak.fbcdn.net/hphotos-ak-ash4/316753_101519056624503_100002992260129_11305_818785329_n.jpg',0,0,'hgt07'),
 (75,'HTU','HGI','HGT08','',NULL,NULL,NULL,'http://a4.sphotos.ak.fbcdn.net/hphotos-ak-ash4/306933_101519119957830_100002992260129_11308_1384966932_n.jpg',0,0,'hgt08'),
 (76,'HTU','HGI','HGT09','',NULL,NULL,NULL,'http://a7.sphotos.ak.fbcdn.net/hphotos-ak-ash4/317703_101519176624491_100002992260129_11311_1696727987_n.jpg',0,0,'hgt09'),
 (77,'HTU','HGI','HGT10','',NULL,NULL,NULL,'http://a3.sphotos.ak.fbcdn.net/hphotos-ak-ash4/299057_101519239957818_100002992260129_11313_334811326_n.jpg',0,0,'hgt10'),
 (78,'HTU','HGI','HGT011','',NULL,NULL,NULL,'http://a6.sphotos.ak.fbcdn.net/hphotos-ak-ash4/319684_101519299957812_100002992260129_11316_1486024765_n.jpg',0,0,'hgt011'),
 (79,'HTU','HGI','HGT012','',NULL,NULL,NULL,'http://a5.sphotos.ak.fbcdn.net/hphotos-ak-snc7/312683_101519396624469_100002992260129_11319_1604329813_n.jpg',0,0,'hgt012'),
 (80,'HTU','HGI','HGT013','',NULL,NULL,NULL,'http://a6.sphotos.ak.fbcdn.net/hphotos-ak-ash4/309654_101519496624459_100002992260129_11321_237077511_n.jpg',0,0,'hgt013'),
 (81,'HTU','HGI','HGT14','',180,NULL,NULL,'http://a2.sphotos.ak.fbcdn.net/hphotos-ak-ash4/319562_101519559957786_100002992260129_11323_198186810_n.jpg',0,0,'hgt14'),
 (82,'HTU','HGI','HGT15','',NULL,NULL,NULL,'http://a5.sphotos.ak.fbcdn.net/hphotos-ak-ash4/299505_103743306402078_100002992260129_32565_29667812_n.jpg',0,0,'hgt15'),
 (83,'HTU','HGI','HGT16','',NULL,NULL,NULL,'http://a7.sphotos.ak.fbcdn.net/hphotos-ak-snc7/299505_103743316402077_100002992260129_32566_1812856603_n.jpg',0,0,'hgt16'),
 (84,'HTU','HGI','HGT17','',NULL,NULL,NULL,'http://a1.sphotos.ak.fbcdn.net/hphotos-ak-ash4/299505_103743326402076_100002992260129_32567_95587291_n.jpg',0,0,'hgt17'),
 (85,'HTU','HGI','HGT18','',NULL,NULL,NULL,'http://a2.sphotos.ak.fbcdn.net/hphotos-ak-ash4/299505_103743336402075_100002992260129_32568_1061423429_n.jpg',0,0,'hgt18'),
 (86,'HTU','HGI','HGT19','',NULL,NULL,NULL,'http://a8.sphotos.ak.fbcdn.net/hphotos-ak-ash4/299505_103743343068741_100002992260129_32569_1799686416_n.jpg',0,0,'hgt19'),
 (87,'HTU','HGI','HGT19A','',NULL,NULL,NULL,'http://a1.sphotos.ak.fbcdn.net/hphotos-ak-ash4/303241_103745049735237_100002992260129_32602_1148265894_n.jpg',0,0,'hgt19a'),
 (88,'HTU','HGI','HGT20','',NULL,NULL,NULL,'http://a7.sphotos.ak.fbcdn.net/hphotos-ak-snc7/303241_103745056401903_100002992260129_32603_1893392428_n.jpg',0,0,'hgt20'),
 (89,'HTU','HGI','HGT21','',NULL,NULL,NULL,'http://a6.sphotos.ak.fbcdn.net/hphotos-ak-ash4/303241_103745063068569_100002992260129_32604_980949762_n.jpg',0,0,'hgt21'),
 (90,'HTU','HGI','HGT22','',NULL,NULL,NULL,'http://a4.sphotos.ak.fbcdn.net/hphotos-ak-snc7/303241_103745069735235_100002992260129_32605_1553710984_n.jpg',0,0,'hgt22'),
 (91,'HTU','HGI','HGT23','',NULL,NULL,NULL,'http://a2.sphotos.ak.fbcdn.net/hphotos-ak-ash4/303241_103745073068568_100002992260129_32606_880451828_n.jpg',0,0,'hgt23'),
 (92,'HTU','HGI','HGT24','',NULL,NULL,NULL,'http://a4.sphotos.ak.fbcdn.net/hphotos-ak-ash4/317581_103757133067362_100002992260129_32756_940942236_n.jpg',0,0,'hgt24');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
