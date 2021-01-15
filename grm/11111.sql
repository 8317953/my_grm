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

/*Table structure for table `equip_status_table` */

DROP TABLE IF EXISTS `equip_status_table`;

CREATE TABLE `equip_status_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sb_id` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `inputtime` datetime DEFAULT NULL,
  `inputer` int(11) DEFAULT NULL,
  `tf_palne_id` int(11) DEFAULT NULL,
  `tf_data_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `equip_status_table_ibfk_1` (`status_id`),
  KEY `equip_status_table_ibfk_2` (`sb_id`),
  CONSTRAINT `equip_status_table_ibfk_1` FOREIGN KEY (`status_id`) REFERENCES `equip_status_type` (`id`),
  CONSTRAINT `equip_status_table_ibfk_2` FOREIGN KEY (`sb_id`) REFERENCES `sd_tf_equip` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `equip_status_table` */

insert  into `equip_status_table`(`id`,`sb_id`,`status_id`,`inputtime`,`inputer`,`tf_palne_id`,`tf_data_id`) values (1,1,1,'2021-01-14 12:03:43',1,NULL,NULL),(2,1,2,'2021-01-22 12:03:57',1,NULL,NULL);

/*Table structure for table `equip_status_type` */

DROP TABLE IF EXISTS `equip_status_type`;

CREATE TABLE `equip_status_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `equip_status_type` */

insert  into `equip_status_type`(`id`,`code_id`,`name`) values (1,1,'使用中'),(2,2,'空闲'),(3,3,'申请购买'),(4,4,'废弃'),(5,5,'维修中');

/*Table structure for table `equipment_type` */

DROP TABLE IF EXISTS `equipment_type`;

CREATE TABLE `equipment_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_id` int(11) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `equipment_type` */

insert  into `equipment_type`(`id`,`code_id`,`name`) values (1,1,'通风设备'),(2,2,'仓窗'),(3,3,'球机'),(4,4,'抓拍机'),(5,5,'数量监测设备'),(6,6,'粮情设备');

/*Table structure for table `sd_tf_equip` */

DROP TABLE IF EXISTS `sd_tf_equip`;

CREATE TABLE `sd_tf_equip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(20) DEFAULT NULL,
  `port` int(11) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `code_id` int(11) DEFAULT NULL,
  `manager` int(11) DEFAULT NULL,
  `inputer` int(11) DEFAULT NULL,
  `input_time` datetime DEFAULT NULL,
  `can_move` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type` (`type`),
  CONSTRAINT `sd_tf_equip_ibfk_1` FOREIGN KEY (`type`) REFERENCES `equipment_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sd_tf_equip` */

insert  into `sd_tf_equip`(`id`,`ip`,`port`,`store_id`,`type`,`name`,`code`,`code_id`,`manager`,`inputer`,`input_time`,`can_move`) values (1,'127.0.0.1',556,229,1,'环流风机','1',1,1,1,'2021-01-13 12:00:57',NULL);

/* Procedure structure for procedure `stock_latest` */

/*!50003 DROP PROCEDURE IF EXISTS  `stock_latest` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `stock_latest`(date1 DATE)
BEGIN
 SELECT 
        `current_stock`.`id` AS `id`,
        `depot_table`.`id` AS `depot_id`,
        `store_table`.`id` AS `store_id`,
        `compartment_table`.`id` AS `compartment_id`,
        `current_stock`.`cargo_id` AS `cargo_id`,
        `current_stock`.`grain_type_id` AS `grain_type_id`,
        `current_stock`.`grain_variety_id` AS `grain_variety_id`,
        `current_stock`.`year` AS `year`,
        IFNULL(`current_stock`.`amount`, 0) AS `amount`,
        `current_stock`.`package_type_id` AS `package_type_id`,
        `current_stock`.`location` AS `location`,
        `current_stock`.`business_key` AS `business_key`,
        `current_stock`.`inputer_id` AS `inputer_id`,
        `current_stock`.`input_comment` AS `input_comment`,
        `current_stock`.`input_time` AS `input_time`,
        `current_stock`.`auditor_id` AS `auditor_id`,
        `current_stock`.`audit_time` AS `audit_time`,
        `current_stock`.`audit_comment` AS `audit_comment`,
        `current_stock`.`in_time` AS `in_time`,
        `current_stock`.`in_finished` AS `in_finished`,
        `current_stock`.`out_time` AS `out_time`,
        `current_stock`.`out_finished` AS `out_finished`,
        `current_stock`.`_unit_weight` AS `_unit_weight`,
        `current_stock`.`_deduct_volume` AS `_deduct_volume`,
        `current_stock`.`_factor` AS `_factor`,
        `latest_exam`.`analysis_level_id` AS `l_analysis_level_id`,
        `latest_exam`.`s1` AS `l_s1`,
        `latest_exam`.`s2` AS `l_s2`,
        `latest_exam`.`s3` AS `l_s3`,
        `latest_exam`.`s4` AS `l_s4`,
        `latest_exam`.`s5` AS `l_s5`,
        `latest_exam`.`a1` AS `l_a1`,
        `latest_exam`.`a2` AS `l_a2`,
        `latest_exam`.`a3` AS `l_a3`,
        `latest_exam`.`a4` AS `l_a4`,
        `latest_exam`.`a5` AS `l_a5`,
        `latest_exam`.`a6` AS `l_a6`,
        `latest_exam`.`a7` AS `l_a7`,
        `latest_exam`.`a8` AS `l_a8`,
        `latest_exam`.`a9` AS `l_a9`,
        `latest_exam`.`a10` AS `l_a10`,
        `in_exam`.`analysis_level_id` AS `i_analysis_level_id`,
        `in_exam`.`s1` AS `i_s1`,
        `in_exam`.`s2` AS `i_s2`,
        `in_exam`.`s3` AS `i_s3`,
        `in_exam`.`s4` AS `i_s4`,
        `in_exam`.`s5` AS `i_s5`,
        `in_exam`.`a1` AS `i_a1`,
        `in_exam`.`a2` AS `i_a2`,
        `in_exam`.`a3` AS `i_a3`,
        `in_exam`.`a4` AS `i_a4`,
        `in_exam`.`a5` AS `i_a5`,
        `in_exam`.`a6` AS `i_a6`,
        `in_exam`.`a7` AS `i_a7`,
        `in_exam`.`a8` AS `i_a8`,
        `in_exam`.`a9` AS `i_a9`,
        `in_exam`.`a10` AS `i_a10`,
        `out_exam`.`analysis_level_id` AS `o_analysis_level_id`,
        `out_exam`.`s1` AS `o_s1`,
        `out_exam`.`s2` AS `o_s2`,
        `out_exam`.`s3` AS `o_s3`,
        `out_exam`.`s4` AS `o_s4`,
        `out_exam`.`s5` AS `o_s5`,
        `out_exam`.`a1` AS `o_a1`,
        `out_exam`.`a2` AS `o_a2`,
        `out_exam`.`a3` AS `o_a3`,
        `out_exam`.`a4` AS `o_a4`,
        `out_exam`.`a5` AS `o_a5`,
        `out_exam`.`a6` AS `o_a6`,
        `out_exam`.`a7` AS `o_a7`,
        `out_exam`.`a8` AS `o_a8`,
        `out_exam`.`a9` AS `o_a9`,
        `out_exam`.`a10` AS `o_a10`,
        IFNULL(`out_stock`.`out_amount`, 0) AS `out_amount`,
        IFNULL(`in_stock`.`in_amount`, 0) AS `in_amount`,
        CONCAT(LPAD(`depot_table`.`code_id`, 3, '0'),
                LPAD(`store_table`.`code_id`, 3, '0'),
                LPAD(`compartment_table`.`code_id`, 2, '0'),
                LPAD(`cargo_table`.`code_id`, 3, '0')) AS `code`,
        CONCAT(`depot_table`.`abbrev`,
                `store_table`.`name`,
                '(',
                `cargo_table`.`name`,
                ') - ',
                `current_stock`.`business_key`) AS `cargo_name`
    FROM
        (((((((((((SELECT 
            `s1`.`id` AS `id`,
                `s1`.`cargo_id` AS `cargo_id`,
                `s1`.`grain_type_id` AS `grain_type_id`,
                `s1`.`grain_variety_id` AS `grain_variety_id`,
                `s1`.`year` AS `year`,
                `s1`.`amount` AS `amount`,
                `s1`.`package_type_id` AS `package_type_id`,
                `s1`.`location` AS `location`,
                `s1`.`business_key` AS `business_key`,
                `s1`.`inputer_id` AS `inputer_id`,
                `s1`.`input_comment` AS `input_comment`,
                `s1`.`input_time` AS `input_time`,
                `s1`.`auditor_id` AS `auditor_id`,
                `s1`.`audit_time` AS `audit_time`,
                `s1`.`audit_comment` AS `audit_comment`,
                `s1`.`in_time` AS `in_time`,
                `s1`.`out_time` AS `out_time`,
                `s1`.`in_finished` AS `in_finished`,
                `s1`.`_unit_weight` AS `_unit_weight`,
                `s1`.`_deduct_volume` AS `_deduct_volume`,
                `s1`.`_factor` AS `_factor`,
                `s1`.`out_finished` AS `out_finished`
        FROM
            (`grm_self`.`gb_stock_id` `s1`
        JOIN (SELECT 
            MAX(`grm_self`.`gb_stock_id`.`input_time`) AS `latest`,
                `grm_self`.`gb_stock_id`.`cargo_id` AS `cargo_id`
        FROM
            `grm_self`.`gb_stock_id`
        WHERE
            (`grm_self`.`gb_stock_id`.`input_time` < date1)
        GROUP BY `grm_self`.`gb_stock_id`.`cargo_id`) `s2` ON (((`s1`.`cargo_id` = `s2`.`cargo_id`)
            AND (`s1`.`input_time` = `s2`.`latest`)))))) `current_stock`
        LEFT JOIN (SELECT 
            `sco1`.`out_amount` AS `out_amount`,
                `sco1`.`source_stock_id` AS `source_stock_id`
        FROM
            (SELECT 
            SUM(IFNULL(`sc1`.`amount`, 0)) AS `out_amount`,
                `sc1`.`source_stock_id` AS `source_stock_id`
        FROM
            `grm_self`.`gb_stock_change` `sc1`
        WHERE
            (`sc1`.`input_time` < date1)
        GROUP BY `sc1`.`source_stock_id`) `sco1`) `out_stock` ON ((`out_stock`.`source_stock_id` = `current_stock`.`id`)))
        LEFT JOIN (SELECT 
            `sco2`.`in_amount` AS `in_amount`,
                `sco2`.`target_stock_id` AS `target_stock_id`
        FROM
            (SELECT 
            SUM(IFNULL(`sc2`.`amount`, 0)) AS `in_amount`,
                `sc2`.`target_stock_id` AS `target_stock_id`
        FROM
            `grm_self`.`gb_stock_change` `sc2`
        WHERE
            (`sc2`.`input_time` < date1)
        GROUP BY `sc2`.`target_stock_id`) `sco2`) `in_stock` ON ((`in_stock`.`target_stock_id` = `current_stock`.`id`)))
        LEFT JOIN (SELECT 
            `le1`.`analysis_level_id` AS `analysis_level_id`,
                `le1`.`s1` AS `s1`,
                `le1`.`s2` AS `s2`,
                `le1`.`s3` AS `s3`,
                `le1`.`s4` AS `s4`,
                `le1`.`s5` AS `s5`,
                `le1`.`a1` AS `a1`,
                `le1`.`a2` AS `a2`,
                `le1`.`a3` AS `a3`,
                `le1`.`a4` AS `a4`,
                `le1`.`a5` AS `a5`,
                `le1`.`a6` AS `a6`,
                `le1`.`a7` AS `a7`,
                `le1`.`a8` AS `a8`,
                `le1`.`a9` AS `a9`,
                `le1`.`a10` AS `a10`,
                `le1`.`input_time` AS `input_time`,
                `le1`.`analysis_type_id` AS `analysis_type_id`,
                `le1`.`stock_id` AS `stock_id`
        FROM
            (`grm_self`.`gb_stock_analysis` `le1`
        JOIN (SELECT 
            MAX(`grm_self`.`gb_stock_analysis`.`input_time`) AS `latest`,
                `grm_self`.`gb_stock_analysis`.`stock_id` AS `stock_id`
        FROM
            `grm_self`.`gb_stock_analysis`
        WHERE
            (`input_time` < date1)
        GROUP BY `grm_self`.`gb_stock_analysis`.`stock_id`) `le2` ON (((`le1`.`input_time` = `le2`.`latest`)
            AND (`le1`.`stock_id` = `le2`.`stock_id`))))) `latest_exam` ON ((`latest_exam`.`stock_id` = `current_stock`.`id`)))
        LEFT JOIN (SELECT 
            `ie1`.`analysis_level_id` AS `analysis_level_id`,
                `ie1`.`s1` AS `s1`,
                `ie1`.`s2` AS `s2`,
                `ie1`.`s3` AS `s3`,
                `ie1`.`s4` AS `s4`,
                `ie1`.`s5` AS `s5`,
                `ie1`.`a1` AS `a1`,
                `ie1`.`a2` AS `a2`,
                `ie1`.`a3` AS `a3`,
                `ie1`.`a4` AS `a4`,
                `ie1`.`a5` AS `a5`,
                `ie1`.`a6` AS `a6`,
                `ie1`.`a7` AS `a7`,
                `ie1`.`a8` AS `a8`,
                `ie1`.`a9` AS `a9`,
                `ie1`.`a10` AS `a10`,
                `ie1`.`input_time` AS `input_time`,
                `ie1`.`analysis_type_id` AS `analysis_type_id`,
                `ie1`.`stock_id` AS `stock_id`
        FROM
            (`grm_self`.`gb_stock_analysis` `ie1`
        JOIN (SELECT 
            MAX(`grm_self`.`gb_stock_analysis`.`input_time`) AS `latest`,
                `grm_self`.`gb_stock_analysis`.`stock_id` AS `stock_id`
        FROM
            `grm_self`.`gb_stock_analysis`
        WHERE
            (`grm_self`.`gb_stock_analysis`.`analysis_type_id` = 1 AND `grm_self`.`gb_stock_analysis`.`input_time` < date1)
        GROUP BY `grm_self`.`gb_stock_analysis`.`stock_id`) `ie2` ON (((`ie1`.`input_time` = `ie2`.`latest`)
            AND (`ie1`.`stock_id` = `ie2`.`stock_id`))))
        WHERE
            (`ie1`.`analysis_type_id` = 1)) `in_exam` ON ((`in_exam`.`stock_id` = `current_stock`.`id`)))
        LEFT JOIN (SELECT 
            `oe1`.`analysis_level_id` AS `analysis_level_id`,
                `oe1`.`s1` AS `s1`,
                `oe1`.`s2` AS `s2`,
                `oe1`.`s3` AS `s3`,
                `oe1`.`s4` AS `s4`,
                `oe1`.`s5` AS `s5`,
                `oe1`.`a1` AS `a1`,
                `oe1`.`a2` AS `a2`,
                `oe1`.`a3` AS `a3`,
                `oe1`.`a4` AS `a4`,
                `oe1`.`a5` AS `a5`,
                `oe1`.`a6` AS `a6`,
                `oe1`.`a7` AS `a7`,
                `oe1`.`a8` AS `a8`,
                `oe1`.`a9` AS `a9`,
                `oe1`.`a10` AS `a10`,
                `oe1`.`input_time` AS `input_time`,
                `oe1`.`analysis_type_id` AS `analysis_type_id`,
                `oe1`.`stock_id` AS `stock_id`
        FROM
            (`grm_self`.`gb_stock_analysis` `oe1`
        JOIN (SELECT 
            MAX(`grm_self`.`gb_stock_analysis`.`input_time`) AS `latest`,
                `grm_self`.`gb_stock_analysis`.`stock_id` AS `stock_id`
        FROM
            `grm_self`.`gb_stock_analysis`
        WHERE
            (`grm_self`.`gb_stock_analysis`.`analysis_type_id` = 2 AND `grm_self`.`gb_stock_analysis`.`input_time` < date1)
        GROUP BY `grm_self`.`gb_stock_analysis`.`stock_id`) `oe2` ON (((`oe1`.`input_time` = `oe2`.`latest`)
            AND (`oe1`.`stock_id` = `oe2`.`stock_id`))))
        WHERE
            (`oe1`.`analysis_type_id` = 2)) `out_exam` ON ((`out_exam`.`stock_id` = `current_stock`.`id`)))
        LEFT JOIN (SELECT 
            `grm_self`.`grm_cargo`.`compartment_id` AS `compartment_id`,
                `grm_self`.`grm_cargo`.`code_id` AS `code_id`,
                `grm_self`.`grm_cargo`.`name` AS `name`,
                `grm_self`.`grm_cargo`.`id` AS `id`
        FROM
            `grm_self`.`grm_cargo`) `cargo_table` ON ((`cargo_table`.`id` = `current_stock`.`cargo_id`)))
        LEFT JOIN (SELECT 
            `grm_self`.`grm_compartment`.`store_id` AS `store_id`,
                `grm_self`.`grm_compartment`.`code_id` AS `code_id`,
                `grm_self`.`grm_compartment`.`id` AS `id`
        FROM
            `grm_self`.`grm_compartment`) `compartment_table` ON ((`compartment_table`.`id` = `cargo_table`.`compartment_id`)))
        LEFT JOIN (SELECT 
            `grm_self`.`grm_store`.`code_id` AS `code_id`,
                `grm_self`.`grm_store`.`name` AS `name`,
                `grm_self`.`grm_store`.`depot_id` AS `depot_id`,
                `grm_self`.`grm_store`.`id` AS `id`
        FROM
            `grm_self`.`grm_store`) `store_table` ON ((`store_table`.`id` = `compartment_table`.`store_id`)))
        LEFT JOIN (SELECT 
            `grm_self`.`grm_depot`.`abbrev` AS `abbrev`,
                `grm_self`.`grm_depot`.`code_id` AS `code_id`,
                `grm_self`.`grm_depot`.`id` AS `id`
        FROM
            `grm_self`.`grm_depot`) `depot_table` ON ((`store_table`.`depot_id` = `depot_table`.`id`)))
    ORDER BY `depot_table`.`id` , `store_table`.`id` , `compartment_table`.`id` , `cargo_table`.`id` , `current_stock`.`input_time` DESC;
END */$$
DELIMITER ;

/* Procedure structure for procedure `sumNum` */

/*!50003 DROP PROCEDURE IF EXISTS  `sumNum` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `sumNum`(out sumNum int)
BEGIN
	select count(*) into sumNum
  from t_temperaturesaverecord;
END */$$
DELIMITER ;

/* Procedure structure for procedure `sumNum1` */

/*!50003 DROP PROCEDURE IF EXISTS  `sumNum1` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `sumNum1`()
BEGIN
	select count(*)
  from t_temperaturesaverecord;
END */$$
DELIMITER ;

/* Procedure structure for procedure `sumNum2` */

/*!50003 DROP PROCEDURE IF EXISTS  `sumNum2` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `sumNum2`(out sumNum int)
BEGIN
	select count(*) + 1 into sumNum
  from t_temperaturesaverecord;
END */$$
DELIMITER ;

/*Table structure for table `gb_contract_representation` */

DROP TABLE IF EXISTS `gb_contract_representation`;

/*!50001 DROP VIEW IF EXISTS `gb_contract_representation` */;
/*!50001 DROP TABLE IF EXISTS `gb_contract_representation` */;

/*!50001 CREATE TABLE  `gb_contract_representation`(
 `id` int(11) ,
 `type_id` int(11) ,
 `is_ingress` tinyint(1) ,
 `client_id` int(11) ,
 `grain_type_id` int(11) ,
 `grain_variety_id` int(11) ,
 `amount` int(11) ,
 `business_key` varchar(150) ,
 `inputer_id` int(11) ,
 `input_comment` varchar(500) ,
 `input_time` datetime ,
 `auditor_id` int(11) ,
 `audit_time` datetime ,
 `audit_comment` varchar(500) ,
 `name` varchar(100) ,
 `scale_id` int(11) ,
 `deadline` date ,
 `price` double(15,3) ,
 `total_price` double(18,3) ,
 `depot_id` int(11) ,
 `package_type_id` int(11) ,
 `readable_name` varchar(325) 
)*/;

/*Table structure for table `gb_material_sum` */

DROP TABLE IF EXISTS `gb_material_sum`;

/*!50001 DROP VIEW IF EXISTS `gb_material_sum` */;
/*!50001 DROP TABLE IF EXISTS `gb_material_sum` */;

/*!50001 CREATE TABLE  `gb_material_sum`(
 `id` int(11) ,
 `type_id` int(11) ,
 `name` varchar(100) ,
 `out_amount` decimal(27,0) ,
 `in_amount` decimal(27,0) ,
 `total` decimal(28,0) 
)*/;

/*Table structure for table `gb_medicine_sum` */

DROP TABLE IF EXISTS `gb_medicine_sum`;

/*!50001 DROP VIEW IF EXISTS `gb_medicine_sum` */;
/*!50001 DROP TABLE IF EXISTS `gb_medicine_sum` */;

/*!50001 CREATE TABLE  `gb_medicine_sum`(
 `id` int(11) ,
 `type_id` int(11) ,
 `name` varchar(100) ,
 `out_amount` double(25,8) ,
 `in_amount` double(25,8) ,
 `total` double(25,8) 
)*/;

/*Table structure for table `gb_stock_agg` */

DROP TABLE IF EXISTS `gb_stock_agg`;

/*!50001 DROP VIEW IF EXISTS `gb_stock_agg` */;
/*!50001 DROP TABLE IF EXISTS `gb_stock_agg` */;

/*!50001 CREATE TABLE  `gb_stock_agg`(
 `id` varchar(51) ,
 `stock_id` int(11) ,
 `sas_id` varchar(25) ,
 `saa_id` varchar(25) ,
 `cargo_id` int(11) ,
 `compartment_id` int(11) ,
 `store_id` int(11) ,
 `depot_id` int(11) ,
 `grain_type_id` int(11) ,
 `grain_variety_id` int(11) ,
 `year` varchar(4) ,
 `package_type_id` int(11) ,
 `package_category_id` int(11) ,
 `location` varchar(20) ,
 `business_key` varchar(150) ,
 `input_time` datetime ,
 `in_time` datetime ,
 `in_finished` tinyint(4) ,
 `out_time` datetime ,
 `out_finished` tinyint(4) ,
 `amount` bigint(20) ,
 `_unit_weight` double(6,2) ,
 `_deduct_volume` double(10,2) ,
 `_factor` double(5,2) ,
 `water_amount` double ,
 `impurity_amount` double ,
 `in_amount` decimal(32,0) ,
 `out_amount` decimal(32,0) ,
 `analysis_type_id` int(11) ,
 `analysis_level_id` int(11) ,
 `a1` double ,
 `a2` double ,
 `a3` double ,
 `a4` double ,
 `a5` double ,
 `a6` double ,
 `a7` double ,
 `a8` double ,
 `a9` double ,
 `a10` double ,
 `a11` double ,
 `a12` double ,
 `a13` double ,
 `a14` double ,
 `a15` double ,
 `s1` varchar(64) ,
 `s2` varchar(64) ,
 `s3` varchar(64) ,
 `s4` varchar(64) ,
 `s5` varchar(64) ,
 `time` datetime ,
 `code` varchar(11) ,
 `cargo_name` varchar(375) ,
 `short_name` varchar(222) 
)*/;

/*Table structure for table `gb_stock_agg_analysis` */

DROP TABLE IF EXISTS `gb_stock_agg_analysis`;

/*!50001 DROP VIEW IF EXISTS `gb_stock_agg_analysis` */;
/*!50001 DROP TABLE IF EXISTS `gb_stock_agg_analysis` */;

/*!50001 CREATE TABLE  `gb_stock_agg_analysis`(
 `id` varchar(25) ,
 `stock_id` int(11) ,
 `analysis_type_id` int(11) ,
 `analysis_level_id` int(11) ,
 `a1` double ,
 `a2` double ,
 `a3` double ,
 `a4` double ,
 `a5` double ,
 `a6` double ,
 `a7` double ,
 `a8` double ,
 `a9` double ,
 `a10` double ,
 `a11` double ,
 `a12` double ,
 `a13` double ,
 `a14` double ,
 `a15` double ,
 `s1` varchar(64) ,
 `s2` varchar(64) ,
 `s3` varchar(64) ,
 `s4` varchar(64) ,
 `s5` varchar(64) ,
 `time` datetime 
)*/;

/*Table structure for table `gb_stock_agg_sum` */

DROP TABLE IF EXISTS `gb_stock_agg_sum`;

/*!50001 DROP VIEW IF EXISTS `gb_stock_agg_sum` */;
/*!50001 DROP TABLE IF EXISTS `gb_stock_agg_sum` */;

/*!50001 CREATE TABLE  `gb_stock_agg_sum`(
 `id` varchar(25) ,
 `stock_id` int(11) ,
 `cargo_id` int(11) ,
 `grain_type_id` int(11) ,
 `grain_variety_id` int(11) ,
 `year` varchar(4) ,
 `package_type_id` int(11) ,
 `package_category_id` int(11) ,
 `location` varchar(20) ,
 `business_key` varchar(150) ,
 `inputer_id` int(11) ,
 `input_comment` varchar(500) ,
 `input_time` datetime ,
 `auditor_id` int(11) ,
 `audit_time` datetime ,
 `audit_comment` varchar(500) ,
 `in_time` datetime ,
 `in_finished` tinyint(4) ,
 `out_time` datetime ,
 `out_finished` tinyint(4) ,
 `_unit_weight` double(6,2) ,
 `_deduct_volume` double(10,2) ,
 `_factor` double(5,2) ,
 `water_amount` double ,
 `impurity_amount` double ,
 `amount` bigint(20) ,
 `in_amount` decimal(32,0) ,
 `out_amount` decimal(32,0) ,
 `time` datetime 
)*/;

/*Table structure for table `gb_stock_agg_time` */

DROP TABLE IF EXISTS `gb_stock_agg_time`;

/*!50001 DROP VIEW IF EXISTS `gb_stock_agg_time` */;
/*!50001 DROP TABLE IF EXISTS `gb_stock_agg_time` */;

/*!50001 CREATE TABLE  `gb_stock_agg_time`(
 `stock_id` int(11) ,
 `time` datetime ,
 `u_id` varchar(25) 
)*/;

/*Table structure for table `gb_stock_change_representation` */

DROP TABLE IF EXISTS `gb_stock_change_representation`;

/*!50001 DROP VIEW IF EXISTS `gb_stock_change_representation` */;
/*!50001 DROP TABLE IF EXISTS `gb_stock_change_representation` */;

/*!50001 CREATE TABLE  `gb_stock_change_representation`(
 `id` int(11) ,
 `type_id` int(11) ,
 `source_stock_id` int(11) ,
 `target_stock_id` int(11) ,
 `amount` int(11) ,
 `contract_id` int(11) ,
 `package_category_id` int(11) ,
 `water` double(5,2) ,
 `analysis_level_id` int(11) ,
 `impurity` double(5,2) ,
 `grain_type_id` int(11) ,
 `grain_variety_id` int(11) ,
 `pack` int(11) ,
 `business_key` varchar(150) ,
 `inputer_id` int(11) ,
 `input_comment` varchar(500) ,
 `input_time` datetime ,
 `auditor_id` int(11) ,
 `audit_time` datetime ,
 `audit_comment` varchar(500) ,
 `content` varchar(448) ,
 `rep_name` text ,
 `cargo_name` varchar(450) 
)*/;

/*Table structure for table `gb_stock_full` */

