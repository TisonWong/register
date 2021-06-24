/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : register_system

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2021-06-24 18:08:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `departments`
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments` (
  `department_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '部门名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `deleted` int(4) DEFAULT NULL COMMENT '是否已经删除',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表';

-- ----------------------------
-- Records of departments
-- ----------------------------

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
