/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : db_yth

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-05-17 11:57:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `id` varchar(255) NOT NULL,
  `pd` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('U00', '111');
INSERT INTO `tb_admin` VALUES ('U01', 'PD222');
INSERT INTO `tb_admin` VALUES ('U02', 'PD333');
INSERT INTO `tb_admin` VALUES ('U03', 'PD444');

-- ----------------------------
-- Table structure for tb_gysinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_gysinfo`;
CREATE TABLE `tb_gysinfo` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gysaddress` varchar(50) DEFAULT NULL,
  `gysmail` varchar(50) DEFAULT NULL,
  `gystel` bigint(20) DEFAULT NULL,
  `gysbat` varchar(30) DEFAULT NULL,
  `gystax` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_gysinfo
-- ----------------------------
INSERT INTO `tb_gysinfo` VALUES ('x123', '沁园', '重庆市南岸区崇文路1号', '1472501943@163.com', '17723601371', '6222033100003614789', '125000004504018000.0');
INSERT INTO `tb_gysinfo` VALUES ('x124', '盛大百货', '重庆市南岸区崇文路2号', '124678456@qq.com', '17723601388', '6222033100003614456', '124561215121542992.0');
INSERT INTO `tb_gysinfo` VALUES ('x125', '欣欣食品', '重庆市南岸区崇文路3号', '12456123154@qq.com', '17723601275', '6222033100003614123', '742589631547895936.0');
INSERT INTO `tb_gysinfo` VALUES ('x126', '马哥副食', '重庆市南岸区崇文路4号', '451132451@163.com', '17723601476', '6222033100003614147', '789563124756123008.0');
INSERT INTO `tb_gysinfo` VALUES ('x127', '眼镜小吃', '重庆市南岸区崇文路5号', '15643142131@qq.com', '17723601562', '6222033100003614258', '745612345963250944.0');