DROP TABLE IF EXISTS `gb_stock_full`;

/*!50001 DROP VIEW IF EXISTS `gb_stock_full` */;
/*!50001 DROP TABLE IF EXISTS `gb_stock_full` */;

/*!50001 CREATE TABLE  `gb_stock_full`(
 `id` int(11) ,
 `depot_id` int(11) ,
 `store_id` int(11) ,
 `cargo_id` int(11) ,
 `grain_type_id` int(11) ,
 `grain_variety_id` int(11) ,
 `year` varchar(4) ,
 `amount` int(11) ,
 `package_type_id` int(11) ,
 `package_category_id` int(11) ,
 `location` varchar(20) ,
 `country_id` int(11) ,
 `business_key` varchar(150) ,
 `inputer_id` int(11) ,
 `input_comment` varchar(500) ,
 `input_time` datetime ,
 `auditor_id` int(11) ,
 `audit_time` datetime ,
 `audit_comment` varchar(500) ,
 `in_finished` tinyint(1) ,
 `out_finished` tinyint(1) ,
 `in_time` datetime ,
 `out_time` datetime ,
 `in_analysis_id` int(11) ,
 `out_analysis_id` int(11) ,
 `_unit_weight` double(6,2) ,
 `_deduct_volume` double(10,2) ,
 `_factor` double(5,2) ,
 `code` varchar(11) ,
 `cargo_name` varchar(379) ,
 `short_name` varchar(222) 
)*/;

/*Table structure for table `gb_stock_r_root` */

DROP TABLE IF EXISTS `gb_stock_r_root`;

/*!50001 DROP VIEW IF EXISTS `gb_stock_r_root` */;
/*!50001 DROP TABLE IF EXISTS `gb_stock_r_root` */;

/*!50001 CREATE TABLE  `gb_stock_r_root`(
 `id` int(11) ,
 `cargo_id` int(11) ,
 `input_time` datetime ,
 `out_finished` tinyint(1) ,
 `business_key` varchar(150) ,
 `code` varchar(11) ,
 `cargo_name` varchar(222) 
)*/;

/*Table structure for table `gb_stock_representation` */

DROP TABLE IF EXISTS `gb_stock_representation`;

/*!50001 DROP VIEW IF EXISTS `gb_stock_representation` */;
/*!50001 DROP TABLE IF EXISTS `gb_stock_representation` */;

/*!50001 CREATE TABLE  `gb_stock_representation`(
 `id` int(11) ,
 `input_time` datetime ,
 `business_key` varchar(150) ,
 `code` varchar(11) ,
 `cargo_name` varchar(222) ,
 `verbose_name` varchar(375) ,
 `is_current` int(1) 
)*/;

/*Table structure for table `gb_stock_sum` */

DROP TABLE IF EXISTS `gb_stock_sum`;

/*!50001 DROP VIEW IF EXISTS `gb_stock_sum` */;
/*!50001 DROP TABLE IF EXISTS `gb_stock_sum` */;

/*!50001 CREATE TABLE  `gb_stock_sum`(
 `id` int(11) ,
 `code` varchar(11) ,
 `cargo_name` varchar(373) ,
 `cargo_name_short` varchar(222) ,
 `depot_id` int(11) ,
 `store_id` int(11) ,
 `compartment_id` int(11) ,
 `cargo_id` int(11) ,
 `grain_type_id` int(11) ,
 `grain_variety_id` int(11) ,
 `year` varchar(4) ,
 `amount` bigint(11) ,
 `package_type_id` int(11) ,
 `package_category_id` int(11) ,
 `location` varchar(20) ,
 `country_id` int(11) ,
 `business_key` varchar(150) ,
 `inputer_id` int(11) ,
 `input_comment` varchar(500) ,
 `input_time` datetime ,
 `auditor_id` int(11) ,
 `audit_time` datetime ,
 `audit_comment` varchar(500) ,
 `in_time` datetime ,
 `in_finished` tinyint(1) ,
 `out_time` datetime ,
 `out_finished` tinyint(1) ,
 `_unit_weight` double(6,2) ,
 `_deduct_volume` double(10,2) ,
 `_factor` double(5,2) ,
 `l_analysis_level_id` int(11) ,
 `l_s1` varchar(64) ,
 `l_s2` varchar(64) ,
 `l_s3` varchar(64) ,
 `l_s4` varchar(64) ,
 `l_s5` varchar(64) ,
 `l_a1` double ,
 `l_a2` double ,
 `l_a3` double ,
 `l_a4` double ,
 `l_a5` double ,
 `l_a6` double ,
 `l_a7` double ,
 `l_a8` double ,
 `l_a9` double ,
 `l_a10` double ,
 `l_a11` double ,
 `l_a12` double ,
 `l_a13` double ,
 `l_a14` double ,
 `l_a15` double ,
 `l_a16` double ,
 `l_a17` double ,
 `i_analysis_level_id` int(11) ,
 `i_s1` varchar(64) ,
 `i_s2` varchar(64) ,
 `i_s3` varchar(64) ,
 `i_s4` varchar(64) ,
 `i_s5` varchar(64) ,
 `i_a1` double ,
 `i_a2` double ,
 `i_a3` double ,
 `i_a4` double ,
 `i_a5` double ,
 `i_a6` double ,
 `i_a7` double ,
 `i_a8` double ,
 `i_a9` double ,
 `i_a10` double ,
 `i_a11` double ,
 `i_a12` double ,
 `i_a13` double ,
 `i_a14` double ,
 `i_a15` double ,
 `i_a16` double ,
 `i_a17` double ,
 `o_analysis_level_id` int(11) ,
 `o_s1` varchar(64) ,
 `o_s2` varchar(64) ,
 `o_s3` varchar(64) ,
 `o_s4` varchar(64) ,
 `o_s5` varchar(64) ,
 `o_a1` double ,
 `o_a2` double ,
 `o_a3` double ,
 `o_a4` double ,
 `o_a5` double ,
 `o_a6` double ,
 `o_a7` double ,
 `o_a8` double ,
 `o_a9` double ,
 `o_a10` double ,
 `o_a11` double ,
 `o_a12` double ,
 `o_a13` double ,
 `o_a14` double ,
 `o_a15` double ,
 `o_a16` double ,
 `o_a17` double ,
 `out_amount` decimal(32,0) ,
 `in_amount` decimal(32,0) ,
 `in_pack` decimal(32,0) ,
 `out_pack` decimal(32,0) 
)*/;

/*Table structure for table `gb_stock_sum_history` */

DROP TABLE IF EXISTS `gb_stock_sum_history`;

/*!50001 DROP VIEW IF EXISTS `gb_stock_sum_history` */;
/*!50001 DROP TABLE IF EXISTS `gb_stock_sum_history` */;

/*!50001 CREATE TABLE  `gb_stock_sum_history`(
 `id` int(11) ,
 `code` varchar(11) ,
 `cargo_name` varchar(379) ,
 `cargo_name_short` varchar(226) ,
 `depot_id` int(11) ,
 `store_id` int(11) ,
 `compartment_id` int(11) ,
 `cargo_id` int(11) ,
 `grain_type_id` int(11) ,
 `grain_variety_id` int(11) ,
 `year` varchar(4) ,
 `amount` bigint(11) ,
 `package_type_id` int(11) ,
 `package_category_id` int(11) ,
 `location` varchar(20) ,
 `country_id` int(11) ,
 `business_key` varchar(150) ,
 `inputer_id` int(11) ,
 `input_comment` varchar(500) ,
 `input_time` datetime ,
 `auditor_id` int(11) ,
 `audit_time` datetime ,
 `audit_comment` varchar(500) ,
 `in_time` datetime ,
 `in_finished` tinyint(1) ,
 `out_time` datetime ,
 `out_finished` tinyint(1) ,
 `_unit_weight` double(6,2) ,
 `_deduct_volume` double(10,2) ,
 `_factor` double(5,2) ,
 `l_analysis_level_id` int(11) ,
 `l_s1` varchar(64) ,
 `l_s2` varchar(64) ,
 `l_s3` varchar(64) ,
 `l_s4` varchar(64) ,
 `l_s5` varchar(64) ,
 `l_a1` double ,
 `l_a2` double ,
 `l_a3` double ,
 `l_a4` double ,
 `l_a5` double ,
 `l_a6` double ,
 `l_a7` double ,
 `l_a8` double ,
 `l_a9` double ,
 `l_a10` double ,
 `l_a11` double ,
 `l_a12` double ,
 `l_a13` double ,
 `l_a14` double ,
 `l_a15` double ,
 `l_a16` double ,
 `l_a17` double ,
 `i_analysis_level_id` int(11) ,
 `i_s1` varchar(64) ,
 `i_s2` varchar(64) ,
 `i_s3` varchar(64) ,
 `i_s4` varchar(64) ,
 `i_s5` varchar(64) ,
 `i_a1` double ,
 `i_a2` double ,
 `i_a3` double ,
 `i_a4` double ,
 `i_a5` double ,
 `i_a6` double ,
 `i_a7` double ,
 `i_a8` double ,
 `i_a9` double ,
 `i_a10` double ,
 `i_a11` double ,
 `i_a12` double ,
 `i_a13` double ,
 `i_a14` double ,
 `i_a15` double ,
 `i_a16` double ,
 `i_a17` double ,
 `o_analysis_level_id` int(11) ,
 `o_s1` varchar(64) ,
 `o_s2` varchar(64) ,
 `o_s3` varchar(64) ,
 `o_s4` varchar(64) ,
 `o_s5` varchar(64) ,
 `o_a1` double ,
 `o_a2` double ,
 `o_a3` double ,
 `o_a4` double ,
 `o_a5` double ,
 `o_a6` double ,
 `o_a7` double ,
 `o_a8` double ,
 `o_a9` double ,
 `o_a10` double ,
 `o_a11` double ,
 `o_a12` double ,
 `o_a13` double ,
 `o_a14` double ,
 `o_a15` double ,
 `o_a16` double ,
 `o_a17` double ,
 `out_amount` decimal(32,0) ,
 `in_amount` decimal(32,0) ,
 `in_pack` decimal(32,0) ,
 `out_pack` decimal(32,0) 
)*/;

/*Table structure for table `grm_cargo_representation` */

DROP TABLE IF EXISTS `grm_cargo_representation`;

/*!50001 DROP VIEW IF EXISTS `grm_cargo_representation` */;
/*!50001 DROP TABLE IF EXISTS `grm_cargo_representation` */;

/*!50001 CREATE TABLE  `grm_cargo_representation`(
 `id` int(11) ,
 `code_id` smallint(2) unsigned zerofill ,
 `name` varchar(100) ,
 `readable_name` varchar(325) ,
 `code` varchar(11) ,
 `status_name` varchar(100) ,
 `status_id` int(11) ,
 `store_name` varchar(100) ,
 `depot_abbrev` varchar(20) ,
 `short_name` varchar(222) ,
 `compartment_id` int(11) 
)*/;

/*Table structure for table `my_change_source` */

DROP TABLE IF EXISTS `my_change_source`;

/*!50001 DROP VIEW IF EXISTS `my_change_source` */;
/*!50001 DROP TABLE IF EXISTS `my_change_source` */;

/*!50001 CREATE TABLE  `my_change_source`(
 `id` int(11) ,
 `source_id` int(11) ,
 `target_id` int(11) ,
 `current_stock_change_amount` int(11) ,
 `input_time` datetime ,
 `c2_id` int(11) ,
 `c2_input_time` datetime ,
 `c2_amount` int(11) ,
 `sum_c2amount` decimal(32,0) 
)*/;

/*Table structure for table `my_change_source_target` */

DROP TABLE IF EXISTS `my_change_source_target`;

/*!50001 DROP VIEW IF EXISTS `my_change_source_target` */;
/*!50001 DROP TABLE IF EXISTS `my_change_source_target` */;

/*!50001 CREATE TABLE  `my_change_source_target`(
 `id` int(11) ,
 `source_id` int(11) ,
 `target_id` int(11) ,
 `current_stock_change_amount` int(11) ,
 `input_time` datetime ,
 `c2_id` int(11) ,
 `c2_input_time` datetime ,
 `c2_amount` int(11) ,
 `sum_c2amount` decimal(32,0) ,
 `c3_id` int(11) ,
 `c3_input_time` datetime ,
 `c3_amount` int(11) ,
 `sum_c3amount` decimal(32,0) 
)*/;

/*Table structure for table `my_current_stock1` */

DROP TABLE IF EXISTS `my_current_stock1`;

/*!50001 DROP VIEW IF EXISTS `my_current_stock1` */;
/*!50001 DROP TABLE IF EXISTS `my_current_stock1` */;

/*!50001 CREATE TABLE  `my_current_stock1`(
 `id` int(11) ,
 `cargo_id` int(11) ,
 `grain_type_id` int(11) ,
 `grain_variety_id` int(11) ,
 `year` varchar(4) ,
 `amount` int(11) ,
 `package_type_id` int(11) ,
 `package_category_id` int(11) ,
 `location` varchar(20) ,
 `business_key` varchar(150) ,
 `inputer_id` int(11) ,
 `input_comment` varchar(500) ,
 `input_time` datetime ,
 `auditor_id` int(11) ,
 `audit_time` datetime ,
 `audit_comment` varchar(500) ,
 `in_finished` tinyint(1) ,
 `out_finished` tinyint(1) ,
 `in_time` datetime ,
 `out_time` datetime ,
 `in_analysis_id` int(11) ,
 `out_analysis_id` int(11) ,
 `_unit_weight` double(6,2) ,
 `_deduct_volume` double(10,2) ,
 `_factor` double(5,2) ,
 `country_id` int(11) ,
 `max_input_time` datetime 
)*/;

/*Table structure for table `my_current_stock2` */

DROP TABLE IF EXISTS `my_current_stock2`;

/*!50001 DROP VIEW IF EXISTS `my_current_stock2` */;
/*!50001 DROP TABLE IF EXISTS `my_current_stock2` */;

/*!50001 CREATE TABLE  `my_current_stock2`(
 `id` int(11) ,
 `cargo_id` int(11) ,
 `grain_type_id` int(11) ,
 `grain_variety_id` int(11) ,
 `year` varchar(4) ,
 `amount` int(11) ,
 `package_type_id` int(11) ,
 `package_category_id` int(11) ,
 `location` varchar(20) ,
 `country_id` int(11) ,
 `business_key` varchar(150) ,
 `inputer_id` int(11) ,
 `input_comment` varchar(500) ,
 `input_time` datetime ,
 `auditor_id` int(11) ,
 `audit_time` datetime ,
 `audit_comment` varchar(500) ,
 `in_time` datetime ,
 `out_time` datetime ,
 `in_finished` tinyint(1) ,
 `_unit_weight` double(6,2) ,
 `_deduct_volume` double(10,2) ,
 `_factor` double(5,2) ,
 `out_finished` tinyint(1) ,
 `compartment_id` int(11) ,
 `cargo_name` varchar(100) ,
 `store_id` int(11) ,
 `store_code` int(3) unsigned zerofill ,
 `depot_id` int(11) 
)*/;

/*Table structure for table `my_current_stock3` */

DROP TABLE IF EXISTS `my_current_stock3`;

/*!50001 DROP VIEW IF EXISTS `my_current_stock3` */;
/*!50001 DROP TABLE IF EXISTS `my_current_stock3` */;

/*!50001 CREATE TABLE  `my_current_stock3`(
 `id` int(11) ,
 `cargo_id` int(11) ,
 `grain_type_id` int(11) ,
 `grain_variety_id` int(11) ,
 `year` varchar(4) ,
 `amount` int(11) ,
 `package_type_id` int(11) ,
 `package_category_id` int(11) ,
 `location` varchar(20) ,
 `country_id` int(11) ,
 `business_key` varchar(150) ,
 `inputer_id` int(11) ,
 `input_comment` varchar(500) ,
 `input_time` datetime ,
 `auditor_id` int(11) ,
 `audit_time` datetime ,
 `audit_comment` varchar(500) ,
 `in_time` datetime ,
 `out_time` datetime ,
 `in_finished` tinyint(1) ,
 `_unit_weight` double(6,2) ,
 `_deduct_volume` double(10,2) ,
 `_factor` double(5,2) ,
 `out_finished` tinyint(1) ,
 `compartment_id` int(11) ,
 `cargo_name` varchar(100) ,
 `store_id` int(11) ,
 `store_code` int(3) unsigned zerofill ,
 `depot_id` int(11) ,
 `out_amount` decimal(32,0) ,
 `in_amount` decimal(32,0) ,
 `hasamount` decimal(34,0) 
)*/;

/*Table structure for table `my_current_stock_change` */

DROP TABLE IF EXISTS `my_current_stock_change`;

/*!50001 DROP VIEW IF EXISTS `my_current_stock_change` */;
/*!50001 DROP TABLE IF EXISTS `my_current_stock_change` */;

/*!50001 CREATE TABLE  `my_current_stock_change`(
 `id` int(11) ,
 `source_id` int(11) ,
 `target_id` int(11) ,
 `current_stock_change_amount` int(11) ,
 `input_time` datetime 
)*/;

/*Table structure for table `my_entry_tem` */

DROP TABLE IF EXISTS `my_entry_tem`;

/*!50001 DROP VIEW IF EXISTS `my_entry_tem` */;
/*!50001 DROP TABLE IF EXISTS `my_entry_tem` */;

/*!50001 CREATE TABLE  `my_entry_tem`(
 `ymd` varchar(8) ,
 `id` int(11) ,
 `store_id` int(11) ,
 `time` datetime ,
 `data` text ,
 `is_auto` tinyint(1) 
)*/;

/*Table structure for table `my_newst_current_stock` */

DROP TABLE IF EXISTS `my_newst_current_stock`;

/*!50001 DROP VIEW IF EXISTS `my_newst_current_stock` */;
/*!50001 DROP TABLE IF EXISTS `my_newst_current_stock` */;

/*!50001 CREATE TABLE  `my_newst_current_stock`(
 `id` int(11) ,
 `cargo_id` int(11) ,
 `grain_type_id` int(11) ,
 `grain_variety_id` int(11) ,
 `year` varchar(4) ,
 `amount` int(11) ,
 `package_type_id` int(11) ,
 `package_category_id` int(11) ,
 `location` varchar(20) ,
 `business_key` varchar(150) ,
 `inputer_id` int(11) ,
 `input_comment` varchar(500) ,
 `input_time` datetime ,
 `auditor_id` int(11) ,
 `audit_time` datetime ,
 `audit_comment` varchar(500) ,
 `in_finished` tinyint(1) ,
 `out_finished` tinyint(1) ,
 `in_time` datetime ,
 `out_time` datetime ,
 `in_analysis_id` int(11) ,
 `out_analysis_id` int(11) ,
 `_unit_weight` double(6,2) ,
 `_deduct_volume` double(10,2) ,
 `_factor` double(5,2) ,
 `country_id` int(11) ,
 `maxcargo_id` int(11) ,
 `max_audit_time` datetime 
)*/;

/*Table structure for table `my_stock_sum_history` */

DROP TABLE IF EXISTS `my_stock_sum_history`;

/*!50001 DROP VIEW IF EXISTS `my_stock_sum_history` */;
/*!50001 DROP TABLE IF EXISTS `my_stock_sum_history` */;

/*!50001 CREATE TABLE  `my_stock_sum_history`(
 `id` int(11) ,
 `cargo_id` int(11) ,
 `grain_type_id` int(11) ,
 `grain_variety_id` int(11) ,
 `year` varchar(4) ,
 `amount` int(11) ,
 `package_type_id` int(11) ,
 `package_category_id` int(11) ,
 `location` varchar(20) ,
 `business_key` varchar(150) ,
 `inputer_id` int(11) ,
 `input_comment` varchar(500) ,
 `input_time` datetime ,
 `auditor_id` int(11) ,
 `audit_time` datetime ,
 `audit_comment` varchar(500) ,
 `in_finished` tinyint(1) ,
 `out_finished` tinyint(1) ,
 `in_time` datetime ,
 `out_time` datetime ,
 `in_analysis_id` int(11) ,
 `out_analysis_id` int(11) ,
 `_unit_weight` double(6,2) ,
 `_deduct_volume` double(10,2) ,
 `_factor` double(5,2) ,
 `country_id` int(11) ,
 `in_amount` decimal(32,0) ,
 `in_stock` int(11) ,
 `out_amount` decimal(32,0) ,
 `out_stock` int(11) 
)*/;

/*Table structure for table `p_month` */

DROP TABLE IF EXISTS `p_month`;

/*!50001 DROP VIEW IF EXISTS `p_month` */;
/*!50001 DROP TABLE IF EXISTS `p_month` */;

/*!50001 CREATE TABLE  `p_month`(
 `type_id` int(11) ,
 `date` date ,
 `content` varchar(20) ,
 `last_date` date ,
 `out_amount` double(21,4) ,
 `in_amount` double(21,4) ,
 `amount` double(21,4) 
)*/;

/*Table structure for table `p_ybb` */

DROP TABLE IF EXISTS `p_ybb`;

/*!50001 DROP VIEW IF EXISTS `p_ybb` */;
/*!50001 DROP TABLE IF EXISTS `p_ybb` */;

/*!50001 CREATE TABLE  `p_ybb`(
 `type_id` int(11) ,
 `date` date ,
 `amount` double(17,0) ,
 `last_amount` double(17,0) ,
 `in_amount` double(17,0) ,
 `out_amount` double(17,0) 
)*/;

/*Table structure for table `sd_my_current_simple_stock` */

DROP TABLE IF EXISTS `sd_my_current_simple_stock`;

/*!50001 DROP VIEW IF EXISTS `sd_my_current_simple_stock` */;
/*!50001 DROP TABLE IF EXISTS `sd_my_current_simple_stock` */;

/*!50001 CREATE TABLE  `sd_my_current_simple_stock`(
 `id` int(11) ,
 `cargo_id` int(11) ,
 `grain_type_id` int(11) ,
 `grain_variety_id` int(11) ,
 `year` varchar(4) ,
 `amount` int(11) ,
 `package_type_id` int(11) ,
 `package_category_id` int(11) ,
 `location` varchar(20) ,
 `business_key` varchar(150) ,
 `inputer_id` int(11) ,
 `input_comment` varchar(500) ,
 `input_time` datetime ,
 `auditor_id` int(11) ,
 `audit_time` datetime ,
 `audit_comment` varchar(500) ,
 `in_finished` tinyint(1) ,
 `out_finished` tinyint(1) ,
 `in_time` datetime ,
 `out_time` datetime ,
 `in_analysis_id` int(11) ,
 `out_analysis_id` int(11) ,
 `_unit_weight` double(6,2) ,
 `_deduct_volume` double(10,2) ,
 `_factor` double(5,2) ,
 `country_id` int(11) ,
 `max_audit_time` datetime 
)*/;

/*Table structure for table `sd_my_js_f_s` */

DROP TABLE IF EXISTS `sd_my_js_f_s`;

/*!50001 DROP VIEW IF EXISTS `sd_my_js_f_s` */;
/*!50001 DROP TABLE IF EXISTS `sd_my_js_f_s` */;

/*!50001 CREATE TABLE  `sd_my_js_f_s`(
 `id` int(11) ,
 `code` varchar(100) ,
 `is_ingress` tinyint(4) ,
 `stage_id` int(11) ,
 `contract_id` int(11) ,
 `register_record_id` int(11) ,
 `analysis_id` int(11) ,
 `time` datetime ,
 `allow_stage` smallint(6) ,
 `out_time` datetime ,
 `has_second` tinyint(4) ,
 `stock_id` int(11) ,
 `stock_change_id` int(11) ,
 `date_stock` varchar(23) ,
 `f_weight` double(9,4) ,
 `s_weight` double(9,4) ,
 `deduct_weight` double(9,4) ,
 `pack` int(11) ,
 `pack_per_weight` double(5,2) ,
 `deduct_percentage` double(5,2) ,
 `isecond` varchar(1) 
)*/;

/*Table structure for table `sd_my_js_f_s_amount` */

DROP TABLE IF EXISTS `sd_my_js_f_s_amount`;

/*!50001 DROP VIEW IF EXISTS `sd_my_js_f_s_amount` */;
/*!50001 DROP TABLE IF EXISTS `sd_my_js_f_s_amount` */;

/*!50001 CREATE TABLE  `sd_my_js_f_s_amount`(
 `id` int(11) ,
 `code` varchar(100) ,
 `is_ingress` tinyint(4) ,
 `stage_id` int(11) ,
 `contract_id` int(11) ,
 `register_record_id` int(11) ,
 `analysis_id` int(11) ,
 `time` datetime ,
 `allow_stage` smallint(6) ,
 `out_time` datetime ,
 `has_second` tinyint(4) ,
 `stock_id` int(11) ,
 `stock_change_id` int(11) ,
 `date_stock` varchar(23) ,
 `f_weight` double(9,4) ,
 `s_weight` double(9,4) ,
 `deduct_weight` double(9,4) ,
 `pack` int(11) ,
 `pack_per_weight` double(5,2) ,
 `isecond` varchar(1) ,
 `myid` varchar(13) ,
 `deduct_percentage` double(5,2) ,
 `pack_total_amount` double(19,2) ,
 `in_amount` double(21,4) ,
 `out_amount` double(21,4) 
)*/;

/*Table structure for table `sd_my_js_f_s_amount_current` */

DROP TABLE IF EXISTS `sd_my_js_f_s_amount_current`;

/*!50001 DROP VIEW IF EXISTS `sd_my_js_f_s_amount_current` */;
/*!50001 DROP TABLE IF EXISTS `sd_my_js_f_s_amount_current` */;

/*!50001 CREATE TABLE  `sd_my_js_f_s_amount_current`(
 `id` int(11) ,
 `code` varchar(100) ,
 `is_ingress` tinyint(4) ,
 `stage_id` int(11) ,
 `contract_id` int(11) ,
 `register_record_id` int(11) ,
 `analysis_id` int(11) ,
 `time` datetime ,
 `allow_stage` smallint(6) ,
 `out_time` datetime ,
 `has_second` tinyint(4) ,
 `stock_id` int(11) ,
 `stock_change_id` int(11) ,
 `date_stock` varchar(23) ,
 `f_weight` double(9,4) ,
 `s_weight` double(9,4) ,
 `deduct_weight` double(9,4) ,
 `pack` int(11) ,
 `pack_per_weight` double(5,2) ,
 `deduct_percentage` double(5,2) ,
 `pack_total_amount` double(19,2) ,
 `in_amount` double(21,4) ,
 `out_amount` double(21,4) ,
 `audit_time` datetime 
)*/;

/*Table structure for table `sd_my_js_f_s_amount_current_date` */

DROP TABLE IF EXISTS `sd_my_js_f_s_amount_current_date`;

/*!50001 DROP VIEW IF EXISTS `sd_my_js_f_s_amount_current_date` */;
/*!50001 DROP TABLE IF EXISTS `sd_my_js_f_s_amount_current_date` */;

/*!50001 CREATE TABLE  `sd_my_js_f_s_amount_current_date`(
 `format_out_time` varchar(10) ,
 `stock_id` int(11) ,
 `date_stock` varchar(23) ,
 `total_out_amount` double(21,4) ,
 `total_in_amount` double(21,4) ,
 `js_amount` double(21,4) 
)*/;

/*Table structure for table `sd_my_js_first` */

DROP TABLE IF EXISTS `sd_my_js_first`;

/*!50001 DROP VIEW IF EXISTS `sd_my_js_first` */;
/*!50001 DROP TABLE IF EXISTS `sd_my_js_first` */;

