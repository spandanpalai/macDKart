drop database if exists macd_res_db;
create database macd_res_db;
use macd_res_db;


create table customer (phone_number integer not null, customer_name varchar(255), order_id integer, primary key (phone_number)) engine=InnoDB;
create table order_table (orderid integer not null auto_increment, order_list varchar(255), primary key (orderid)) engine=InnoDB;
alter table customer add constraint FKtepmc1kisirpydbi95dcho8da foreign key (order_id) references order_table (orderid);


insert into order_table values(1,'COKE');
insert into order_table values(2,'MACD_NONVEG_BURGER');

insert into customer (phone_number, customer_name, order_id) values (9439,'Satyam Behera',1);
insert into customer (phone_number, customer_name, order_id) values (408040,'Spandan Palai',2);create table customer (phone_number integer not null, customer_name varchar(255), order_id integer, primary key (phone_number)) engine=InnoDB
create table order_table (orderid integer not null auto_increment, order_list varchar(255), primary key (orderid)) engine=InnoDB
alter table customer add constraint FKtepmc1kisirpydbi95dcho8da foreign key (order_id) references order_table (orderid)
create table customer (phone_number integer not null, customer_name varchar(255), order_id integer, primary key (phone_number)) engine=InnoDB
create table order_table (orderid integer not null auto_increment, order_list varchar(255), primary key (orderid)) engine=InnoDB
alter table customer add constraint FKtepmc1kisirpydbi95dcho8da foreign key (order_id) references order_table (orderid)
create table customer (phone_number integer not null, customer_name varchar(255), order_id integer, primary key (phone_number)) engine=InnoDB
create table order_table (orderid integer not null auto_increment, order_list varchar(255), primary key (orderid)) engine=InnoDB
alter table customer add constraint FKtepmc1kisirpydbi95dcho8da foreign key (order_id) references order_table (orderid)
