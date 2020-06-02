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

 Date: 03/06/2020 13:49:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for AvatarRecord
-- ----------------------------
DROP TABLE IF EXISTS `AvatarRecord`;
CREATE TABLE `AvatarRecord`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '记录uuid',
  `userId` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'UserInfo id 外键',
  `imageId` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ImageInfo id 外键',
  `isCurrent` bit(1) NOT NULL COMMENT '是否为当前设置头像',
  `createTime` datetime(0) NOT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_avatar`(`userId`, `imageId`) USING BTREE COMMENT '头像唯一索引',
  INDEX `index_avatar`(`userId`, `imageId`) USING BTREE COMMENT '头像记录索引',
  INDEX `fk_image`(`imageId`) USING BTREE,
  CONSTRAINT `fk_image` FOREIGN KEY (`imageId`) REFERENCES `ImageInfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user` FOREIGN KEY (`userId`) REFERENCES `UserInfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '头像记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for ImageInfo
-- ----------------------------
DROP TABLE IF EXISTS `ImageInfo`;
CREATE TABLE `ImageInfo`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片uuid',
  `imageUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片链接',
  `width` int(0) NOT NULL COMMENT '图片宽度',
  `height` int(0) NOT NULL COMMENT '图片高度',
  `hasDelete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `imageType` tinyint(0) NOT NULL COMMENT '图片用途,1->显示，2->头像',
  `takeTime` datetime(0) NOT NULL COMMENT '拍照时间',
  `md5` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原图片MD5',
  `createTime` datetime(0) NOT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图像信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for RelationshipInfo
-- ----------------------------
DROP TABLE IF EXISTS `RelationshipInfo`;
CREATE TABLE `RelationshipInfo`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关系uuid',
  `relationship` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关系说明',
  `createTime` datetime(0) NOT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for UserInfo
-- ----------------------------
DROP TABLE IF EXISTS `UserInfo`;
CREATE TABLE `UserInfo`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户uuid',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `relationshipId` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'RelationshipInfo id外键',
  `createTime` datetime(0) NOT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_user_phone`(`phone`) USING BTREE COMMENT '手机号唯一索引',
  INDEX `fk_relationship`(`relationshipId`) USING BTREE,
  INDEX `index_user_phone`(`phone`) USING BTREE,
  CONSTRAINT `fk_relationship` FOREIGN KEY (`relationshipId`) REFERENCES `RelationshipInfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Triggers structure for table AvatarRecord
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger_avatar_create`;
delimiter ;;
CREATE TRIGGER `trigger_avatar_create` BEFORE INSERT ON `AvatarRecord` FOR EACH ROW begin
 set new.updateTime=now();
 set new.createTime=now();
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table AvatarRecord
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger_avatar_update`;
delimiter ;;
CREATE TRIGGER `trigger_avatar_update` BEFORE UPDATE ON `AvatarRecord` FOR EACH ROW begin
 set new.updateTime=now();
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table ImageInfo
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger_image_create`;
delimiter ;;
CREATE TRIGGER `trigger_image_create` BEFORE INSERT ON `ImageInfo` FOR EACH ROW begin
 set new.updateTime=now();
 set new.createTime=now();
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table ImageInfo
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger_image_update`;
delimiter ;;
CREATE TRIGGER `trigger_image_update` BEFORE UPDATE ON `ImageInfo` FOR EACH ROW begin
 set new.updateTime=now();
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table RelationshipInfo
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger_relationship_create`;
delimiter ;;
CREATE TRIGGER `trigger_relationship_create` BEFORE INSERT ON `RelationshipInfo` FOR EACH ROW begin
 set new.updateTime=now();
 set new.createTime=now();
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table RelationshipInfo
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger_relationship_update`;
delimiter ;;
CREATE TRIGGER `trigger_relationship_update` BEFORE UPDATE ON `RelationshipInfo` FOR EACH ROW begin
 set new.updateTime=now();
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table UserInfo
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger_user_create`;
delimiter ;;
CREATE TRIGGER `trigger_user_create` BEFORE INSERT ON `UserInfo` FOR EACH ROW begin
 set new.updateTime=now();
 set new.createTime=now();
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table UserInfo
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger_user_update`;
delimiter ;;
CREATE TRIGGER `trigger_user_update` BEFORE UPDATE ON `UserInfo` FOR EACH ROW begin
 set new.updateTime=now();
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
