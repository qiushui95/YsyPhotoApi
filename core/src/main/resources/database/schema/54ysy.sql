/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 192.168.112.128:3306
 Source Schema         : 54ysy

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 19/06/2020 17:08:46
*/

SET NAMES utf8mb4;;
SET FOREIGN_KEY_CHECKS = 0;;

-- ----------------------------
-- Table structure for ImageInfo
-- ----------------------------
CREATE TABLE IF NOT EXISTS `ImageInfo`  (
  `row` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片uuid',
  `imageUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片链接',
  `width` int(0) NOT NULL COMMENT '图片宽度',
  `height` int(0) NOT NULL COMMENT '图片高度',
  `hasDelete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `imageType` tinyint(0) NOT NULL COMMENT '图片用途,1->显示，2->头像',
  `takeTime` datetime(3) NOT NULL COMMENT '拍照时间',
  `md5` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原图片MD5',
  `userId` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'UserInfo外键id',
  `createTime` datetime(3) NOT NULL COMMENT '创建时间',
  `updateTime` datetime(3) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`row`) USING BTREE,
  INDEX `index_image_id_md5`(`id`, `md5`) USING BTREE COMMENT '图片查询索引',
  UNIQUE INDEX `unique_image_id`(`id`) USING BTREE COMMENT 'id唯一索引',
  UNIQUE INDEX `unique_image_md5`(`md5`) USING BTREE COMMENT 'md5唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图像信息表' ROW_FORMAT = DYNAMIC;;

-- ----------------------------
-- Table structure for RelationshipInfo
-- ----------------------------
CREATE TABLE IF NOT EXISTS `RelationshipInfo`  (
  `row` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关系uuid',
  `relationship` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关系说明',
  `createTime` datetime(3) NOT NULL COMMENT '创建时间',
  `updateTime` datetime(3) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`row`) USING BTREE,
  UNIQUE INDEX `unique_relationship_id`(`id`) USING BTREE COMMENT 'id唯一索引',
  UNIQUE INDEX `unique_relationship_relationship`(`relationship`) USING BTREE COMMENT 'relationship唯一索引',
  INDEX `index_relationship_id`(`id`) USING BTREE COMMENT '关系查询索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '关系表' ROW_FORMAT = DYNAMIC;;

-- ----------------------------
-- Table structure for UserInfo
-- ----------------------------
CREATE TABLE IF NOT EXISTS `UserInfo`  (
  `row` int(0) NOT NULL AUTO_INCREMENT,
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户uuid',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `avatarId` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ImageInfo  id外键',
  `relationshipId` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'RelationshipInfo id外键',
  `createTime` datetime(3) NOT NULL COMMENT '创建时间',
  `updateTime` datetime(3) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`row`) USING BTREE,
  UNIQUE INDEX `unique_user_phone`(`phone`) USING BTREE COMMENT '手机号唯一索引',
  INDEX `fk_relationship`(`relationshipId`) USING BTREE COMMENT '关系外键',
  INDEX `index_user_phone`(`phone`) USING BTREE COMMENT '手机号查询索引',
  INDEX `fk_avatar`(`avatarId`) USING BTREE COMMENT '头像图片外键',
  UNIQUE INDEX `unique_user_id`(`id`) USING BTREE COMMENT 'id唯一索引',
  INDEX `index_user_id`(`id`) USING BTREE COMMENT 'id查询索引',
  CONSTRAINT `fk_avatar` FOREIGN KEY (`avatarId`) REFERENCES `ImageInfo` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_relationship` FOREIGN KEY (`relationshipId`) REFERENCES `RelationshipInfo` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;;

-- ----------------------------
-- Triggers structure for table ImageInfo
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger_image_create`;;
CREATE TRIGGER `trigger_image_create` BEFORE INSERT ON `ImageInfo` FOR EACH ROW begin set new.updateTime=now(3); set new.createTime=now(3); end
;;

-- ----------------------------
-- Triggers structure for table ImageInfo
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger_image_update`;;
CREATE TRIGGER `trigger_image_update` BEFORE UPDATE ON `ImageInfo` FOR EACH ROW begin set new.updateTime=now(3); end
;;

-- ----------------------------
-- Triggers structure for table RelationshipInfo
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger_relationship_create`;;
CREATE TRIGGER `trigger_relationship_create` BEFORE INSERT ON `RelationshipInfo` FOR EACH ROW begin set new.updateTime=now(3); set new.createTime=now(3); end
;;

-- ----------------------------
-- Triggers structure for table RelationshipInfo
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger_relationship_update`;;
CREATE TRIGGER `trigger_relationship_update` BEFORE UPDATE ON `RelationshipInfo` FOR EACH ROW begin set new.updateTime=now(3); end
;;

-- ----------------------------
-- Triggers structure for table UserInfo
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger_user_update`;;
CREATE TRIGGER `trigger_user_update` BEFORE UPDATE ON `UserInfo` FOR EACH ROW begin set new.updateTime=now(3); end
;;

-- ----------------------------
-- Triggers structure for table UserInfo
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger_user_create`;;
CREATE TRIGGER `trigger_user_create` BEFORE INSERT ON `UserInfo` FOR EACH ROW begin set new.updateTime=now(3); set new.createTime=now(3); end
;;

SET FOREIGN_KEY_CHECKS = 1;;

SET time_zone = '+8:00';;