/*!50001 CREATE TABLE  `sd_my_js_first`(
 `id` int(11) ,
 `code` varchar(100) ,
 `is_ingress` tinyint(1) ,
 `stage_id` int(11) ,
 `contract_id` int(11) ,
 `register_record_id` int(11) ,
 `analysis_id` int(11) ,
 `time` datetime ,
 `allow_stage` smallint(6) ,
 `out_time` datetime ,
 `has_second` tinyint(1) ,
 `stock_id` int(8) ,
 `stock_change_id` int(8) ,
 `date_stock` varchar(23) ,
 `f_weight` double(9,4) ,
 `s_weight` double(9,4) ,
 `deduct_weight` double(9,4) ,
 `pack` int(11) ,
 `pack_per_weight` double(5,2) ,
 `deduct_percentage` double(5,2) 
)*/;

/*Table structure for table `sd_my_js_orgin` */

DROP TABLE IF EXISTS `sd_my_js_orgin`;

/*!50001 DROP VIEW IF EXISTS `sd_my_js_orgin` */;
/*!50001 DROP TABLE IF EXISTS `sd_my_js_orgin` */;

/*!50001 CREATE TABLE  `sd_my_js_orgin`(
 `id` int(11) ,
 `code` varchar(100) ,
 `is_ingress` tinyint(1) ,
 `stage_id` int(11) ,
 `contract_id` int(11) ,
 `register_record_id` int(11) ,
 `analysis_id` int(11) ,
 `weight_sheet_id` int(11) ,
 `balance_sheet_id` int(11) ,
 `is_finished` tinyint(1) ,
 `time` datetime ,
 `allow_stage` smallint(6) ,
 `second_weight_sheet_id` int(11) ,
 `out_time` datetime ,
 `has_second` tinyint(1) ,
 `second_contract_id` int(11) ,
 `stock_id` int(8) ,
 `stock_change_id` int(8) ,
 `second_stock_id` int(8) ,
 `second_stock_change_id` int(8) ,
 `first_finished_stock` varchar(23) ,
 `second_finished_stock` varchar(23) 
)*/;

/*Table structure for table `sd_my_js_second` */

DROP TABLE IF EXISTS `sd_my_js_second`;

/*!50001 DROP VIEW IF EXISTS `sd_my_js_second` */;
/*!50001 DROP TABLE IF EXISTS `sd_my_js_second` */;

/*!50001 CREATE TABLE  `sd_my_js_second`(
 `id` int(11) ,
 `code` varchar(100) ,
 `is_ingress` tinyint(1) ,
 `stage_id` int(11) ,
 `contract_id` int(11) ,
 `register_record_id` int(11) ,
 `analysis_id` int(11) ,
 `time` datetime ,
 `allow_stage` smallint(6) ,
 `out_time` datetime ,
 `has_second` tinyint(1) ,
 `stock_id` int(8) ,
 `stock_change_id` int(8) ,
 `date_stock` varchar(23) ,
 `f_weight` double(9,4) ,
 `s_weight` double(9,4) ,
 `deduct_weight` double(9,4) ,
 `pack` int(11) ,
 `pack_per_weight` double(5,2) ,
 `deduct_percentage` double(5,2) 
)*/;

/*Table structure for table `stat_changes` */

DROP TABLE IF EXISTS `stat_changes`;

/*!50001 DROP VIEW IF EXISTS `stat_changes` */;
/*!50001 DROP TABLE IF EXISTS `stat_changes` */;

/*!50001 CREATE TABLE  `stat_changes`(
 `date` date ,
 `stock_id` int(11) ,
 `move_out_amount` decimal(32,0) ,
 `move_in_amount` decimal(32,0) ,
 `out_amount` decimal(32,0) ,
 `plus_amount` decimal(32,0) ,
 `in_amount` decimal(32,0) ,
 `minus_amount` decimal(32,0) ,
 `cargo_id` int(11) 
)*/;

/*Table structure for table `stat_changes_root` */

DROP TABLE IF EXISTS `stat_changes_root`;

/*!50001 DROP VIEW IF EXISTS `stat_changes_root` */;
/*!50001 DROP TABLE IF EXISTS `stat_changes_root` */;

/*!50001 CREATE TABLE  `stat_changes_root`(
 `date` date ,
 `stock_id` int(11) ,
 `move_out_amount` decimal(32,0) ,
 `move_in_amount` decimal(32,0) ,
 `out_amount` decimal(32,0) ,
 `plus_amount` decimal(32,0) ,
 `in_amount` decimal(32,0) ,
 `minus_amount` decimal(32,0) 
)*/;

/*Table structure for table `stat_flybb` */

DROP TABLE IF EXISTS `stat_flybb`;

/*!50001 DROP VIEW IF EXISTS `stat_flybb` */;
/*!50001 DROP TABLE IF EXISTS `stat_flybb` */;

/*!50001 CREATE TABLE  `stat_flybb`(
 `date` date ,
 `content` varchar(20) ,
 `depot_id` int(11) ,
 `stock_id` int(11) ,
 `grain_variety_id` int(11) ,
 `grain_type_id` int(11) ,
 `package_type_id` int(11) ,
 `amount` decimal(34,0) ,
 `year` varchar(4) 
)*/;

/*Table structure for table `stat_kcb` */

DROP TABLE IF EXISTS `stat_kcb`;

/*!50001 DROP VIEW IF EXISTS `stat_kcb` */;
/*!50001 DROP TABLE IF EXISTS `stat_kcb` */;

/*!50001 CREATE TABLE  `stat_kcb`(
 `content` varchar(123) ,
 `depot_id` int(11) ,
 `cargo_id` int(11) ,
 `grain_variety_id` int(11) ,
 `date` date ,
 `amount` decimal(34,0) ,
 `last_amount` decimal(34,0) ,
 `in_amount` decimal(32,0) ,
 `out_amount` decimal(32,0) ,
 `minus_amount` decimal(32,0) ,
 `plus_amount` decimal(32,0) ,
 `move_amount` decimal(33,0) 
)*/;

/*Table structure for table `stat_kcybb` */

DROP TABLE IF EXISTS `stat_kcybb`;

/*!50001 DROP VIEW IF EXISTS `stat_kcybb` */;
/*!50001 DROP TABLE IF EXISTS `stat_kcybb` */;

/*!50001 CREATE TABLE  `stat_kcybb`(
 `content` varchar(123) ,
 `depot_id` int(11) ,
 `cargo_id` int(11) ,
 `grain_variety_id` int(11) ,
 `date` date ,
 `amount` decimal(34,0) ,
 `last_amount` decimal(34,0) ,
 `in_amount` decimal(32,0) ,
 `out_amount` decimal(32,0) ,
 `minus_amount` decimal(32,0) ,
 `plus_amount` decimal(32,0) ,
 `move_amount` decimal(33,0) 
)*/;

/*Table structure for table `stat_month` */

DROP TABLE IF EXISTS `stat_month`;

/*!50001 DROP VIEW IF EXISTS `stat_month` */;
/*!50001 DROP TABLE IF EXISTS `stat_month` */;

/*!50001 CREATE TABLE  `stat_month`(
 `stock_id` int(11) ,
 `content` varchar(20) ,
 `date` date ,
 `last_date` date ,
 `depot_id` int(11) ,
 `store_id` int(11) ,
 `compartment_id` int(11) ,
 `cargo_id` int(11) ,
 `grain_type_id` int(11) ,
 `grain_variety_id` int(11) ,
 `year` varchar(4) ,
 `amount` decimal(34,0) ,
 `package_type_id` int(11) ,
 `package_category_id` int(11) ,
 `location` varchar(20) ,
 `business_key` varchar(150) ,
 `out_amount` decimal(32,0) ,
 `in_amount` decimal(32,0) ,
 `initial_amount` bigint(20) ,
 `code` varchar(11) ,
 `cargo_name` varchar(375) 
)*/;

/*Table structure for table `stat_mxz` */

DROP TABLE IF EXISTS `stat_mxz`;

/*!50001 DROP VIEW IF EXISTS `stat_mxz` */;
/*!50001 DROP TABLE IF EXISTS `stat_mxz` */;

/*!50001 CREATE TABLE  `stat_mxz`(
 `content` varchar(448) ,
 `business_key` varchar(150) ,
 `water` double(5,2) ,
 `impurity` double(5,2) ,
 `depot_id` int(11) ,
 `stock_id` int(11) ,
 `date` date ,
 `input_time` datetime ,
 `amount` decimal(34,0) ,
 `last_amount` decimal(35,0) ,
 `in_amount` decimal(32,0) ,
 `out_amount` decimal(32,0) ,
 `minus_amount` decimal(32,0) ,
 `plus_amount` decimal(32,0) ,
 `move_in_amount` decimal(32,0) ,
 `move_out_amount` decimal(32,0) ,
 `water_amount` double ,
 `impurity_amount` double 
)*/;

/*Table structure for table `stat_year` */

DROP TABLE IF EXISTS `stat_year`;

/*!50001 DROP VIEW IF EXISTS `stat_year` */;
/*!50001 DROP TABLE IF EXISTS `stat_year` */;

/*!50001 CREATE TABLE  `stat_year`(
 `stock_id` int(11) ,
 `content` varchar(20) ,
 `date` date ,
 `last_date` binary(0) ,
 `depot_id` int(11) ,
 `store_id` int(11) ,
 `compartment_id` int(11) ,
 `cargo_id` int(11) ,
 `grain_type_id` int(11) ,
 `grain_variety_id` int(11) ,
 `year` varchar(4) ,
 `amount` decimal(34,0) ,
 `package_type_id` int(11) ,
 `location` varchar(20) ,
 `business_key` varchar(150) ,
 `out_amount` decimal(32,0) ,
 `in_amount` decimal(32,0) ,
 `initial_amount` bigint(11) ,
 `code` varchar(11) ,
 `cargo_name` varchar(375) 
)*/;

/*Table structure for table `stat_zz` */

DROP TABLE IF EXISTS `stat_zz`;

/*!50001 DROP VIEW IF EXISTS `stat_zz` */;
/*!50001 DROP TABLE IF EXISTS `stat_zz` */;

/*!50001 CREATE TABLE  `stat_zz`(
 `content` varchar(20) ,
 `business_key` binary(0) ,
 `water` binary(0) ,
 `impurity` binary(0) ,
 `depot_id` int(11) ,
 `stock_id` int(11) ,
 `date` date ,
 `grain_variety_id` int(11) ,
 `grain_type_id` int(11) ,
 `amount` decimal(34,0) ,
 `last_amount` decimal(34,0) ,
 `in_amount` decimal(32,0) ,
 `out_amount` decimal(32,0) ,
 `minus_amount` decimal(32,0) ,
 `plus_amount` decimal(32,0) ,
 `move_in_amount` decimal(32,0) ,
 `move_out_amount` decimal(32,0) 
)*/;

/*Table structure for table `x_month` */

DROP TABLE IF EXISTS `x_month`;

/*!50001 DROP VIEW IF EXISTS `x_month` */;
/*!50001 DROP TABLE IF EXISTS `x_month` */;

/*!50001 CREATE TABLE  `x_month`(
 `type_id` int(11) ,
 `date` date ,
 `content` varchar(20) ,
 `last_date` date ,
 `out_amount` decimal(27,0) ,
 `in_amount` decimal(27,0) ,
 `amount` decimal(28,0) 
)*/;

/*Table structure for table `x_ybb` */

DROP TABLE IF EXISTS `x_ybb`;

/*!50001 DROP VIEW IF EXISTS `x_ybb` */;
/*!50001 DROP TABLE IF EXISTS `x_ybb` */;

/*!50001 CREATE TABLE  `x_ybb`(
 `type_id` int(11) ,
 `date` date ,
 `amount` decimal(28,0) ,
 `last_amount` decimal(28,0) ,
 `in_amount` decimal(28,0) ,
 `out_amount` decimal(28,0) 
)*/;

/*View structure for view gb_contract_representation */

/*!50001 DROP TABLE IF EXISTS `gb_contract_representation` */;
/*!50001 DROP VIEW IF EXISTS `gb_contract_representation` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gb_contract_representation` AS select `contract`.`id` AS `id`,`contract`.`type_id` AS `type_id`,`contract`.`is_ingress` AS `is_ingress`,`contract`.`client_id` AS `client_id`,`contract`.`grain_type_id` AS `grain_type_id`,`contract`.`grain_variety_id` AS `grain_variety_id`,`contract`.`amount` AS `amount`,`contract`.`business_key` AS `business_key`,`contract`.`inputer_id` AS `inputer_id`,`contract`.`input_comment` AS `input_comment`,`contract`.`input_time` AS `input_time`,`contract`.`auditor_id` AS `auditor_id`,`contract`.`audit_time` AS `audit_time`,`contract`.`audit_comment` AS `audit_comment`,`contract`.`name` AS `name`,`contract`.`scale_id` AS `scale_id`,`contract`.`deadline` AS `deadline`,`contract`.`price` AS `price`,`contract`.`total_price` AS `total_price`,`contract`.`depot_id` AS `depot_id`,`contract`.`package_type_id` AS `package_type_id`,concat(`contract`.`name`,'-',`client`.`name`,' (',`grain_variety`.`name`,',',`grain_type`.`name`,')') AS `readable_name` from (((`grm_self`.`gb_contract` `contract` left join (select `grm_self`.`gb_client`.`id` AS `id`,`grm_self`.`gb_client`.`name` AS `name` from `grm_self`.`gb_client`) `client` on((`contract`.`client_id` = `client`.`id`))) left join (select `grm_self`.`sc_grain_variety`.`id` AS `id`,`grm_self`.`sc_grain_variety`.`name` AS `name` from `grm_self`.`sc_grain_variety`) `grain_variety` on((`contract`.`grain_variety_id` = `grain_variety`.`id`))) left join (select `grm_self`.`bt_grain_type`.`id` AS `id`,`grm_self`.`bt_grain_type`.`name` AS `name` from `grm_self`.`bt_grain_type`) `grain_type` on((`contract`.`grain_type_id` = `grain_type`.`id`))) order by `contract`.`business_key` desc */;

/*View structure for view gb_material_sum */

/*!50001 DROP TABLE IF EXISTS `gb_material_sum` */;
/*!50001 DROP VIEW IF EXISTS `gb_material_sum` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gb_material_sum` AS select `in_result`.`id` AS `id`,`in_result`.`type_id` AS `type_id`,`in_result`.`name` AS `name`,ifnull(`out_result`.`out_amount`,0) AS `out_amount`,ifnull(`in_result`.`in_amount`,0) AS `in_amount`,(ifnull(`in_result`.`in_amount`,0) - ifnull(`out_result`.`out_amount`,0)) AS `total` from (((select `stock`.`id` AS `id`,`stock`.`type_id` AS `type_id`,`t2`.`name` AS `name`,sum(`stock`.`amount`) AS `in_amount` from (`grm_self`.`gb_material_stock` `stock` join `grm_self`.`bt_material_type` `t2` on((`stock`.`type_id` = `t2`.`id`))) group by `t2`.`name`)) `in_result` left join (select `request`.`type_id` AS `type_id`,`t`.`name` AS `name`,sum(`request`.`amount`) AS `out_amount` from (`grm_self`.`gb_material_request` `request` join `grm_self`.`bt_material_type` `t` on((`request`.`type_id` = `t`.`id`))) group by `t`.`name`) `out_result` on((`out_result`.`type_id` = `in_result`.`type_id`))) */;

/*View structure for view gb_medicine_sum */

/*!50001 DROP TABLE IF EXISTS `gb_medicine_sum` */;
/*!50001 DROP VIEW IF EXISTS `gb_medicine_sum` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gb_medicine_sum` AS select `in_result`.`id` AS `id`,`in_result`.`type_id` AS `type_id`,`in_result`.`name` AS `name`,ifnull(`out_result`.`out_amount`,0) AS `out_amount`,ifnull(`in_result`.`in_amount`,0) AS `in_amount`,(ifnull(`in_result`.`in_amount`,0) - ifnull(`out_result`.`out_amount`,0)) AS `total` from (((select `stock`.`id` AS `id`,`stock`.`type_id` AS `type_id`,`t2`.`name` AS `name`,(sum((`stock`.`amount` * `s2`.`factor`)) / 1000) AS `in_amount` from ((`grm_self`.`gb_medicine_stock` `stock` join `grm_self`.`bt_medicine_type` `t2` on((`stock`.`type_id` = `t2`.`id`))) join `grm_self`.`bt_scale` `s2` on((`stock`.`scale_id` = `s2`.`id`))) group by `t2`.`name`)) `in_result` left join (select `request`.`type_id` AS `type_id`,`t`.`name` AS `name`,(sum((`request`.`amount` * `s`.`factor`)) / 1000) AS `out_amount` from ((`grm_self`.`gb_medicine_request` `request` join `grm_self`.`bt_medicine_type` `t` on((`request`.`type_id` = `t`.`id`))) join `grm_self`.`bt_scale` `s` on((`request`.`scale_id` = `s`.`id`))) group by `t`.`name`) `out_result` on((`out_result`.`type_id` = `in_result`.`type_id`))) */;

/*View structure for view gb_stock_agg */

/*!50001 DROP TABLE IF EXISTS `gb_stock_agg` */;
/*!50001 DROP VIEW IF EXISTS `gb_stock_agg` */;

/*!50001 CREATE ALGORITHM=TEMPTABLE DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gb_stock_agg` AS select concat(`sas`.`id`,'-',`saa`.`id`) AS `id`,`sat`.`stock_id` AS `stock_id`,`sas`.`id` AS `sas_id`,`saa`.`id` AS `saa_id`,`sas`.`cargo_id` AS `cargo_id`,`cargo_table`.`compartment_id` AS `compartment_id`,`compartment_table`.`store_id` AS `store_id`,`store_table`.`depot_id` AS `depot_id`,`sas`.`grain_type_id` AS `grain_type_id`,`sas`.`grain_variety_id` AS `grain_variety_id`,`sas`.`year` AS `year`,`sas`.`package_type_id` AS `package_type_id`,`sas`.`package_category_id` AS `package_category_id`,`sas`.`location` AS `location`,`sas`.`business_key` AS `business_key`,`sas`.`input_time` AS `input_time`,`sas`.`in_time` AS `in_time`,`sas`.`in_finished` AS `in_finished`,`sas`.`out_time` AS `out_time`,`sas`.`out_finished` AS `out_finished`,`sas`.`amount` AS `amount`,`sas`.`_unit_weight` AS `_unit_weight`,`sas`.`_deduct_volume` AS `_deduct_volume`,`sas`.`_factor` AS `_factor`,`sas`.`water_amount` AS `water_amount`,`sas`.`impurity_amount` AS `impurity_amount`,`sas`.`in_amount` AS `in_amount`,`sas`.`out_amount` AS `out_amount`,`saa`.`analysis_type_id` AS `analysis_type_id`,`saa`.`analysis_level_id` AS `analysis_level_id`,`saa`.`a1` AS `a1`,`saa`.`a2` AS `a2`,`saa`.`a3` AS `a3`,`saa`.`a4` AS `a4`,`saa`.`a5` AS `a5`,`saa`.`a6` AS `a6`,`saa`.`a7` AS `a7`,`saa`.`a8` AS `a8`,`saa`.`a9` AS `a9`,`saa`.`a10` AS `a10`,`saa`.`a11` AS `a11`,`saa`.`a12` AS `a12`,`saa`.`a13` AS `a13`,`saa`.`a14` AS `a14`,`saa`.`a15` AS `a15`,`saa`.`s1` AS `s1`,`saa`.`s2` AS `s2`,`saa`.`s3` AS `s3`,`saa`.`s4` AS `s4`,`saa`.`s5` AS `s5`,`sat`.`time` AS `time`,concat(lpad(`depot_table`.`code_id`,3,'0'),lpad(`store_table`.`code_id`,3,'0'),lpad(`compartment_table`.`code_id`,2,'0'),lpad(`cargo_table`.`code_id`,3,'0')) AS `code`,concat(`depot_table`.`abbrev`,`store_table`.`name`,'(',`cargo_table`.`name`,') - ',`sas`.`business_key`) AS `cargo_name`,concat(`depot_table`.`abbrev`,`store_table`.`name`,'(',`cargo_table`.`name`,')') AS `short_name` from ((((((((select `time_table`.`time` AS `time`,`time_table`.`stock_id` AS `stock_id`,max(`sas1`.`time`) AS `s_time`,max(`saa1`.`time`) AS `a_time` from ((`grm_self`.`gb_stock_agg_time` `time_table` left join `grm_self`.`gb_stock_agg_sum` `sas1` on(((`sas1`.`stock_id` = `time_table`.`stock_id`) and (`time_table`.`time` >= `sas1`.`time`)))) left join `grm_self`.`gb_stock_agg_analysis` `saa1` on(((`saa1`.`stock_id` = `time_table`.`stock_id`) and (`time_table`.`time` >= `saa1`.`time`)))) group by `time_table`.`u_id`)) `sat` left join `grm_self`.`gb_stock_agg_sum` `sas` on(((`sat`.`s_time` = `sas`.`time`) and (`sat`.`stock_id` = `sas`.`stock_id`)))) left join `grm_self`.`gb_stock_agg_analysis` `saa` on(((`sat`.`a_time` = `saa`.`time`) and (`sat`.`stock_id` = `saa`.`stock_id`)))) left join (select `grm_self`.`grm_cargo`.`compartment_id` AS `compartment_id`,`grm_self`.`grm_cargo`.`code_id` AS `code_id`,`grm_self`.`grm_cargo`.`name` AS `name`,`grm_self`.`grm_cargo`.`id` AS `id` from `grm_self`.`grm_cargo`) `cargo_table` on((`cargo_table`.`id` = `sas`.`cargo_id`))) left join (select `grm_self`.`grm_compartment`.`store_id` AS `store_id`,`grm_self`.`grm_compartment`.`code_id` AS `code_id`,`grm_self`.`grm_compartment`.`id` AS `id` from `grm_self`.`grm_compartment`) `compartment_table` on((`compartment_table`.`id` = `cargo_table`.`compartment_id`))) left join (select `grm_self`.`grm_store`.`code_id` AS `code_id`,`grm_self`.`grm_store`.`name` AS `name`,`grm_self`.`grm_store`.`depot_id` AS `depot_id`,`grm_self`.`grm_store`.`id` AS `id` from `grm_self`.`grm_store`) `store_table` on((`store_table`.`id` = `compartment_table`.`store_id`))) left join (select `grm_self`.`grm_depot`.`abbrev` AS `abbrev`,`grm_self`.`grm_depot`.`code_id` AS `code_id`,`grm_self`.`grm_depot`.`id` AS `id` from `grm_self`.`grm_depot`) `depot_table` on((`store_table`.`depot_id` = `depot_table`.`id`))) order by `sat`.`time` desc */;

/*View structure for view gb_stock_agg_analysis */

/*!50001 DROP TABLE IF EXISTS `gb_stock_agg_analysis` */;
/*!50001 DROP VIEW IF EXISTS `gb_stock_agg_analysis` */;

/*!50001 CREATE ALGORITHM=TEMPTABLE DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gb_stock_agg_analysis` AS select concat('A-',`current_stock`.`id`,'-',ifnull(`stock_analyses`.`id`,0)) AS `id`,`current_stock`.`id` AS `stock_id`,`stock_analyses`.`analysis_type_id` AS `analysis_type_id`,`stock_analyses`.`analysis_level_id` AS `analysis_level_id`,`stock_analyses`.`a1` AS `a1`,`stock_analyses`.`a2` AS `a2`,`stock_analyses`.`a3` AS `a3`,`stock_analyses`.`a4` AS `a4`,`stock_analyses`.`a5` AS `a5`,`stock_analyses`.`a6` AS `a6`,`stock_analyses`.`a7` AS `a7`,`stock_analyses`.`a8` AS `a8`,`stock_analyses`.`a9` AS `a9`,`stock_analyses`.`a10` AS `a10`,`stock_analyses`.`a11` AS `a11`,`stock_analyses`.`a12` AS `a12`,`stock_analyses`.`a13` AS `a13`,`stock_analyses`.`a14` AS `a14`,`stock_analyses`.`a15` AS `a15`,`stock_analyses`.`s1` AS `s1`,`stock_analyses`.`s2` AS `s2`,`stock_analyses`.`s3` AS `s3`,`stock_analyses`.`s4` AS `s4`,`stock_analyses`.`s5` AS `s5`,ifnull(`stock_analyses`.`input_time`,`current_stock`.`input_time`) AS `time` from (((select `s1`.`id` AS `id`,`s1`.`input_time` AS `input_time` from `grm_self`.`gb_stock_id` `s1`)) `current_stock` left join (select `sa`.`id` AS `id`,`sa`.`a1` AS `a1`,`sa`.`stock_id` AS `stock_id`,`sa`.`analysis_type_id` AS `analysis_type_id`,`sa`.`analysis_level_id` AS `analysis_level_id`,`sa`.`input_time` AS `input_time`,`sa`.`a2` AS `a2`,`sa`.`a3` AS `a3`,`sa`.`a4` AS `a4`,`sa`.`a5` AS `a5`,`sa`.`a6` AS `a6`,`sa`.`a7` AS `a7`,`sa`.`a8` AS `a8`,`sa`.`a9` AS `a9`,`sa`.`a10` AS `a10`,`sa`.`a11` AS `a11`,`sa`.`a12` AS `a12`,`sa`.`a13` AS `a13`,`sa`.`a14` AS `a14`,`sa`.`a15` AS `a15`,`sa`.`s1` AS `s1`,`sa`.`s2` AS `s2`,`sa`.`s3` AS `s3`,`sa`.`s4` AS `s4`,`sa`.`s5` AS `s5` from `grm_self`.`gb_stock_analysis` `sa`) `stock_analyses` on((`stock_analyses`.`stock_id` = `current_stock`.`id`))) */;

/*View structure for view gb_stock_agg_sum */

/*!50001 DROP TABLE IF EXISTS `gb_stock_agg_sum` */;
/*!50001 DROP VIEW IF EXISTS `gb_stock_agg_sum` */;

