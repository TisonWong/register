/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : register_system

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2021-06-24 18:08:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `members`
-- ----------------------------
DROP TABLE IF EXISTS `members`;
CREATE TABLE `members` (
  `member_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `member_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `member_phone` varchar(150) DEFAULT NULL COMMENT '用户电话',
  `member_email` varchar(200) DEFAULT NULL COMMENT '用户邮箱',
  `member_identity` varchar(20) DEFAULT NULL COMMENT '用户身份（admin/user)',
  `member_pwd` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `department_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `deleted` int(4) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- ----------------------------
-- Records of members
-- ----------------------------
