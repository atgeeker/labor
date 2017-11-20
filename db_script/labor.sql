/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : labor1120

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-11-20 11:05:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `demission`
-- ----------------------------
DROP TABLE IF EXISTS `demission`;
CREATE TABLE `demission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `post` varchar(100) DEFAULT NULL COMMENT '工作岗位',
  `applyleavetime` date DEFAULT NULL COMMENT '申请离职时间',
  `orgagreeleavetime` date DEFAULT NULL COMMENT '单位同意离职时间',
  `orgid` bigint(20) DEFAULT NULL COMMENT '所属用工单位id',
  `orgname` varchar(100) DEFAULT NULL COMMENT '所属用工单位名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='离职信息';

-- ----------------------------
-- Records of demission
-- ----------------------------

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `gender` char(1) DEFAULT NULL COMMENT '性别',
  `nation` varchar(50) DEFAULT NULL COMMENT '民族',
  `idcardno` varchar(18) DEFAULT NULL COMMENT '身份证号码',
  `birthday` date DEFAULT NULL COMMENT '出生年月',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '家庭住址',
  `tel` varchar(20) DEFAULT NULL COMMENT '电话',
  `state` char(1) DEFAULT NULL COMMENT '状态',
  `orgid` bigint(20) DEFAULT NULL COMMENT '所属用工单位id',
  `orgname` varchar(100) DEFAULT NULL COMMENT '所属用工单位名',
  `degree` varchar(50) DEFAULT NULL COMMENT '文化程度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='员工基本信息';

-- ----------------------------
-- Records of employee
-- ----------------------------

-- ----------------------------
-- Table structure for `entry`
-- ----------------------------
DROP TABLE IF EXISTS `entry`;
CREATE TABLE `entry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `post` varchar(100) DEFAULT NULL COMMENT '工作岗位',
  `entrytime` date DEFAULT NULL COMMENT '入职时间',
  `probationbegin` date DEFAULT NULL COMMENT '试用期开始时间',
  `probationend` date DEFAULT NULL COMMENT '试用期结束时间',
  `contractbegin` date DEFAULT NULL COMMENT '合同开始时间',
  `contractend` date DEFAULT NULL COMMENT '合同结束时间',
  `orgid` bigint(20) DEFAULT NULL COMMENT '所属用工单位id',
  `orgname` varchar(100) DEFAULT NULL COMMENT '所属用工单位名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='入职信息';

-- ----------------------------
-- Records of entry
-- ----------------------------

-- ----------------------------
-- Table structure for `organization`
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) DEFAULT NULL COMMENT '单位名称',
  `type` varchar(100) DEFAULT NULL COMMENT '单位类型',
  `manager` varchar(100) DEFAULT NULL COMMENT '负责人',
  `tel` varchar(20) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用工单位';

-- ----------------------------
-- Records of organization
-- ----------------------------

-- ----------------------------
-- Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `resource_url` varchar(255) NOT NULL COMMENT '资源url',
  `resource_name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `code` varchar(255) DEFAULT NULL COMMENT '资源代码',
  `status` varchar(255) NOT NULL COMMENT '状态1-正常 2-禁用',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '资源父ID,层级关系',
  `discription` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`),
  KEY `parent_id_fk` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of resource
-- ----------------------------

-- ----------------------------
-- Table structure for `resource_role`
-- ----------------------------
DROP TABLE IF EXISTS `resource_role`;
CREATE TABLE `resource_role` (
  `resource_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`resource_id`),
  KEY `resource_id_fk` (`resource_id`),
  CONSTRAINT `resource_id_fk` FOREIGN KEY (`resource_id`) REFERENCES `resource` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源角色表';

-- ----------------------------
-- Records of resource_role
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(255) NOT NULL COMMENT '角色名称',
  `status` varchar(255) DEFAULT NULL COMMENT '状态1-正常 2-禁用',
  `discription` varchar(255) DEFAULT NULL COMMENT '角色功能描述',
  `code` varchar(255) DEFAULT NULL COMMENT '角色标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级用户', '1', '超级用户角色', 'admin');
INSERT INTO `role` VALUES ('2', '管理员', '1', '管理员角色', 'manager');
INSERT INTO `role` VALUES ('3', '普通用户', '1', '普通用户角色', 'person');

-- ----------------------------
-- Table structure for `salary`
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `base` decimal(10,2) DEFAULT NULL COMMENT '基本工资',
  `achievements` decimal(10,2) DEFAULT NULL COMMENT '绩效',
  `endowment` decimal(10,2) DEFAULT NULL COMMENT '养老保险',
  `nemployment` decimal(10,2) DEFAULT NULL COMMENT '失业保险',
  `maternity` decimal(10,2) DEFAULT NULL COMMENT '生育保险',
  `injury` decimal(10,2) DEFAULT NULL COMMENT '工伤保险',
  `medical` decimal(10,2) DEFAULT NULL COMMENT '医疗保险',
  `payablesalary` decimal(10,2) DEFAULT NULL COMMENT '应发工资',
  `realsalary` decimal(10,2) DEFAULT NULL COMMENT '实发工资',
  `state` char(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='工资信息';

-- ----------------------------
-- Records of salary
-- ----------------------------

-- ----------------------------
-- Table structure for `social_security`
-- ----------------------------
DROP TABLE IF EXISTS `social_security`;
CREATE TABLE `social_security` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `insuredtime` date DEFAULT NULL COMMENT '参保时间',
  `idcardno` varchar(18) DEFAULT NULL COMMENT '身份证号码',
  `base` decimal(10,2) DEFAULT NULL COMMENT '缴费基数',
  `endowment` decimal(10,2) DEFAULT NULL COMMENT '养老保险',
  `nemployment` decimal(10,2) DEFAULT NULL COMMENT '失业保险',
  `maternity` decimal(10,2) DEFAULT NULL COMMENT '生育保险',
  `injury` decimal(10,2) DEFAULT NULL COMMENT '工伤保险',
  `medical` decimal(10,2) DEFAULT NULL COMMENT '医疗保险',
  `securitytotal` decimal(10,2) DEFAULT NULL COMMENT '社保合计',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='社保信息';

-- ----------------------------
-- Records of social_security
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_system_log`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_system_log`;
CREATE TABLE `tbl_system_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) NOT NULL DEFAULT '',
  `create_time` varchar(20) NOT NULL DEFAULT '',
  `ip_address` varchar(30) NOT NULL DEFAULT '',
  `log_level` varchar(16) NOT NULL DEFAULT '',
  `message` varchar(256) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=726 DEFAULT CHARSET=utf8 COMMENT='系统日志记录';

-- ----------------------------
-- Records of tbl_system_log
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '用户密码(加密后)',
  `salt` varchar(255) DEFAULT NULL COMMENT '用户加密的盐值',
  `ipaddress` varchar(30) DEFAULT NULL,
  `status` char(1) DEFAULT NULL COMMENT '用户状态1-正常；2-锁定',
  `realname` varchar(128) DEFAULT '' COMMENT '用户真实姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '0f62647237ede238b6ef011599f5f46b570685bb', '6admin', 'true', '1', '超级管理员');
INSERT INTO `user` VALUES ('2', 'manager', 'f0e59c743ff1cd60f42257cc6c091d9ff51c47c4', '3manager', 'false', '1', '管理员');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `role_id_fk` (`role_id`),
  CONSTRAINT `role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '2');
INSERT INTO `user_role` VALUES ('1', '3');
