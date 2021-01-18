/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.20-log : Database - grm_self
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`grm_self` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `grm_self`;

/*Table structure for table `qt_cd_fm` */

DROP TABLE IF EXISTS `qt_cd_fm`;

CREATE TABLE `qt_cd_fm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_id` int(11) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `port` int(6) DEFAULT NULL,
  `com` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `qt_cd_fm` */

insert  into `qt_cd_fm`(`id`,`code_id`,`code`,`name`,`store_id`,`ip`,`port`,`com`) values (1,1,'FM0001','FM0001',229,'192.168.10.45',554,'com1');

/*Table structure for table `qt_cd_jl` */

DROP TABLE IF EXISTS `qt_cd_jl`;

CREATE TABLE `qt_cd_jl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_id` int(11) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `cd_model_id` int(11) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  `yushenongdu` double DEFAULT NULL,
  `endnongdu` double DEFAULT NULL,
  `yusheamount` double DEFAULT NULL,
  `endamount` double DEFAULT NULL,
  `startdate` datetime DEFAULT NULL,
  `enddate` datetime DEFAULT NULL,
  `manager_id` int(11) DEFAULT NULL,
  `inputer_id` int(11) DEFAULT NULL,
  `acter_id` int(11) DEFAULT NULL,
  `inputtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `qt_cd_jl` */

insert  into `qt_cd_jl`(`id`,`code_id`,`code`,`cd_model_id`,`store_id`,`yushenongdu`,`endnongdu`,`yusheamount`,`endamount`,`startdate`,`enddate`,`manager_id`,`inputer_id`,`acter_id`,`inputtime`) values (1,1,'11111',1,229,12,12,12,12,'2021-01-07 15:39:08','2021-01-23 15:39:11',16,16,16,'2021-01-14 15:39:21');

/*Table structure for table `qt_cd_model` */

DROP TABLE IF EXISTS `qt_cd_model`;

CREATE TABLE `qt_cd_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_id` int(11) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `cd_type_id` int(11) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  `fm1` int(11) DEFAULT NULL,
  `fm2` int(11) DEFAULT NULL,
  `fm3` int(11) DEFAULT NULL,
  `fm4` int(11) DEFAULT NULL,
  `fm5` int(11) DEFAULT NULL,
  `fm6` int(11) DEFAULT NULL,
  `fm7` int(11) DEFAULT NULL,
  `fm8` int(11) DEFAULT NULL,
  `fm9` int(11) DEFAULT NULL,
  `fm10` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `qt_cd_model` */

insert  into `qt_cd_model`(`id`,`code_id`,`code`,`cd_type_id`,`store_id`,`fm1`,`fm2`,`fm3`,`fm4`,`fm5`,`fm6`,`fm7`,`fm8`,`fm9`,`fm10`) values (1,1,'123123',1,229,1,1,1,1,1,1,1,NULL,NULL,NULL);

/*Table structure for table `qt_cd_type` */

DROP TABLE IF EXISTS `qt_cd_type`;

CREATE TABLE `qt_cd_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `qt_cd_type` */

insert  into `qt_cd_type`(`id`,`code_id`,`name`) values (1,NULL,'上充下排'),(2,NULL,'边充边排');

/*Table structure for table `qt_qt_data` */

DROP TABLE IF EXISTS `qt_qt_data`;

CREATE TABLE `qt_qt_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `code_id` int(11) DEFAULT NULL,
  `o2` varchar(50) DEFAULT NULL,
  `co2` varchar(50) DEFAULT NULL,
  `ph3` varchar(50) DEFAULT NULL,
  `so2f2` varchar(50) DEFAULT NULL,
  `no1` varchar(50) DEFAULT NULL,
  `co1` varchar(50) DEFAULT NULL,
  `gettime` datetime DEFAULT NULL,
  `inputer` int(11) DEFAULT NULL,
  `inputtime` datetime DEFAULT NULL,
  `n2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qt_qt_data` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
