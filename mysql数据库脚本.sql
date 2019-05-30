/*
 Navicat MySQL Data Transfer

 Source Server         : link
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : jeedb

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 30/05/2019 16:16:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `date` timestamp(0) NULL DEFAULT NULL,
  `grade` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `upper_id` int(11) NULL DEFAULT NULL,
  `remark` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES (0, 'root', '1234567', '广辉', '男', '717108998@qq.com', '15225158238', '莲花街100号6120', '2019-05-19 16:42:14', '1', 0, '牛逼');
INSERT INTO `admins` VALUES (2, 'sheen', '123456', 'sfes', 'sg', 'sgrg@qq.com', '16165158', 'esfs', '2019-05-26 04:37:38', '10', 0, '1');
INSERT INTO `admins` VALUES (3, 'ycc', '123456', '杨晨', '男', '18165@qq.com', '1561865165', '山西', '2019-05-26 04:39:46', '10', 0, ' 老板娘');
INSERT INTO `admins` VALUES (4, 'yangchen', '123456', '杨岑', '分', 'fefwefn@qq.com', '18656968', 'efes', '2019-05-26 04:42:26', '10', 0, 'fefe');

-- ----------------------------
-- Table structure for evaluation_record
-- ----------------------------
DROP TABLE IF EXISTS `evaluation_record`;
CREATE TABLE `evaluation_record`  (
  `evaluate_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `date` timestamp(0) NULL DEFAULT NULL,
  `level` int(11) NULL DEFAULT NULL,
  `context` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `remark` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`evaluate_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluation_record
-- ----------------------------
INSERT INTO `evaluation_record` VALUES (5, '1000020190526111059253', 1, '2019-05-28 15:54:49', 4, '16851', '4849');
INSERT INTO `evaluation_record` VALUES (6, '1000020190526105034157', 1, '2019-05-28 15:55:46', 5, 'fef', 'fege5gy6rj7t');
INSERT INTO `evaluation_record` VALUES (7, '1000020190528235629875', 1, '2019-05-28 16:10:24', 5, 'fef', 'frhtjjuyu');
INSERT INTO `evaluation_record` VALUES (8, '1000020190528232918477', 1, '2019-05-30 05:05:24', 4, '很棒', '加油');
INSERT INTO `evaluation_record` VALUES (9, '1000020190530130511444', 11, '2019-05-31 00:00:00', 3, '传递', 'vvdf');
INSERT INTO `evaluation_record` VALUES (10, '1000020190530132515444', 11, '2019-05-30 15:22:55', 5, '如果人多', '人多不');
INSERT INTO `evaluation_record` VALUES (11, '1000020190530130511444', 11, '2019-05-30 07:32:47', 3, 'hdh', '');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `theme` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES (1, 'd', 'dd', 'dd', 'dd');
INSERT INTO `feedback` VALUES (2, '建议填写', '建议填写，便于我们联络您。', '请认真填写！', '请详细填写！');
INSERT INTO `feedback` VALUES (3, '建议v', 'v便于我们联络您。', '请认 ', '请详 细填写！');
INSERT INTO `feedback` VALUES (4, '建v ', ' ，便于我们联络您。', '请认真填写！', '请详细填写！');
INSERT INTO `feedback` VALUES (5, '建议填写', 'd络您。', ' ', '请 写！');
INSERT INTO `feedback` VALUES (6, '建议填写', '建议填写，便于我们联络您。', '请认真填写！', '请详细填写！');
INSERT INTO `feedback` VALUES (7, '建议填写', '建议填写，便于我们联络您。', '请认真填写！', '请详细填写！');
INSERT INTO `feedback` VALUES (8, '建议填fef写', 'f，便于我们联络您。', 'f', 'f！');
INSERT INTO `feedback` VALUES (9, '爱迪生', '6161658@qq.com', '统计信息！', '急需，请赶紧完善');

-- ----------------------------
-- Table structure for pc_parts
-- ----------------------------
DROP TABLE IF EXISTS `pc_parts`;
CREATE TABLE `pc_parts`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `producer` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `total` int(11) NULL DEFAULT NULL,
  `remainder` int(11) NULL DEFAULT NULL,
  `bid` double NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `remark` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pc_parts
-- ----------------------------
INSERT INTO `pc_parts` VALUES (1, '给日本', '是', 'vdb', 65, 25, 5, 6, '444');
INSERT INTO `pc_parts` VALUES (2, '鼠标', '夫人夫人', '割让给', 600, 80, 40, 100, '0');
INSERT INTO `pc_parts` VALUES (3, '键盘', '硬件', '华硕', 100, 99, 20, 80, '牛逼');

-- ----------------------------
-- Table structure for repair_orders
-- ----------------------------
DROP TABLE IF EXISTS `repair_orders`;
CREATE TABLE `repair_orders`  (
  `order_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `custom_id` int(11) NULL DEFAULT NULL,
  `apply_time` timestamp(0) NULL DEFAULT NULL,
  `link_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `link_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `link_address` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `repair_time` timestamp(0) NULL DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `remark` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repair_orders
-- ----------------------------
INSERT INTO `repair_orders` VALUES ('1000020190528235629875', 1, '2019-05-28 15:56:10', '是个哈哈哈', '16896565', '恶风瑟瑟是给', '2019-05-16 15:56:22', '分工表', '分身乏术', '粉丝');
INSERT INTO `repair_orders` VALUES ('1000020190530130511443', 1, '2019-05-30 05:03:42', '宋广辉', '15225158238', '莲花街100号', '2019-05-31 05:04:33', '硬件', '键盘失灵', '急');
INSERT INTO `repair_orders` VALUES ('1000020190530130511444', 11, '2019-05-30 05:03:42', '宋广辉', '186165', '莲花街100号', '2019-05-30 00:00:00', '软件', '的', '测试');
INSERT INTO `repair_orders` VALUES ('1000020190530132515444', 11, '2019-05-28 00:00:00', 'vfvf', '16156', '莲花街100号', '2019-05-31 00:00:00', 'vfd', 'vfb', 'vfb');

-- ----------------------------
-- Table structure for repair_receipt
-- ----------------------------
DROP TABLE IF EXISTS `repair_receipt`;
CREATE TABLE `repair_receipt`  (
  `receipt_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `admin_id` int(11) NULL DEFAULT NULL,
  `repair_time` timestamp(0) NULL DEFAULT NULL,
  `need_parts` tinyint(1) NULL DEFAULT NULL,
  `parts_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `resolvent` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `advise` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `remark` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`receipt_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repair_receipt
-- ----------------------------
INSERT INTO `repair_receipt` VALUES (1, '1000120190526104124758', 4, '2019-05-26 08:18:59', 0, '若未使用，可不填！', '', '', '');
INSERT INTO `repair_receipt` VALUES (2, '1000020190526105034157', 4, '2019-05-26 08:19:04', 1, '若未使用，可不填！', 's', 'f', 'f');
INSERT INTO `repair_receipt` VALUES (6, '1000120190528233147375', 3, '2019-05-28 16:08:52', 0, '若未使用，可不填！', 'g', 'g', 'g');
INSERT INTO `repair_receipt` VALUES (7, '1000020190528232918477', 3, '2019-05-28 16:09:02', 1, 'gjyju', 'ghth', 'grgdg', 'grgrg');
INSERT INTO `repair_receipt` VALUES (8, '1000020190530130511443', 0, '2019-05-30 05:17:47', 1, '键盘', '更换', '远离水', '啊');
INSERT INTO `repair_receipt` VALUES (9, '1000020190530132515444', 4, '2019-05-30 15:23:24', 0, '0', '0', '0', '0');
INSERT INTO `repair_receipt` VALUES (10, '1000020190530130511444', 3, '2019-05-30 15:23:48', 1, '11', '11', '1', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birthday` timestamp(0) NULL DEFAULT NULL,
  `date` timestamp(0) NULL DEFAULT NULL,
  `point` int(11) NULL DEFAULT NULL,
  `unit` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'sheen', '123456', 'sgh', '男', '48646@qq.com', '168516531', 'Lianhuajie', '2019-05-04 00:00:00', '2019-05-19 15:39:04', 10, '唯e', '老板');
INSERT INTO `user` VALUES (9, 'sgh', '123456', '杨晨', '男', 'ycc@qq.com', '1522254685', 'frrfrfr', '2019-05-04 00:00:00', '2019-05-21 11:49:00', 10, 'hthfth', '0');
INSERT INTO `user` VALUES (10, 'ycc', '123456', '杨晨', '男', 'ycc@qq.com', '1522254685', 'frrfrfr', '2019-04-25 00:00:00', '2019-05-21 11:52:09', 10, 'haut', '老板娘');
INSERT INTO `user` VALUES (11, 'root', '123456', '宋广辉', '男', '71710898@qq.com', '152555484', 'frff', '2015-05-04 00:00:00', '2019-05-21 11:57:11', 10, 'ffr', 'f');
INSERT INTO `user` VALUES (12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
