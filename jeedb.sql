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

 Date: 29/05/2019 00:15:17
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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluation_record
-- ----------------------------
INSERT INTO `evaluation_record` VALUES (5, '1000020190526111059253', 1, '2019-05-28 15:54:49', 4, '16851', '4849');
INSERT INTO `evaluation_record` VALUES (6, '1000020190526105034157', 1, '2019-05-28 15:55:46', 5, 'fef', 'fege5gy6rj7t');
INSERT INTO `evaluation_record` VALUES (7, '1000020190528235629875', 1, '2019-05-28 16:10:24', 5, 'fef', 'frhtjjuyu');

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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `repair_orders` VALUES ('1000120190526104124758', 1, '2019-05-26 02:41:10', 'fesf', '4165', 'fses', '2019-05-31 02:41:17', 'fe', 'fse', 'sef');
INSERT INTO `repair_orders` VALUES ('1000020190526105034157', 1, '2019-05-26 02:50:13', '分色法', '486165', '十分十分', '2019-05-03 02:50:26', '是v', '发', '分');
INSERT INTO `repair_orders` VALUES ('1000020190526105304610', 1, '2019-05-26 02:52:49', '瑟夫', '发', '方式', '2019-05-28 02:52:55', '方式', '方式', '人');
INSERT INTO `repair_orders` VALUES ('1000020190526105502461', 1, '2019-05-26 02:54:44', '分', '1865', '二分', '2019-05-28 02:54:52', '发', '个人', '给');
INSERT INTO `repair_orders` VALUES ('1000020190526111059253', 1, '2019-05-26 03:10:37', 'efe', '15', 'fef', '2019-05-21 03:10:53', 'fes', 'sefe', 'se');
INSERT INTO `repair_orders` VALUES ('1000020190528232918477', 1, '2019-05-28 15:29:05', '', 'cs', 'cs', '2019-05-14 15:29:13', 'scs', 'vs', 'vs');
INSERT INTO `repair_orders` VALUES ('1000120190528233147375', 11, '2019-05-28 15:31:35', 'd', '1865', 'de', '2019-05-22 15:31:41', 'fe', 'fe', 'fef');
INSERT INTO `repair_orders` VALUES ('1000020190528235629875', 1, '2019-05-28 15:56:10', '是个哈哈哈', '16896565', '恶风瑟瑟是给', '2019-05-16 15:56:22', '分工表', '分身乏术', '粉丝');

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
INSERT INTO `repair_receipt` VALUES (3, '1000020190526111059253', 4, '2019-05-26 08:47:03', 1, '413', 'vdv', 'VS发v', '重试');
INSERT INTO `repair_receipt` VALUES (4, '1000120190528233147375', 2, '2019-05-27 07:11:29', 0, '若未使用，可不填！', '', '', '');
INSERT INTO `repair_receipt` VALUES (5, '1000020190528235629875', 3, '2019-05-28 16:08:33', 1, 'grgrg', 'grgr', 'grdgd', 'gdrgdr');
INSERT INTO `repair_receipt` VALUES (6, '1000120190528233147375', 3, '2019-05-28 16:08:52', 0, '若未使用，可不填！', 'g', 'g', 'g');
INSERT INTO `repair_receipt` VALUES (7, '1000020190528232918477', 3, '2019-05-28 16:09:02', 1, 'gjyju', 'ghth', 'grgdg', 'grgrg');

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
INSERT INTO `user` VALUES (1, 'sheen', '123456', 'sgh', '男', '48646@qq.com', '168516531', 'sffrsfrsfrs', '2019-05-05 00:00:00', '2019-05-19 15:39:04', 10, '唯e', '老板');
INSERT INTO `user` VALUES (9, 'sgh', '123456', '杨晨', '男', 'ycc@qq.com', '1522254685', 'frrfrfr', '2019-05-04 00:00:00', '2019-05-21 11:49:00', 10, 'hthfth', '0');
INSERT INTO `user` VALUES (10, 'ycc', '123456', '杨晨', '男', 'ycc@qq.com', '1522254685', 'frrfrfr', '2019-04-25 00:00:00', '2019-05-21 11:52:09', 10, 'haut', '老板娘');
INSERT INTO `user` VALUES (11, 'root', '123456', '宋广辉', '男', '71710898@qq.com', '152555484', 'frff', '2015-05-04 00:00:00', '2019-05-21 11:57:11', 10, 'ffr', 'f');

SET FOREIGN_KEY_CHECKS = 1;
