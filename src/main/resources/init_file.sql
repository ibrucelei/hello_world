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