/*!50001 CREATE ALGORITHM=TEMPTABLE DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gb_stock_agg_sum` AS select concat('S-',`current_stock`.`id`,'-',ifnull(`stock_changes`.`id`,0)) AS `id`,`current_stock`.`id` AS `stock_id`,`current_stock`.`cargo_id` AS `cargo_id`,`current_stock`.`grain_type_id` AS `grain_type_id`,`current_stock`.`grain_variety_id` AS `grain_variety_id`,`current_stock`.`year` AS `year`,`current_stock`.`package_type_id` AS `package_type_id`,`current_stock`.`package_category_id` AS `package_category_id`,`current_stock`.`location` AS `location`,`current_stock`.`business_key` AS `business_key`,`current_stock`.`inputer_id` AS `inputer_id`,`current_stock`.`input_comment` AS `input_comment`,`current_stock`.`input_time` AS `input_time`,`current_stock`.`auditor_id` AS `auditor_id`,`current_stock`.`audit_time` AS `audit_time`,`current_stock`.`audit_comment` AS `audit_comment`,`current_stock`.`in_time` AS `in_time`,`current_stock`.`in_finished` AS `in_finished`,`current_stock`.`out_time` AS `out_time`,`current_stock`.`out_finished` AS `out_finished`,`current_stock`.`_unit_weight` AS `_unit_weight`,`current_stock`.`_deduct_volume` AS `_deduct_volume`,`current_stock`.`_factor` AS `_factor`,`stock_changes`.`water_amount` AS `water_amount`,`stock_changes`.`impurity_amount` AS `impurity_amount`,ifnull(`current_stock`.`amount`,0) AS `amount`,ifnull(`stock_changes`.`in_amount`,0) AS `in_amount`,ifnull(`stock_changes`.`out_amount`,0) AS `out_amount`,ifnull(`stock_changes`.`input_time`,`current_stock`.`input_time`) AS `time` from (((select `s1`.`id` AS `id`,`s1`.`cargo_id` AS `cargo_id`,`s1`.`grain_type_id` AS `grain_type_id`,`s1`.`grain_variety_id` AS `grain_variety_id`,`s1`.`year` AS `year`,`s1`.`amount` AS `amount`,`s1`.`package_type_id` AS `package_type_id`,`s1`.`package_category_id` AS `package_category_id`,`s1`.`location` AS `location`,`s1`.`business_key` AS `business_key`,`s1`.`inputer_id` AS `inputer_id`,`s1`.`input_comment` AS `input_comment`,`s1`.`input_time` AS `input_time`,`s1`.`input_time` AS `time`,`s1`.`auditor_id` AS `auditor_id`,`s1`.`audit_time` AS `audit_time`,`s1`.`audit_comment` AS `audit_comment`,`s1`.`in_time` AS `in_time`,`s1`.`out_time` AS `out_time`,`s1`.`in_finished` AS `in_finished`,`s1`.`_unit_weight` AS `_unit_weight`,`s1`.`_deduct_volume` AS `_deduct_volume`,`s1`.`_factor` AS `_factor`,`s1`.`out_finished` AS `out_finished` from `grm_self`.`gb_stock_id` `s1`)) `current_stock` join ((select `sc2`.`id` AS `id`,`sc2`.`target_stock_id` AS `stock_id`,`sc2`.`input_time` AS `input_time`,(select (sum(ifnull((`sc1`.`amount` * `sc1`.`water`),0)) / 100) from `grm_self`.`gb_stock_change` `sc1` where ((`sc1`.`target_stock_id` = `sc2`.`target_stock_id`) and (`sc2`.`input_time` >= `sc1`.`input_time`))) AS `water_amount`,(select (sum(ifnull((`sc1`.`amount` * `sc1`.`impurity`),0)) / 100) from `grm_self`.`gb_stock_change` `sc1` where ((`sc1`.`target_stock_id` = `sc2`.`target_stock_id`) and (`sc2`.`input_time` >= `sc1`.`input_time`))) AS `impurity_amount`,(select sum(ifnull(`sc3`.`amount`,0)) from `grm_self`.`gb_stock_change` `sc3` where ((`sc3`.`source_stock_id` = `sc2`.`target_stock_id`) and (`sc2`.`input_time` >= `sc3`.`input_time`))) AS `out_amount`,(select sum(`sc1`.`amount`) from `grm_self`.`gb_stock_change` `sc1` where ((`sc1`.`target_stock_id` = `sc2`.`target_stock_id`) and (`sc2`.`input_time` >= `sc1`.`input_time`))) AS `in_amount` from `grm_self`.`gb_stock_change` `sc2` where ((`sc2`.`target_stock_id` is not null) and (`sc2`.`amount` is not null))) union (select `scc2`.`id` AS `id`,`scc2`.`source_stock_id` AS `stock_id`,`scc2`.`input_time` AS `input_time`,0 AS `water_amount`,0 AS `impurity_amount`,(select sum(`scc1`.`amount`) from `grm_self`.`gb_stock_change` `scc1` where ((`scc1`.`source_stock_id` = `scc2`.`source_stock_id`) and (`scc2`.`input_time` >= `scc1`.`input_time`))) AS `out_amount`,(select sum(ifnull(`scc3`.`amount`,0)) from `grm_self`.`gb_stock_change` `scc3` where ((`scc3`.`target_stock_id` = `scc2`.`source_stock_id`) and (`scc2`.`input_time` >= `scc3`.`input_time`))) AS `in_amount` from `grm_self`.`gb_stock_change` `scc2` where ((`scc2`.`source_stock_id` is not null) and (`scc2`.`amount` is not null)))) `stock_changes` on((`stock_changes`.`stock_id` = `current_stock`.`id`))) union (select concat('S-',`current_stock`.`id`,'-',0) AS `id`,`current_stock`.`id` AS `stock_id`,`current_stock`.`cargo_id` AS `cargo_id`,`current_stock`.`grain_type_id` AS `grain_type_id`,`current_stock`.`grain_variety_id` AS `grain_variety_id`,`current_stock`.`year` AS `year`,`current_stock`.`package_type_id` AS `package_type_id`,`current_stock`.`package_category_id` AS `package_category_id`,`current_stock`.`location` AS `location`,`current_stock`.`business_key` AS `business_key`,`current_stock`.`inputer_id` AS `inputer_id`,`current_stock`.`input_comment` AS `input_comment`,`current_stock`.`input_time` AS `input_time`,`current_stock`.`auditor_id` AS `auditor_id`,`current_stock`.`audit_time` AS `audit_time`,`current_stock`.`audit_comment` AS `audit_comment`,`current_stock`.`in_time` AS `in_time`,`current_stock`.`in_finished` AS `in_finished`,`current_stock`.`out_time` AS `out_time`,`current_stock`.`out_finished` AS `out_finished`,`current_stock`.`_unit_weight` AS `_unit_weight`,`current_stock`.`_deduct_volume` AS `_deduct_volume`,`current_stock`.`_factor` AS `_factor`,0 AS `water_amount`,0 AS `impurity_amount`,ifnull(`current_stock`.`amount`,0) AS `amount`,0 AS `in_amount`,0 AS `out_amount`,`current_stock`.`input_time` AS `time` from ((select `s1`.`id` AS `id`,`s1`.`cargo_id` AS `cargo_id`,`s1`.`grain_type_id` AS `grain_type_id`,`s1`.`grain_variety_id` AS `grain_variety_id`,`s1`.`year` AS `year`,`s1`.`amount` AS `amount`,`s1`.`package_type_id` AS `package_type_id`,`s1`.`package_category_id` AS `package_category_id`,`s1`.`location` AS `location`,`s1`.`business_key` AS `business_key`,`s1`.`inputer_id` AS `inputer_id`,`s1`.`input_comment` AS `input_comment`,`s1`.`input_time` AS `input_time`,`s1`.`input_time` AS `time`,`s1`.`auditor_id` AS `auditor_id`,`s1`.`audit_time` AS `audit_time`,`s1`.`audit_comment` AS `audit_comment`,`s1`.`in_time` AS `in_time`,`s1`.`out_time` AS `out_time`,`s1`.`in_finished` AS `in_finished`,`s1`.`_unit_weight` AS `_unit_weight`,`s1`.`_deduct_volume` AS `_deduct_volume`,`s1`.`_factor` AS `_factor`,`s1`.`out_finished` AS `out_finished` from `grm_self`.`gb_stock_id` `s1`)) `current_stock`) */;

/*View structure for view gb_stock_agg_time */

/*!50001 DROP TABLE IF EXISTS `gb_stock_agg_time` */;
/*!50001 DROP VIEW IF EXISTS `gb_stock_agg_time` */;

/*!50001 CREATE ALGORITHM=TEMPTABLE DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gb_stock_agg_time` AS (select `as`.`stock_id` AS `stock_id`,`as`.`time` AS `time`,`as`.`id` AS `u_id` from `grm_self`.`gb_stock_agg_sum` `as`) union (select `aa`.`stock_id` AS `stock_id`,`aa`.`time` AS `time`,`aa`.`id` AS `u_id` from `grm_self`.`gb_stock_agg_analysis` `aa`) order by `stock_id` */;

/*View structure for view gb_stock_change_representation */

/*!50001 DROP TABLE IF EXISTS `gb_stock_change_representation` */;
/*!50001 DROP VIEW IF EXISTS `gb_stock_change_representation` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gb_stock_change_representation` AS select `sc`.`id` AS `id`,`sc`.`type_id` AS `type_id`,`sc`.`source_stock_id` AS `source_stock_id`,`sc`.`target_stock_id` AS `target_stock_id`,`sc`.`amount` AS `amount`,`sc`.`contract_id` AS `contract_id`,`sc`.`package_category_id` AS `package_category_id`,`sc`.`water` AS `water`,`sc`.`analysis_level_id` AS `analysis_level_id`,`sc`.`impurity` AS `impurity`,`sc`.`grain_type_id` AS `grain_type_id`,`sc`.`grain_variety_id` AS `grain_variety_id`,`sc`.`pack` AS `pack`,`sc`.`business_key` AS `business_key`,`sc`.`inputer_id` AS `inputer_id`,`sc`.`input_comment` AS `input_comment`,`sc`.`input_time` AS `input_time`,`sc`.`auditor_id` AS `auditor_id`,`sc`.`audit_time` AS `audit_time`,`sc`.`audit_comment` AS `audit_comment`,(case when (`sc`.`type_id` = 1) then concat('从',`sr`.`short_name`,'转堆到',`sr2`.`short_name`) when (`sc`.`type_id` = 2) then concat(`client`.`name`,'调入') when (`sc`.`type_id` = 3) then concat(`client`.`name`,'提货') when (`sc`.`type_id` = 4) then '溢收' when (`sc`.`type_id` = 5) then '损耗' else NULL end) AS `content`,concat(`sc`.`business_key`,'-',(case when (`sc`.`type_id` = 1) then concat('从',`sr`.`short_name`,'转堆到',`sr2`.`short_name`,'-') when (`sc`.`type_id` = 2) then concat(`client`.`name`,'调入-',`sr2`.`short_name`) when (`sc`.`type_id` = 3) then concat(`client`.`name`,'提货-',`sr`.`short_name`) when (`sc`.`type_id` = 4) then concat('溢收-',`sr2`.`short_name`) when (`sc`.`type_id` = 5) then concat('损耗-',`sr`.`short_name`) else NULL end)) AS `rep_name`,(case when (`sc`.`type_id` = 1) then concat(`sr`.`short_name`,'转堆到',`sr2`.`short_name`,' - ') when (`sc`.`type_id` = 2) then `sr2`.`short_name` when (`sc`.`type_id` = 3) then `sr`.`short_name` when (`sc`.`type_id` = 4) then `sr2`.`short_name` when (`sc`.`type_id` = 5) then `sr`.`short_name` else NULL end) AS `cargo_name` from ((((`grm_self`.`gb_stock_change` `sc` left join `grm_self`.`gb_stock_full` `sr` on((`sc`.`source_stock_id` = `sr`.`id`))) left join `grm_self`.`gb_stock_full` `sr2` on((`sc`.`target_stock_id` = `sr2`.`id`))) left join `grm_self`.`gb_contract` `contract` on((`contract`.`id` = `sc`.`contract_id`))) left join `grm_self`.`gb_client` `client` on((`client`.`id` = `contract`.`client_id`))) */;

/*View structure for view gb_stock_full */

/*!50001 DROP TABLE IF EXISTS `gb_stock_full` */;
/*!50001 DROP VIEW IF EXISTS `gb_stock_full` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gb_stock_full` AS select `si`.`id` AS `id`,`depot_table`.`id` AS `depot_id`,`store_table`.`id` AS `store_id`,`si`.`cargo_id` AS `cargo_id`,`si`.`grain_type_id` AS `grain_type_id`,`si`.`grain_variety_id` AS `grain_variety_id`,`si`.`year` AS `year`,`si`.`amount` AS `amount`,`si`.`package_type_id` AS `package_type_id`,`si`.`package_category_id` AS `package_category_id`,`si`.`location` AS `location`,`si`.`country_id` AS `country_id`,`si`.`business_key` AS `business_key`,`si`.`inputer_id` AS `inputer_id`,`si`.`input_comment` AS `input_comment`,`si`.`input_time` AS `input_time`,`si`.`auditor_id` AS `auditor_id`,`si`.`audit_time` AS `audit_time`,`si`.`audit_comment` AS `audit_comment`,`si`.`in_finished` AS `in_finished`,`si`.`out_finished` AS `out_finished`,`si`.`in_time` AS `in_time`,`si`.`out_time` AS `out_time`,`si`.`in_analysis_id` AS `in_analysis_id`,`si`.`out_analysis_id` AS `out_analysis_id`,`si`.`_unit_weight` AS `_unit_weight`,`si`.`_deduct_volume` AS `_deduct_volume`,`si`.`_factor` AS `_factor`,concat(lpad(`depot_table`.`code_id`,3,'0'),lpad(`store_table`.`code_id`,3,'0'),lpad(`compartment_table`.`code_id`,2,'0'),lpad(`cargo_table`.`code_id`,3,'0')) AS `code`,concat(`depot_table`.`abbrev`,`store_table`.`name`,'(',`cargo_table`.`name`,') ',if(`si`.`out_finished`,'已出库','进行中'),' - ',`si`.`business_key`) AS `cargo_name`,concat(`depot_table`.`abbrev`,`store_table`.`name`,'(',`cargo_table`.`name`,')') AS `short_name` from ((((`grm_self`.`gb_stock_id` `si` left join (select `grm_self`.`grm_cargo`.`compartment_id` AS `compartment_id`,`grm_self`.`grm_cargo`.`code_id` AS `code_id`,`grm_self`.`grm_cargo`.`name` AS `name`,`grm_self`.`grm_cargo`.`id` AS `id` from `grm_self`.`grm_cargo`) `cargo_table` on((`cargo_table`.`id` = `si`.`cargo_id`))) left join (select `grm_self`.`grm_compartment`.`store_id` AS `store_id`,`grm_self`.`grm_compartment`.`code_id` AS `code_id`,`grm_self`.`grm_compartment`.`id` AS `id` from `grm_self`.`grm_compartment`) `compartment_table` on((`compartment_table`.`id` = `cargo_table`.`compartment_id`))) left join (select `grm_self`.`grm_store`.`code_id` AS `code_id`,`grm_self`.`grm_store`.`name` AS `name`,`grm_self`.`grm_store`.`depot_id` AS `depot_id`,`grm_self`.`grm_store`.`id` AS `id` from `grm_self`.`grm_store`) `store_table` on((`store_table`.`id` = `compartment_table`.`store_id`))) left join (select `grm_self`.`grm_depot`.`abbrev` AS `abbrev`,`grm_self`.`grm_depot`.`code_id` AS `code_id`,`grm_self`.`grm_depot`.`id` AS `id` from `grm_self`.`grm_depot`) `depot_table` on((`store_table`.`depot_id` = `depot_table`.`id`))) order by `depot_table`.`id`,`si`.`out_finished`,`store_table`.`id`,`compartment_table`.`id`,`cargo_table`.`id`,`si`.`input_time` desc */;

/*View structure for view gb_stock_r_root */

/*!50001 DROP TABLE IF EXISTS `gb_stock_r_root` */;
/*!50001 DROP VIEW IF EXISTS `gb_stock_r_root` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gb_stock_r_root` AS select `si`.`id` AS `id`,`si`.`cargo_id` AS `cargo_id`,`si`.`input_time` AS `input_time`,`si`.`out_finished` AS `out_finished`,`si`.`business_key` AS `business_key`,concat(lpad(`depot_table`.`code_id`,3,'0'),lpad(`store_table`.`code_id`,3,'0'),lpad(`compartment_table`.`code_id`,2,'0'),lpad(`cargo_table`.`code_id`,3,'0')) AS `code`,concat(`depot_table`.`abbrev`,`store_table`.`name`,'(',`cargo_table`.`name`,')') AS `cargo_name` from ((((`grm_self`.`gb_stock_id` `si` left join (select `grm_self`.`grm_cargo`.`compartment_id` AS `compartment_id`,`grm_self`.`grm_cargo`.`code_id` AS `code_id`,`grm_self`.`grm_cargo`.`name` AS `name`,`grm_self`.`grm_cargo`.`id` AS `id` from `grm_self`.`grm_cargo`) `cargo_table` on((`cargo_table`.`id` = `si`.`cargo_id`))) left join (select `grm_self`.`grm_compartment`.`store_id` AS `store_id`,`grm_self`.`grm_compartment`.`code_id` AS `code_id`,`grm_self`.`grm_compartment`.`id` AS `id` from `grm_self`.`grm_compartment`) `compartment_table` on((`compartment_table`.`id` = `cargo_table`.`compartment_id`))) left join (select `grm_self`.`grm_store`.`code_id` AS `code_id`,`grm_self`.`grm_store`.`name` AS `name`,`grm_self`.`grm_store`.`depot_id` AS `depot_id`,`grm_self`.`grm_store`.`id` AS `id` from `grm_self`.`grm_store`) `store_table` on((`store_table`.`id` = `compartment_table`.`store_id`))) left join (select `grm_self`.`grm_depot`.`abbrev` AS `abbrev`,`grm_self`.`grm_depot`.`code_id` AS `code_id`,`grm_self`.`grm_depot`.`id` AS `id` from `grm_self`.`grm_depot`) `depot_table` on((`store_table`.`depot_id` = `depot_table`.`id`))) where (`si`.`cargo_id` is not null) */;

/*View structure for view gb_stock_representation */

/*!50001 DROP TABLE IF EXISTS `gb_stock_representation` */;
/*!50001 DROP VIEW IF EXISTS `gb_stock_representation` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gb_stock_representation` AS select `s1`.`id` AS `id`,`s1`.`input_time` AS `input_time`,`s1`.`business_key` AS `business_key`,`s1`.`code` AS `code`,`s1`.`cargo_name` AS `cargo_name`,concat(`s1`.`cargo_name`,' - ',`s1`.`business_key`) AS `verbose_name`,if(((`s1`.`input_time` = `s2`.`latest`) and (`s1`.`out_finished` <> 1)),1,0) AS `is_current` from (`grm_self`.`gb_stock_r_root` `s1` join (select max(`gb_stock_r_root`.`input_time`) AS `latest`,`gb_stock_r_root`.`cargo_id` AS `cargo_id` from `grm_self`.`gb_stock_r_root` group by `gb_stock_r_root`.`cargo_id`) `s2` on((`s1`.`cargo_id` = `s2`.`cargo_id`))) order by `s1`.`code`,`s1`.`input_time` desc */;

/*View structure for view gb_stock_sum */

/*!50001 DROP TABLE IF EXISTS `gb_stock_sum` */;
/*!50001 DROP VIEW IF EXISTS `gb_stock_sum` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gb_stock_sum` AS select `current_stock`.`id` AS `id`,concat(lpad(`depot_table`.`code_id`,3,'0'),lpad(`store_table`.`code_id`,3,'0'),lpad(`compartment_table`.`code_id`,2,'0'),lpad(`cargo_table`.`code_id`,3,'0')) AS `code`,concat(`depot_table`.`abbrev`,`store_table`.`name`,'(',`cargo_table`.`name`,') ',`current_stock`.`business_key`) AS `cargo_name`,concat(`depot_table`.`abbrev`,`store_table`.`name`,'(',`cargo_table`.`name`,')') AS `cargo_name_short`,`depot_table`.`id` AS `depot_id`,`store_table`.`id` AS `store_id`,`compartment_table`.`id` AS `compartment_id`,`current_stock`.`cargo_id` AS `cargo_id`,`current_stock`.`grain_type_id` AS `grain_type_id`,`current_stock`.`grain_variety_id` AS `grain_variety_id`,`current_stock`.`year` AS `year`,ifnull(`current_stock`.`amount`,0) AS `amount`,`current_stock`.`package_type_id` AS `package_type_id`,`current_stock`.`package_category_id` AS `package_category_id`,`current_stock`.`location` AS `location`,`current_stock`.`country_id` AS `country_id`,`current_stock`.`business_key` AS `business_key`,`current_stock`.`inputer_id` AS `inputer_id`,`current_stock`.`input_comment` AS `input_comment`,`current_stock`.`input_time` AS `input_time`,`current_stock`.`auditor_id` AS `auditor_id`,`current_stock`.`audit_time` AS `audit_time`,`current_stock`.`audit_comment` AS `audit_comment`,`current_stock`.`in_time` AS `in_time`,`current_stock`.`in_finished` AS `in_finished`,`current_stock`.`out_time` AS `out_time`,`current_stock`.`out_finished` AS `out_finished`,`current_stock`.`_unit_weight` AS `_unit_weight`,`current_stock`.`_deduct_volume` AS `_deduct_volume`,`current_stock`.`_factor` AS `_factor`,`latest_exam`.`analysis_level_id` AS `l_analysis_level_id`,`latest_exam`.`s1` AS `l_s1`,`latest_exam`.`s2` AS `l_s2`,`latest_exam`.`s3` AS `l_s3`,`latest_exam`.`s4` AS `l_s4`,`latest_exam`.`s5` AS `l_s5`,`latest_exam`.`a1` AS `l_a1`,`latest_exam`.`a2` AS `l_a2`,`latest_exam`.`a3` AS `l_a3`,`latest_exam`.`a4` AS `l_a4`,`latest_exam`.`a5` AS `l_a5`,`latest_exam`.`a6` AS `l_a6`,`latest_exam`.`a7` AS `l_a7`,`latest_exam`.`a8` AS `l_a8`,`latest_exam`.`a9` AS `l_a9`,`latest_exam`.`a10` AS `l_a10`,`latest_exam`.`a11` AS `l_a11`,`latest_exam`.`a12` AS `l_a12`,`latest_exam`.`a13` AS `l_a13`,`latest_exam`.`a14` AS `l_a14`,`latest_exam`.`a15` AS `l_a15`,`latest_exam`.`a16` AS `l_a16`,`latest_exam`.`a17` AS `l_a17`,`in_exam`.`analysis_level_id` AS `i_analysis_level_id`,`in_exam`.`s1` AS `i_s1`,`in_exam`.`s2` AS `i_s2`,`in_exam`.`s3` AS `i_s3`,`in_exam`.`s4` AS `i_s4`,`in_exam`.`s5` AS `i_s5`,`in_exam`.`a1` AS `i_a1`,`in_exam`.`a2` AS `i_a2`,`in_exam`.`a3` AS `i_a3`,`in_exam`.`a4` AS `i_a4`,`in_exam`.`a5` AS `i_a5`,`in_exam`.`a6` AS `i_a6`,`in_exam`.`a7` AS `i_a7`,`in_exam`.`a8` AS `i_a8`,`in_exam`.`a9` AS `i_a9`,`in_exam`.`a10` AS `i_a10`,`in_exam`.`a11` AS `i_a11`,`in_exam`.`a12` AS `i_a12`,`in_exam`.`a13` AS `i_a13`,`in_exam`.`a14` AS `i_a14`,`in_exam`.`a15` AS `i_a15`,`in_exam`.`a16` AS `i_a16`,`in_exam`.`a17` AS `i_a17`,`out_exam`.`analysis_level_id` AS `o_analysis_level_id`,`out_exam`.`s1` AS `o_s1`,`out_exam`.`s2` AS `o_s2`,`out_exam`.`s3` AS `o_s3`,`out_exam`.`s4` AS `o_s4`,`out_exam`.`s5` AS `o_s5`,`out_exam`.`a1` AS `o_a1`,`out_exam`.`a2` AS `o_a2`,`out_exam`.`a3` AS `o_a3`,`out_exam`.`a4` AS `o_a4`,`out_exam`.`a5` AS `o_a5`,`out_exam`.`a6` AS `o_a6`,`out_exam`.`a7` AS `o_a7`,`out_exam`.`a8` AS `o_a8`,`out_exam`.`a9` AS `o_a9`,`out_exam`.`a10` AS `o_a10`,`out_exam`.`a11` AS `o_a11`,`out_exam`.`a12` AS `o_a12`,`out_exam`.`a13` AS `o_a13`,`out_exam`.`a14` AS `o_a14`,`out_exam`.`a15` AS `o_a15`,`out_exam`.`a16` AS `o_a16`,`out_exam`.`a17` AS `o_a17`,ifnull(`out_stock`.`out_amount`,0) AS `out_amount`,ifnull(`in_stock`.`in_amount`,0) AS `in_amount`,ifnull(`in_stock`.`in_pack`,0) AS `in_pack`,ifnull(`out_stock`.`out_pack`,0) AS `out_pack` from (((((((((((select `s1`.`id` AS `id`,`s1`.`cargo_id` AS `cargo_id`,`s1`.`grain_type_id` AS `grain_type_id`,`s1`.`grain_variety_id` AS `grain_variety_id`,`s1`.`year` AS `year`,`s1`.`amount` AS `amount`,`s1`.`package_type_id` AS `package_type_id`,`s1`.`package_category_id` AS `package_category_id`,`s1`.`location` AS `location`,`s1`.`country_id` AS `country_id`,`s1`.`business_key` AS `business_key`,`s1`.`inputer_id` AS `inputer_id`,`s1`.`input_comment` AS `input_comment`,`s1`.`input_time` AS `input_time`,`s1`.`auditor_id` AS `auditor_id`,`s1`.`audit_time` AS `audit_time`,`s1`.`audit_comment` AS `audit_comment`,`s1`.`in_time` AS `in_time`,`s1`.`out_time` AS `out_time`,`s1`.`in_finished` AS `in_finished`,`s1`.`_unit_weight` AS `_unit_weight`,`s1`.`_deduct_volume` AS `_deduct_volume`,`s1`.`_factor` AS `_factor`,`s1`.`out_finished` AS `out_finished` from (`grm_self`.`gb_stock_id` `s1` join (select max(`grm_self`.`gb_stock_id`.`input_time`) AS `latest`,`grm_self`.`gb_stock_id`.`cargo_id` AS `cargo_id` from `grm_self`.`gb_stock_id` group by `grm_self`.`gb_stock_id`.`cargo_id`) `s2` on(((`s1`.`cargo_id` = `s2`.`cargo_id`) and (`s1`.`input_time` = `s2`.`latest`)))) where (`s1`.`out_finished` <> 1))) `current_stock` left join (select `sco1`.`out_amount` AS `out_amount`,`sco1`.`out_pack` AS `out_pack`,`sco1`.`source_stock_id` AS `source_stock_id` from (select sum(ifnull(`sc1`.`amount`,0)) AS `out_amount`,sum(ifnull(`sc1`.`pack`,0)) AS `out_pack`,`sc1`.`source_stock_id` AS `source_stock_id` from `grm_self`.`gb_stock_change` `sc1` group by `sc1`.`source_stock_id`) `sco1`) `out_stock` on((`out_stock`.`source_stock_id` = `current_stock`.`id`))) left join (select `sco2`.`in_amount` AS `in_amount`,`sco2`.`in_pack` AS `in_pack`,`sco2`.`target_stock_id` AS `target_stock_id` from (select sum(ifnull(`sc2`.`amount`,0)) AS `in_amount`,sum(ifnull(`sc2`.`pack`,0)) AS `in_pack`,`sc2`.`target_stock_id` AS `target_stock_id` from `grm_self`.`gb_stock_change` `sc2` group by `sc2`.`target_stock_id`) `sco2`) `in_stock` on((`in_stock`.`target_stock_id` = `current_stock`.`id`))) left join (select `le1`.`analysis_level_id` AS `analysis_level_id`,`le1`.`s1` AS `s1`,`le1`.`s2` AS `s2`,`le1`.`s3` AS `s3`,`le1`.`s4` AS `s4`,`le1`.`s5` AS `s5`,`le1`.`a1` AS `a1`,`le1`.`a2` AS `a2`,`le1`.`a3` AS `a3`,`le1`.`a4` AS `a4`,`le1`.`a5` AS `a5`,`le1`.`a6` AS `a6`,`le1`.`a7` AS `a7`,`le1`.`a8` AS `a8`,`le1`.`a9` AS `a9`,`le1`.`a10` AS `a10`,`le1`.`a11` AS `a11`,`le1`.`a12` AS `a12`,`le1`.`a13` AS `a13`,`le1`.`a14` AS `a14`,`le1`.`a15` AS `a15`,`le1`.`a16` AS `a16`,`le1`.`a17` AS `a17`,`le1`.`input_time` AS `input_time`,`le1`.`analysis_type_id` AS `analysis_type_id`,`le1`.`stock_id` AS `stock_id` from (`grm_self`.`gb_stock_analysis` `le1` join (select max(`grm_self`.`gb_stock_analysis`.`input_time`) AS `latest`,`grm_self`.`gb_stock_analysis`.`stock_id` AS `stock_id` from `grm_self`.`gb_stock_analysis` group by `grm_self`.`gb_stock_analysis`.`stock_id`) `le2` on(((`le1`.`input_time` = `le2`.`latest`) and (`le1`.`stock_id` = `le2`.`stock_id`))))) `latest_exam` on((`latest_exam`.`stock_id` = `current_stock`.`id`))) left join (select `ie1`.`analysis_level_id` AS `analysis_level_id`,`ie1`.`s1` AS `s1`,`ie1`.`s2` AS `s2`,`ie1`.`s3` AS `s3`,`ie1`.`s4` AS `s4`,`ie1`.`s5` AS `s5`,`ie1`.`a1` AS `a1`,`ie1`.`a2` AS `a2`,`ie1`.`a3` AS `a3`,`ie1`.`a4` AS `a4`,`ie1`.`a5` AS `a5`,`ie1`.`a6` AS `a6`,`ie1`.`a7` AS `a7`,`ie1`.`a8` AS `a8`,`ie1`.`a9` AS `a9`,`ie1`.`a10` AS `a10`,`ie1`.`a11` AS `a11`,`ie1`.`a12` AS `a12`,`ie1`.`a13` AS `a13`,`ie1`.`a14` AS `a14`,`ie1`.`a15` AS `a15`,`ie1`.`a16` AS `a16`,`ie1`.`a17` AS `a17`,`ie1`.`input_time` AS `input_time`,`ie1`.`analysis_type_id` AS `analysis_type_id`,`ie1`.`stock_id` AS `stock_id` from (`grm_self`.`gb_stock_analysis` `ie1` join (select max(`grm_self`.`gb_stock_analysis`.`input_time`) AS `latest`,`grm_self`.`gb_stock_analysis`.`stock_id` AS `stock_id` from `grm_self`.`gb_stock_analysis` where (`grm_self`.`gb_stock_analysis`.`analysis_type_id` = 1) group by `grm_self`.`gb_stock_analysis`.`stock_id`) `ie2` on(((`ie1`.`input_time` = `ie2`.`latest`) and (`ie1`.`stock_id` = `ie2`.`stock_id`)))) where (`ie1`.`analysis_type_id` = 1)) `in_exam` on((`in_exam`.`stock_id` = `current_stock`.`id`))) left join (select `oe1`.`analysis_level_id` AS `analysis_level_id`,`oe1`.`s1` AS `s1`,`oe1`.`s2` AS `s2`,`oe1`.`s3` AS `s3`,`oe1`.`s4` AS `s4`,`oe1`.`s5` AS `s5`,`oe1`.`a1` AS `a1`,`oe1`.`a2` AS `a2`,`oe1`.`a3` AS `a3`,`oe1`.`a4` AS `a4`,`oe1`.`a5` AS `a5`,`oe1`.`a6` AS `a6`,`oe1`.`a7` AS `a7`,`oe1`.`a8` AS `a8`,`oe1`.`a9` AS `a9`,`oe1`.`a10` AS `a10`,`oe1`.`a11` AS `a11`,`oe1`.`a12` AS `a12`,`oe1`.`a13` AS `a13`,`oe1`.`a14` AS `a14`,`oe1`.`a15` AS `a15`,`oe1`.`a16` AS `a16`,`oe1`.`a17` AS `a17`,`oe1`.`input_time` AS `input_time`,`oe1`.`analysis_type_id` AS `analysis_type_id`,`oe1`.`stock_id` AS `stock_id` from (`grm_self`.`gb_stock_analysis` `oe1` join (select max(`grm_self`.`gb_stock_analysis`.`input_time`) AS `latest`,`grm_self`.`gb_stock_analysis`.`stock_id` AS `stock_id` from `grm_self`.`gb_stock_analysis` where (`grm_self`.`gb_stock_analysis`.`analysis_type_id` = 2) group by `grm_self`.`gb_stock_analysis`.`stock_id`) `oe2` on(((`oe1`.`input_time` = `oe2`.`latest`) and (`oe1`.`stock_id` = `oe2`.`stock_id`)))) where (`oe1`.`analysis_type_id` = 2)) `out_exam` on((`out_exam`.`stock_id` = `current_stock`.`id`))) left join (select `grm_self`.`grm_cargo`.`compartment_id` AS `compartment_id`,`grm_self`.`grm_cargo`.`code_id` AS `code_id`,`grm_self`.`grm_cargo`.`name` AS `name`,`grm_self`.`grm_cargo`.`id` AS `id` from `grm_self`.`grm_cargo`) `cargo_table` on((`cargo_table`.`id` = `current_stock`.`cargo_id`))) left join (select `grm_self`.`grm_compartment`.`store_id` AS `store_id`,`grm_self`.`grm_compartment`.`code_id` AS `code_id`,`grm_self`.`grm_compartment`.`id` AS `id` from `grm_self`.`grm_compartment`) `compartment_table` on((`compartment_table`.`id` = `cargo_table`.`compartment_id`))) left join (select `grm_self`.`grm_store`.`code_id` AS `code_id`,`grm_self`.`grm_store`.`name` AS `name`,`grm_self`.`grm_store`.`depot_id` AS `depot_id`,`grm_self`.`grm_store`.`id` AS `id` from `grm_self`.`grm_store`) `store_table` on((`store_table`.`id` = `compartment_table`.`store_id`))) left join (select `grm_self`.`grm_depot`.`abbrev` AS `abbrev`,`grm_self`.`grm_depot`.`code_id` AS `code_id`,`grm_self`.`grm_depot`.`id` AS `id` from `grm_self`.`grm_depot`) `depot_table` on((`store_table`.`depot_id` = `depot_table`.`id`))) order by `depot_table`.`id`,`store_table`.`id`,`compartment_table`.`id`,`cargo_table`.`id`,`current_stock`.`input_time` desc */;

