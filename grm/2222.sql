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

/*Table structure for table `nh_data` */

DROP TABLE IF EXISTS `nh_data`;

CREATE TABLE `nh_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_id` int(11) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `nh_type_id` int(11) DEFAULT NULL,
  `pow` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `nh_data` */

insert  into `nh_data`(`id`,`code_id`,`code`,`nh_type_id`,`pow`) values (1,1,'1',1,20);

/*Table structure for table `nh_type` */

DROP TABLE IF EXISTS `nh_type`;

CREATE TABLE `nh_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `nh_type` */

insert  into `nh_type`(`id`,`code_id`,`name`) values (1,1,'通风能耗'),(2,2,'平房1号仓能耗');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