-- ----------------------------
-- Table structure for tb_khinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_khinfo`;
CREATE TABLE `tb_khinfo` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `khdj` varchar(255) DEFAULT NULL,
  `khtel` varchar(255) DEFAULT NULL,
  `khye` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_khinfo
-- ----------------------------
INSERT INTO `tb_khinfo` VALUES ('0003', '小明', '3', '13564286078', '100');
INSERT INTO `tb_khinfo` VALUES ('K000', '小红', '1.0', '18523762001', '100.0');
INSERT INTO `tb_khinfo` VALUES ('K001', '小黑', '2.0', '18523762002', '200.0');
INSERT INTO `tb_khinfo` VALUES ('K002', '小白', '3.0', '18523762003', '300.0');
INSERT INTO `tb_khinfo` VALUES ('K003', '小天', '3.0', '18523762004', '400.0');
INSERT INTO `tb_khinfo` VALUES ('K004', '小王', '4.0', '18523762005', '500.0');

-- ----------------------------
-- Table structure for tb_kucun
-- ----------------------------
DROP TABLE IF EXISTS `tb_kucun`;
CREATE TABLE `tb_kucun` (
  `id` varchar(10) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `spcd` varchar(10) DEFAULT NULL,
  `gysname` varchar(50) DEFAULT NULL,
  `spdw` varchar(5) DEFAULT NULL,
  `spdj` float DEFAULT NULL,
  `spsl` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_kucun
-- ----------------------------
INSERT INTO `tb_kucun` VALUES ('S000', '泡椒凤爪', '重庆', '沁园', '个', '3', '50');
INSERT INTO `tb_kucun` VALUES ('S001', '大白兔奶糖', '四川', '盛大百货', '包', '6', '20');
INSERT INTO `tb_kucun` VALUES ('S002', '彩虹糖', '贵州', '欣欣食品', '包', '5', '20');
INSERT INTO `tb_kucun` VALUES ('S003', '德芙巧克力', '云南', '马哥副食', '盒', '20', '20');
INSERT INTO `tb_kucun` VALUES ('S004', '巧乐兹雪糕', '北京', '眼镜小吃', '个', '3.5', '30');
INSERT INTO `tb_kucun` VALUES ('S005', '雪碧', '上海', '沁园', '瓶', '3', '30');
INSERT INTO `tb_kucun` VALUES ('S006', '可乐', '天津', '盛大百货', '瓶', '3', '30');
INSERT INTO `tb_kucun` VALUES ('S007', '牛奶', '内蒙古', '欣欣食品', '盒', '5', '20');
INSERT INTO `tb_kucun` VALUES ('S008', '棒棒糖', '重庆', '马哥副食', '个', '0.5', '30');
INSERT INTO `tb_kucun` VALUES ('S009', '泡泡糖', '重庆', '眼镜小吃', '包', '2', '20');

-- ----------------------------
-- Table structure for tb_rukudetail
-- ----------------------------
DROP TABLE IF EXISTS `tb_rukudetail`;
CREATE TABLE `tb_rukudetail` (
  `tbrkID` varchar(10) DEFAULT NULL,
  `tbSpinfo` varchar(50) DEFAULT NULL,
  `dj` float DEFAULT NULL,
  `sl` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_rukudetail
-- ----------------------------
INSERT INTO `tb_rukudetail` VALUES ('IM000', '泡椒凤爪', '1.5', '100');
INSERT INTO `tb_rukudetail` VALUES ('IM001', '大白兔奶糖', '4', '30');
INSERT INTO `tb_rukudetail` VALUES ('IM001', '彩虹糖', '3.5', '30');
INSERT INTO `tb_rukudetail` VALUES ('IM002', '德芙巧克力', '15', '50');
INSERT INTO `tb_rukudetail` VALUES ('IM002', '巧乐兹雪糕', '2', '50');
INSERT INTO `tb_rukudetail` VALUES ('IM002', '雪碧', '2', '50');
INSERT INTO `tb_rukudetail` VALUES ('IM003', '可乐', '2', '50');
INSERT INTO `tb_rukudetail` VALUES ('IM003', '牛奶', '4', '50');
INSERT INTO `tb_rukudetail` VALUES ('IM004', '棒棒糖', '0.3', '50');
INSERT INTO `tb_rukudetail` VALUES ('IM004', '泡泡糖', '1.5', '50');

-- ----------------------------
-- Table structure for tb_rukumain
-- ----------------------------
DROP TABLE IF EXISTS `tb_rukumain`;
CREATE TABLE `tb_rukumain` (
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
-- Records of tb_rukumain
-- ----------------------------
INSERT INTO `tb_rukumain` VALUES ('IM000', '1', '150.0', 'ok', '沁园', '20190102', 'C000', '张三', '现金');
INSERT INTO `tb_rukumain` VALUES ('IM001', '2', '207.0', 'ok', '盛大百货', '20190225', 'C001', '李四', '支付宝');
INSERT INTO `tb_rukumain` VALUES ('IM002', '3', '950.0', 'ok', '欣欣食品', '20190227', 'C002', '王五', '微信');
INSERT INTO `tb_rukumain` VALUES ('IM003', '2', '300.0', 'ok', '马哥副食', '20190305', 'C003', '陈二', '银行转账');
INSERT INTO `tb_rukumain` VALUES ('IM004', '2', '90.0', 'ok', '眼镜小吃', '20190405', 'C001', '李四', '支付宝');

-- ----------------------------
-- Table structure for tb_selldetail
-- ----------------------------
DROP TABLE IF EXISTS `tb_selldetail`;
CREATE TABLE `tb_selldetail` (
  `id` varchar(255) DEFAULT NULL,
  `spid` varchar(255) DEFAULT NULL,
  `dj` varchar(255) DEFAULT NULL,
  `sl` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_selldetail
-- ----------------------------
INSERT INTO `tb_selldetail` VALUES ('SM000', 'S005', '2.5', '50');
INSERT INTO `tb_selldetail` VALUES ('SM001', 'S002', '5.0', '10');
INSERT INTO `tb_selldetail` VALUES ('SM001', 'S003', '20.0', '10');
INSERT INTO `tb_selldetail` VALUES ('SM001', 'S004', '3.5', '30');
INSERT INTO `tb_selldetail` VALUES ('SM001', 'S005', '3.0', '20');
INSERT INTO `tb_selldetail` VALUES ('SB002', 'S007', '5.0', '20');
INSERT INTO `tb_selldetail` VALUES ('SM003', 'S003', '20.0', '20');
INSERT INTO `tb_selldetail` VALUES ('SM003', 'S004', '3.5', '30');
INSERT INTO `tb_selldetail` VALUES ('SM004', 'S008', '0.5', '20');
INSERT INTO `tb_selldetail` VALUES ('SM004', 'S009', '2.0', '30');

-- ----------------------------
-- Table structure for tb_sellmain
-- ----------------------------
DROP TABLE IF EXISTS `tb_sellmain`;
CREATE TABLE `tb_sellmain` (
  `sellID` varchar(255) DEFAULT NULL,
  `khname` varchar(255) DEFAULT NULL,
  `hydj` varchar(255) DEFAULT NULL,
  `je` varchar(255) DEFAULT NULL,
  `xsdate` varchar(255) DEFAULT NULL,
  `jsr` varchar(255) DEFAULT NULL,
  `czy` varchar(255) DEFAULT NULL,
  `jsfs` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_sellmain
-- ----------------------------
INSERT INTO `tb_sellmain` VALUES ('SM000', '小红', '1', '100.0', '20190405', '张三', 'U00', '微信');
INSERT INTO `tb_sellmain` VALUES ('SM001', '小黑', '2', '415.0', '20190406', '李四', 'U01', '支付宝');
INSERT INTO `tb_sellmain` VALUES ('SM002', '小白', '3', '100.0', '20190407', '王五', 'U02', '现金');
INSERT INTO `tb_sellmain` VALUES ('SM003', '小天', '3', '145.0', '20190408', '陈二', 'U03', '支付宝');
INSERT INTO `tb_sellmain` VALUES ('SM004', '小王', '4', '70.0', '20190409', '陈二', 'U03', '微信');

-- ----------------------------
-- Table structure for tb_shangjiadetail
-- ----------------------------
DROP TABLE IF EXISTS `tb_shangjiadetail`;
CREATE TABLE `tb_shangjiadetail` (
  `sjid` varchar(255) DEFAULT NULL,
  `tbSpinfo` varchar(255) DEFAULT NULL,
  `dj` varchar(255) DEFAULT NULL,
  `sl` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_shangjiadetail
-- ----------------------------
INSERT INTO `tb_shangjiadetail` VALUES ('OM000', 'S000', '2.5', '50');
INSERT INTO `tb_shangjiadetail` VALUES ('OM000', 'S001', '6.0', '20');
INSERT INTO `tb_shangjiadetail` VALUES ('OM001', 'S002', '5.0', '20');
INSERT INTO `tb_shangjiadetail` VALUES ('OM002', 'S003', '20.0', '20');
INSERT INTO `tb_shangjiadetail` VALUES ('OM003', 'S004', '3.5', '30');
INSERT INTO `tb_shangjiadetail` VALUES ('OM003', 'S005', '3.0', '30');
INSERT INTO `tb_shangjiadetail` VALUES ('OM003', 'S006', '3.0', '30');
INSERT INTO `tb_shangjiadetail` VALUES ('OM004', 'S007', '5.0', '20');
INSERT INTO `tb_shangjiadetail` VALUES ('OM004', 'S008', '0.5', '30');
INSERT INTO `tb_shangjiadetail` VALUES ('OM004', 'S009', '2.0', '20');

-- ----------------------------
-- Table structure for tb_shangjiamain
-- ----------------------------
DROP TABLE IF EXISTS `tb_shangjiamain`;
CREATE TABLE `tb_shangjiamain` (
  `sjId` varchar(255) DEFAULT NULL,
  `pzs` varchar(255) DEFAULT NULL,
  `je` varchar(255) DEFAULT NULL,
  `sjdate` varchar(255) DEFAULT NULL,
  `czy` varchar(255) DEFAULT NULL,
  `jsr` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_shangjiamain
-- ----------------------------
INSERT INTO `tb_shangjiamain` VALUES ('OM000', '2', '245.0', '20190420', 'U00', '张三');
INSERT INTO `tb_shangjiamain` VALUES ('OM001', '1', '100.0', '20190421', 'U01', '李四');
INSERT INTO `tb_shangjiamain` VALUES ('OM002', '1', '400.0', '20190422', 'U02', '王五');
INSERT INTO `tb_shangjiamain` VALUES ('OM003', '3', '285.0', '20190423', 'U03', '陈二');
INSERT INTO `tb_shangjiamain` VALUES ('OM004', '3', '155.0', '20190422', 'U00', '张三');

-- ----------------------------
-- Table structure for tb_spinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_spinfo`;
CREATE TABLE `tb_spinfo` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `spcd` varchar(255) DEFAULT NULL,
  `spdw` varchar(255) DEFAULT NULL,
  `spdj` varchar(255) DEFAULT NULL,
  `spsl` varchar(255) DEFAULT NULL,
  `gysname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_spinfo
-- ----------------------------
INSERT INTO `tb_spinfo` VALUES ('S001', '大白兔奶糖', '四川', '5.0', '6.0', '20', '盛大百货');
INSERT INTO `tb_spinfo` VALUES ('S002', '彩虹糖', '贵州', '包', '5.0', '20', '欣欣食品');
INSERT INTO `tb_spinfo` VALUES ('S003', '德芙巧克力', '云南', '盒', '20.0', '20', '马哥副食');
INSERT INTO `tb_spinfo` VALUES ('S004', '巧乐兹雪糕', '北京', '个', '3.5', '30', '眼镜小吃');
INSERT INTO `tb_spinfo` VALUES ('S005', '雪碧', '上海', '瓶', '3.0', '30', '沁园');
INSERT INTO `tb_spinfo` VALUES ('S006', '可乐', '天津', '瓶', '3.0', '30', '盛大百货');
INSERT INTO `tb_spinfo` VALUES ('S007', '牛奶', '内蒙古', '盒', '5.0', '20', '欣欣食品');
INSERT INTO `tb_spinfo` VALUES ('S008', '棒棒糖', '重庆', '个', '0.5', '30', '马哥副食');
INSERT INTO `tb_spinfo` VALUES ('S009', '泡泡糖', '重庆', '包', '2.0', '20', '眼镜小吃');
INSERT INTO `tb_spinfo` VALUES ('sp10', '铅笔', '浙江', '支', '2', '30', '盛大百货');

-- ----------------------------
-- Table structure for tb_zg
-- ----------------------------
DROP TABLE IF EXISTS `tb_zg`;
CREATE TABLE `tb_zg` (
  `id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `bat` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_zg