/*View structure for view gb_stock_sum_history */

/*!50001 DROP TABLE IF EXISTS `gb_stock_sum_history` */;
/*!50001 DROP VIEW IF EXISTS `gb_stock_sum_history` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gb_stock_sum_history` AS select `current_stock`.`id` AS `id`,concat(lpad(`depot_table`.`code_id`,3,'0'),lpad(`store_table`.`code_id`,3,'0'),lpad(`compartment_table`.`code_id`,2,'0'),lpad(`cargo_table`.`code_id`,3,'0')) AS `code`,concat(`depot_table`.`abbrev`,`store_table`.`name`,'(',`cargo_table`.`name`,') ',if(`current_stock`.`out_finished`,'已出库','进行中'),' - ',`current_stock`.`business_key`) AS `cargo_name`,concat(`depot_table`.`abbrev`,`store_table`.`name`,'(',`cargo_table`.`name`,') ',if(`current_stock`.`out_finished`,'已出库','进行中')) AS `cargo_name_short`,`depot_table`.`id` AS `depot_id`,`store_table`.`id` AS `store_id`,`compartment_table`.`id` AS `compartment_id`,`current_stock`.`cargo_id` AS `cargo_id`,`current_stock`.`grain_type_id` AS `grain_type_id`,`current_stock`.`grain_variety_id` AS `grain_variety_id`,`current_stock`.`year` AS `year`,ifnull(`current_stock`.`amount`,0) AS `amount`,`current_stock`.`package_type_id` AS `package_type_id`,`current_stock`.`package_category_id` AS `package_category_id`,`current_stock`.`location` AS `location`,`current_stock`.`country_id` AS `country_id`,`current_stock`.`business_key` AS `business_key`,`current_stock`.`inputer_id` AS `inputer_id`,`current_stock`.`input_comment` AS `input_comment`,`current_stock`.`input_time` AS `input_time`,`current_stock`.`auditor_id` AS `auditor_id`,`current_stock`.`audit_time` AS `audit_time`,`current_stock`.`audit_comment` AS `audit_comment`,`current_stock`.`in_time` AS `in_time`,`current_stock`.`in_finished` AS `in_finished`,`current_stock`.`out_time` AS `out_time`,`current_stock`.`out_finished` AS `out_finished`,`current_stock`.`_unit_weight` AS `_unit_weight`,`current_stock`.`_deduct_volume` AS `_deduct_volume`,`current_stock`.`_factor` AS `_factor`,`latest_exam`.`analysis_level_id` AS `l_analysis_level_id`,`latest_exam`.`s1` AS `l_s1`,`latest_exam`.`s2` AS `l_s2`,`latest_exam`.`s3` AS `l_s3`,`latest_exam`.`s4` AS `l_s4`,`latest_exam`.`s5` AS `l_s5`,`latest_exam`.`a1` AS `l_a1`,`latest_exam`.`a2` AS `l_a2`,`latest_exam`.`a3` AS `l_a3`,`latest_exam`.`a4` AS `l_a4`,`latest_exam`.`a5` AS `l_a5`,`latest_exam`.`a6` AS `l_a6`,`latest_exam`.`a7` AS `l_a7`,`latest_exam`.`a8` AS `l_a8`,`latest_exam`.`a9` AS `l_a9`,`latest_exam`.`a10` AS `l_a10`,`latest_exam`.`a11` AS `l_a11`,`latest_exam`.`a12` AS `l_a12`,`latest_exam`.`a13` AS `l_a13`,`latest_exam`.`a14` AS `l_a14`,`latest_exam`.`a15` AS `l_a15`,`latest_exam`.`a16` AS `l_a16`,`latest_exam`.`a17` AS `l_a17`,`in_exam`.`analysis_level_id` AS `i_analysis_level_id`,`in_exam`.`s1` AS `i_s1`,`in_exam`.`s2` AS `i_s2`,`in_exam`.`s3` AS `i_s3`,`in_exam`.`s4` AS `i_s4`,`in_exam`.`s5` AS `i_s5`,`in_exam`.`a1` AS `i_a1`,`in_exam`.`a2` AS `i_a2`,`in_exam`.`a3` AS `i_a3`,`in_exam`.`a4` AS `i_a4`,`in_exam`.`a5` AS `i_a5`,`in_exam`.`a6` AS `i_a6`,`in_exam`.`a7` AS `i_a7`,`in_exam`.`a8` AS `i_a8`,`in_exam`.`a9` AS `i_a9`,`in_exam`.`a10` AS `i_a10`,`in_exam`.`a11` AS `i_a11`,`in_exam`.`a12` AS `i_a12`,`in_exam`.`a13` AS `i_a13`,`in_exam`.`a14` AS `i_a14`,`in_exam`.`a15` AS `i_a15`,`in_exam`.`a16` AS `i_a16`,`in_exam`.`a17` AS `i_a17`,`out_exam`.`analysis_level_id` AS `o_analysis_level_id`,`out_exam`.`s1` AS `o_s1`,`out_exam`.`s2` AS `o_s2`,`out_exam`.`s3` AS `o_s3`,`out_exam`.`s4` AS `o_s4`,`out_exam`.`s5` AS `o_s5`,`out_exam`.`a1` AS `o_a1`,`out_exam`.`a2` AS `o_a2`,`out_exam`.`a3` AS `o_a3`,`out_exam`.`a4` AS `o_a4`,`out_exam`.`a5` AS `o_a5`,`out_exam`.`a6` AS `o_a6`,`out_exam`.`a7` AS `o_a7`,`out_exam`.`a8` AS `o_a8`,`out_exam`.`a9` AS `o_a9`,`out_exam`.`a10` AS `o_a10`,`out_exam`.`a11` AS `o_a11`,`out_exam`.`a12` AS `o_a12`,`out_exam`.`a13` AS `o_a13`,`out_exam`.`a14` AS `o_a14`,`out_exam`.`a15` AS `o_a15`,`out_exam`.`a16` AS `o_a16`,`out_exam`.`a17` AS `o_a17`,ifnull(`out_stock`.`out_amount`,0) AS `out_amount`,ifnull(`in_stock`.`in_amount`,0) AS `in_amount`,ifnull(`in_stock`.`in_pack`,0) AS `in_pack`,ifnull(`out_stock`.`out_pack`,0) AS `out_pack` from (((((((((((select `s1`.`id` AS `id`,`s1`.`cargo_id` AS `cargo_id`,`s1`.`grain_type_id` AS `grain_type_id`,`s1`.`grain_variety_id` AS `grain_variety_id`,`s1`.`year` AS `year`,`s1`.`amount` AS `amount`,`s1`.`package_type_id` AS `package_type_id`,`s1`.`package_category_id` AS `package_category_id`,`s1`.`location` AS `location`,`s1`.`country_id` AS `country_id`,`s1`.`business_key` AS `business_key`,`s1`.`inputer_id` AS `inputer_id`,`s1`.`input_comment` AS `input_comment`,`s1`.`input_time` AS `input_time`,`s1`.`auditor_id` AS `auditor_id`,`s1`.`audit_time` AS `audit_time`,`s1`.`audit_comment` AS `audit_comment`,`s1`.`in_time` AS `in_time`,`s1`.`out_time` AS `out_time`,`s1`.`in_finished` AS `in_finished`,`s1`.`_unit_weight` AS `_unit_weight`,`s1`.`_deduct_volume` AS `_deduct_volume`,`s1`.`_factor` AS `_factor`,`s1`.`out_finished` AS `out_finished` from `grm_self`.`gb_stock_id` `s1`)) `current_stock` left join (select `sco1`.`out_amount` AS `out_amount`,`sco1`.`out_pack` AS `out_pack`,`sco1`.`source_stock_id` AS `source_stock_id` from (select sum(ifnull(`sc1`.`amount`,0)) AS `out_amount`,sum(ifnull(`sc1`.`pack`,0)) AS `out_pack`,`sc1`.`source_stock_id` AS `source_stock_id` from `grm_self`.`gb_stock_change` `sc1` group by `sc1`.`source_stock_id`) `sco1`) `out_stock` on((`out_stock`.`source_stock_id` = `current_stock`.`id`))) left join (select `sco2`.`in_amount` AS `in_amount`,`sco2`.`in_pack` AS `in_pack`,`sco2`.`target_stock_id` AS `target_stock_id` from (select sum(ifnull(`sc2`.`amount`,0)) AS `in_amount`,sum(ifnull(`sc2`.`pack`,0)) AS `in_pack`,`sc2`.`target_stock_id` AS `target_stock_id` from `grm_self`.`gb_stock_change` `sc2` group by `sc2`.`target_stock_id`) `sco2`) `in_stock` on((`in_stock`.`target_stock_id` = `current_stock`.`id`))) left join (select `le1`.`analysis_level_id` AS `analysis_level_id`,`le1`.`s1` AS `s1`,`le1`.`s2` AS `s2`,`le1`.`s3` AS `s3`,`le1`.`s4` AS `s4`,`le1`.`s5` AS `s5`,`le1`.`a1` AS `a1`,`le1`.`a2` AS `a2`,`le1`.`a3` AS `a3`,`le1`.`a4` AS `a4`,`le1`.`a5` AS `a5`,`le1`.`a6` AS `a6`,`le1`.`a7` AS `a7`,`le1`.`a8` AS `a8`,`le1`.`a9` AS `a9`,`le1`.`a10` AS `a10`,`le1`.`a11` AS `a11`,`le1`.`a12` AS `a12`,`le1`.`a13` AS `a13`,`le1`.`a14` AS `a14`,`le1`.`a15` AS `a15`,`le1`.`a16` AS `a16`,`le1`.`a17` AS `a17`,`le1`.`input_time` AS `input_time`,`le1`.`analysis_type_id` AS `analysis_type_id`,`le1`.`stock_id` AS `stock_id` from (`grm_self`.`gb_stock_analysis` `le1` join (select max(`grm_self`.`gb_stock_analysis`.`input_time`) AS `latest`,`grm_self`.`gb_stock_analysis`.`stock_id` AS `stock_id` from `grm_self`.`gb_stock_analysis` group by `grm_self`.`gb_stock_analysis`.`stock_id`) `le2` on(((`le1`.`input_time` = `le2`.`latest`) and (`le1`.`stock_id` = `le2`.`stock_id`))))) `latest_exam` on((`latest_exam`.`stock_id` = `current_stock`.`id`))) left join (select `ie1`.`analysis_level_id` AS `analysis_level_id`,`ie1`.`s1` AS `s1`,`ie1`.`s2` AS `s2`,`ie1`.`s3` AS `s3`,`ie1`.`s4` AS `s4`,`ie1`.`s5` AS `s5`,`ie1`.`a1` AS `a1`,`ie1`.`a2` AS `a2`,`ie1`.`a3` AS `a3`,`ie1`.`a4` AS `a4`,`ie1`.`a5` AS `a5`,`ie1`.`a6` AS `a6`,`ie1`.`a7` AS `a7`,`ie1`.`a8` AS `a8`,`ie1`.`a9` AS `a9`,`ie1`.`a10` AS `a10`,`ie1`.`a11` AS `a11`,`ie1`.`a12` AS `a12`,`ie1`.`a13` AS `a13`,`ie1`.`a14` AS `a14`,`ie1`.`a15` AS `a15`,`ie1`.`a16` AS `a16`,`ie1`.`a17` AS `a17`,`ie1`.`input_time` AS `input_time`,`ie1`.`analysis_type_id` AS `analysis_type_id`,`ie1`.`stock_id` AS `stock_id` from (`grm_self`.`gb_stock_analysis` `ie1` join (select max(`grm_self`.`gb_stock_analysis`.`input_time`) AS `latest`,`grm_self`.`gb_stock_analysis`.`stock_id` AS `stock_id` from `grm_self`.`gb_stock_analysis` where (`grm_self`.`gb_stock_analysis`.`analysis_type_id` = 1) group by `grm_self`.`gb_stock_analysis`.`stock_id`) `ie2` on(((`ie1`.`input_time` = `ie2`.`latest`) and (`ie1`.`stock_id` = `ie2`.`stock_id`)))) where (`ie1`.`analysis_type_id` = 1)) `in_exam` on((`in_exam`.`stock_id` = `current_stock`.`id`))) left join (select `oe1`.`analysis_level_id` AS `analysis_level_id`,`oe1`.`s1` AS `s1`,`oe1`.`s2` AS `s2`,`oe1`.`s3` AS `s3`,`oe1`.`s4` AS `s4`,`oe1`.`s5` AS `s5`,`oe1`.`a1` AS `a1`,`oe1`.`a2` AS `a2`,`oe1`.`a3` AS `a3`,`oe1`.`a4` AS `a4`,`oe1`.`a5` AS `a5`,`oe1`.`a6` AS `a6`,`oe1`.`a7` AS `a7`,`oe1`.`a8` AS `a8`,`oe1`.`a9` AS `a9`,`oe1`.`a10` AS `a10`,`oe1`.`a11` AS `a11`,`oe1`.`a12` AS `a12`,`oe1`.`a13` AS `a13`,`oe1`.`a14` AS `a14`,`oe1`.`a15` AS `a15`,`oe1`.`a16` AS `a16`,`oe1`.`a17` AS `a17`,`oe1`.`input_time` AS `input_time`,`oe1`.`analysis_type_id` AS `analysis_type_id`,`oe1`.`stock_id` AS `stock_id` from (`grm_self`.`gb_stock_analysis` `oe1` join (select max(`grm_self`.`gb_stock_analysis`.`input_time`) AS `latest`,`grm_self`.`gb_stock_analysis`.`stock_id` AS `stock_id` from `grm_self`.`gb_stock_analysis` where (`grm_self`.`gb_stock_analysis`.`analysis_type_id` = 2) group by `grm_self`.`gb_stock_analysis`.`stock_id`) `oe2` on(((`oe1`.`input_time` = `oe2`.`latest`) and (`oe1`.`stock_id` = `oe2`.`stock_id`)))) where (`oe1`.`analysis_type_id` = 2)) `out_exam` on((`out_exam`.`stock_id` = `current_stock`.`id`))) left join (select `grm_self`.`grm_cargo`.`compartment_id` AS `compartment_id`,`grm_self`.`grm_cargo`.`code_id` AS `code_id`,`grm_self`.`grm_cargo`.`name` AS `name`,`grm_self`.`grm_cargo`.`id` AS `id` from `grm_self`.`grm_cargo`) `cargo_table` on((`cargo_table`.`id` = `current_stock`.`cargo_id`))) left join (select `grm_self`.`grm_compartment`.`store_id` AS `store_id`,`grm_self`.`grm_compartment`.`code_id` AS `code_id`,`grm_self`.`grm_compartment`.`id` AS `id` from `grm_self`.`grm_compartment`) `compartment_table` on((`compartment_table`.`id` = `cargo_table`.`compartment_id`))) left join (select `grm_self`.`grm_store`.`code_id` AS `code_id`,`grm_self`.`grm_store`.`name` AS `name`,`grm_self`.`grm_store`.`depot_id` AS `depot_id`,`grm_self`.`grm_store`.`id` AS `id` from `grm_self`.`grm_store`) `store_table` on((`store_table`.`id` = `compartment_table`.`store_id`))) left join (select `grm_self`.`grm_depot`.`abbrev` AS `abbrev`,`grm_self`.`grm_depot`.`code_id` AS `code_id`,`grm_self`.`grm_depot`.`id` AS `id` from `grm_self`.`grm_depot`) `depot_table` on((`store_table`.`depot_id` = `depot_table`.`id`))) order by `depot_table`.`id`,`current_stock`.`out_finished`,`store_table`.`id`,`compartment_table`.`id`,`cargo_table`.`id`,`current_stock`.`input_time` desc */;

/*View structure for view grm_cargo_representation */

/*!50001 DROP TABLE IF EXISTS `grm_cargo_representation` */;
/*!50001 DROP VIEW IF EXISTS `grm_cargo_representation` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `grm_cargo_representation` AS select `cargo_table`.`id` AS `id`,`cargo_table`.`code_id` AS `code_id`,`cargo_table`.`name` AS `name`,concat(`depot_table`.`abbrev`,`store_table`.`name`,'(',`cargo_table`.`name`,') - ',`status_table`.`name`) AS `readable_name`,concat(lpad(`depot_table`.`code_id`,3,'0'),lpad(`store_table`.`code_id`,3,'0'),lpad(`compartment_table`.`code_id`,2,'0'),lpad(`cargo_table`.`code_id`,3,'0')) AS `code`,`status_table`.`name` AS `status_name`,`status_table`.`id` AS `status_id`,`store_table`.`name` AS `store_name`,`depot_table`.`abbrev` AS `depot_abbrev`,concat(`depot_table`.`abbrev`,`store_table`.`name`,'(',`cargo_table`.`name`,')') AS `short_name`,`cargo_table`.`compartment_id` AS `compartment_id` from ((((`grm_self`.`grm_cargo` `cargo_table` left join (select `grm_self`.`bt_cargo_status`.`name` AS `name`,`grm_self`.`bt_cargo_status`.`id` AS `id`,`grm_self`.`bt_cargo_status`.`code_id` AS `code_id` from `grm_self`.`bt_cargo_status`) `status_table` on((`status_table`.`id` = `cargo_table`.`status_id`))) left join (select `grm_self`.`grm_compartment`.`store_id` AS `store_id`,`grm_self`.`grm_compartment`.`code_id` AS `code_id`,`grm_self`.`grm_compartment`.`id` AS `id` from `grm_self`.`grm_compartment`) `compartment_table` on((`compartment_table`.`id` = `cargo_table`.`compartment_id`))) left join (select `grm_self`.`grm_store`.`code_id` AS `code_id`,`grm_self`.`grm_store`.`name` AS `name`,`grm_self`.`grm_store`.`depot_id` AS `depot_id`,`grm_self`.`grm_store`.`id` AS `id` from `grm_self`.`grm_store`) `store_table` on((`store_table`.`id` = `compartment_table`.`store_id`))) left join (select `grm_self`.`grm_depot`.`abbrev` AS `abbrev`,`grm_self`.`grm_depot`.`code_id` AS `code_id`,`grm_self`.`grm_depot`.`id` AS `id` from `grm_self`.`grm_depot`) `depot_table` on((`store_table`.`depot_id` = `depot_table`.`id`))) order by `depot_table`.`id`,`status_table`.`code_id`,`store_table`.`id`,`compartment_table`.`id`,`cargo_table`.`id` */;

/*View structure for view my_change_source */

/*!50001 DROP TABLE IF EXISTS `my_change_source` */;
/*!50001 DROP VIEW IF EXISTS `my_change_source` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `my_change_source` AS (select `my_change_source`.`id` AS `id`,`my_change_source`.`source_id` AS `source_id`,`my_change_source`.`target_id` AS `target_id`,`my_change_source`.`current_stock_change_amount` AS `current_stock_change_amount`,`my_change_source`.`input_time` AS `input_time`,`my_change_source`.`c2_id` AS `c2_id`,`my_change_source`.`c2_input_time` AS `c2_input_time`,`my_change_source`.`c2_amount` AS `c2_amount`,sum(`my_change_source`.`c2_amount`) AS `sum_c2amount` from (select `c1`.`id` AS `id`,`c1`.`source_id` AS `source_id`,`c1`.`target_id` AS `target_id`,`c1`.`current_stock_change_amount` AS `current_stock_change_amount`,`c1`.`input_time` AS `input_time`,`c2`.`id` AS `c2_id`,`c2`.`input_time` AS `c2_input_time`,`c2`.`current_stock_change_amount` AS `c2_amount` from (`grm_self`.`my_current_stock_change` `c1` left join `grm_self`.`my_current_stock_change` `c2` on(((`c2`.`input_time` <= `c1`.`input_time`) and (`c2`.`source_id` = `c1`.`source_id`))))) `my_change_source` group by `my_change_source`.`id`) */;

/*View structure for view my_change_source_target */

/*!50001 DROP TABLE IF EXISTS `my_change_source_target` */;
/*!50001 DROP VIEW IF EXISTS `my_change_source_target` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `my_change_source_target` AS (select `s1`.`id` AS `id`,`s1`.`source_id` AS `source_id`,`s1`.`target_id` AS `target_id`,`s1`.`current_stock_change_amount` AS `current_stock_change_amount`,`s1`.`input_time` AS `input_time`,`s1`.`c2_id` AS `c2_id`,`s1`.`c2_input_time` AS `c2_input_time`,`s1`.`c2_amount` AS `c2_amount`,`s1`.`sum_c2amount` AS `sum_c2amount`,`s1`.`c3_id` AS `c3_id`,`s1`.`c3_input_time` AS `c3_input_time`,`s1`.`c3_amount` AS `c3_amount`,sum(`s1`.`c3_amount`) AS `sum_c3amount` from (select `c1`.`id` AS `id`,`c1`.`source_id` AS `source_id`,`c1`.`target_id` AS `target_id`,`c1`.`current_stock_change_amount` AS `current_stock_change_amount`,`c1`.`input_time` AS `input_time`,`c1`.`c2_id` AS `c2_id`,`c1`.`c2_input_time` AS `c2_input_time`,`c1`.`c2_amount` AS `c2_amount`,`c1`.`sum_c2amount` AS `sum_c2amount`,`c3`.`id` AS `c3_id`,`c3`.`input_time` AS `c3_input_time`,`c3`.`current_stock_change_amount` AS `c3_amount` from (`grm_self`.`my_change_source` `c1` left join `grm_self`.`my_current_stock_change` `c3` on(((`c3`.`input_time` <= `c1`.`input_time`) and (`c3`.`target_id` = `c1`.`target_id`))))) `s1` group by `s1`.`id`) */;

/*View structure for view my_current_stock1 */

