create database if not exists sgt_wx;
use sgt_wx;
create table fast_user(id int primary key NOT NULL AUTO_INCREMENT,
                       user_name varchar(20),
                       user_open_id varchar(50),
                       user_wx_number varchar(50),
                       user_phone int,
                       del_flg char(1));
create table fast_advise(id int primary key NOT NULL AUTO_INCREMENT,
                         user_id varchar(50),
                         advise varchar(300));
create table fast_private_order(id int primary key NOT NULL AUTO_INCREMENT,
		                         user_id varchar(50),
		                         odrder varchar(300));
create table fast_group_info(id int primary key NOT NULL AUTO_INCREMENT,
                               name varchar(20),
                               price double,
                               discount_price double,
                               people_num int,
                               num int,
                               dead_line datetime,
                               img varchar(100),
                               del_flg char(1));
insert into fast_group_info (name,price,discount_price,people_num,num)values('正道产品',6888.00,5888.00,258,358);
create table fast_group_order(id int primary key NOT NULL AUTO_INCREMENT,		                         user_id varchar(50),
		                         num int,
		                         price double,
		                         order_date datetime);