# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.17)
# Database: second_hand_car
# Generation Time: 2017-10-17 02:35:07 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table second_hand_car
# ------------------------------------------------------------

DROP TABLE IF EXISTS `second_hand_car`;

CREATE TABLE `second_hand_car` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `car_id` varchar(25) NOT NULL DEFAULT '' COMMENT '车辆ID',
  `title` varchar(255) NOT NULL DEFAULT '' COMMENT '车辆标题',
  `license_date` datetime NOT NULL COMMENT '上牌日期',
  `road_haul` varchar(11) NOT NULL DEFAULT '' COMMENT '行驶里程',
  `thumb_img` varchar(512) DEFAULT NULL COMMENT '缩略图',
  `price` varchar(11) NOT NULL DEFAULT '' COMMENT '总价',
  `first_pay` varchar(11) NOT NULL DEFAULT '' COMMENT '首付',
  `new_post` tinyint(1) DEFAULT NULL COMMENT '是否新上架',
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  `order_no` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='二手车基础表';



# Dump of table second_hand_car_config_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `second_hand_car_config_detail`;

CREATE TABLE `second_hand_car_config_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='二手车详细配置表';



# Dump of table second_hand_car_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `second_hand_car_detail`;

CREATE TABLE `second_hand_car_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `car_id` varchar(25) NOT NULL DEFAULT '' COMMENT '二手车表中的cardId',
  `air_displacement` varchar(10) NOT NULL DEFAULT '' COMMENT '排放量',
  `gearbox` varchar(10) NOT NULL DEFAULT '' COMMENT '变速箱类型',
  `seller` varchar(10) NOT NULL DEFAULT '' COMMENT '售卖者',
  `seller_job` varchar(10) NOT NULL DEFAULT '' COMMENT '售卖者职业',
  `transfer_num` varchar(10) NOT NULL DEFAULT '' COMMENT '过户次数',
  `card_city` varchar(10) NOT NULL DEFAULT '' COMMENT '车牌所在地',
  `district_name` varchar(10) NOT NULL DEFAULT '' COMMENT '所在区名',
  `seller_description` varchar(512) NOT NULL DEFAULT '' COMMENT '卖家描述',
  `audit_date` varchar(10) NOT NULL DEFAULT '' COMMENT '年检到期描述',
  `strong_insurance_date` varchar(10) NOT NULL DEFAULT '' COMMENT '交强险到期描述',
  `insurance_date` varchar(10) NOT NULL DEFAULT '' COMMENT '商业险到期描述',
  `deal_price` varchar(10) NOT NULL DEFAULT '' COMMENT '折让价',
  `new_price` varchar(10) NOT NULL DEFAULT '' COMMENT '新车价格',
  `use_date` varchar(10) NOT NULL DEFAULT '' COMMENT '使用年限',
  `follow_num` varchar(10) NOT NULL DEFAULT '' COMMENT '关注人数',
  `emission_standard` varchar(10) NOT NULL DEFAULT '' COMMENT '排放标准',
  `emission_standard_desc` varchar(128) NOT NULL DEFAULT '' COMMENT '排放标准提示',
  `emission_standards_url` varchar(512) NOT NULL DEFAULT '' COMMENT '排放标准提示h5 url',
  `hege_icon` varchar(128) NOT NULL DEFAULT '' COMMENT '合格证图标',
  `evaluator_desc` varchar(512) NOT NULL DEFAULT '' COMMENT '检测描述',
  `phone` varchar(10) NOT NULL DEFAULT '' COMMENT '联系电话',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='二手车详情表';



# Dump of table second_hand_car_hot_param
# ------------------------------------------------------------

DROP TABLE IF EXISTS `second_hand_car_hot_param`;

CREATE TABLE `second_hand_car_hot_param` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `car_id` varchar(25) NOT NULL DEFAULT '' COMMENT '二手车表中的cardId',
  `text` varchar(20) NOT NULL DEFAULT '' COMMENT '热门属性文本',
  `color` varchar(16) NOT NULL DEFAULT '' COMMENT '热门属性颜色',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='二手车热门属性表';







/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
