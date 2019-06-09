/*
Navicat MySQL Data Transfer

Source Server         : 180502
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : db_storemanagement

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-05-13 16:46:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbadmin
-- ----------------------------
DROP TABLE IF EXISTS `tbadmin`;
CREATE TABLE `tbadmin` (
  `id` varchar(255) DEFAULT NULL,
  `pd` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbadmin
-- ----------------------------
INSERT INTO `tbadmin` VALUES ('U00', 'PD111');
INSERT INTO `tbadmin` VALUES ('U01', 'PD222');
INSERT INTO `tbadmin` VALUES ('U02', 'PD333');
INSERT INTO `tbadmin` VALUES ('U03', 'PD444');

-- ----------------------------
-- Table structure for tbgysinfo
-- ----------------------------
DROP TABLE IF EXISTS `tbgysinfo`;
CREATE TABLE `tbgysinfo` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gysaddress` varchar(50) DEFAULT NULL,
  `gysmail` varchar(50) DEFAULT NULL,
  `gystel` bigint(20) DEFAULT NULL,
  `gysbat` varchar(30) DEFAULT NULL,
  `gystax` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbgysinfo
-- ----------------------------
INSERT INTO `tbgysinfo` VALUES ('gys1002', '沁园', '重庆市南岸区崇文路2号', '1472501943@163.com', '17723601371', '6222033100003614789', '125000004504018000.0');
INSERT INTO `tbgysinfo` VALUES ('gys1005', '盛大百货', '重庆市南岸区崇文路2号', '124678456@qq.com', '17723601388', '6222033100003614456', '124561215121542992.0');
INSERT INTO `tbgysinfo` VALUES ('gys1007', '眼镜小吃', '重庆市南岸区崇文路5号', '15643142131@qq.com', '17723601562', '6222033100003614258', '745612345963250944.0');
INSERT INTO `tbgysinfo` VALUES ('gys1009', '欣欣食品', '重庆市南岸区崇文路3号', '12456123154@qq.com', '17723601275', '6222033100003614123', '742589631547895936.0');
INSERT INTO `tbgysinfo` VALUES ('gys1100', '马哥副食', '重庆市南岸区崇文路4号', '451132451@163.com', '17723601476', '6222033100003614147', '789563124756123008.0');
INSERT INTO `tbgysinfo` VALUES ('gys1101', 'TT', 'T1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for tbkhinfo
-- ----------------------------
DROP TABLE IF EXISTS `tbkhinfo`;
CREATE TABLE `tbkhinfo` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `khdj` varchar(255) DEFAULT NULL,
  `khtel` varchar(255) DEFAULT NULL,
  `khye` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbkhinfo
-- ----------------------------
INSERT INTO `tbkhinfo` VALUES ('K000', '小红', '1.0', '18523762001', '100.0');
INSERT INTO `tbkhinfo` VALUES ('K001', '小黑', '2.0', '18523762002', '200.0');
INSERT INTO `tbkhinfo` VALUES ('K002', '小白', '3.0', '18523762003', '300.0');
INSERT INTO `tbkhinfo` VALUES ('K003', '小天', '3.0', '18523762004', '400.0');
INSERT INTO `tbkhinfo` VALUES ('K004', '小王', '4.0', '18523762005', '500.0');

-- ----------------------------
-- Table structure for tbkucun
-- ----------------------------
DROP TABLE IF EXISTS `tbkucun`;
CREATE TABLE `tbkucun` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `spcd` varchar(10) DEFAULT NULL,
  `gysname` varchar(50) DEFAULT NULL,
  `spdw` varchar(5) DEFAULT NULL,
  `spdj` double(4,0) DEFAULT NULL,
  `spsl` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbkucun
-- ----------------------------
INSERT INTO `tbkucun` VALUES ('S000', '泡椒凤爪', '重庆', '沁园', '个', '3', '50');
INSERT INTO `tbkucun` VALUES ('S001', '大白兔奶糖', '四川', '盛大百货', '包', '6', '20');
INSERT INTO `tbkucun` VALUES ('S002', '彩虹糖', '贵州', '欣欣食品', '包', '5', '20');
INSERT INTO `tbkucun` VALUES ('S003', '德芙巧克力', '云南', '马哥副食', '盒', '20', '20');
INSERT INTO `tbkucun` VALUES ('S004', '巧乐兹雪糕', '北京', '眼镜小吃', '个', '4', '30');
INSERT INTO `tbkucun` VALUES ('S005', '雪碧', '上海', '沁园', '瓶', '3', '30');
INSERT INTO `tbkucun` VALUES ('S006', '可乐', '天津', '盛大百货', '瓶', '3', '30');
INSERT INTO `tbkucun` VALUES ('S007', '牛奶', '内蒙古', '欣欣食品', '盒', '5', '20');
INSERT INTO `tbkucun` VALUES ('S008', '棒棒糖', '重庆', '马哥副食', '个', '0', '30');
INSERT INTO `tbkucun` VALUES ('S009', '泡泡糖', '重庆', '眼镜小吃', '包', '2', '20');

-- ----------------------------
-- Table structure for tbrukudetail
-- ----------------------------
DROP TABLE IF EXISTS `tbrukudetail`;
CREATE TABLE `tbrukudetail` (
  `tbrkID` varchar(10) DEFAULT NULL,
  `tbSpinfo` varchar(50) DEFAULT NULL,
  `dj` float DEFAULT NULL,
  `sl` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbrukudetail
-- ----------------------------
INSERT INTO `tbrukudetail` VALUES ('IM000', '泡椒凤爪', '1.5', '100');
INSERT INTO `tbrukudetail` VALUES ('IM001', '大白兔奶糖', '4', '30');
INSERT INTO `tbrukudetail` VALUES ('IM001', '彩虹糖', '3.5', '30');
INSERT INTO `tbrukudetail` VALUES ('IM002', '德芙巧克力', '15', '50');
INSERT INTO `tbrukudetail` VALUES ('IM002', '巧乐兹雪糕', '2', '50');
INSERT INTO `tbrukudetail` VALUES ('IM002', '雪碧', '2', '50');
INSERT INTO `tbrukudetail` VALUES ('IM003', '可乐', '2', '50');
INSERT INTO `tbrukudetail` VALUES ('IM003', '牛奶', '4', '50');
INSERT INTO `tbrukudetail` VALUES ('IM004', '棒棒糖', '0.3', '50');
INSERT INTO `tbrukudetail` VALUES ('IM004', '泡泡糖', '1.5', '50');

-- ----------------------------
-- Table structure for tbrukumain
-- ----------------------------
DROP TABLE IF EXISTS `tbrukumain`;
CREATE TABLE `tbrukumain` (
  `rkid` varchar(255) DEFAULT NULL,
  `pzs` varchar(255) DEFAULT NULL,
  `je` varchar(255) DEFAULT NULL,
  `ysjl` varchar(255) DEFAULT NULL,
  `gysname` varchar(255) DEFAULT NULL,
  `rkdate` varchar(255) DEFAULT NULL,
  `czy` varchar(255) DEFAULT NULL,
  `jsr` varchar(255) DEFAULT NULL,
  `jsfs` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbrukumain
-- ----------------------------
INSERT INTO `tbrukumain` VALUES ('IM000', '1', '150.0', 'ok', '沁园', '20190102', 'C000', '张三', '现金');
INSERT INTO `tbrukumain` VALUES ('IM001', '2', '207.0', 'ok', '盛大百货', '20190225', 'C001', '李四', '支付宝');
INSERT INTO `tbrukumain` VALUES ('IM002', '3', '950.0', 'ok', '欣欣食品', '20190227', 'C002', '王五', '微信');
INSERT INTO `tbrukumain` VALUES ('IM003', '2', '300.0', 'ok', '马哥副食', '20190305', 'C003', '陈二', '银行转账');
INSERT INTO `tbrukumain` VALUES ('IM004', '2', '90.0', 'ok', '眼镜小吃', '20190405', 'C001', '李四', '支付宝');

-- ----------------------------
-- Table structure for tbselldetail
-- ----------------------------
DROP TABLE IF EXISTS `tbselldetail`;
CREATE TABLE `tbselldetail` (
  `selID` varchar(255) NOT NULL,
  `spid` varchar(255) DEFAULT NULL,
  `dj` varchar(255) DEFAULT NULL,
  `sl` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbselldetail
-- ----------------------------
INSERT INTO `tbselldetail` VALUES ('SM000', 'sp005', '2.5', '50');
INSERT INTO `tbselldetail` VALUES ('SM001', 'sp002', '5.0', '10');
INSERT INTO `tbselldetail` VALUES ('SM001', 'sp003', '20.0', '10');
INSERT INTO `tbselldetail` VALUES ('SM001', 'sp004', '3.5', '30');
INSERT INTO `tbselldetail` VALUES ('SM001', 'sp005', '3.0', '20');
INSERT INTO `tbselldetail` VALUES ('SM002', 'sp007', '5.0', '20');
INSERT INTO `tbselldetail` VALUES ('SM003', 'sp003', '20.0', '20');
INSERT INTO `tbselldetail` VALUES ('SM003', 'sp004', '3.5', '30');
INSERT INTO `tbselldetail` VALUES ('SM004', 'sp008', '0.5', '20');
INSERT INTO `tbselldetail` VALUES ('SM004', 'sp009', '2.0', '30');

-- ----------------------------
-- Table structure for tbsellmain
-- ----------------------------
DROP TABLE IF EXISTS `tbsellmain`;
CREATE TABLE `tbsellmain` (
  `sellID` varchar(255) NOT NULL,
  `khname` varchar(255) DEFAULT NULL,
  `hydj` varchar(255) DEFAULT NULL,
  `je` varchar(255) DEFAULT NULL,
  `xsdate` varchar(255) DEFAULT NULL,
  `jsr` varchar(255) DEFAULT NULL,
  `czy` varchar(255) DEFAULT NULL,
  `jsfs` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbsellmain
-- ----------------------------
INSERT INTO `tbsellmain` VALUES ('SM000', '小红', '1', '100.0', '20190405', '张三', 'U00', '微信');
INSERT INTO `tbsellmain` VALUES ('SM001', '小黑', '2', '415.0', '20190406', '李四', 'U01', '支付宝');
INSERT INTO `tbsellmain` VALUES ('SM002', '小白', '3', '100.0', '20190407', '王五', 'U02', '现金');
INSERT INTO `tbsellmain` VALUES ('SM003', '小天', '3', '145.0', '20190408', '陈二', 'U03', '支付宝');
INSERT INTO `tbsellmain` VALUES ('SM004', '小王', '4', '70.0', '20190409', '陈二', 'U03', '微信');

-- ----------------------------
-- Table structure for tbshangjiadetail
-- ----------------------------
DROP TABLE IF EXISTS `tbshangjiadetail`;
CREATE TABLE `tbshangjiadetail` (
  `sjid` varchar(255) DEFAULT NULL,
  `tbSpinfo` varchar(255) DEFAULT NULL,
  `dj` varchar(255) DEFAULT NULL,
  `sl` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbshangjiadetail
-- ----------------------------
INSERT INTO `tbshangjiadetail` VALUES ('OM000', 'S000', '2.5', '50');
INSERT INTO `tbshangjiadetail` VALUES ('OM000', 'S001', '6.0', '20');
INSERT INTO `tbshangjiadetail` VALUES ('OM001', 'S002', '5.0', '20');
INSERT INTO `tbshangjiadetail` VALUES ('OM002', 'S003', '20.0', '20');
INSERT INTO `tbshangjiadetail` VALUES ('OM003', 'S004', '3.5', '30');
INSERT INTO `tbshangjiadetail` VALUES ('OM003', 'S005', '3.0', '30');
INSERT INTO `tbshangjiadetail` VALUES ('OM003', 'S006', '3.0', '30');
INSERT INTO `tbshangjiadetail` VALUES ('OM004', 'S007', '5.0', '20');
INSERT INTO `tbshangjiadetail` VALUES ('OM004', 'S008', '0.5', '30');
INSERT INTO `tbshangjiadetail` VALUES ('OM004', 'S009', '2.0', '20');

-- ----------------------------
-- Table structure for tbshangjiamain
-- ----------------------------
DROP TABLE IF EXISTS `tbshangjiamain`;
CREATE TABLE `tbshangjiamain` (
  `sjId` varchar(255) DEFAULT NULL,
  `pzs` varchar(255) DEFAULT NULL,
  `je` varchar(255) DEFAULT NULL,
  `sjdate` varchar(255) DEFAULT NULL,
  `czy` varchar(255) DEFAULT NULL,
  `jsr` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbshangjiamain
-- ----------------------------
INSERT INTO `tbshangjiamain` VALUES ('OM000', '2', '245.0', '20190420', 'U00', '张三');
INSERT INTO `tbshangjiamain` VALUES ('OM001', '1', '100.0', '20190421', 'U01', '李四');
INSERT INTO `tbshangjiamain` VALUES ('OM002', '1', '400.0', '20190422', 'U02', '王五');
INSERT INTO `tbshangjiamain` VALUES ('OM003', '3', '285.0', '20190423', 'U03', '陈二');
INSERT INTO `tbshangjiamain` VALUES ('OM004', '3', '155.0', '20190422', 'U00', '张三');

-- ----------------------------
-- Table structure for tbspinfo
-- ----------------------------
DROP TABLE IF EXISTS `tbspinfo`;
CREATE TABLE `tbspinfo` (
  `id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `spcd` varchar(255) DEFAULT NULL,
  `spdw` varchar(255) DEFAULT NULL,
  `spdj` varchar(255) DEFAULT NULL,
  `spsl` varchar(255) DEFAULT NULL,
  `gysname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbspinfo
-- ----------------------------
INSERT INTO `tbspinfo` VALUES ('sp000', '泡椒凤爪', '重庆', '个', '2.5', '50', '沁园');
INSERT INTO `tbspinfo` VALUES ('sp001', '大白兔奶糖', '四川', '包', '6.0', '20', '盛大百货');
INSERT INTO `tbspinfo` VALUES ('sp002', '彩虹糖', '贵州', '包', '5.0', '20', '欣欣食品');
INSERT INTO `tbspinfo` VALUES ('sp003', '德芙巧克力', '云南', '盒', '20.0', '20', '马哥副食');
INSERT INTO `tbspinfo` VALUES ('sp004', '巧乐兹雪糕', '北京', '个', '3.5', '30', '眼镜小吃');
INSERT INTO `tbspinfo` VALUES ('sp005', '雪碧', '上海', '瓶', '3.0', '30', '沁园');
INSERT INTO `tbspinfo` VALUES ('sp006', '可乐', '天津', '瓶', '3.0', '30', '盛大百货');
INSERT INTO `tbspinfo` VALUES ('sp007', '牛奶', '内蒙古', '盒', '5.0', '20', '欣欣食品');
INSERT INTO `tbspinfo` VALUES ('sp008', '棒棒糖', '重庆', '个', '0.5', '30', '马哥副食');
INSERT INTO `tbspinfo` VALUES ('sp009', '泡泡糖', '重庆', '包', '2.0', '20', '眼镜小吃');
INSERT INTO `tbspinfo` VALUES ('sp10', '天天', 'tt', 'h', '1', '1', '盛大百货');

-- ----------------------------
-- Table structure for tbzg
-- ----------------------------
DROP TABLE IF EXISTS `tbzg`;
CREATE TABLE `tbzg` (
  `id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `bat` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbzg
-- ----------------------------
INSERT INTO `tbzg` VALUES ('J000', '张三', '男', '25', '13896900381', '6222033100003614111', '1');
INSERT INTO `tbzg` VALUES ('J001', '李四', '女', '26', '13896900382', '6222033100003614222', '1');
INSERT INTO `tbzg` VALUES ('J002', '王五', '男', '45', '13896900383', '6222033100003614333', '1');
INSERT INTO `tbzg` VALUES ('J003', '陈二', '女', '27', '13896900384', '6222033100003614444', '1');

-- ----------------------------
-- View structure for v_sellview
-- ----------------------------
DROP VIEW IF EXISTS `v_sellview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_sellview` AS select `tbsellmain`.`sellID` AS `sellID`,`tbsellmain`.`khname` AS `khname`,`tbsellmain`.`hydj` AS `hydj`,`tbsellmain`.`je` AS `je`,`tbsellmain`.`xsdate` AS `xsdate`,`tbsellmain`.`czy` AS `czy`,`tbsellmain`.`jsfs` AS `jsfs`,`tbselldetail`.`spid` AS `spid`,`tbselldetail`.`dj` AS `dj`,`tbselldetail`.`sl` AS `sl`,`tbspinfo`.`name` AS `name`,`tbspinfo`.`spdw` AS `spdw` from ((`tbselldetail` join `tbsellmain`) join `tbspinfo` on((`tbselldetail`.`spid` = `tbspinfo`.`id`))) ;
