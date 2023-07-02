# 建数据库和见表语句
create database if not exists pet_transaction;

use pet_transaction;

drop table if exists tb_transaction;
drop table if exists tb_pet;
drop table if exists tb_pet_classes;
drop table if exists tb_user;



create table tb_user
(
    username varchar(10) primary key,
    password varchar(10) not null,
    balance  decimal(10, 2) default 0.00
);

create table tb_pet_classes
(
    pet_class_id int primary key auto_increment,
    pet_class    varchar(10) unique
);

create table tb_pet
(
    pet_id        int primary key auto_increment,
    sell_username varchar(10),
    description   varchar(20),
    price         decimal(10, 2),
    pet_class     varchar(10),
    has_sold_out  boolean default false,
    CONSTRAINT pet_class_id_constraint
        FOREIGN KEY (pet_class) REFERENCES tb_pet_classes (pet_class),
    CONSTRAINT sell_username_constraint
        FOREIGN KEY (sell_username) REFERENCES tb_user (username)
);

create table tb_transaction
(
    transaction_id    int primary key auto_increment,
    pet_id            int,
    purchase_username varchar(10),
    sell_username     varchar(10),
    transaction_date  date,
    CONSTRAINT pet_id_constraint
        FOREIGN KEY (pet_id) REFERENCES tb_pet (pet_id),
    CONSTRAINT purchase_username
        FOREIGN KEY (purchase_username) REFERENCES tb_user (username),
    CONSTRAINT sell_username
        FOREIGN KEY (sell_username) REFERENCES tb_user (username)
);

# tb_user 操作
insert into tb_user (username, password, balance)
VALUES ('张三', 'passwd', 20.00);
insert into tb_user (username, password, balance)
VALUES ('李四', 'passwd', 17.00);
insert into tb_user (username, password, balance)
VALUES ('王五', 'passwd', 28.00);

update tb_user
set balance=30.0
where username = '李四';

select username, password, balance
from tb_user;

# tb_pet_classes 操作
insert into tb_pet_classes (pet_class) VALUES ('dog');
insert into tb_pet_classes (pet_class) VALUES ('cat');

select pet_class_id, pet_class from tb_pet_classes;

# tb_pet 操作
insert into tb_pet (sell_username, description, price, pet_class) VALUES ('张三', '一只可爱的狗', 100.0 , 'dog');
insert into tb_pet (sell_username, description, price, pet_class) VALUES ('李四', '一只可爱的猫', 300.0 , 'cat');

select pet_id, sell_username, description, price, pet_class, has_sold_out from tb_pet;

# tb_transaction 操作
insert into tb_transaction (pet_id, purchase_username, sell_username, transaction_date) VALUES ('1', '张三', '李四', '2022-10-03');

select transaction_id, pet_id, purchase_username, sell_username, transaction_date from tb_transaction;
