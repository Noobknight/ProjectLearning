/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : productsell

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-04-27 17:05:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `level` tinyint(3) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `time_create` datetime DEFAULT NULL,
  `time_update` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` varchar(12) NOT NULL,
  `image` text,
  `link` text,
  `category_id` int(11) DEFAULT NULL,
  `time_update` datetime DEFAULT NULL,
  `time_create` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