-- ----------------------------
INSERT INTO `tb_zg` VALUES ('J000', '张三', '男', '25', '13896900381', '6222033100003614111', '-1');
INSERT INTO `tb_zg` VALUES ('J001', '李四', '女', '26', '13896900382', '6222033100003614222', '1');
INSERT INTO `tb_zg` VALUES ('J002', '王五', '男', '45', '13896900383', '6222033100003614333', '1');
INSERT INTO `tb_zg` VALUES ('J003', '陈二', '女', '27', '13896900384', '6222033100003614444', '-1');
INSERT INTO `tb_zg` VALUES ('j006', '李明', '男', '26', '138846521496', '6222153478921463178', '1');

-- ----------------------------
-- View structure for v_sellview
-- ----------------------------
DROP VIEW IF EXISTS `v_sellview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_sellview` AS select `tb_sellmain`.`sellID` AS `sellID`,`tb_sellmain`.`khname` AS `khname`,`tb_sellmain`.`hydj` AS `hydj`,`tb_sellmain`.`je` AS `je`,`tb_sellmain`.`xsdate` AS `xsdate`,`tb_sellmain`.`czy` AS `czy`,`tb_sellmain`.`jsfs` AS `jsfs`,`tb_selldetail`.`spid` AS `spid`,`tb_selldetail`.`dj` AS `dj`,`tb_selldetail`.`sl` AS `sl`,`tb_spinfo`.`name` AS `name`,`tb_spinfo`.`spdw` AS `spdw` from ((`tb_selldetail` join `tb_sellmain`) join `tb_spinfo` on((`tb_selldetail`.`spid` = `tb_spinfo`.`id`))) ;
