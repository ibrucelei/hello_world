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

--alter table department modify employer_id VARCHAR(100) NOT NULL;

CREATE TABLE IF NOT EXISTS `role`(
   `id` VARCHAR(100) NOT NULL,
   `role_name` VARCHAR(100) NOT NULL,
   `create_date` DATE,
   `modify_date` DATE,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user`( 
   `id` VARCHAR(100) NOT NULL,
   `user_name` VARCHAR(100) NOT NULL,
   `password` VARCHAR(100) NOT NULL,
   `create_date` DATE,
   `modify_date` DATE,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user_role`(
   `id` VARCHAR(100) NOT NULL,
   `user_id` VARCHAR(100) NOT NULL,
   `role_id` VARCHAR(100) NOT NULL,
   `create_date` DATE,
   `modify_date` DATE,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user(id,user_name,password) values('001','root','password');
insert into role(id,role_name) values('001','role_root');
insert into user_role(id,user_id,role_id) values('001','001','001');
SELECT r.* from user_role ur,role r where ur.user_id=r.id and ur.user_id=''