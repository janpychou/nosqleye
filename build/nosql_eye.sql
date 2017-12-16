/*
Navicat MySQL Data Transfer

Source Server         : 10.89.0.143(MySQLEYE-WEB)
Source Server Version : 50719
Source Host           : 10.89.0.143:3306
Source Database       : nosql_eye

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-09-15 10:32:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `alert_config`
-- ----------------------------
DROP TABLE IF EXISTS `alert_config`;
CREATE TABLE `alert_config` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `server_type` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '服务器类型:mysql,redis,mongodb',
  `server_id` bigint(10) NOT NULL COMMENT '服务器ID',
  `phone_numbers` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '手机号码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `last_alert_time` datetime DEFAULT NULL COMMENT '最后一次告警时间',
  `realert_seconds_later` bigint(20) DEFAULT '600' COMMENT '在多少秒后可以再次报警',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of alert_config
-- ----------------------------

-- ----------------------------
-- Table structure for `alert_list`
-- ----------------------------
DROP TABLE IF EXISTS `alert_list`;
CREATE TABLE `alert_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `server_id` bigint(20) NOT NULL COMMENT '服务器id',
  `alert_level` enum('ERROR','INFO','WARN') NOT NULL COMMENT '报警级别',
  `alert_content` varchar(255) NOT NULL COMMENT '报警内容',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_server_id` (`server_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of alert_list
-- ----------------------------

-- ----------------------------
-- Table structure for `mongodb_server`
-- ----------------------------
DROP TABLE IF EXISTS `mongodb_server`;
CREATE TABLE `mongodb_server` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `host` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '主机地址',
  `port` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '端口',
  `username` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `tags` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标签',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of mongodb_server
-- ----------------------------

-- ----------------------------
-- Table structure for `mongodb_top_history`
-- ----------------------------
DROP TABLE IF EXISTS `mongodb_top_history`;
CREATE TABLE `mongodb_top_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `server_id` bigint(20) DEFAULT NULL COMMENT 'mongodb服务器id',
  `ns` varchar(255) DEFAULT NULL COMMENT '名称空间',
  `total_count` bigint(11) DEFAULT NULL,
  `total_time` bigint(11) DEFAULT NULL,
  `total_count_persecond` varchar(11) DEFAULT NULL,
  `write_lock_count` bigint(11) DEFAULT NULL,
  `write_lock_time` bigint(11) DEFAULT NULL,
  `write_lock_count_persecond` varchar(11) DEFAULT NULL,
  `read_lock_count` bigint(11) DEFAULT NULL,
  `read_lock_time` bigint(11) DEFAULT NULL,
  `read_lock_count_persecond` varchar(11) DEFAULT NULL,
  `insert_count` bigint(11) DEFAULT NULL,
  `insert_time` bigint(11) DEFAULT NULL,
  `insert_count_persecond` varchar(11) DEFAULT NULL,
  `update_count` bigint(11) DEFAULT NULL,
  `update_time` bigint(11) DEFAULT NULL,
  `update_count_persecond` varchar(11) DEFAULT NULL,
  `get_more_count` bigint(11) DEFAULT NULL,
  `get_more_time` bigint(11) DEFAULT NULL,
  `get_more_count_persecond` varchar(11) DEFAULT NULL,
  `queries_count` bigint(11) DEFAULT NULL,
  `queries_time` bigint(11) DEFAULT NULL,
  `queries_count_persecond` varchar(11) DEFAULT NULL,
  `remove_count` bigint(11) DEFAULT NULL,
  `remove_time` bigint(11) DEFAULT NULL,
  `remove_count_persecond` varchar(11) DEFAULT NULL,
  `commands_count` bigint(11) DEFAULT NULL,
  `commands_time` bigint(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10295132 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mongodb_top_history
-- ----------------------------

-- ----------------------------
-- Table structure for `redis_cluster`
-- ----------------------------
DROP TABLE IF EXISTS `redis_cluster`;
CREATE TABLE `redis_cluster` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '集群名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of redis_cluster
-- ----------------------------

-- ----------------------------
-- Table structure for `redis_server`
-- ----------------------------
DROP TABLE IF EXISTS `redis_server`;
CREATE TABLE `redis_server` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `host` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '主机地址',
  `port` int(10) NOT NULL COMMENT '端口',
  `password` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `tags` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标签',
  `cluster_id` bigint(20) DEFAULT NULL COMMENT '集群ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of redis_server
-- ----------------------------

-- ----------------------------
-- Table structure for `redis_status_history`
-- ----------------------------
DROP TABLE IF EXISTS `redis_status_history`;
CREATE TABLE `redis_status_history` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `server_id` bigint(20) NOT NULL COMMENT 'redis server id',
  `connected_clients` varchar(255) DEFAULT NULL,
  `blocked_clients` varchar(255) DEFAULT NULL,
  `used_memory` varchar(255) DEFAULT NULL,
  `used_memory_human` varchar(255) DEFAULT NULL,
  `used_memory_rss` varchar(255) DEFAULT NULL,
  `used_memory_rss_human` varchar(255) DEFAULT NULL,
  `used_memory_peak` varchar(255) DEFAULT NULL,
  `used_memory_peak_human` varchar(255) DEFAULT NULL,
  `mem_fragmentation_ratio` varchar(20) DEFAULT NULL,
  `total_system_memory` varchar(255) DEFAULT NULL,
  `total_system_memory_human` varchar(255) DEFAULT NULL,
  `total_connections_received` varchar(255) DEFAULT NULL,
  `total_commands_processed` varchar(255) DEFAULT NULL,
  `instantaneous_ops_per_sec` varchar(255) DEFAULT NULL,
  `total_net_input_bytes` varchar(255) DEFAULT NULL,
  `total_net_output_bytes` varchar(255) DEFAULT NULL,
  `expired_keys` varchar(255) DEFAULT NULL,
  `used_cpu_sys` varchar(255) DEFAULT NULL,
  `used_cpu_user` varchar(255) DEFAULT NULL,
  `keyspace` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pk_server_id_create_time` (`server_id`,`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12021432 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of redis_status_history
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码（MD5密文）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_username` (`username`),
  KEY `idx_test` (`password`,`create_time`,`modify_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '2017-04-13 17:44:49', '2017-04-13 17:44:56');
