drop table if exists vacancyList;
create table if not exists vacancyList (
id bigint not null primary key AUTO_INCREMENT ,
title varchar(255) not null ,
salary integer not null,
experience varchar(255) not null ,
city varchar(255) not null
);