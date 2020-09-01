/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-08-30 09:53:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('1', 'JAVA01');
INSERT INTO `t_class` VALUES ('2', 'JAVA02');
INSERT INTO `t_class` VALUES ('3', 'JAVA03');
INSERT INTO `t_class` VALUES ('4', 'JAVA04');
INSERT INTO `t_class` VALUES ('104', 'JAVA0104');
INSERT INTO `t_class` VALUES ('105', 'JAVA07');

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp` (
  `eno` int(11) NOT NULL COMMENT '员工编号',
  `ename` varchar(30) NOT NULL COMMENT '员工姓名',
  `mgr` int(11) DEFAULT NULL COMMENT '上级领导编号',
  PRIMARY KEY (`eno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_emp
-- ----------------------------
INSERT INTO `t_emp` VALUES ('1', '张三', '8');
INSERT INTO `t_emp` VALUES ('2', '张小一', '1');
INSERT INTO `t_emp` VALUES ('3', '张小二', '1');
INSERT INTO `t_emp` VALUES ('4', '张小三', '1');
INSERT INTO `t_emp` VALUES ('5', '李四', '8');
INSERT INTO `t_emp` VALUES ('6', '李小一', '5');
INSERT INTO `t_emp` VALUES ('7', '李小二', '5');
INSERT INTO `t_emp` VALUES ('8', '李董', null);

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `sex` enum('男','女','保密') DEFAULT NULL,
  `age` int(11) DEFAULT '0',
  `height` double(5,2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0 正常  1 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '张三丰', '男', '100', '180.21', '1880-09-25', '1', '0');
INSERT INTO `t_student` VALUES ('2', '张无忌', '男', '28', '180.30', '1990-09-25', '3', '0');
INSERT INTO `t_student` VALUES ('3', '张翠山', '男', '50', '179.20', '1970-01-01', '2', '0');
INSERT INTO `t_student` VALUES ('4', '殷素素', '女', '45', '168.00', '1975-01-01', '2', '0');
INSERT INTO `t_student` VALUES ('5', '赵敏', '女', '28', '170.20', '1992-10-19', '3', '0');
INSERT INTO `t_student` VALUES ('6', '周芷若', '女', '28', '175.00', '1992-10-19', null, '1');
INSERT INTO `t_student` VALUES ('7', '殷天正', '男', '48', '180.30', '1972-01-01', '2', '0');
INSERT INTO `t_student` VALUES ('8', '谢逊', '男', '50', '186.30', '1960-01-01', '2', '0');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '123456', '13888888888', 'admin@126.com', '2020-08-29 15:30:00', '2020-08-29 16:30:03');
INSERT INTO `t_user` VALUES ('2', 'test', '123121', '12888888888', 'test@126.com', '2020-08-29 17:23:11', '2020-08-29 17:23:14');
