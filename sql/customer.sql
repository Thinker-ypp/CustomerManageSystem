/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50559
Source Host           : 127.0.0.1:3306
Source Database       : yupanpan

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-03-27 10:47:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` varchar(40) NOT NULL,
  `name` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `cellphone` varchar(10) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `preference` varchar(200) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('0c6d6cb1-dc7e-4a2c-89c3-2f9aae703350', '而我若', '男', '666666', '645470300@qq.com', '唱歌,打代码', 'VIP', '倚天剑与团购价');
INSERT INTO `customer` VALUES ('257de611-eed9-4862-a363-b4a21363d86b', '3', '男', '333333', '333@qq.com', '跳舞,打代码', '黑名单客户', '发的都是');
INSERT INTO `customer` VALUES ('2be20ba9-b529-451a-9e4c-416c366f0d82', '333', '女', '1213123123', '1231e@qq.com', '打代码', 'VIP', 'ewrew发放');
INSERT INTO `customer` VALUES ('3837aef2-de68-4f60-9c23-2b45a03bdba6', 'aaa', '男', '2313123123', '1231e@qq.com', '唱歌', 'VIP', 'ewfwefsw');
INSERT INTO `customer` VALUES ('4', 'yanyue', '女', '123456', '113445@qq.com', '旅游', '尊享VIP', '她是个坏人！！！');
INSERT INTO `customer` VALUES ('41df050b-3a94-43f1-8fb5-ddf25a3c534a', '啦啦啦', '女', '2313123123', '1231e@qq.com', '唱歌', 'VIP', 'sdfdsfds');
INSERT INTO `customer` VALUES ('5411420c-1be3-4b28-85c1-dfb0916e5801', '阿斯达', '男', '1213123123', '1231e@qq.com', '唱歌,打代码', 'VIP', '的身份是提高人体');
INSERT INTO `customer` VALUES ('5dac46fa-aaea-49da-945f-675a3b582491', '1', '男', '1213123123', '1231e@qq.com', '唱歌', 'VIP', '是多少');
INSERT INTO `customer` VALUES ('6cc63830-947b-4f86-bf2a-21ffa80c7f99', '收到货呢', '女', '666666', '645470300@qq.com', '唱歌,跳舞,打代码', '黑名单客户', '登革热导入液也让他');
INSERT INTO `customer` VALUES ('70c07a1d-33ae-4b60-8ad0-efd1be1642e8', '2', '女', '2313123123', '2275616125@qq.com', '打代码', '普通客户', '弟弟');
INSERT INTO `customer` VALUES ('7c2c984d-a7fa-4ab2-9854-2b0967e81a2a', '5555', '男', '111', '1231e@qq.com', '跳舞,打代码', 'VIP', '工会经费哈哈');
INSERT INTO `customer` VALUES ('8f185002-5d0d-45a4-877f-5b3a93b3d57c', 'bbb', '女', '2313123123', '1231e@qq.com', '唱歌', 'VIP', 'ewfwefsw');
INSERT INTO `customer` VALUES ('8f6c1467-53a9-4dba-bd4d-0070810b2b1b', '经理', '男', '1213123123', '1231e@qq.com', '唱歌', '普通客户', '拉的及案例到家啦');
INSERT INTO `customer` VALUES ('9299299e-9417-4b02-a6d6-86c6c7b337f5', '而特特', '女', '123456', '113445@qq.com', '跳舞,打代码', 'VIP', '她是个坏人！！！');
INSERT INTO `customer` VALUES ('92e3a295-3c57-4324-9305-398a0fefb80d', 'sdfesfs', 'male', '1213123123', '1231e@qq.com', '打代码', 'VIP', 'fdgdfgdfg');
INSERT INTO `customer` VALUES ('9f40cd33-19f2-42a3-a73b-db3a1b369adb', 'aaa', '男', '2313123123', '1231e@qq.com', '唱歌', 'VIP', 'ewfwefsw');
INSERT INTO `customer` VALUES ('a6e81a1b-49b3-4813-b9d9-73c94af2d75c', '4', '男', '44444', '4444445@qq.cm', '跳舞,打代码', '黑名单客户', '给大哥');
INSERT INTO `customer` VALUES ('bf2607b8-6e61-4590-8202-edde88abe8ed', '1111', '女', '2313123123', '214213@qq.com', '唱歌,跳舞,打代码', 'VIP', 'drftdt');
INSERT INTO `customer` VALUES ('c60ecfe3-920a-41b0-bb27-54cf0b523164', '让他一人', '女', '5565656', '2275616125@qq.com', '唱歌,跳舞,打代码', 'VIP', '让他以后让他一人头一回');
INSERT INTO `customer` VALUES ('c7e1a84d-dc7b-4601-bc59-09deb0fb3d0a', '看看', '女', '666666', '4444445@qq.cm', '唱歌,打代码', 'VIP', 'rgwgrwgswgswg');
INSERT INTO `customer` VALUES ('dce88b84-d767-47f1-8bd7-131ed1e6c98d', '第三方', '男', '1213123123', '333@qq.com', '唱歌,跳舞,打代码', 'VIP', '电饭锅电饭锅的');
INSERT INTO `customer` VALUES ('e103724e-e1da-471c-9776-51fd67a721e9', '假设', '女', '44222', '333@qq.com', '唱歌,跳舞,打代码', '普通客户', '热高铁听歌听歌');
INSERT INTO `customer` VALUES ('fc91858d-559f-44a5-881d-7fc426e8b300', '三方', '女', '2313123123', '1231e@qq.com', '唱歌', '黑名单客户', '所说的方式立刻返回来上课光华观府国际');
