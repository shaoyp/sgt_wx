create database if not exists 'zd_product';
use 'zd_product';
create table fast_user(id int primary key NOT NULL AUTO_INCREMENT,
                       user_name varchar(20),
                       user_open_id varchar(50),
                       user_wx_number varchar(50),
                       user_phone int,
                       del_flg char(1));
create table fast_advise(id int primary key NOT NULL AUTO_INCREMENT,
                         user_id int,
                         advise varchar(300));
create table fast_group_buying(id int primary key NOT NULL AUTO_INCREMENT,
                               name varchar(20),
                               price double,
                               discount_price double,
                               people_num int,
                               num int,
                               dead_line datetime,
                               img varchar(100),
                               del_flg char(1));