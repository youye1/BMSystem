/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.31 : Database - bms
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bms_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bms_db`;

/*Table structure for table `book` */
CREATE TABLE `book` (
  `id` varchar(50) NOT NULL COMMENT '编号',
  `name` varchar(50) NOT NULL COMMENT '书名',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `interpreter` varchar(50) DEFAULT NULL COMMENT '译者',
  `type` varchar(50) NOT NULL COMMENT '类别',
  `publish` varchar(50) DEFAULT NULL COMMENT '出版社',
  `price` double DEFAULT NULL COMMENT '价格',
  `count` int(11) DEFAULT NULL COMMENT '总页数',
  `print_date` date DEFAULT NULL COMMENT '出版日期',
  `imgUrl` varchar(225) DEFAULT NULL COMMENT '封面图URL',
  `description` varchar(0) DEFAULT NULL COMMENT '书籍介绍文本路径',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新者',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  `remarks` varchar(225) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `type` (
  `id` varchar(50) NOT NULL COMMENT '编号',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `parent_id` varchar(225) DEFAULT NULL COMMENT '父类别',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新者',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  `remarks` varchar(225) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `user` (
  `id` varchar(50) NOT NULL COMMENT '编号',
  `name` varchar(50) NOT NULL COMMENT '登录名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `phone` decimal(10,0) DEFAULT NULL COMMENT '联系方式',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新者',
  `imgUrl` varchar(225) DEFAULT NULL COMMENT '头像',
  `introduction` varchar(225) DEFAULT NULL COMMENT '简介',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  `remarks` varchar(225) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


insert into `book` (`id`, `name`, `author`, `interpreter`, `type`, `publish`, `price`, `count`, `print_date`, `imgUrl`, `description`, `create_date`, `update_date`, `create_by`, `update_by`, `del_flag`, `remarks`) values('1bd056c8e9864d4b9a848630d3838dff','从你的全世界路过','张嘉佳','无人头','6b6b8471-5f61-11e6-a93b-408d5cc10d3b','北京十月文艺出版社','11','1111',NULL,'12','','2016-08-11 00:00:00','2016-08-11 15:15:46',NULL,NULL,'0',NULL);
insert into `book` (`id`, `name`, `author`, `interpreter`, `type`, `publish`, `price`, `count`, `print_date`, `imgUrl`, `description`, `create_date`, `update_date`, `create_by`, `update_by`, `del_flag`, `remarks`) values('518cb880c4914ebebe83cb8a58f309c5','萨哈的故事','三毛','无','6b6b8471-5f61-11e6-a93b-408d5cc10d3b','北京十月文艺出版社',NULL,NULL,NULL,'','','2016-08-11 00:00:00','2016-08-11 00:00:00',NULL,NULL,'1',NULL);
insert into `book` (`id`, `name`, `author`, `interpreter`, `type`, `publish`, `price`, `count`, `print_date`, `imgUrl`, `description`, `create_date`, `update_date`, `create_by`, `update_by`, `del_flag`, `remarks`) values('cb4163d04b424487b71df0330840db02','温柔的夜','三毛','无','6b6b8471-5f61-11e6-a93b-408d5cc10d3b','北京十月文艺出版社',NULL,NULL,NULL,'','','2016-08-11 14:20:29','2016-08-11 14:20:29',NULL,NULL,'0',NULL);
insert into `book` (`id`, `name`, `author`, `interpreter`, `type`, `publish`, `price`, `count`, `print_date`, `imgUrl`, `description`, `create_date`, `update_date`, `create_by`, `update_by`, `del_flag`, `remarks`) values('d5b2642f20c14ce99e92a53db924819d','稻草人笔记','三毛','无','北京十月文艺出版社','北京十月文艺出版社',NULL,NULL,NULL,'','','2016-08-11 00:00:00','2016-08-11 14:57:28',NULL,NULL,'0',NULL);


insert into `type` (`id`, `name`, `parent_id`, `create_date`, `update_date`, `create_by`, `update_by`, `del_flag`, `remarks`) values('6b6b8471-5f61-11e6-a93b-408d5cc10d3b','科技',NULL,'2016-08-11 00:00:00','2016-08-11 00:00:00',NULL,NULL,'0',NULL);
insert into `type` (`id`, `name`, `parent_id`, `create_date`, `update_date`, `create_by`, `update_by`, `del_flag`, `remarks`) values('7ccf3eff-5f61-11e6-a93b-408d5cc10d3b','文学',NULL,'2016-08-11 00:00:00','2016-08-11 00:00:00',NULL,NULL,'0',NULL);


insert into `user` (`id`, `name`, `password`, `user_name`, `phone`, `create_date`, `update_date`, `create_by`, `update_by`, `imgUrl`, `introduction`, `del_flag`, `remarks`) values('111','youye','123456','youye',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0',NULL);
