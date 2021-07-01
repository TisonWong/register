/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : register_system

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2021-06-25 15:55:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `departments`
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments` (
  `department_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(150) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '部门名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `deleted` int(4) DEFAULT NULL COMMENT '是否已经删除',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='部门表';

-- ----------------------------
-- Records of departments
-- ----------------------------
INSERT INTO `departments` VALUES ('1', '行政部', '2021-06-25 11:23:55', '2021-06-25 11:24:01', '0');
INSERT INTO `departments` VALUES ('2', '信息管理部', '2021-06-25 11:24:31', '2021-06-25 11:24:36', '0');
INSERT INTO `departments` VALUES ('3', '人力资源部', '2021-06-25 11:24:38', '2021-06-25 11:24:40', '0');
INSERT INTO `departments` VALUES ('4', '采购部', '2021-06-25 11:24:43', '2021-06-25 11:24:45', '0');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of members
-- ----------------------------

-- ----------------------------
-- Table structure for `registration`
-- ----------------------------
DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
  `register_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `dinner_date` datetime DEFAULT NULL COMMENT '就餐日期',
  `department_name` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `deleted` int(4) DEFAULT '0',
  PRIMARY KEY (`register_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COMMENT='登记记录表';