/*!50001 DROP TABLE IF EXISTS `my_current_stock1` */;
/*!50001 DROP VIEW IF EXISTS `my_current_stock1` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `my_current_stock1` AS (select `gb_stock`.`id` AS `id`,`gb_stock`.`cargo_id` AS `cargo_id`,`gb_stock`.`grain_type_id` AS `grain_type_id`,`gb_stock`.`grain_variety_id` AS `grain_variety_id`,`gb_stock`.`year` AS `year`,`gb_stock`.`amount` AS `amount`,`gb_stock`.`package_type_id` AS `package_type_id`,`gb_stock`.`package_category_id` AS `package_category_id`,`gb_stock`.`location` AS `location`,`gb_stock`.`business_key` AS `business_key`,`gb_stock`.`inputer_id` AS `inputer_id`,`gb_stock`.`input_comment` AS `input_comment`,`gb_stock`.`input_time` AS `input_time`,`gb_stock`.`auditor_id` AS `auditor_id`,`gb_stock`.`audit_time` AS `audit_time`,`gb_stock`.`audit_comment` AS `audit_comment`,`gb_stock`.`in_finished` AS `in_finished`,`gb_stock`.`out_finished` AS `out_finished`,`gb_stock`.`in_time` AS `in_time`,`gb_stock`.`out_time` AS `out_time`,`gb_stock`.`in_analysis_id` AS `in_analysis_id`,`gb_stock`.`out_analysis_id` AS `out_analysis_id`,`gb_stock`.`_unit_weight` AS `_unit_weight`,`gb_stock`.`_deduct_volume` AS `_deduct_volume`,`gb_stock`.`_factor` AS `_factor`,`gb_stock`.`country_id` AS `country_id`,`maxtime`.`input_time` AS `max_input_time` from (`grm_self`.`gb_stock_id` `gb_stock` join (select `grm_self`.`gb_stock_id`.`cargo_id` AS `cargo_id`,max(`grm_self`.`gb_stock_id`.`input_time`) AS `input_time` from `grm_self`.`gb_stock_id` where ((`grm_self`.`gb_stock_id`.`out_finished` <> 1) and (`grm_self`.`gb_stock_id`.`cargo_id` is not null)) group by `grm_self`.`gb_stock_id`.`cargo_id`) `maxtime` on(((`maxtime`.`cargo_id` = `gb_stock`.`cargo_id`) and (`maxtime`.`input_time` = `gb_stock`.`input_time`))))) */;

/*View structure for view my_current_stock2 */

/*!50001 DROP TABLE IF EXISTS `my_current_stock2` */;
/*!50001 DROP VIEW IF EXISTS `my_current_stock2` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `my_current_stock2` AS (select `my_current_stock1`.`id` AS `id`,`my_current_stock1`.`cargo_id` AS `cargo_id`,`my_current_stock1`.`grain_type_id` AS `grain_type_id`,`my_current_stock1`.`grain_variety_id` AS `grain_variety_id`,`my_current_stock1`.`year` AS `year`,`my_current_stock1`.`amount` AS `amount`,`my_current_stock1`.`package_type_id` AS `package_type_id`,`my_current_stock1`.`package_category_id` AS `package_category_id`,`my_current_stock1`.`location` AS `location`,`my_current_stock1`.`country_id` AS `country_id`,`my_current_stock1`.`business_key` AS `business_key`,`my_current_stock1`.`inputer_id` AS `inputer_id`,`my_current_stock1`.`input_comment` AS `input_comment`,`my_current_stock1`.`input_time` AS `input_time`,`my_current_stock1`.`auditor_id` AS `auditor_id`,`my_current_stock1`.`audit_time` AS `audit_time`,`my_current_stock1`.`audit_comment` AS `audit_comment`,`my_current_stock1`.`in_time` AS `in_time`,`my_current_stock1`.`out_time` AS `out_time`,`my_current_stock1`.`in_finished` AS `in_finished`,`my_current_stock1`.`_unit_weight` AS `_unit_weight`,`my_current_stock1`.`_deduct_volume` AS `_deduct_volume`,`my_current_stock1`.`_factor` AS `_factor`,`my_current_stock1`.`out_finished` AS `out_finished`,`grm_self`.`grm_cargo`.`compartment_id` AS `compartment_id`,`grm_self`.`grm_cargo`.`name` AS `cargo_name`,`grm_self`.`grm_compartment`.`store_id` AS `store_id`,`grm_self`.`grm_store`.`code_id` AS `store_code`,`grm_self`.`grm_store`.`depot_id` AS `depot_id` from (((`grm_self`.`my_current_stock1` join `grm_self`.`grm_cargo` on((`grm_self`.`grm_cargo`.`id` = `my_current_stock1`.`cargo_id`))) join `grm_self`.`grm_compartment` on((`grm_self`.`grm_compartment`.`id` = `grm_self`.`grm_cargo`.`compartment_id`))) join `grm_self`.`grm_store` on(((`grm_self`.`grm_store`.`id` = `grm_self`.`grm_compartment`.`store_id`) and (`grm_self`.`grm_store`.`depot_id` = 1))))) */;

/*View structure for view my_current_stock3 */

/*!50001 DROP TABLE IF EXISTS `my_current_stock3` */;
/*!50001 DROP VIEW IF EXISTS `my_current_stock3` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `my_current_stock3` AS (select `my_current_stock2`.`id` AS `id`,`my_current_stock2`.`cargo_id` AS `cargo_id`,`my_current_stock2`.`grain_type_id` AS `grain_type_id`,`my_current_stock2`.`grain_variety_id` AS `grain_variety_id`,`my_current_stock2`.`year` AS `year`,`my_current_stock2`.`amount` AS `amount`,`my_current_stock2`.`package_type_id` AS `package_type_id`,`my_current_stock2`.`package_category_id` AS `package_category_id`,`my_current_stock2`.`location` AS `location`,`my_current_stock2`.`country_id` AS `country_id`,`my_current_stock2`.`business_key` AS `business_key`,`my_current_stock2`.`inputer_id` AS `inputer_id`,`my_current_stock2`.`input_comment` AS `input_comment`,`my_current_stock2`.`input_time` AS `input_time`,`my_current_stock2`.`auditor_id` AS `auditor_id`,`my_current_stock2`.`audit_time` AS `audit_time`,`my_current_stock2`.`audit_comment` AS `audit_comment`,`my_current_stock2`.`in_time` AS `in_time`,`my_current_stock2`.`out_time` AS `out_time`,`my_current_stock2`.`in_finished` AS `in_finished`,`my_current_stock2`.`_unit_weight` AS `_unit_weight`,`my_current_stock2`.`_deduct_volume` AS `_deduct_volume`,`my_current_stock2`.`_factor` AS `_factor`,`my_current_stock2`.`out_finished` AS `out_finished`,`my_current_stock2`.`compartment_id` AS `compartment_id`,`my_current_stock2`.`cargo_name` AS `cargo_name`,`my_current_stock2`.`store_id` AS `store_id`,`my_current_stock2`.`store_code` AS `store_code`,`my_current_stock2`.`depot_id` AS `depot_id`,`source`.`out_amount` AS `out_amount`,`target`.`in_amount` AS `in_amount`,((ifnull(`my_current_stock2`.`amount`,0) + ifnull(`target`.`in_amount`,0)) - ifnull(`source`.`out_amount`,0)) AS `hasamount` from ((`grm_self`.`my_current_stock2` left join (select sum(`grm_self`.`gb_stock_change`.`amount`) AS `out_amount`,`grm_self`.`gb_stock_change`.`source_stock_id` AS `source_stock_id` from `grm_self`.`gb_stock_change` group by `grm_self`.`gb_stock_change`.`source_stock_id`) `source` on((`source`.`source_stock_id` = `my_current_stock2`.`id`))) left join (select sum(`grm_self`.`gb_stock_change`.`amount`) AS `in_amount`,`grm_self`.`gb_stock_change`.`target_stock_id` AS `target_stock_id` from `grm_self`.`gb_stock_change` group by `grm_self`.`gb_stock_change`.`target_stock_id`) `target` on((`target`.`target_stock_id` = `my_current_stock2`.`id`)))) */;

/*View structure for view my_current_stock_change */

/*!50001 DROP TABLE IF EXISTS `my_current_stock_change` */;
/*!50001 DROP VIEW IF EXISTS `my_current_stock_change` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `my_current_stock_change` AS (select `grm_self`.`gb_stock_change`.`id` AS `id`,`grm_self`.`gb_stock_change`.`source_stock_id` AS `source_id`,`grm_self`.`gb_stock_change`.`target_stock_id` AS `target_id`,`grm_self`.`gb_stock_change`.`amount` AS `current_stock_change_amount`,`grm_self`.`gb_stock_change`.`input_time` AS `input_time` from `grm_self`.`gb_stock_change` where (`grm_self`.`gb_stock_change`.`source_stock_id` in (select `my_current_stock2`.`id` from `grm_self`.`my_current_stock2`) or `grm_self`.`gb_stock_change`.`target_stock_id` in (select `my_current_stock2`.`id` from `grm_self`.`my_current_stock2`))) */;

/*View structure for view my_entry_tem */

/*!50001 DROP TABLE IF EXISTS `my_entry_tem` */;
/*!50001 DROP VIEW IF EXISTS `my_entry_tem` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `my_entry_tem` AS (select date_format(`entry_temperature`.`time`,'%Y%m%d') AS `ymd`,`entry_temperature`.`id` AS `id`,`entry_temperature`.`store_id` AS `store_id`,`entry_temperature`.`time` AS `time`,`entry_temperature`.`data` AS `data`,`entry_temperature`.`is_auto` AS `is_auto` from `entry_temperature`) */;

/*View structure for view my_newst_current_stock */

/*!50001 DROP TABLE IF EXISTS `my_newst_current_stock` */;
/*!50001 DROP VIEW IF EXISTS `my_newst_current_stock` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `my_newst_current_stock` AS (select `grm_self`.`gb_stock_id`.`id` AS `id`,`grm_self`.`gb_stock_id`.`cargo_id` AS `cargo_id`,`grm_self`.`gb_stock_id`.`grain_type_id` AS `grain_type_id`,`grm_self`.`gb_stock_id`.`grain_variety_id` AS `grain_variety_id`,`grm_self`.`gb_stock_id`.`year` AS `year`,`grm_self`.`gb_stock_id`.`amount` AS `amount`,`grm_self`.`gb_stock_id`.`package_type_id` AS `package_type_id`,`grm_self`.`gb_stock_id`.`package_category_id` AS `package_category_id`,`grm_self`.`gb_stock_id`.`location` AS `location`,`grm_self`.`gb_stock_id`.`business_key` AS `business_key`,`grm_self`.`gb_stock_id`.`inputer_id` AS `inputer_id`,`grm_self`.`gb_stock_id`.`input_comment` AS `input_comment`,`grm_self`.`gb_stock_id`.`input_time` AS `input_time`,`grm_self`.`gb_stock_id`.`auditor_id` AS `auditor_id`,`grm_self`.`gb_stock_id`.`audit_time` AS `audit_time`,`grm_self`.`gb_stock_id`.`audit_comment` AS `audit_comment`,`grm_self`.`gb_stock_id`.`in_finished` AS `in_finished`,`grm_self`.`gb_stock_id`.`out_finished` AS `out_finished`,`grm_self`.`gb_stock_id`.`in_time` AS `in_time`,`grm_self`.`gb_stock_id`.`out_time` AS `out_time`,`grm_self`.`gb_stock_id`.`in_analysis_id` AS `in_analysis_id`,`grm_self`.`gb_stock_id`.`out_analysis_id` AS `out_analysis_id`,`grm_self`.`gb_stock_id`.`_unit_weight` AS `_unit_weight`,`grm_self`.`gb_stock_id`.`_deduct_volume` AS `_deduct_volume`,`grm_self`.`gb_stock_id`.`_factor` AS `_factor`,`grm_self`.`gb_stock_id`.`country_id` AS `country_id`,`current_stock`.`maxcargo_id` AS `maxcargo_id`,`current_stock`.`max_audit_time` AS `max_audit_time` from (`grm_self`.`gb_stock_id` left join (select `grm_self`.`gb_stock_id`.`cargo_id` AS `maxcargo_id`,max(`grm_self`.`gb_stock_id`.`audit_time`) AS `max_audit_time` from `grm_self`.`gb_stock_id` group by `grm_self`.`gb_stock_id`.`cargo_id`) `current_stock` on((`current_stock`.`maxcargo_id` = `grm_self`.`gb_stock_id`.`cargo_id`))) where (`current_stock`.`max_audit_time` = `grm_self`.`gb_stock_id`.`audit_time`)) */;

/*View structure for view my_stock_sum_history */

/*!50001 DROP TABLE IF EXISTS `my_stock_sum_history` */;
/*!50001 DROP VIEW IF EXISTS `my_stock_sum_history` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `my_stock_sum_history` AS (select `grm_self`.`gb_stock_id`.`id` AS `id`,`grm_self`.`gb_stock_id`.`cargo_id` AS `cargo_id`,`grm_self`.`gb_stock_id`.`grain_type_id` AS `grain_type_id`,`grm_self`.`gb_stock_id`.`grain_variety_id` AS `grain_variety_id`,`grm_self`.`gb_stock_id`.`year` AS `year`,`grm_self`.`gb_stock_id`.`amount` AS `amount`,`grm_self`.`gb_stock_id`.`package_type_id` AS `package_type_id`,`grm_self`.`gb_stock_id`.`package_category_id` AS `package_category_id`,`grm_self`.`gb_stock_id`.`location` AS `location`,`grm_self`.`gb_stock_id`.`business_key` AS `business_key`,`grm_self`.`gb_stock_id`.`inputer_id` AS `inputer_id`,`grm_self`.`gb_stock_id`.`input_comment` AS `input_comment`,`grm_self`.`gb_stock_id`.`input_time` AS `input_time`,`grm_self`.`gb_stock_id`.`auditor_id` AS `auditor_id`,`grm_self`.`gb_stock_id`.`audit_time` AS `audit_time`,`grm_self`.`gb_stock_id`.`audit_comment` AS `audit_comment`,`grm_self`.`gb_stock_id`.`in_finished` AS `in_finished`,`grm_self`.`gb_stock_id`.`out_finished` AS `out_finished`,`grm_self`.`gb_stock_id`.`in_time` AS `in_time`,`grm_self`.`gb_stock_id`.`out_time` AS `out_time`,`grm_self`.`gb_stock_id`.`in_analysis_id` AS `in_analysis_id`,`grm_self`.`gb_stock_id`.`out_analysis_id` AS `out_analysis_id`,`grm_self`.`gb_stock_id`.`_unit_weight` AS `_unit_weight`,`grm_self`.`gb_stock_id`.`_deduct_volume` AS `_deduct_volume`,`grm_self`.`gb_stock_id`.`_factor` AS `_factor`,`grm_self`.`gb_stock_id`.`country_id` AS `country_id`,`in_s`.`in_amount` AS `in_amount`,`in_s`.`in_stock` AS `in_stock`,`out_s`.`out_amount` AS `out_amount`,`out_s`.`out_stock` AS `out_stock` from ((`grm_self`.`gb_stock_id` left join (select sum(`grm_self`.`gb_stock_change`.`amount`) AS `in_amount`,`grm_self`.`gb_stock_change`.`target_stock_id` AS `in_stock` from `grm_self`.`gb_stock_change` group by `grm_self`.`gb_stock_change`.`target_stock_id`) `in_s` on((`in_s`.`in_stock` = `grm_self`.`gb_stock_id`.`id`))) left join (select sum(`grm_self`.`gb_stock_change`.`amount`) AS `out_amount`,`grm_self`.`gb_stock_change`.`source_stock_id` AS `out_stock` from `grm_self`.`gb_stock_change` group by `grm_self`.`gb_stock_change`.`source_stock_id`) `out_s` on((`out_s`.`out_stock` = `grm_self`.`gb_stock_id`.`id`)))) */;

/*View structure for view p_month */

/*!50001 DROP TABLE IF EXISTS `p_month` */;
/*!50001 DROP VIEW IF EXISTS `p_month` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `p_month` AS select `current_stock`.`type_id` AS `type_id`,`current_stock`.`date` AS `date`,`current_stock`.`content` AS `content`,`current_stock`.`last_date` AS `last_date`,`out_stock`.`out_amount` AS `out_amount`,`in_stock`.`in_amount` AS `in_amount`,(`in_stock`.`in_amount` - `out_stock`.`out_amount`) AS `amount` from ((((select `s2`.`latest` AS `latest`,`s2`.`type_id` AS `type_id`,`s2`.`date` AS `date`,`s2`.`content` AS `content`,`s2`.`last_date` AS `last_date` from (`grm_self`.`gb_medicine_stock` `s1` join (select max(`grm_self`.`gb_medicine_stock`.`input_time`) AS `latest`,`grm_self`.`gb_medicine_stock`.`type_id` AS `type_id`,`m`.`date` AS `date`,`m`.`content` AS `content`,`m`.`last_date` AS `last_date` from (`grm_self`.`gb_medicine_stock` join `grm_self`.`meta_month` `m`) where ((`grm_self`.`gb_medicine_stock`.`input_time` < `m`.`date`) and (`m`.`date` < now())) group by `grm_self`.`gb_medicine_stock`.`type_id`,`m`.`date`) `s2` on(((`s1`.`type_id` = `s2`.`type_id`) and (`s1`.`input_time` = `s2`.`latest`)))))) `current_stock` left join (select `sco1`.`out_amount` AS `out_amount`,`sco1`.`type_id` AS `type_id`,`sco1`.`date` AS `date` from (select sum((ifnull(`sc1`.`amount`,0) * `scale`.`factor`)) AS `out_amount`,`sc1`.`type_id` AS `type_id`,`m`.`date` AS `date` from ((`grm_self`.`gb_medicine_request` `sc1` join `grm_self`.`meta_month` `m`) join `grm_self`.`bt_scale` `scale` on((`sc1`.`scale_id` = `scale`.`id`))) where ((`sc1`.`input_time` < `m`.`date`) and (`m`.`date` < now())) group by `sc1`.`type_id`,`m`.`date`) `sco1`) `out_stock` on(((`out_stock`.`type_id` = `current_stock`.`type_id`) and (`current_stock`.`date` = `out_stock`.`date`)))) left join (select `sco2`.`in_amount` AS `in_amount`,`sco2`.`type_id` AS `type_id`,`sco2`.`date` AS `date` from (select sum((ifnull(`sc2`.`amount`,0) * `scale`.`factor`)) AS `in_amount`,`sc2`.`type_id` AS `type_id`,`m`.`date` AS `date` from ((`grm_self`.`gb_medicine_stock` `sc2` join `grm_self`.`meta_month` `m`) join `grm_self`.`bt_scale` `scale` on((`sc2`.`scale_id` = `scale`.`id`))) where ((`sc2`.`input_time` < `m`.`date`) and (`m`.`date` < now())) group by `sc2`.`type_id`,`m`.`date`) `sco2`) `in_stock` on(((`in_stock`.`type_id` = `current_stock`.`type_id`) and (`current_stock`.`date` = `in_stock`.`date`)))) */;

/*View structure for view p_ybb */

/*!50001 DROP TABLE IF EXISTS `p_ybb` */;
/*!50001 DROP VIEW IF EXISTS `p_ybb` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `p_ybb` AS select `a`.`type_id` AS `type_id`,`a`.`date` AS `date`,round((`a`.`amount` / 1000),0) AS `amount`,round((`a`.`last_amount` / 1000),0) AS `last_amount`,round((`a`.`in_amount` / 1000),0) AS `in_amount`,round((`a`.`out_amount` / 1000),0) AS `out_amount` from ((select `yy`.`date` AS `date`,`yy`.`last_date` AS `last_date`,`yy`.`type_id` AS `type_id`,`yy`.`amount` AS `amount`,(`yy`.`in_amount` - ifnull(`xx`.`in_amount`,0)) AS `in_amount`,(`yy`.`out_amount` - ifnull(`xx`.`out_amount`,0)) AS `out_amount`,ifnull(`xx`.`amount`,0) AS `last_amount` from (((select `p_month`.`date` AS `date`,`p_month`.`last_date` AS `last_date`,`p_month`.`type_id` AS `type_id`,`p_month`.`amount` AS `amount`,`p_month`.`in_amount` AS `in_amount`,`p_month`.`out_amount` AS `out_amount` from `grm_self`.`p_month`)) `yy` left join (select `p_month`.`date` AS `date`,`p_month`.`last_date` AS `last_date`,`p_month`.`type_id` AS `type_id`,`p_month`.`amount` AS `amount`,`p_month`.`in_amount` AS `in_amount`,`p_month`.`out_amount` AS `out_amount` from `grm_self`.`p_month`) `xx` on(((`xx`.`date` = `yy`.`last_date`) and (`xx`.`type_id` = `yy`.`type_id`)))))) `a` */;

/*View structure for view sd_my_current_simple_stock */

/*!50001 DROP TABLE IF EXISTS `sd_my_current_simple_stock` */;
/*!50001 DROP VIEW IF EXISTS `sd_my_current_simple_stock` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sd_my_current_simple_stock` AS (select `grm_self`.`gb_stock_id`.`id` AS `id`,`grm_self`.`gb_stock_id`.`cargo_id` AS `cargo_id`,`grm_self`.`gb_stock_id`.`grain_type_id` AS `grain_type_id`,`grm_self`.`gb_stock_id`.`grain_variety_id` AS `grain_variety_id`,`grm_self`.`gb_stock_id`.`year` AS `year`,`grm_self`.`gb_stock_id`.`amount` AS `amount`,`grm_self`.`gb_stock_id`.`package_type_id` AS `package_type_id`,`grm_self`.`gb_stock_id`.`package_category_id` AS `package_category_id`,`grm_self`.`gb_stock_id`.`location` AS `location`,`grm_self`.`gb_stock_id`.`business_key` AS `business_key`,`grm_self`.`gb_stock_id`.`inputer_id` AS `inputer_id`,`grm_self`.`gb_stock_id`.`input_comment` AS `input_comment`,`grm_self`.`gb_stock_id`.`input_time` AS `input_time`,`grm_self`.`gb_stock_id`.`auditor_id` AS `auditor_id`,`grm_self`.`gb_stock_id`.`audit_time` AS `audit_time`,`grm_self`.`gb_stock_id`.`audit_comment` AS `audit_comment`,`grm_self`.`gb_stock_id`.`in_finished` AS `in_finished`,`grm_self`.`gb_stock_id`.`out_finished` AS `out_finished`,`grm_self`.`gb_stock_id`.`in_time` AS `in_time`,`grm_self`.`gb_stock_id`.`out_time` AS `out_time`,`grm_self`.`gb_stock_id`.`in_analysis_id` AS `in_analysis_id`,`grm_self`.`gb_stock_id`.`out_analysis_id` AS `out_analysis_id`,`grm_self`.`gb_stock_id`.`_unit_weight` AS `_unit_weight`,`grm_self`.`gb_stock_id`.`_deduct_volume` AS `_deduct_volume`,`grm_self`.`gb_stock_id`.`_factor` AS `_factor`,`grm_self`.`gb_stock_id`.`country_id` AS `country_id`,`lastes`.`max_audit_time` AS `max_audit_time` from (`grm_self`.`gb_stock_id` join (select max(`grm_self`.`gb_stock_id`.`audit_time`) AS `max_audit_time`,`grm_self`.`gb_stock_id`.`cargo_id` AS `cargo_id` from `grm_self`.`gb_stock_id` group by `grm_self`.`gb_stock_id`.`cargo_id`) `lastes` on(((`lastes`.`cargo_id` = `grm_self`.`gb_stock_id`.`cargo_id`) and (`lastes`.`max_audit_time` = `grm_self`.`gb_stock_id`.`audit_time`))))) */;

/*View structure for view sd_my_js_f_s */

/*!50001 DROP TABLE IF EXISTS `sd_my_js_f_s` */;
/*!50001 DROP VIEW IF EXISTS `sd_my_js_f_s` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sd_my_js_f_s` AS select `sd_my_js_first`.`id` AS `id`,`sd_my_js_first`.`code` AS `code`,`sd_my_js_first`.`is_ingress` AS `is_ingress`,`sd_my_js_first`.`stage_id` AS `stage_id`,`sd_my_js_first`.`contract_id` AS `contract_id`,`sd_my_js_first`.`register_record_id` AS `register_record_id`,`sd_my_js_first`.`analysis_id` AS `analysis_id`,`sd_my_js_first`.`time` AS `time`,`sd_my_js_first`.`allow_stage` AS `allow_stage`,`sd_my_js_first`.`out_time` AS `out_time`,`sd_my_js_first`.`has_second` AS `has_second`,`sd_my_js_first`.`stock_id` AS `stock_id`,`sd_my_js_first`.`stock_change_id` AS `stock_change_id`,`sd_my_js_first`.`date_stock` AS `date_stock`,`sd_my_js_first`.`f_weight` AS `f_weight`,`sd_my_js_first`.`s_weight` AS `s_weight`,`sd_my_js_first`.`deduct_weight` AS `deduct_weight`,`sd_my_js_first`.`pack` AS `pack`,`sd_my_js_first`.`pack_per_weight` AS `pack_per_weight`,`sd_my_js_first`.`deduct_percentage` AS `deduct_percentage`,concat('0') AS `isecond` from `sd_my_js_first` union all select `sd_my_js_second`.`id` AS `id`,`sd_my_js_second`.`code` AS `code`,`sd_my_js_second`.`is_ingress` AS `is_ingress`,`sd_my_js_second`.`stage_id` AS `stage_id`,`sd_my_js_second`.`contract_id` AS `contract_id`,`sd_my_js_second`.`register_record_id` AS `register_record_id`,`sd_my_js_second`.`analysis_id` AS `analysis_id`,`sd_my_js_second`.`time` AS `time`,`sd_my_js_second`.`allow_stage` AS `allow_stage`,`sd_my_js_second`.`out_time` AS `out_time`,`sd_my_js_second`.`has_second` AS `has_second`,`sd_my_js_second`.`stock_id` AS `stock_id`,`sd_my_js_second`.`stock_change_id` AS `stock_change_id`,`sd_my_js_second`.`date_stock` AS `date_stock`,`sd_my_js_second`.`f_weight` AS `f_weight`,`sd_my_js_second`.`s_weight` AS `s_weight`,`sd_my_js_second`.`deduct_weight` AS `deduct_weight`,`sd_my_js_second`.`pack` AS `pack`,`sd_my_js_second`.`pack_per_weight` AS `pack_per_weight`,`sd_my_js_second`.`deduct_percentage` AS `deduct_percentage`,concat('1') AS `isecond` from `sd_my_js_second` */;

/*View structure for view sd_my_js_f_s_amount */

