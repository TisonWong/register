/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : register_system

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2021-06-24 18:08:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `registration`
-- ----------------------------
DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
  `register_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL COMMENT '人员ID',
  `dinner_date` datetime DEFAULT NULL COMMENT '就餐日期',
  `register_date` datetime DEFAULT NULL COMMENT '登记日期',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `deleted` int(4) DEFAULT '0',
  PRIMARY KEY (`register_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='登记记录表';

-- ----------------------------
-- Records of registration
-- ----------------------------
