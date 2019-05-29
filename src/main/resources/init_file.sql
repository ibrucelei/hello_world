create database file;
use file;
CREATE TABLE IF NOT EXISTS `state`(
   `id` VARCHAR(100) NOT NULL,
   `state` VARCHAR(100) NOT NULL,
   `population` VARCHAR(40) NOT NULL,
   `create_date` DATE,
   `modify_date` DATE,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE IF NOT EXISTS `media`(
   `id` VARCHAR(100) NOT NULL,
   `name` VARCHAR(100),
   `path` VARCHAR(100),
   `content_type` VARCHAR(20) NOT NULL,
   `content` VARCHAR(200),
   `user_id` VARCHAR(100),
   `description` VARCHAR(100),
   `title` VARCHAR(100),
   `label_id` VARCHAR(100),
   `category_id` VARCHAR(100),
   `nLike` int(11),
   `nStore` int(11),
   `nBrowse` int(11),
   `nRemark` int(11),
   `create_date` DATE,
   `modify_date` DATE,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--alter table media modify userId user_id VARCHAR(100) NOT NULL;
--alter table media add  label_id VARCHAR(100) NOT NULL;
--alter table media add  category_id VARCHAR(100) NOT NULL;