/*!50001 DROP TABLE IF EXISTS `sd_my_js_f_s_amount` */;
/*!50001 DROP VIEW IF EXISTS `sd_my_js_f_s_amount` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sd_my_js_f_s_amount` AS (select `sd_my_js_f_s`.`id` AS `id`,`sd_my_js_f_s`.`code` AS `code`,`sd_my_js_f_s`.`is_ingress` AS `is_ingress`,`sd_my_js_f_s`.`stage_id` AS `stage_id`,`sd_my_js_f_s`.`contract_id` AS `contract_id`,`sd_my_js_f_s`.`register_record_id` AS `register_record_id`,`sd_my_js_f_s`.`analysis_id` AS `analysis_id`,`sd_my_js_f_s`.`time` AS `time`,`sd_my_js_f_s`.`allow_stage` AS `allow_stage`,`sd_my_js_f_s`.`out_time` AS `out_time`,`sd_my_js_f_s`.`has_second` AS `has_second`,`sd_my_js_f_s`.`stock_id` AS `stock_id`,`sd_my_js_f_s`.`stock_change_id` AS `stock_change_id`,`sd_my_js_f_s`.`date_stock` AS `date_stock`,`sd_my_js_f_s`.`f_weight` AS `f_weight`,`sd_my_js_f_s`.`s_weight` AS `s_weight`,`sd_my_js_f_s`.`deduct_weight` AS `deduct_weight`,`sd_my_js_f_s`.`pack` AS `pack`,`sd_my_js_f_s`.`pack_per_weight` AS `pack_per_weight`,`sd_my_js_f_s`.`isecond` AS `isecond`,concat(`sd_my_js_f_s`.`id`,'_',`sd_my_js_f_s`.`isecond`) AS `myid`,`sd_my_js_f_s`.`deduct_percentage` AS `deduct_percentage`,(ifnull(`sd_my_js_f_s`.`pack`,0) * ifnull(`sd_my_js_f_s`.`pack_per_weight`,0)) AS `pack_total_amount`,if((`sd_my_js_f_s`.`is_ingress` = 1),(((`sd_my_js_f_s`.`f_weight` - `sd_my_js_f_s`.`s_weight`) - `sd_my_js_f_s`.`deduct_weight`) - (ifnull(`sd_my_js_f_s`.`pack`,0) * ifnull(`sd_my_js_f_s`.`pack_per_weight`,0))),0) AS `in_amount`,if((`sd_my_js_f_s`.`is_ingress` = 0),((((`sd_my_js_f_s`.`s_weight` - `sd_my_js_f_s`.`f_weight`) + `sd_my_js_f_s`.`deduct_weight`) - (ifnull(`sd_my_js_f_s`.`pack`,0) * ifnull(`sd_my_js_f_s`.`pack_per_weight`,0))) * -(1)),0) AS `out_amount` from `sd_my_js_f_s`) */;

/*View structure for view sd_my_js_f_s_amount_current */

/*!50001 DROP TABLE IF EXISTS `sd_my_js_f_s_amount_current` */;
/*!50001 DROP VIEW IF EXISTS `sd_my_js_f_s_amount_current` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sd_my_js_f_s_amount_current` AS (select `sd_my_js_f_s_amount`.`id` AS `id`,`sd_my_js_f_s_amount`.`code` AS `code`,`sd_my_js_f_s_amount`.`is_ingress` AS `is_ingress`,`sd_my_js_f_s_amount`.`stage_id` AS `stage_id`,`sd_my_js_f_s_amount`.`contract_id` AS `contract_id`,`sd_my_js_f_s_amount`.`register_record_id` AS `register_record_id`,`sd_my_js_f_s_amount`.`analysis_id` AS `analysis_id`,`sd_my_js_f_s_amount`.`time` AS `time`,`sd_my_js_f_s_amount`.`allow_stage` AS `allow_stage`,`sd_my_js_f_s_amount`.`out_time` AS `out_time`,`sd_my_js_f_s_amount`.`has_second` AS `has_second`,`sd_my_js_f_s_amount`.`stock_id` AS `stock_id`,`sd_my_js_f_s_amount`.`stock_change_id` AS `stock_change_id`,`sd_my_js_f_s_amount`.`date_stock` AS `date_stock`,`sd_my_js_f_s_amount`.`f_weight` AS `f_weight`,`sd_my_js_f_s_amount`.`s_weight` AS `s_weight`,`sd_my_js_f_s_amount`.`deduct_weight` AS `deduct_weight`,`sd_my_js_f_s_amount`.`pack` AS `pack`,`sd_my_js_f_s_amount`.`pack_per_weight` AS `pack_per_weight`,`sd_my_js_f_s_amount`.`deduct_percentage` AS `deduct_percentage`,`sd_my_js_f_s_amount`.`pack_total_amount` AS `pack_total_amount`,`sd_my_js_f_s_amount`.`in_amount` AS `in_amount`,`sd_my_js_f_s_amount`.`out_amount` AS `out_amount`,`sd_my_current_simple_stock`.`audit_time` AS `audit_time` from (`grm_self`.`sd_my_js_f_s_amount` join `grm_self`.`sd_my_current_simple_stock` on((`sd_my_current_simple_stock`.`id` = `sd_my_js_f_s_amount`.`stock_id`)))) */;

/*View structure for view sd_my_js_f_s_amount_current_date */

/*!50001 DROP TABLE IF EXISTS `sd_my_js_f_s_amount_current_date` */;
/*!50001 DROP VIEW IF EXISTS `sd_my_js_f_s_amount_current_date` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sd_my_js_f_s_amount_current_date` AS (select date_format(`sd_my_js_f_s_amount_current`.`out_time`,'%Y-%m-%d') AS `format_out_time`,`sd_my_js_f_s_amount_current`.`stock_id` AS `stock_id`,`sd_my_js_f_s_amount_current`.`date_stock` AS `date_stock`,sum(`sd_my_js_f_s_amount_current`.`out_amount`) AS `total_out_amount`,sum(`sd_my_js_f_s_amount_current`.`in_amount`) AS `total_in_amount`,(sum(`sd_my_js_f_s_amount_current`.`out_amount`) + sum(`sd_my_js_f_s_amount_current`.`in_amount`)) AS `js_amount` from `grm_self`.`sd_my_js_f_s_amount_current` group by `sd_my_js_f_s_amount_current`.`date_stock`) */;

/*View structure for view sd_my_js_first */

/*!50001 DROP TABLE IF EXISTS `sd_my_js_first` */;
/*!50001 DROP VIEW IF EXISTS `sd_my_js_first` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sd_my_js_first` AS (select `sd_my_js_orgin`.`id` AS `id`,`sd_my_js_orgin`.`code` AS `code`,`sd_my_js_orgin`.`is_ingress` AS `is_ingress`,`sd_my_js_orgin`.`stage_id` AS `stage_id`,`sd_my_js_orgin`.`contract_id` AS `contract_id`,`sd_my_js_orgin`.`register_record_id` AS `register_record_id`,`sd_my_js_orgin`.`analysis_id` AS `analysis_id`,`sd_my_js_orgin`.`time` AS `time`,`sd_my_js_orgin`.`allow_stage` AS `allow_stage`,`sd_my_js_orgin`.`out_time` AS `out_time`,`sd_my_js_orgin`.`has_second` AS `has_second`,`sd_my_js_orgin`.`stock_id` AS `stock_id`,`sd_my_js_orgin`.`stock_change_id` AS `stock_change_id`,`sd_my_js_orgin`.`first_finished_stock` AS `date_stock`,`ies_weight_sheet`.`first_weight` AS `f_weight`,`ies_weight_sheet`.`second_weight` AS `s_weight`,`ies_weight_sheet`.`deduct_weight` AS `deduct_weight`,`ies_weight_sheet`.`pack` AS `pack`,`ies_weight_sheet`.`pack_per_weight` AS `pack_per_weight`,`ies_weight_sheet`.`deduct_percentage` AS `deduct_percentage` from (`sd_my_js_orgin` join `ies_weight_sheet` on((`ies_weight_sheet`.`id` = `sd_my_js_orgin`.`weight_sheet_id`)))) */;

/*View structure for view sd_my_js_orgin */

/*!50001 DROP TABLE IF EXISTS `sd_my_js_orgin` */;
/*!50001 DROP VIEW IF EXISTS `sd_my_js_orgin` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sd_my_js_orgin` AS (select `ies_ee_sheet`.`id` AS `id`,`ies_ee_sheet`.`code` AS `code`,`ies_ee_sheet`.`is_ingress` AS `is_ingress`,`ies_ee_sheet`.`stage_id` AS `stage_id`,`ies_ee_sheet`.`contract_id` AS `contract_id`,`ies_ee_sheet`.`register_record_id` AS `register_record_id`,`ies_ee_sheet`.`analysis_id` AS `analysis_id`,`ies_ee_sheet`.`weight_sheet_id` AS `weight_sheet_id`,`ies_ee_sheet`.`balance_sheet_id` AS `balance_sheet_id`,`ies_ee_sheet`.`is_finished` AS `is_finished`,`ies_ee_sheet`.`time` AS `time`,`ies_ee_sheet`.`allow_stage` AS `allow_stage`,`ies_ee_sheet`.`second_weight_sheet_id` AS `second_weight_sheet_id`,`ies_ee_sheet`.`out_time` AS `out_time`,`ies_ee_sheet`.`has_second` AS `has_second`,`ies_ee_sheet`.`second_contract_id` AS `second_contract_id`,`ies_ee_sheet`.`stock_id` AS `stock_id`,`ies_ee_sheet`.`stock_change_id` AS `stock_change_id`,`ies_ee_sheet`.`second_stock_id` AS `second_stock_id`,`ies_ee_sheet`.`second_stock_change_id` AS `second_stock_change_id`,concat(date_format(`ies_ee_sheet`.`out_time`,'%Y-%m-%d'),'__',`ies_ee_sheet`.`stock_id`) AS `first_finished_stock`,concat(date_format(`ies_ee_sheet`.`out_time`,'%Y-%m-%d'),'__',`ies_ee_sheet`.`second_stock_id`) AS `second_finished_stock` from `ies_ee_sheet` where (`ies_ee_sheet`.`is_finished` = 1)) */;

/*View structure for view sd_my_js_second */

/*!50001 DROP TABLE IF EXISTS `sd_my_js_second` */;
/*!50001 DROP VIEW IF EXISTS `sd_my_js_second` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sd_my_js_second` AS (select `sd_my_js_orgin`.`id` AS `id`,`sd_my_js_orgin`.`code` AS `code`,`sd_my_js_orgin`.`is_ingress` AS `is_ingress`,`sd_my_js_orgin`.`stage_id` AS `stage_id`,`sd_my_js_orgin`.`second_contract_id` AS `contract_id`,`sd_my_js_orgin`.`register_record_id` AS `register_record_id`,`sd_my_js_orgin`.`analysis_id` AS `analysis_id`,`sd_my_js_orgin`.`time` AS `time`,`sd_my_js_orgin`.`allow_stage` AS `allow_stage`,`sd_my_js_orgin`.`out_time` AS `out_time`,`sd_my_js_orgin`.`has_second` AS `has_second`,`sd_my_js_orgin`.`second_stock_id` AS `stock_id`,`sd_my_js_orgin`.`second_stock_change_id` AS `stock_change_id`,`sd_my_js_orgin`.`second_finished_stock` AS `date_stock`,`ies_weight_sheet`.`first_weight` AS `f_weight`,`ies_weight_sheet`.`second_weight` AS `s_weight`,`ies_weight_sheet`.`deduct_weight` AS `deduct_weight`,`ies_weight_sheet`.`pack` AS `pack`,`ies_weight_sheet`.`pack_per_weight` AS `pack_per_weight`,`ies_weight_sheet`.`deduct_percentage` AS `deduct_percentage` from (`sd_my_js_orgin` join `ies_weight_sheet` on((`ies_weight_sheet`.`id` = `sd_my_js_orgin`.`second_weight_sheet_id`)))) */;

/*View structure for view stat_changes */

/*!50001 DROP TABLE IF EXISTS `stat_changes` */;
/*!50001 DROP VIEW IF EXISTS `stat_changes` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stat_changes` AS select `a1`.`date` AS `date`,`a1`.`stock_id` AS `stock_id`,`a1`.`move_out_amount` AS `move_out_amount`,`a1`.`move_in_amount` AS `move_in_amount`,`a1`.`out_amount` AS `out_amount`,`a1`.`plus_amount` AS `plus_amount`,`a1`.`in_amount` AS `in_amount`,`a1`.`minus_amount` AS `minus_amount`,`a2`.`cargo_id` AS `cargo_id` from (`grm_self`.`stat_changes_root` `a1` left join `grm_self`.`gb_stock_id` `a2` on((`a1`.`stock_id` = `a2`.`id`))) */;

/*View structure for view stat_changes_root */

/*!50001 DROP TABLE IF EXISTS `stat_changes_root` */;
/*!50001 DROP VIEW IF EXISTS `stat_changes_root` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stat_changes_root` AS select ifnull(`sa1`.`date`,`sa2`.`date`) AS `date`,`sa1`.`source_stock_id` AS `stock_id`,ifnull(`sa1`.`move_amount_out`,0) AS `move_out_amount`,ifnull(`sa2`.`move_amount`,0) AS `move_in_amount`,ifnull(`sa1`.`out_amount`,0) AS `out_amount`,ifnull(`sa2`.`plus_amount`,0) AS `plus_amount`,ifnull(`sa2`.`in_amount`,0) AS `in_amount`,ifnull(`sa1`.`minus_amount`,0) AS `minus_amount` from (((select `m1`.`date` AS `date`,`sc`.`source_stock_id` AS `source_stock_id`,ifnull(sum(if((`sc`.`type_id` = 1),`sc`.`amount`,0)),0) AS `move_amount_out`,ifnull(sum(if((`sc`.`type_id` = 3),`sc`.`amount`,0)),0) AS `out_amount`,ifnull(sum(if((`sc`.`type_id` = 5),`sc`.`amount`,0)),0) AS `minus_amount` from (`grm_self`.`gb_stock_change` `sc` join (select `grm_self`.`meta_month`.`id` AS `id`,`grm_self`.`meta_month`.`date` AS `date`,`grm_self`.`meta_month`.`year` AS `year`,`grm_self`.`meta_month`.`month` AS `month`,`grm_self`.`meta_month`.`last_date` AS `last_date`,`grm_self`.`meta_month`.`month_name` AS `month_name`,`grm_self`.`meta_month`.`date_name` AS `date_name`,`grm_self`.`meta_month`.`content` AS `content` from `grm_self`.`meta_month` where (`grm_self`.`meta_month`.`date` < now())) `m1` on(((`m1`.`date` > (`sc`.`input_time` - interval 1 day)) and (`m1`.`last_date` <= (`sc`.`input_time` - interval 1 day))))) where (`sc`.`source_stock_id` is not null) group by `m1`.`date`,`sc`.`source_stock_id`)) `sa1` left join (select `m1`.`date` AS `date`,`sc`.`target_stock_id` AS `target_stock_id`,ifnull(sum(if((`sc`.`type_id` = 1),`sc`.`amount`,0)),0) AS `move_amount`,ifnull(sum(if((`sc`.`type_id` = 2),`sc`.`amount`,0)),0) AS `in_amount`,ifnull(sum(if((`sc`.`type_id` = 4),`sc`.`amount`,0)),0) AS `plus_amount` from (`grm_self`.`gb_stock_change` `sc` join (select `grm_self`.`meta_month`.`id` AS `id`,`grm_self`.`meta_month`.`date` AS `date`,`grm_self`.`meta_month`.`year` AS `year`,`grm_self`.`meta_month`.`month` AS `month`,`grm_self`.`meta_month`.`last_date` AS `last_date`,`grm_self`.`meta_month`.`month_name` AS `month_name`,`grm_self`.`meta_month`.`date_name` AS `date_name`,`grm_self`.`meta_month`.`content` AS `content` from `grm_self`.`meta_month` where (`grm_self`.`meta_month`.`date` < now())) `m1` on(((`m1`.`date` > (`sc`.`input_time` - interval 1 day)) and (`m1`.`last_date` <= (`sc`.`input_time` - interval 1 day))))) where (`sc`.`target_stock_id` is not null) group by `m1`.`date`,`sc`.`target_stock_id`) `sa2` on(((`sa1`.`source_stock_id` = `sa2`.`target_stock_id`) and (`sa1`.`date` = `sa2`.`date`)))) union select ifnull(`sa1`.`date`,`sa2`.`date`) AS `date`,`sa2`.`target_stock_id` AS `stock_id`,ifnull(`sa1`.`move_amount_out`,0) AS `move_out_amount`,ifnull(`sa2`.`move_amount`,0) AS `move_in_amount`,ifnull(`sa1`.`out_amount`,0) AS `out_amount`,ifnull(`sa2`.`plus_amount`,0) AS `plus_amount`,ifnull(`sa2`.`in_amount`,0) AS `in_amount`,ifnull(`sa1`.`minus_amount`,0) AS `minus_amount` from (((select `m1`.`date` AS `date`,`sc`.`target_stock_id` AS `target_stock_id`,ifnull(sum(if((`sc`.`type_id` = 1),`sc`.`amount`,0)),0) AS `move_amount`,ifnull(sum(if((`sc`.`type_id` = 2),`sc`.`amount`,0)),0) AS `in_amount`,ifnull(sum(if((`sc`.`type_id` = 4),`sc`.`amount`,0)),0) AS `plus_amount` from (`grm_self`.`gb_stock_change` `sc` join (select `grm_self`.`meta_month`.`id` AS `id`,`grm_self`.`meta_month`.`date` AS `date`,`grm_self`.`meta_month`.`year` AS `year`,`grm_self`.`meta_month`.`month` AS `month`,`grm_self`.`meta_month`.`last_date` AS `last_date`,`grm_self`.`meta_month`.`month_name` AS `month_name`,`grm_self`.`meta_month`.`date_name` AS `date_name`,`grm_self`.`meta_month`.`content` AS `content` from `grm_self`.`meta_month` where (`grm_self`.`meta_month`.`date` < now())) `m1` on(((`m1`.`date` > (`sc`.`input_time` - interval 1 day)) and (`m1`.`last_date` <= (`sc`.`input_time` - interval 1 day))))) where (`sc`.`target_stock_id` is not null) group by `m1`.`date`,`sc`.`target_stock_id`)) `sa2` left join ((select `m1`.`date` AS `date`,`sc`.`source_stock_id` AS `source_stock_id`,ifnull(sum(if((`sc`.`type_id` = 1),`sc`.`amount`,0)),0) AS `move_amount_out`,ifnull(sum(if((`sc`.`type_id` = 3),`sc`.`amount`,0)),0) AS `out_amount`,ifnull(sum(if((`sc`.`type_id` = 5),`sc`.`amount`,0)),0) AS `minus_amount` from (`grm_self`.`gb_stock_change` `sc` join (select `grm_self`.`meta_month`.`id` AS `id`,`grm_self`.`meta_month`.`date` AS `date`,`grm_self`.`meta_month`.`year` AS `year`,`grm_self`.`meta_month`.`month` AS `month`,`grm_self`.`meta_month`.`last_date` AS `last_date`,`grm_self`.`meta_month`.`month_name` AS `month_name`,`grm_self`.`meta_month`.`date_name` AS `date_name`,`grm_self`.`meta_month`.`content` AS `content` from `grm_self`.`meta_month` where (`grm_self`.`meta_month`.`date` < now())) `m1` on(((`m1`.`date` > (`sc`.`input_time` - interval 1 day)) and (`m1`.`last_date` <= (`sc`.`input_time` - interval 1 day))))) where (`sc`.`source_stock_id` is not null) group by `m1`.`date`,`sc`.`source_stock_id`)) `sa1` on(((`sa1`.`source_stock_id` = `sa2`.`target_stock_id`) and (`sa1`.`date` = `sa2`.`date`)))) */;

/*View structure for view stat_flybb */

/*!50001 DROP TABLE IF EXISTS `stat_flybb` */;
/*!50001 DROP VIEW IF EXISTS `stat_flybb` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stat_flybb` AS select `n`.`date` AS `date`,`n`.`content` AS `content`,`n`.`depot_id` AS `depot_id`,`n`.`stock_id` AS `stock_id`,`n`.`grain_variety_id` AS `grain_variety_id`,`n`.`grain_type_id` AS `grain_type_id`,`n`.`package_type_id` AS `package_type_id`,`n`.`amount` AS `amount`,`n`.`year` AS `year` from `grm_self`.`stat_month` `n` */;

/*View structure for view stat_kcb */

/*!50001 DROP TABLE IF EXISTS `stat_kcb` */;
/*!50001 DROP VIEW IF EXISTS `stat_kcb` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stat_kcb` AS select concat(`gv`.`name`,' (',`pt`.`name`,')') AS `content`,`a`.`depot_id` AS `depot_id`,`a`.`cargo_id` AS `cargo_id`,`a`.`grain_variety_id` AS `grain_variety_id`,`a`.`date` AS `date`,`a`.`amount` AS `amount`,`a`.`last_amount` AS `last_amount`,`changes`.`in_amount` AS `in_amount`,`changes`.`out_amount` AS `out_amount`,`changes`.`minus_amount` AS `minus_amount`,`changes`.`plus_amount` AS `plus_amount`,(`changes`.`move_in_amount` - `changes`.`move_out_amount`) AS `move_amount` from (((((select `yy`.`date` AS `date`,`yy`.`last_date` AS `last_date`,`yy`.`content` AS `content`,`yy`.`depot_id` AS `depot_id`,`yy`.`cargo_id` AS `cargo_id`,`yy`.`grain_variety_id` AS `grain_variety_id`,`yy`.`grain_type_id` AS `grain_type_id`,`yy`.`package_type_id` AS `package_type_id`,`yy`.`amount` AS `amount`,`yy`.`year` AS `year`,`xx`.`amount` AS `last_amount` from (((select `stat_month`.`date` AS `date`,`stat_month`.`last_date` AS `last_date`,`stat_month`.`content` AS `content`,`stat_month`.`depot_id` AS `depot_id`,`stat_month`.`cargo_id` AS `cargo_id`,`stat_month`.`grain_variety_id` AS `grain_variety_id`,`stat_month`.`grain_type_id` AS `grain_type_id`,`stat_month`.`package_type_id` AS `package_type_id`,`stat_month`.`amount` AS `amount`,`stat_month`.`year` AS `year` from `grm_self`.`stat_month`)) `yy` left join (select `stat_month`.`date` AS `date`,`stat_month`.`last_date` AS `last_date`,`stat_month`.`content` AS `content`,`stat_month`.`depot_id` AS `depot_id`,`stat_month`.`cargo_id` AS `cargo_id`,`stat_month`.`grain_variety_id` AS `grain_variety_id`,`stat_month`.`grain_type_id` AS `grain_type_id`,`stat_month`.`package_type_id` AS `package_type_id`,`stat_month`.`amount` AS `amount`,`stat_month`.`year` AS `year` from `grm_self`.`stat_month`) `xx` on(((`xx`.`date` = `yy`.`last_date`) and (`xx`.`cargo_id` = `yy`.`cargo_id`)))))) `a` left join `grm_self`.`stat_changes` `changes` on(((`a`.`date` = `changes`.`date`) and (`a`.`cargo_id` = `changes`.`cargo_id`)))) left join `grm_self`.`bt_package_type` `pt` on((`a`.`package_type_id` = `pt`.`id`))) left join `grm_self`.`sc_grain_variety` `gv` on((`a`.`grain_variety_id` = `gv`.`id`))) */;

/*View structure for view stat_kcybb */

/*!50001 DROP TABLE IF EXISTS `stat_kcybb` */;
/*!50001 DROP VIEW IF EXISTS `stat_kcybb` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stat_kcybb` AS select concat(`gv`.`name`,' (',`pt`.`name`,')') AS `content`,`a`.`depot_id` AS `depot_id`,`a`.`cargo_id` AS `cargo_id`,`a`.`grain_variety_id` AS `grain_variety_id`,`a`.`date` AS `date`,`a`.`amount` AS `amount`,ifnull(`a`.`last_amount`,0) AS `last_amount`,`changes`.`in_amount` AS `in_amount`,`changes`.`out_amount` AS `out_amount`,`changes`.`minus_amount` AS `minus_amount`,`changes`.`plus_amount` AS `plus_amount`,(`changes`.`move_in_amount` - `changes`.`move_out_amount`) AS `move_amount` from (((((select `yy`.`date` AS `date`,`yy`.`last_date` AS `last_date`,`yy`.`content` AS `content`,`yy`.`depot_id` AS `depot_id`,`yy`.`stock_id` AS `stock_id`,`yy`.`cargo_id` AS `cargo_id`,`yy`.`grain_variety_id` AS `grain_variety_id`,`yy`.`grain_type_id` AS `grain_type_id`,`yy`.`package_type_id` AS `package_type_id`,`yy`.`amount` AS `amount`,`yy`.`year` AS `year`,`xx`.`amount` AS `last_amount` from (((select `stat_month`.`date` AS `date`,`stat_month`.`last_date` AS `last_date`,`stat_month`.`content` AS `content`,`stat_month`.`stock_id` AS `stock_id`,`stat_month`.`depot_id` AS `depot_id`,`stat_month`.`cargo_id` AS `cargo_id`,`stat_month`.`grain_variety_id` AS `grain_variety_id`,`stat_month`.`grain_type_id` AS `grain_type_id`,`stat_month`.`package_type_id` AS `package_type_id`,`stat_month`.`amount` AS `amount`,`stat_month`.`year` AS `year` from `grm_self`.`stat_month`)) `yy` left join (select `stat_month`.`date` AS `date`,`stat_month`.`last_date` AS `last_date`,`stat_month`.`content` AS `content`,`stat_month`.`stock_id` AS `stock_id`,`stat_month`.`depot_id` AS `depot_id`,`stat_month`.`cargo_id` AS `cargo_id`,`stat_month`.`grain_variety_id` AS `grain_variety_id`,`stat_month`.`grain_type_id` AS `grain_type_id`,`stat_month`.`package_type_id` AS `package_type_id`,`stat_month`.`amount` AS `amount`,`stat_month`.`year` AS `year` from `grm_self`.`stat_month`) `xx` on(((`xx`.`date` = `yy`.`last_date`) and (`xx`.`stock_id` = `yy`.`stock_id`)))))) `a` left join `grm_self`.`stat_changes` `changes` on(((`a`.`date` = `changes`.`date`) and (`a`.`stock_id` = `changes`.`stock_id`)))) left join `grm_self`.`bt_package_type` `pt` on((`a`.`package_type_id` = `pt`.`id`))) left join `grm_self`.`sc_grain_variety` `gv` on((`a`.`grain_variety_id` = `gv`.`id`))) */;

/*View structure for view stat_month */

