/*
Navicat MySQL Data Transfer

Source Server         : lfxiui
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : scaffolding

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-03-01 18:44:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL COMMENT '计划名称',
  `des` varchar(255) DEFAULT NULL COMMENT '计划描述',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL,
  `create_user_name` varchar(128) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
