create database test;
use test;
CREATE TABLE IF NOT EXISTS `department`(
   `id` VARCHAR(100) NOT NULL,
   `name` VARCHAR(100) NOT NULL,
   `employer_id` VARCHAR(100) NOT NULL,
   `create_date` DATE,
   `modify_date` DATE,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table department modify employer_id VARCHAR(100) NOT NULL;