/*!50001 DROP TABLE IF EXISTS `stat_month` */;
/*!50001 DROP VIEW IF EXISTS `stat_month` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stat_month` AS select distinct `current_stock`.`id` AS `stock_id`,`current_stock`.`content` AS `content`,`current_stock`.`date` AS `date`,`current_stock`.`last_date` AS `last_date`,`depot_table`.`id` AS `depot_id`,`store_table`.`id` AS `store_id`,`compartment_table`.`id` AS `compartment_id`,`current_stock`.`cargo_id` AS `cargo_id`,`current_stock`.`grain_type_id` AS `grain_type_id`,`current_stock`.`grain_variety_id` AS `grain_variety_id`,`current_stock`.`year` AS `year`,`current_stock`.`amount` AS `amount`,`current_stock`.`package_type_id` AS `package_type_id`,`current_stock`.`package_category_id` AS `package_category_id`,`current_stock`.`location` AS `location`,`current_stock`.`business_key` AS `business_key`,ifnull(`out_stock`.`out_amount`,0) AS `out_amount`,ifnull(`in_stock`.`in_amount`,0) AS `in_amount`,ifnull(`current_stock`.`initial_amount`,0) AS `initial_amount`,concat(lpad(`depot_table`.`code_id`,3,'0'),lpad(`store_table`.`code_id`,3,'0'),lpad(`compartment_table`.`code_id`,2,'0'),lpad(`cargo_table`.`code_id`,3,'0')) AS `code`,concat(`depot_table`.`abbrev`,`store_table`.`name`,'(',`cargo_table`.`name`,') - ',`current_stock`.`business_key`) AS `cargo_name` from ((((((((select `s1`.`stock_id` AS `id`,`s1`.`cargo_id` AS `cargo_id`,`s1`.`grain_type_id` AS `grain_type_id`,`s1`.`grain_variety_id` AS `grain_variety_id`,`s1`.`year` AS `year`,`s1`.`amount` AS `initial_amount`,((`s1`.`amount` + `s1`.`in_amount`) - `s1`.`out_amount`) AS `amount`,`s1`.`package_type_id` AS `package_type_id`,`s1`.`package_category_id` AS `package_category_id`,`s1`.`location` AS `location`,`s1`.`business_key` AS `business_key`,`s1`.`input_time` AS `input_time`,`s2`.`content` AS `content`,`s2`.`date` AS `date`,`s2`.`last_date` AS `last_date` from (`grm_self`.`gb_stock_agg_sum` `s1` join (select max(`gb_stock_agg_sum`.`time`) AS `latest`,`gb_stock_agg_sum`.`stock_id` AS `stock_id`,`m`.`date` AS `date`,`m`.`content` AS `content`,`m`.`last_date` AS `last_date` from (`grm_self`.`gb_stock_agg_sum` join `grm_self`.`meta_month` `m`) where (((`gb_stock_agg_sum`.`time` - interval 1 day) < `m`.`date`) and (`m`.`date` < now())) group by `gb_stock_agg_sum`.`stock_id`,`m`.`date`) `s2` on(((`s1`.`stock_id` = `s2`.`stock_id`) and (`s1`.`time` = `s2`.`latest`)))))) `current_stock` left join (select `sco1`.`out_amount` AS `out_amount`,`sco1`.`source_stock_id` AS `source_stock_id`,`sco1`.`date` AS `date` from (select sum(ifnull(`sc1`.`amount`,0)) AS `out_amount`,`sc1`.`source_stock_id` AS `source_stock_id`,`m`.`date` AS `date` from (`grm_self`.`gb_stock_change` `sc1` join `grm_self`.`meta_month` `m`) where (((`sc1`.`input_time` - interval 1 day) < `m`.`date`) and (`sc1`.`input_time` > `m`.`last_date`) and (`sc1`.`source_stock_id` is not null) and (`m`.`date` < now())) group by `sc1`.`source_stock_id`,`m`.`date`) `sco1`) `out_stock` on(((`out_stock`.`source_stock_id` = `current_stock`.`id`) and (`current_stock`.`date` = `out_stock`.`date`)))) left join (select `sco2`.`in_amount` AS `in_amount`,`sco2`.`target_stock_id` AS `target_stock_id`,`sco2`.`date` AS `date` from (select sum(ifnull(`sc2`.`amount`,0)) AS `in_amount`,`sc2`.`target_stock_id` AS `target_stock_id`,`m`.`date` AS `date` from (`grm_self`.`gb_stock_change` `sc2` join `grm_self`.`meta_month` `m`) where (((`sc2`.`input_time` - interval 1 day) < `m`.`date`) and (`sc2`.`input_time` > `m`.`last_date`) and (`sc2`.`target_stock_id` is not null) and (`m`.`date` < now())) group by `sc2`.`target_stock_id`,`m`.`date`) `sco2`) `in_stock` on(((`in_stock`.`target_stock_id` = `current_stock`.`id`) and (`current_stock`.`date` = `in_stock`.`date`)))) left join (select `grm_self`.`grm_cargo`.`compartment_id` AS `compartment_id`,`grm_self`.`grm_cargo`.`code_id` AS `code_id`,`grm_self`.`grm_cargo`.`name` AS `name`,`grm_self`.`grm_cargo`.`id` AS `id` from `grm_self`.`grm_cargo`) `cargo_table` on((`cargo_table`.`id` = `current_stock`.`cargo_id`))) left join (select `grm_self`.`grm_compartment`.`store_id` AS `store_id`,`grm_self`.`grm_compartment`.`code_id` AS `code_id`,`grm_self`.`grm_compartment`.`id` AS `id` from `grm_self`.`grm_compartment`) `compartment_table` on((`compartment_table`.`id` = `cargo_table`.`compartment_id`))) left join (select `grm_self`.`grm_store`.`code_id` AS `code_id`,`grm_self`.`grm_store`.`name` AS `name`,`grm_self`.`grm_store`.`depot_id` AS `depot_id`,`grm_self`.`grm_store`.`id` AS `id` from `grm_self`.`grm_store`) `store_table` on((`store_table`.`id` = `compartment_table`.`store_id`))) left join (select `grm_self`.`grm_depot`.`abbrev` AS `abbrev`,`grm_self`.`grm_depot`.`code_id` AS `code_id`,`grm_self`.`grm_depot`.`id` AS `id` from `grm_self`.`grm_depot`) `depot_table` on((`store_table`.`depot_id` = `depot_table`.`id`))) */;

/*View structure for view stat_mxz */

/*!50001 DROP TABLE IF EXISTS `stat_mxz` */;
/*!50001 DROP VIEW IF EXISTS `stat_mxz` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stat_mxz` AS select `a`.`content` AS `content`,NULL AS `business_key`,NULL AS `water`,NULL AS `impurity`,`a`.`depot_id` AS `depot_id`,`a`.`stock_id` AS `stock_id`,`a`.`date` AS `date`,(`a`.`date` + interval 86399 second) AS `input_time`,`a`.`amount` AS `amount`,`a`.`last_amount` AS `last_amount`,ifnull(`changes`.`in_amount`,0) AS `in_amount`,ifnull(`changes`.`out_amount`,0) AS `out_amount`,ifnull(`changes`.`minus_amount`,0) AS `minus_amount`,ifnull(`changes`.`plus_amount`,0) AS `plus_amount`,ifnull(`changes`.`move_in_amount`,0) AS `move_in_amount`,ifnull(`changes`.`move_out_amount`,0) AS `move_out_amount`,NULL AS `water_amount`,NULL AS `impurity_amount` from (((select `yy`.`date` AS `date`,`yy`.`last_date` AS `last_date`,`yy`.`content` AS `content`,`yy`.`depot_id` AS `depot_id`,`yy`.`stock_id` AS `stock_id`,`yy`.`amount` AS `amount`,`yy`.`year` AS `year`,`xx`.`amount` AS `last_amount` from (((select `stat_month`.`date` AS `date`,`stat_month`.`last_date` AS `last_date`,`stat_month`.`content` AS `content`,`stat_month`.`depot_id` AS `depot_id`,`stat_month`.`stock_id` AS `stock_id`,`stat_month`.`amount` AS `amount`,`stat_month`.`year` AS `year` from `grm_self`.`stat_month`)) `yy` left join (select `stat_month`.`date` AS `date`,`stat_month`.`last_date` AS `last_date`,`stat_month`.`content` AS `content`,`stat_month`.`depot_id` AS `depot_id`,`stat_month`.`stock_id` AS `stock_id`,`stat_month`.`amount` AS `amount`,`stat_month`.`year` AS `year` from `grm_self`.`stat_month`) `xx` on(((`xx`.`date` = `yy`.`last_date`) and (`xx`.`stock_id` = `yy`.`stock_id`)))))) `a` left join `grm_self`.`stat_changes` `changes` on(((`a`.`date` = `changes`.`date`) and (`a`.`stock_id` = `changes`.`stock_id`)))) union select `stat_year`.`content` AS `content`,NULL AS `business_key`,NULL AS `water`,NULL AS `impurity`,`stat_year`.`depot_id` AS `depot_id`,`stat_year`.`stock_id` AS `stock_id`,`stat_year`.`date` AS `date`,`stat_year`.`date` AS `input_time`,`stat_year`.`amount` AS `amount`,NULL AS `last_amount`,NULL AS `in_amount`,NULL AS `out_amount`,NULL AS `minus_amount`,NULL AS `plus_amount`,NULL AS `move_in_amount`,NULL AS `move_out_amount`,NULL AS `water_amount`,NULL AS `impurity_amount` from `grm_self`.`stat_year` union select `sc`.`content` AS `content`,`sc`.`business_key` AS `business_key`,`sc`.`water` AS `water`,`sc`.`impurity` AS `impurity`,`depot_table`.`id` AS `depot_id`,`sc`.`source_stock_id` AS `stock_id`,cast(`sc`.`input_time` as date) AS `date`,`sc`.`input_time` AS `input_time`,`stock_agg`.`amount` AS `amount`,(`stock_agg`.`amount` + `sc`.`amount`) AS `last_amount`,0 AS `in_amount`,if((`sc`.`type_id` = 3),`sc`.`amount`,0) AS `out_amount`,if((`sc`.`type_id` = 5),`sc`.`amount`,0) AS `minus_amount`,0 AS `plus_amount`,0 AS `move_in_amount`,if((`sc`.`type_id` = 1),`sc`.`amount`,0) AS `move_out_amount`,0 AS `water_amount`,0 AS `impurity_amount` from ((((((`grm_self`.`gb_stock_change_representation` `sc` left join (select ((ifnull(`gb_stock_agg`.`amount`,0) + ifnull(`gb_stock_agg`.`in_amount`,0)) - ifnull(`gb_stock_agg`.`out_amount`,0)) AS `amount`,`gb_stock_agg`.`time` AS `time`,`gb_stock_agg`.`stock_id` AS `stock_id` from `grm_self`.`gb_stock_agg`) `stock_agg` on(((`stock_agg`.`time` = `sc`.`input_time`) and (`stock_agg`.`stock_id` = `sc`.`source_stock_id`)))) left join (select `grm_self`.`gb_stock_id`.`cargo_id` AS `cargo_id`,`grm_self`.`gb_stock_id`.`id` AS `id` from `grm_self`.`gb_stock_id`) `stock_table` on((`stock_table`.`id` = `sc`.`source_stock_id`))) left join (select `grm_self`.`grm_cargo`.`compartment_id` AS `compartment_id`,`grm_self`.`grm_cargo`.`id` AS `id` from `grm_self`.`grm_cargo`) `cargo_table` on((`cargo_table`.`id` = `stock_table`.`cargo_id`))) left join (select `grm_self`.`grm_compartment`.`store_id` AS `store_id`,`grm_self`.`grm_compartment`.`id` AS `id` from `grm_self`.`grm_compartment`) `compartment_table` on((`compartment_table`.`id` = `cargo_table`.`compartment_id`))) left join (select `grm_self`.`grm_store`.`depot_id` AS `depot_id`,`grm_self`.`grm_store`.`id` AS `id` from `grm_self`.`grm_store`) `store_table` on((`store_table`.`id` = `compartment_table`.`store_id`))) left join (select `grm_self`.`grm_depot`.`code_id` AS `code_id`,`grm_self`.`grm_depot`.`id` AS `id` from `grm_self`.`grm_depot`) `depot_table` on((`store_table`.`depot_id` = `depot_table`.`id`))) where (`sc`.`source_stock_id` is not null) union select `sc2`.`content` AS `content`,`sc2`.`business_key` AS `business_key`,`sc2`.`water` AS `water`,`sc2`.`impurity` AS `impurity`,`depot_table`.`id` AS `depot_id`,`sc2`.`target_stock_id` AS `stock_id`,cast(`sc2`.`input_time` as date) AS `date`,`sc2`.`input_time` AS `input_time`,`stock_agg`.`amount` AS `amount`,(`stock_agg`.`amount` - `sc2`.`amount`) AS `last_amount`,if((`sc2`.`type_id` = 2),`sc2`.`amount`,0) AS `in_amount`,0 AS `out_amount`,0 AS `minus_amount`,if((`sc2`.`type_id` = 4),`sc2`.`amount`,0) AS `plus_amount`,if((`sc2`.`type_id` = 1),`sc2`.`amount`,0) AS `move_in_amount`,0 AS `move_out_amount`,`stock_agg`.`water_amount` AS `water_amount`,`stock_agg`.`impurity_amount` AS `impurity_amount` from ((((((`grm_self`.`gb_stock_change_representation` `sc2` left join (select ((ifnull(`gb_stock_agg`.`amount`,0) + ifnull(`gb_stock_agg`.`in_amount`,0)) - ifnull(`gb_stock_agg`.`out_amount`,0)) AS `amount`,`gb_stock_agg`.`time` AS `time`,`gb_stock_agg`.`water_amount` AS `water_amount`,`gb_stock_agg`.`impurity_amount` AS `impurity_amount`,`gb_stock_agg`.`stock_id` AS `stock_id` from `grm_self`.`gb_stock_agg`) `stock_agg` on(((`stock_agg`.`time` = `sc2`.`input_time`) and (`stock_agg`.`stock_id` = `sc2`.`target_stock_id`)))) left join (select `grm_self`.`gb_stock_id`.`cargo_id` AS `cargo_id`,`grm_self`.`gb_stock_id`.`id` AS `id` from `grm_self`.`gb_stock_id`) `stock_table` on((`stock_table`.`id` = `sc2`.`target_stock_id`))) left join (select `grm_self`.`grm_cargo`.`compartment_id` AS `compartment_id`,`grm_self`.`grm_cargo`.`id` AS `id` from `grm_self`.`grm_cargo`) `cargo_table` on((`cargo_table`.`id` = `stock_table`.`cargo_id`))) left join (select `grm_self`.`grm_compartment`.`store_id` AS `store_id`,`grm_self`.`grm_compartment`.`id` AS `id` from `grm_self`.`grm_compartment`) `compartment_table` on((`compartment_table`.`id` = `cargo_table`.`compartment_id`))) left join (select `grm_self`.`grm_store`.`depot_id` AS `depot_id`,`grm_self`.`grm_store`.`id` AS `id` from `grm_self`.`grm_store`) `store_table` on((`store_table`.`id` = `compartment_table`.`store_id`))) left join (select `grm_self`.`grm_depot`.`code_id` AS `code_id`,`grm_self`.`grm_depot`.`id` AS `id` from `grm_self`.`grm_depot`) `depot_table` on((`store_table`.`depot_id` = `depot_table`.`id`))) where (`sc2`.`target_stock_id` is not null) */;

/*View structure for view stat_year */

/*!50001 DROP TABLE IF EXISTS `stat_year` */;
/*!50001 DROP VIEW IF EXISTS `stat_year` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stat_year` AS select `current_stock`.`id` AS `stock_id`,`current_stock`.`content` AS `content`,`current_stock`.`date` AS `date`,NULL AS `last_date`,`depot_table`.`id` AS `depot_id`,`store_table`.`id` AS `store_id`,`compartment_table`.`id` AS `compartment_id`,`current_stock`.`cargo_id` AS `cargo_id`,`current_stock`.`grain_type_id` AS `grain_type_id`,`current_stock`.`grain_variety_id` AS `grain_variety_id`,`current_stock`.`year` AS `year`,((ifnull(`current_stock`.`amount`,0) + ifnull(`in_stock`.`in_amount`,0)) - ifnull(`out_stock`.`out_amount`,0)) AS `amount`,`current_stock`.`package_type_id` AS `package_type_id`,`current_stock`.`location` AS `location`,`current_stock`.`business_key` AS `business_key`,ifnull(`out_stock`.`out_amount`,0) AS `out_amount`,ifnull(`in_stock`.`in_amount`,0) AS `in_amount`,ifnull(`current_stock`.`amount`,0) AS `initial_amount`,concat(lpad(`depot_table`.`code_id`,3,'0'),lpad(`store_table`.`code_id`,3,'0'),lpad(`compartment_table`.`code_id`,2,'0'),lpad(`cargo_table`.`code_id`,3,'0')) AS `code`,concat(`depot_table`.`abbrev`,`store_table`.`name`,'(',`cargo_table`.`name`,') - ',`current_stock`.`business_key`) AS `cargo_name` from ((((((((select `s1`.`id` AS `id`,`s1`.`cargo_id` AS `cargo_id`,`s1`.`grain_type_id` AS `grain_type_id`,`s1`.`grain_variety_id` AS `grain_variety_id`,`s1`.`year` AS `year`,`s1`.`amount` AS `amount`,`s1`.`package_type_id` AS `package_type_id`,`s1`.`location` AS `location`,`s1`.`business_key` AS `business_key`,`s1`.`input_time` AS `input_time`,`s2`.`content` AS `content`,`s2`.`date` AS `date` from (`grm_self`.`gb_stock_id` `s1` join (select max(`grm_self`.`gb_stock_id`.`input_time`) AS `latest`,`grm_self`.`gb_stock_id`.`cargo_id` AS `cargo_id`,`m`.`date` AS `date`,`m`.`content` AS `content` from (`grm_self`.`gb_stock_id` join `grm_self`.`meta_year` `m`) where ((`grm_self`.`gb_stock_id`.`input_time` < `m`.`date`) and (`m`.`date` < now())) group by `grm_self`.`gb_stock_id`.`cargo_id`,`m`.`date`) `s2` on(((`s1`.`cargo_id` = `s2`.`cargo_id`) and (`s1`.`input_time` = `s2`.`latest`)))))) `current_stock` left join (select `sco1`.`out_amount` AS `out_amount`,`sco1`.`source_stock_id` AS `source_stock_id`,`sco1`.`date` AS `date` from (select sum(ifnull(`sc1`.`amount`,0)) AS `out_amount`,`sc1`.`source_stock_id` AS `source_stock_id`,`m`.`date` AS `date` from (`grm_self`.`gb_stock_change` `sc1` join `grm_self`.`meta_year` `m`) where ((`sc1`.`input_time` < `m`.`date`) and (`m`.`date` < now())) group by `sc1`.`source_stock_id`,`m`.`date`) `sco1`) `out_stock` on(((`out_stock`.`source_stock_id` = `current_stock`.`id`) and (`current_stock`.`date` = `out_stock`.`date`)))) left join (select `sco2`.`in_amount` AS `in_amount`,`sco2`.`target_stock_id` AS `target_stock_id`,`sco2`.`date` AS `date` from (select sum(ifnull(`sc2`.`amount`,0)) AS `in_amount`,`sc2`.`target_stock_id` AS `target_stock_id`,`m`.`date` AS `date` from (`grm_self`.`gb_stock_change` `sc2` join `grm_self`.`meta_year` `m`) where ((`sc2`.`input_time` < `m`.`date`) and (`m`.`date` < now())) group by `sc2`.`target_stock_id`,`m`.`date`) `sco2`) `in_stock` on(((`in_stock`.`target_stock_id` = `current_stock`.`id`) and (`current_stock`.`date` = `in_stock`.`date`)))) left join (select `grm_self`.`grm_cargo`.`compartment_id` AS `compartment_id`,`grm_self`.`grm_cargo`.`code_id` AS `code_id`,`grm_self`.`grm_cargo`.`name` AS `name`,`grm_self`.`grm_cargo`.`id` AS `id` from `grm_self`.`grm_cargo`) `cargo_table` on((`cargo_table`.`id` = `current_stock`.`cargo_id`))) left join (select `grm_self`.`grm_compartment`.`store_id` AS `store_id`,`grm_self`.`grm_compartment`.`code_id` AS `code_id`,`grm_self`.`grm_compartment`.`id` AS `id` from `grm_self`.`grm_compartment`) `compartment_table` on((`compartment_table`.`id` = `cargo_table`.`compartment_id`))) left join (select `grm_self`.`grm_store`.`code_id` AS `code_id`,`grm_self`.`grm_store`.`name` AS `name`,`grm_self`.`grm_store`.`depot_id` AS `depot_id`,`grm_self`.`grm_store`.`id` AS `id` from `grm_self`.`grm_store`) `store_table` on((`store_table`.`id` = `compartment_table`.`store_id`))) left join (select `grm_self`.`grm_depot`.`abbrev` AS `abbrev`,`grm_self`.`grm_depot`.`code_id` AS `code_id`,`grm_self`.`grm_depot`.`id` AS `id` from `grm_self`.`grm_depot`) `depot_table` on((`store_table`.`depot_id` = `depot_table`.`id`))) */;

/*View structure for view stat_zz */

/*!50001 DROP TABLE IF EXISTS `stat_zz` */;
/*!50001 DROP VIEW IF EXISTS `stat_zz` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stat_zz` AS select `a`.`content` AS `content`,NULL AS `business_key`,NULL AS `water`,NULL AS `impurity`,`a`.`depot_id` AS `depot_id`,`a`.`stock_id` AS `stock_id`,`a`.`date` AS `date`,`a`.`grain_variety_id` AS `grain_variety_id`,`a`.`grain_type_id` AS `grain_type_id`,`a`.`amount` AS `amount`,`a`.`last_amount` AS `last_amount`,ifnull(`changes`.`in_amount`,0) AS `in_amount`,ifnull(`changes`.`out_amount`,0) AS `out_amount`,ifnull(`changes`.`minus_amount`,0) AS `minus_amount`,ifnull(`changes`.`plus_amount`,0) AS `plus_amount`,ifnull(`changes`.`move_in_amount`,0) AS `move_in_amount`,ifnull(`changes`.`move_out_amount`,0) AS `move_out_amount` from (((select `yy`.`date` AS `date`,`yy`.`last_date` AS `last_date`,`yy`.`content` AS `content`,`yy`.`depot_id` AS `depot_id`,`yy`.`stock_id` AS `stock_id`,`yy`.`grain_variety_id` AS `grain_variety_id`,`yy`.`grain_type_id` AS `grain_type_id`,`yy`.`package_type_id` AS `package_type_id`,`yy`.`amount` AS `amount`,`yy`.`year` AS `year`,`xx`.`amount` AS `last_amount` from (((select `stat_month`.`date` AS `date`,`stat_month`.`last_date` AS `last_date`,`stat_month`.`content` AS `content`,`stat_month`.`depot_id` AS `depot_id`,`stat_month`.`stock_id` AS `stock_id`,`stat_month`.`grain_variety_id` AS `grain_variety_id`,`stat_month`.`grain_type_id` AS `grain_type_id`,`stat_month`.`package_type_id` AS `package_type_id`,`stat_month`.`amount` AS `amount`,`stat_month`.`year` AS `year` from `grm_self`.`stat_month`)) `yy` left join (select `stat_month`.`date` AS `date`,`stat_month`.`last_date` AS `last_date`,`stat_month`.`content` AS `content`,`stat_month`.`depot_id` AS `depot_id`,`stat_month`.`stock_id` AS `stock_id`,`stat_month`.`grain_variety_id` AS `grain_variety_id`,`stat_month`.`grain_type_id` AS `grain_type_id`,`stat_month`.`package_type_id` AS `package_type_id`,`stat_month`.`amount` AS `amount`,`stat_month`.`year` AS `year` from `grm_self`.`stat_month`) `xx` on(((`xx`.`date` = `yy`.`last_date`) and (`xx`.`stock_id` = `yy`.`stock_id`)))))) `a` left join `grm_self`.`stat_changes` `changes` on(((`a`.`date` = `changes`.`date`) and (`a`.`stock_id` = `changes`.`stock_id`)))) union select `stat_year`.`content` AS `content`,NULL AS `business_key`,NULL AS `water`,NULL AS `impurity`,`stat_year`.`depot_id` AS `depot_id`,`stat_year`.`stock_id` AS `stock_id`,`stat_year`.`date` AS `date`,`stat_year`.`grain_variety_id` AS `grain_variety_id`,`stat_year`.`grain_type_id` AS `grain_type_id`,`stat_year`.`amount` AS `amount`,NULL AS `last_amount`,NULL AS `in_amount`,NULL AS `out_amount`,NULL AS `minus_amount`,NULL AS `plus_amount`,NULL AS `move_in_amount`,NULL AS `move_out_amount` from `grm_self`.`stat_year` */;

/*View structure for view x_month */

/*!50001 DROP TABLE IF EXISTS `x_month` */;
/*!50001 DROP VIEW IF EXISTS `x_month` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `x_month` AS select `current_stock`.`type_id` AS `type_id`,`current_stock`.`date` AS `date`,`current_stock`.`content` AS `content`,`current_stock`.`last_date` AS `last_date`,`out_stock`.`out_amount` AS `out_amount`,`in_stock`.`in_amount` AS `in_amount`,(`in_stock`.`in_amount` - `out_stock`.`out_amount`) AS `amount` from ((((select `s2`.`latest` AS `latest`,`s2`.`type_id` AS `type_id`,`s2`.`date` AS `date`,`s2`.`content` AS `content`,`s2`.`last_date` AS `last_date` from (`grm_self`.`gb_material_stock` `s1` join (select max(`grm_self`.`gb_material_stock`.`input_time`) AS `latest`,`grm_self`.`gb_material_stock`.`type_id` AS `type_id`,`m`.`date` AS `date`,`m`.`content` AS `content`,`m`.`last_date` AS `last_date` from (`grm_self`.`gb_material_stock` join `grm_self`.`meta_month` `m`) where ((`grm_self`.`gb_material_stock`.`input_time` < `m`.`date`) and (`m`.`date` < now())) group by `grm_self`.`gb_material_stock`.`type_id`,`m`.`date`) `s2` on(((`s1`.`type_id` = `s2`.`type_id`) and (`s1`.`input_time` = `s2`.`latest`)))))) `current_stock` left join (select `sco1`.`out_amount` AS `out_amount`,`sco1`.`type_id` AS `type_id`,`sco1`.`date` AS `date` from (select sum(ifnull(`sc1`.`amount`,0)) AS `out_amount`,`sc1`.`type_id` AS `type_id`,`m`.`date` AS `date` from (`grm_self`.`gb_material_request` `sc1` join `grm_self`.`meta_month` `m`) where ((`sc1`.`input_time` < `m`.`date`) and (`m`.`date` < now())) group by `sc1`.`type_id`,`m`.`date`) `sco1`) `out_stock` on(((`out_stock`.`type_id` = `current_stock`.`type_id`) and (`current_stock`.`date` = `out_stock`.`date`)))) left join (select `sco2`.`in_amount` AS `in_amount`,`sco2`.`type_id` AS `type_id`,`sco2`.`date` AS `date` from (select sum(ifnull(`sc2`.`amount`,0)) AS `in_amount`,`sc2`.`type_id` AS `type_id`,`m`.`date` AS `date` from (`grm_self`.`gb_material_stock` `sc2` join `grm_self`.`meta_month` `m`) where ((`sc2`.`input_time` < `m`.`date`) and (`m`.`date` < now())) group by `sc2`.`type_id`,`m`.`date`) `sco2`) `in_stock` on(((`in_stock`.`type_id` = `current_stock`.`type_id`) and (`current_stock`.`date` = `in_stock`.`date`)))) */;

/*View structure for view x_ybb */

/*!50001 DROP TABLE IF EXISTS `x_ybb` */;
/*!50001 DROP VIEW IF EXISTS `x_ybb` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `x_ybb` AS select `a`.`type_id` AS `type_id`,`a`.`date` AS `date`,round(`a`.`amount`,0) AS `amount`,round(`a`.`last_amount`,0) AS `last_amount`,round(`a`.`in_amount`,0) AS `in_amount`,round(`a`.`out_amount`,0) AS `out_amount` from ((select `yy`.`date` AS `date`,`yy`.`last_date` AS `last_date`,`yy`.`type_id` AS `type_id`,`yy`.`amount` AS `amount`,(`yy`.`in_amount` - ifnull(`xx`.`in_amount`,0)) AS `in_amount`,(`yy`.`out_amount` - ifnull(`xx`.`out_amount`,0)) AS `out_amount`,ifnull(`xx`.`amount`,0) AS `last_amount` from (((select `x_month`.`date` AS `date`,`x_month`.`last_date` AS `last_date`,`x_month`.`type_id` AS `type_id`,`x_month`.`amount` AS `amount`,`x_month`.`in_amount` AS `in_amount`,`x_month`.`out_amount` AS `out_amount` from `grm_self`.`x_month`)) `yy` left join (select `x_month`.`date` AS `date`,`x_month`.`last_date` AS `last_date`,`x_month`.`type_id` AS `type_id`,`x_month`.`amount` AS `amount`,`x_month`.`in_amount` AS `in_amount`,`x_month`.`out_amount` AS `out_amount` from `grm_self`.`x_month`) `xx` on(((`xx`.`date` = `yy`.`last_date`) and (`xx`.`type_id` = `yy`.`type_id`)))))) `a` */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
